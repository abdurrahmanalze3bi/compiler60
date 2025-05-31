package classes;

import gen.typescriptparser;
import gen.typescriptparserBaseVisitor;
import jdk.dynalink.Operation;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Stack;

public class MyVisitor extends typescriptparserBaseVisitor {

    SymbolTable symbolTable = new SymbolTable();
    private SemanticErrorManager errorManager;
    private Stack<SemanticErrorManager.MethodInfo> currentMethodStack = new Stack<>();
    public MyVisitor() {
        this.errorManager = new SemanticErrorManager(symbolTable);
    }

    @Override
    public Program visitProgram(typescriptparser.ProgramContext ctx) {
        Program prog = new Program();
        this.errorManager.resetAnalysis();

        for (int i = 0; i < ctx.statement().size(); i++) {
            if (ctx.statement(i) != null) {
                prog.getStatments().add(visitStatement(ctx.statement(i)));
            }
        }

        this.symbolTable.print();
        this.errorManager.finalizeAnalysis();
        this.errorManager.printErrors();
        return prog;
    }

    @Override
    public Statment visitStatement(typescriptparser.StatementContext ctx) {
        Statment statment = new Statment();

        if (ctx.assignmentStatement() != null) {
            statment.setAssignmentStatement(visitAssignmentStatement(ctx.assignmentStatement()));
        }
        if (ctx.componentDeclaration() != null) {
            symbolTable.enterScope("COMPONENT");
            statment.setComponentDeclaration(visitComponentDeclaration(ctx.componentDeclaration()));
            symbolTable.exitScope();
        }
        if (ctx.importDeclaration() != null) {
            statment.setImportDeclaration(visitImportDeclaration(ctx.importDeclaration()));
        }
        if (ctx.classDeclaration() != null) {
            // Handle class declaration with duplicate check
            typescriptparser.ClassDeclarationContext classCtx = ctx.classDeclaration();
            String className = null;
            if (classCtx.ID() != null) {
                className = classCtx.ID().getText();

                // Check for duplicate in current scope
                if (symbolTable.existsInCurrentScope(className)) {
                    // Report semantic error
                    int line = classCtx.ID().getSymbol().getLine();
                    int column = classCtx.ID().getSymbol().getCharPositionInLine();
                    errorManager.reportDuplicateClass(className, line, column);
                } else {
                    // Only add to symbol table if not duplicate
                    symbolTable.addSymbol("CLASS", className);
                }
            }

            // Process class body regardless of duplicate name
            symbolTable.enterScope("CLASS");
            statment.setClassDeclaration(visitClassDeclaration(classCtx));
            symbolTable.exitScope();
        }
        if (ctx.methodDeclaration() != null) {
            symbolTable.enterScope("METHOD");
            statment.setMethodDeclaration(visitMethodDeclaration(ctx.methodDeclaration()));
            symbolTable.exitScope();
        }
        if (ctx.variableDeclaration() != null) {
            statment.setVariableDeclaration(visitVariableDeclaration(ctx.variableDeclaration()));
        }
        if (ctx.interfaceDeclaration() != null) {
            // Handle interface declaration with duplicate check
            typescriptparser.InterfaceDeclarationContext interfaceCtx = ctx.interfaceDeclaration();
            String interfaceName = null;
            if (interfaceCtx.ID() != null) {
                interfaceName = interfaceCtx.ID().getText();

                // Check for duplicate in current scope
                if (symbolTable.existsInCurrentScope(interfaceName)) {
                    // Report semantic error
                    int line = interfaceCtx.ID().getSymbol().getLine();
                    int column = interfaceCtx.ID().getSymbol().getCharPositionInLine();
                    errorManager.reportDuplicateInterface(interfaceName, line, column);
                } else {
                    // Only add to symbol table if not duplicate
                    symbolTable.addSymbol("INTERFACE", interfaceName);
                }
            }

            // Process interface body regardless of duplicate name
            symbolTable.enterScope("INTERFACE");
            statment.setInterfaceDeclaration(visitInterfaceDeclaration(interfaceCtx));
            symbolTable.exitScope();
        }
        return statment;
    }


    @Override
    public AssignmentStatement visitAssignmentStatement(typescriptparser.AssignmentStatementContext ctx) {
        AssignmentStatement assignmentStatement = new AssignmentStatement();

        if (ctx.ID() != null && ctx.ID().getText() != null) {
            String variableName = ctx.ID().getText();
            assignmentStatement.setVariable(variableName);

            // NEW: Check for undefined variable
            errorManager.checkUndefinedVariable(
                    variableName,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );

            // Existing logic: Check if variable exists
            Row existingSymbol = symbolTable.lookupSymbol(variableName);
            if (existingSymbol == null) {
                // Still add to symbol table as undefined reference
                symbolTable.addSymbol("UNDEFINED_VARIABLE", variableName);
            } else {
                // Variable exists - add as reference if not present
                if (!symbolTable.existsInCurrentScope(variableName)) {
                    symbolTable.addSymbol("VARIABLE_REFERENCE", variableName);
                }
            }
        }

        if (ctx.expression() != null) {
            assignmentStatement.setExpression(visitExpression(ctx.expression()));
        }

        return assignmentStatement;
    }



    @Override
    public ImportDeclaration visitImportDeclaration(typescriptparser.ImportDeclarationContext ctx) {
        ImportDeclaration importDeclaration = new ImportDeclaration();
        String idValue = null;
        String stringValue = null;

        if (ctx.ID() != null && ctx.ID().getText() != null) {
            idValue = ctx.ID().getText();
            importDeclaration.setId(idValue);

            // Add to symbol table with scope information if not already exists
            if (!symbolTable.existsInCurrentScope(idValue)) {
                symbolTable.addSymbol("IMPORT_ID", idValue);
            }
        }

        if (ctx.STRING_LIT() != null && ctx.STRING_LIT().getText() != null) {
            stringValue = ctx.STRING_LIT().getText();
            importDeclaration.setString_lit(stringValue);

            // Add import path to symbol table
            symbolTable.addSymbol("IMPORT_PATH", stringValue);
        }

        // THIS IS THE MISSING CALL - Add this line to track imports in the semantic error manager
        this.errorManager.checkImportDeclaration(idValue, stringValue);

        return importDeclaration;
    }


    @Override
    public ClassDeclaration visitClassDeclaration(typescriptparser.ClassDeclarationContext ctx) {
        ClassDeclaration classDeclaration = new ClassDeclaration();

        if (ctx.ID() != null && ctx.ID().getText() != null) {
            String className = ctx.ID().getText();

            // Check for duplicate class in current scope
            if (symbolTable.existsInCurrentScope(className)) {
                errorManager.reportDuplicateClass(className,
                        ctx.getStart().getLine(),
                        ctx.getStart().getCharPositionInLine());
            } else {
                // Add class to current scope (should be Global)
                symbolTable.addSymbol("CLASS", className);
            }

            // Enter class scope for processing class body
            symbolTable.enterScope("CLASS");
            symbolTable.setCurrentScopeName("CLASS." + className);

            classDeclaration.setNameClass(className);

            // Process class body within the class scope
            if (ctx.classDeclarationBody() != null) {
                classDeclaration.setClassDeclarationBody(
                        visitClassDeclarationBody(ctx.classDeclarationBody())
                );
            }

            // Exit class scope after processing
            symbolTable.exitScope();
        }

        return classDeclaration;
    }

    @Override
    public ClassDeclarationBody visitClassDeclarationBody(typescriptparser.ClassDeclarationBodyContext ctx) {
        ClassDeclarationBody classDeclarationBody = new ClassDeclarationBody();

        // We're already in CLASS scope from visitClassDeclaration
        // Process all class members in this scope
        if (ctx.classMember() != null) {
            for (int i = 0; i < ctx.classMember().size(); i++) {
                if (ctx.classMember(i) != null) {
                    ClassMember member = visitClassMember(ctx.classMember(i));
                    if (member != null) {
                        classDeclarationBody.getClassMembers().add(member);
                    }
                }
            }
        }

        return classDeclarationBody;
    }


    @Override
    public ClassMember visitClassMember(typescriptparser.ClassMemberContext ctx) {
        ClassMember classMember = new ClassMember();

        if (ctx.methodDeclaration() != null) {
            // We're already in the correct CLASS scope context
            classMember.setMethodDeclaration(visitMethodDeclaration(ctx.methodDeclaration()));
        }

        if (ctx.propertyDeclaration() != null) {
            // Process property declaration within current CLASS scope
            classMember.setPropertyDeclaration(visitPropertyDeclaration(ctx.propertyDeclaration()));
        }

        return classMember;
    }
    @Override
    public PropertyDeclaration visitPropertyDeclaration(typescriptparser.PropertyDeclarationContext ctx) {
        PropertyDeclaration propertyDeclaration = new PropertyDeclaration();

        for (TerminalNode idNode : ctx.ID()) {
            String propertyId = idNode.getText();
            propertyDeclaration.getID().add(propertyId);

            // Add to component properties for semantic analysis
            errorManager.addComponentProperty(propertyId);

            // Add property to current scope (should be CLASS scope)
            if (!symbolTable.existsInCurrentScope(propertyId)) {
                symbolTable.addSymbol("PROPERTY", propertyId);

                        symbolTable.getCurrentScopeName();
            }
        }

        if (ctx.type() != null) {
            propertyDeclaration.setTypeV(visitType(ctx.type()));
        }

        if (ctx.initvalue() != null) {
            propertyDeclaration.setInitvalue(visitInitvalue(ctx.initvalue()));
        }

        return propertyDeclaration;
    }

    @Override
    public MethodDeclaration visitMethodDeclaration(typescriptparser.MethodDeclarationContext ctx) {
        MethodDeclaration methodDeclaration = new MethodDeclaration();
        String methodName = null;
        String returnType = "void";

        if (ctx.ID() != null) {
            methodName = ctx.ID().getText();
            methodDeclaration.setName(methodName);
        }

        if (ctx.type() != null) {
            returnType = ctx.type().getText();
            methodDeclaration.setTypeReturn(visitType(ctx.type()));
        }

        List<String> parameterTypes = new ArrayList<>();
        if (ctx.parameterList() != null) {
            methodDeclaration.setParameterLists(visitParameterList(ctx.parameterList()));
            parameterTypes = extractParameterTypes(methodDeclaration.getParameterLists());
        }

        SemanticErrorManager.MethodInfo methodInfo = null;
        if (methodName != null) {
            errorManager.registerMethodDeclaration(
                    methodName,
                    returnType,
                    parameterTypes,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );

            String currentScopeName = symbolTable.getCurrentScopeName();
            String methodSignature = errorManager.createMethodSignature(
                    currentScopeName + "." + methodName,
                    parameterTypes
            );
            methodInfo = errorManager.getMethodInfoBySignature(methodSignature);
        }

        MethodContext methodContext = new MethodContext(methodName, returnType, methodInfo);
        methodContextStack.push(methodContext);

        symbolTable.enterScope("METHOD");
        if (methodName != null && !symbolTable.existsInCurrentScope(methodName)) {
            symbolTable.addSymbol("METHOD", methodName);
        }

        if (ctx.methodBody() != null) {
            methodDeclaration.setMethodBody(visitMethodBody(ctx.methodBody()));
        }

        String currentScopeType = symbolTable.getCurrentScopeType();
        boolean isInterfaceMethod = currentScopeType != null &&
                (currentScopeType.equals("INTERFACE") || currentScopeType.equals("INTERFACE_METHOD"));

        if (!isInterfaceMethod && methodInfo != null && !methodInfo.isVoidMethod()) {
            if (!methodContext.hasReturnStatement()) {
                SemanticError error = new SemanticError(
                        SemanticErrorType.MISSING_RETURN_STATEMENT,
                        "Non-void method '" + methodName + "' must return a value",
                        ctx.getStart().getLine(),
                        ctx.getStart().getCharPositionInLine(),
                        methodName
                );
                errorManager.getErrors().add(error);
            }
        }

        symbolTable.exitScope();
        methodContextStack.pop();

        return methodDeclaration;
    }




    private List<String> extractParameterTypes(ParameterList parameterList) {
        List<String> types = new ArrayList<>();

        if (parameterList == null || parameterList.getParameters() == null) {
            return types;
        }

        try {
            for (Parameter parameter : parameterList.getParameters()) {
                if (parameter != null && parameter.getTypeV() != null) {
                    // Extract type from TypeV object
                    TypeV typeV = parameter.getTypeV();
                    String paramType = extractTypeFromTypeV(typeV);
                    types.add(paramType != null ? paramType : "any");
                } else {
                    types.add("any");
                }
            }
        } catch (Exception e) {
            System.err.println("Error extracting parameter types: " + e.getMessage());
        }

        return types;
    }

    private String extractTypeFromTypeV(TypeV typeV) {
        if (typeV == null) {
            return "any";
        }

        try {
            if (typeV.getIsboolean() != null && !typeV.getIsboolean().isEmpty()) {
                return "boolean";
            }
            if (typeV.getNumber_type() != null && !typeV.getNumber_type().isEmpty()) {
                return "number";
            }
            if (typeV.getString_type() != null && !typeV.getString_type().isEmpty()) {
                return typeV.getString_type();
            }
            if (typeV.getListV() != null) {
                return "Array"; // or could be more specific like "Array<T>"
            }
        } catch (Exception e) {
            System.err.println("Error extracting type from TypeV: " + e.getMessage());
        }

        return "any";
    }
    @Override
    public TypeV visitType(typescriptparser.TypeContext ctx) {
        TypeV typeV = new TypeV();

        if (ctx.BOOLEAN_TYPE() != null) {
            String booleanType = ctx.BOOLEAN_TYPE().getText();
            typeV.setIsboolean(booleanType);
            if (!symbolTable.existsInCurrentScope(booleanType)) {
                symbolTable.addSymbol("BOOLEAN_TYPE", booleanType);
            }
        }

        if (ctx.ID() != null) {
            String idType = ctx.ID().getText();
            typeV.setString_type(idType);
            Row typeSymbol = symbolTable.lookupSymbol(idType);
            if (!symbolTable.existsInCurrentScope(idType)) {
                symbolTable.addSymbol("TYPE", idType);
            }
        }

        if (ctx.list() != null) {
            typeV.setListV(visitList(ctx.list()));
        } else if (ctx.NUMBER_TYPE() != null) {
            String numberType = ctx.NUMBER_TYPE().getText();
            typeV.setNumber_type(numberType);
            if (!symbolTable.existsInCurrentScope(numberType)) {
                symbolTable.addSymbol("NUMBER_TYPE", numberType);
            }
        }

        return typeV;
    }

    @Override
    public Operator visitOperator(typescriptparser.OperatorContext ctx) {
        Operator operator = new Operator();

        if (ctx.PLUS() != null) {
            String plusOp = ctx.PLUS().getText();
            operator.setPlus(plusOp);

            // Add operator to symbol table if not already present
            if (!symbolTable.existsInCurrentScope(plusOp)) {
                symbolTable.addSymbol("ARITHMETIC_OPERATOR", plusOp);
            }
        }
        else if (ctx.MINUS() != null) {
            String minusOp = ctx.MINUS().getText();
            operator.setMinus(minusOp);

            // Add operator to symbol table if not already present
            if (!symbolTable.existsInCurrentScope(minusOp)) {
                symbolTable.addSymbol("ARITHMETIC_OPERATOR", minusOp);
            }
        }
        else if (ctx.SLASH() != null) {
            String divOp = ctx.SLASH().getText();
            operator.setDiv(divOp);

            // Add operator to symbol table if not already present
            if (!symbolTable.existsInCurrentScope(divOp)) {
                symbolTable.addSymbol("ARITHMETIC_OPERATOR", divOp);
            }
        }
        else if (ctx.STAR() != null) {
            String multOp = ctx.STAR().getText();
            operator.setMult(multOp);

            // Add operator to symbol table if not already present
            if (!symbolTable.existsInCurrentScope(multOp)) {
                symbolTable.addSymbol("ARITHMETIC_OPERATOR", multOp);
            }
        }

        return operator;
    }

    @Override
    public MemberAccess visitMemberAccess(typescriptparser.MemberAccessContext ctx) {
        MemberAccess memberAccess = new MemberAccess();

        // Handle 'this' keyword
        if (ctx.THIS() != null && "this".equals(ctx.THIS().getText())) {
            memberAccess.setThis(true);

            // Add 'this' keyword to symbol table if not already present
            if (!symbolTable.existsInCurrentScope("this")) {
                symbolTable.addSymbol("KEYWORD", "this");
            }

            // If there's also an ID (like this.propertyName), handle it
            if (ctx.ID() != null) {
                String memberName = ctx.ID().getText();
                memberAccess.setMemberName(memberName);

                // Add the member name as a property reference
                if (!symbolTable.existsInCurrentScope(memberName)) {
                    symbolTable.addSymbol("PROPERTY_REFERENCE", memberName);
                }
            }
        }
        // Handle regular member access (without 'this')
        else if (ctx.ID() != null) {
            String memberName = ctx.ID().getText();
            memberAccess.setMemberName(memberName);

            // Look up the symbol to see if it exists in any scope
            Row existingSymbol = symbolTable.lookupSymbol(memberName);
            if (existingSymbol != null) {
                // It's a reference to an existing symbol
                if (!symbolTable.existsInCurrentScope(memberName)) {
                    symbolTable.addSymbol("MEMBER_REFERENCE", memberName);
                }
            } else {
                // It's a new member access - could be a property or method call
                if (!symbolTable.existsInCurrentScope(memberName)) {
                    symbolTable.addSymbol("MEMBER_ACCESS", memberName);
                }
            }
        }

        return memberAccess;
    }
    @Override
    public ListV visitList(typescriptparser.ListContext ctx) {
        ListV listV = new ListV();
        if (ctx.ID() != null) {
            String listName = ctx.ID().getText();
            listV.setNameList(listName);
            if (!symbolTable.existsInCurrentScope(listName)) {
                symbolTable.addSymbol("LIST_TYPE", listName);
            }
        }
        return listV;
    }

    @Override
    public ParameterList visitParameterList(typescriptparser.ParameterListContext ctx) {
        ParameterList parameterList = new ParameterList();
        for (typescriptparser.ParameterContext pCtx : ctx.parameter()) {
            parameterList.getParameters().add(visitParameter(pCtx));
        }
        return parameterList;
    }

    @Override
    public Initvalue visitInitvalue(typescriptparser.InitvalueContext ctx) {
        Initvalue initvalue = new Initvalue();

        if (ctx.STRING_LIT() != null) {
            String s = ctx.STRING_LIT().getText();
            initvalue.setString(s);
            if (!symbolTable.existsInCurrentScope(s)) {
                symbolTable.addSymbol("STRING_LITERAL", s);
            }
        } else if (ctx.NUMBER_LIT() != null) {
            String n = ctx.NUMBER_LIT().getText();
            initvalue.setNumber(n);
            if (!symbolTable.existsInCurrentScope(n)) {
                symbolTable.addSymbol("NUMBER_LITERAL", n);
            }
        } else if (ctx.isboolean() != null) {
            initvalue.setIsBoolean(visitIsboolean(ctx.isboolean()));
        } else if (ctx.bodylist() != null) {
            initvalue.setBodyList(visitBodylist(ctx.bodylist()));
        }

        if (ctx.object() != null) {
            symbolTable.enterScope("OBJECT");
            initvalue.setObjectV(visitObject(ctx.object()));
            symbolTable.exitScope();
        }

        return initvalue;
    }

    @Override
    public MethodBody visitMethodBody(typescriptparser.MethodBodyContext ctx) {
        MethodBody methodBody = new MethodBody();
        for (typescriptparser.StatementMethodContext smCtx : ctx.statementMethod()) {
            methodBody.getStatementMethods().add(visitStatementMethod(smCtx));
        }
        return methodBody;
    }


    @Override
    public StatementMethod visitStatementMethod(typescriptparser.StatementMethodContext ctx) {
        StatementMethod statementMethod = new StatementMethod();

        // Handle variable assignment: ID = expression
        if (ctx.ID() != null && ctx.ASSIGN() != null) {
            String varName = ctx.ID().getText();
            statementMethod.getVariable().add(varName);

            // Check for duplicate declaration in current scope
            if (!symbolTable.existsInCurrentScope(varName)) {
                symbolTable.addSymbol("VARIABLE", varName);
            }

            if (ctx.expression() != null) {
                statementMethod.setExpression(visitExpression(ctx.expression()));
            }
        }
        // Handle this.property assignment: this.ID = expression
        else if (ctx.THIS() != null && ctx.DOT() != null && ctx.ID() != null) {
            // Add 'this' keyword to symbol table
            if (!symbolTable.existsInCurrentScope("this")) {
                symbolTable.addSymbol("KEYWORD", "this");
            }

            String prop = ctx.ID().getText();
            statementMethod.getVariable().add(prop);

            // Add property reference to symbol table
            if (!symbolTable.existsInCurrentScope(prop)) {
                symbolTable.addSymbol("PROPERTY", prop);
            }

            if (ctx.expression() != null) {
                statementMethod.setExpression(visitExpression(ctx.expression()));
            }
        }
        // Handle standalone expression
        else if (ctx.expression() != null) {
            statementMethod.setExpression(visitExpression(ctx.expression()));
        }
        // Handle return statement
        else if (ctx.return_() != null) {
            statementMethod.setIsreturn(true);

            // Add 'return' keyword to symbol table
            if (!symbolTable.existsInCurrentScope("return")) {
                symbolTable.addSymbol("KEYWORD", "return");
            }


                statementMethod.setReturnN(visitReturn(ctx.return_()));

        }

        return statementMethod;
    }

    @Override
    public ReturnN visitReturn(typescriptparser.ReturnContext ctx) {
        ReturnN returnN = new ReturnN();
        String returnValue = null;
        String returnType = "void";

        // Only process if this is actually a return statement
        String contextText = ctx.getText();
        if (contextText == null || !contextText.startsWith("return")) {
            return returnN;
        }

        // Handle expression return
        if (ctx.expression() != null) {
            Expression expr = visitExpression(ctx.expression());
            returnN.setExpressionReturn(expr);
            returnType = determineExpressionType(expr);
            returnValue = ctx.expression().getText();
        }
        // Handle ID return value
        else if (ctx.ID() != null && ctx.ID().getText() != null) {
            returnValue = ctx.ID().getText();
            Row symbol = symbolTable.lookupSymbol(returnValue);
            returnType = symbol != null ? symbol.getType() : "any";
            returnN.setValueReturn(returnValue);
        }
        // Handle boolean return value
        else if (ctx.isboolean() != null) {
            returnN.setBoolReturn(visitIsboolean(ctx.isboolean()));
            returnType = "boolean";
            returnValue = ctx.isboolean().getText();
        }
        // Handle empty return statement
        else if (contextText.equals("return") || contextText.equals("return;")) {
            returnValue = null;
            returnType = "void";
        }
        // Handle other return expressions
        else {
            returnValue = contextText.replace("return", "").replace(";", "").trim();
            if (!returnValue.isEmpty()) {
                returnType = "any";
                returnN.setValueReturn(returnValue);
            }
        }

        // Check return statement semantics if we're in a method
        if (!methodContextStack.isEmpty()) {
            MethodContext currentMethod = methodContextStack.peek();
            currentMethod.markHasReturn();

            // Get the MethodInfo object for semantic checking
            SemanticErrorManager.MethodInfo methodInfo = currentMethod.getMethodInfo();
            if (methodInfo != null) {
                errorManager.checkReturnStatement(
                        methodInfo,
                        returnValue,
                        returnType,
                        ctx.getStart().getLine(),
                        ctx.getStart().getCharPositionInLine()
                );
            }
        }

        return returnN;
    }
    @Override
    public Parameter visitParameter(typescriptparser.ParameterContext ctx) {
        Parameter parameter = new Parameter();

        if (ctx.ID() != null) {
            String paramName = ctx.ID().getText();
            parameter.setName(paramName);
            if (!symbolTable.existsInCurrentScope(paramName)) {
                symbolTable.addSymbol("PARAMETER", paramName);
            }
        }
        if (ctx.type() != null) {
            parameter.setTypeV(visitType(ctx.type()));
        }
        return parameter;
    }

    @Override
    public IsBoolean visitIsboolean(typescriptparser.IsbooleanContext ctx) {
        IsBoolean isBoolean = new IsBoolean();

        if (ctx.TRUE() != null) {
            String trueValue = ctx.TRUE().getText();
            isBoolean.setTruev(trueValue);

            // Add boolean literal to symbol table if not already present
            if (!symbolTable.existsInCurrentScope(trueValue)) {
                symbolTable.addSymbol("BOOLEAN_LITERAL", trueValue);
            }
        }
        else if (ctx.FALSE() != null) {
            String falseValue = ctx.FALSE().getText();
            isBoolean.setFalsev(falseValue);

            // Add boolean literal to symbol table if not already present
            if (!symbolTable.existsInCurrentScope(falseValue)) {
                symbolTable.addSymbol("BOOLEAN_LITERAL", falseValue);
            }
        }

        return isBoolean;
    }
    @Override
    public BodyList visitBodylist(typescriptparser.BodylistContext ctx) {
        BodyList bodyList = new BodyList();
        symbolTable.enterScope("BODY_LIST");
        for (typescriptparser.InitvalueContext ivCtx : ctx.initvalue()) {
            bodyList.getInitvalues().add(visitInitvalue(ivCtx));
        }
        symbolTable.exitScope();
        return bodyList;
    }


    @Override
    public ObjectV visitObject(typescriptparser.ObjectContext ctx) {
        ObjectV object = new ObjectV();
        if (ctx.bodyobject() != null) {
            object.setBodyObject(visitBodyobject(ctx.bodyobject()));
        }
        return object;
    }

    @Override
    public VariableDeclaration visitVariableDeclaration(typescriptparser.VariableDeclarationContext ctx) {
        VariableDeclaration variableDeclaration = new VariableDeclaration();

        if (ctx.ID() != null) {
            String variableName = ctx.ID().getText();
            variableDeclaration.setName(variableName);

            // Add variable if not already in current scope
            if (!symbolTable.existsInCurrentScope(variableName)) {
                symbolTable.addSymbol("VARIABLE", variableName);
            }
        }

        if (ctx.expression() != null) {
            variableDeclaration.setExpression(visitExpression(ctx.expression()));
        }

        if (ctx.VAR() != null) {
            String varKeyword = ctx.VAR().getText();
            variableDeclaration.setVar(varKeyword);
            if (!symbolTable.existsInCurrentScope(varKeyword)) {
                symbolTable.addSymbol("KEYWORD", varKeyword);
            }
        }

        if (ctx.CONST() != null) {
            String constKeyword = ctx.CONST().getText();
            variableDeclaration.setConstv(constKeyword);
            if (!symbolTable.existsInCurrentScope(constKeyword)) {
                symbolTable.addSymbol("KEYWORD", constKeyword);
            }
        }

        if (ctx.LET() != null) {
            String letKeyword = ctx.LET().getText();
            variableDeclaration.setLet(letKeyword);
            if (!symbolTable.existsInCurrentScope(letKeyword)) {
                symbolTable.addSymbol("KEYWORD", letKeyword);
            }
        }

        return variableDeclaration;
    }

    @Override
    public Expression visitExpression(typescriptparser.ExpressionContext ctx) {
        Expression expression = new Expression();

        if (ctx.ID() != null && ctx.ID().getText() != null) {
            String idValue = ctx.ID().getText();
            expression.setString(idValue);

            // Add identifier reference if not present
            if (!symbolTable.existsInCurrentScope(idValue)) {
                symbolTable.addSymbol("ID_REFERENCE", idValue);
            }
        }
        else if (ctx.isboolean() != null) {
            expression.setIsboolean(visitIsboolean(ctx.isboolean()));
        }
        else if (ctx.variableDeclaration() != null) {
            expression.setVariableDeclaration(visitVariableDeclaration(ctx.variableDeclaration()));
        }
        else if (ctx.functionCall() != null) {
            expression.setFunctionCall(visitFunctionCall(ctx.functionCall()));
        }

        return expression;
    }



    @Override
    public FunctionCall visitFunctionCall(typescriptparser.FunctionCallContext ctx) {
        FunctionCall functionCall = new FunctionCall();

        if (ctx.ID() != null) {
            String functionName = ctx.ID().getText();
            functionCall.setNameFun(functionName);

            // Add function call symbol if not already there
            if (!symbolTable.existsInCurrentScope(functionName)) {
                symbolTable.addSymbol("FUNCTION_CALL", functionName);
            }
        }

        // Process and add each argument
        for (typescriptparser.ArgumentContext argCtx : ctx.argument()) {
            functionCall.getArguments().add(visitArgument(argCtx));
        }

        return functionCall;
    }

    @Override
    public Argument visitArgument(typescriptparser.ArgumentContext ctx) {
        Argument argument = new Argument();
        if (ctx.expression() != null) {
            argument.setExpression(visitExpression(ctx.expression()));
        }
        return argument;
    }


    @Override
    public ComponentDeclaration visitComponentDeclaration(typescriptparser.ComponentDeclarationContext ctx) {
        ComponentDeclaration componentDeclaration = new ComponentDeclaration();

        if (ctx.DECORATOR() != null) {
            String decoratorValue = ctx.DECORATOR().getText();
            componentDeclaration.setDecorato(decoratorValue);

            // Check for missing @ symbol
            if (!decoratorValue.startsWith("@")) {
                errorManager.checkMissingDecoratorSymbol(decoratorValue, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            }

            if (!symbolTable.existsInCurrentScope(decoratorValue)) {
                symbolTable.addSymbol("DECORATOR", decoratorValue);
            }
        }

        if (ctx.componentDeclarationBody() != null) {
            ComponentDeclarationBody body = (ComponentDeclarationBody) visitComponentDeclarationBody(ctx.componentDeclarationBody());
            componentDeclaration.setComponentDeclarationBody(body);
        }

        return componentDeclaration;
    }

    @Override
    public ComponentDeclarationBody visitComponentDeclarationBody(typescriptparser.ComponentDeclarationBodyContext ctx) {
        ComponentDeclarationBody componentDeclarationBody = new ComponentDeclarationBody();

        // Process all component body elements
        for (typescriptparser.ComponentBodyElementContext elementCtx : ctx.componentBodyElement()) {
            ComponentBodyElement element = visitComponentBodyElement(elementCtx);
            if (element != null) {
                componentDeclarationBody.getComponentBodyElements().add(element);
            }
        }

        return componentDeclarationBody;
    }

    @Override
    public ComponentBodyElement visitComponentBodyElement(typescriptparser.ComponentBodyElementContext ctx) {
        ComponentBodyElement componentBodyElement = new ComponentBodyElement();

        if (ctx.selector() != null) {
            componentBodyElement.setSelector(visitSelector(ctx.selector()));
        }
        if (ctx.standalone() != null) {
            componentBodyElement.setStandalone(visitStandalone(ctx.standalone()));
        }
        if (ctx.importDeclaration() != null) {
            componentBodyElement.setImportDeclaration(
                    visitImportDeclaration(ctx.importDeclaration())
            );
        }
        if (ctx.template() != null) {
            symbolTable.enterScope("TEMPLATE");
            componentBodyElement.setTemplate(visitTemplate(ctx.template()));
            symbolTable.exitScope();
        }
        if (ctx.styles() != null) {
            symbolTable.enterScope("STYLES");
            componentBodyElement.setStyles(visitStyles(ctx.styles()));
            symbolTable.exitScope();
        }

        return componentBodyElement;
    }

    @Override
    public Selector visitSelector(typescriptparser.SelectorContext ctx) {
        Selector selector = new Selector();

        if (ctx.STRING_LIT() != null) {
            String selectorValue = ctx.STRING_LIT().getText();
            selector.setSTRING_LIT(selectorValue);

            // Add selector string only if new in scope
            if (!symbolTable.existsInCurrentScope(selectorValue)) {
                symbolTable.addSymbol("SELECTOR_STRING", selectorValue);
            }
        }

        return selector;
    }
    @Override
    public Standalone visitStandalone(typescriptparser.StandaloneContext ctx) {
        Standalone standalone = new Standalone();

        if (ctx.isboolean() != null) {
            standalone.setIsboolean(visitIsboolean(ctx.isboolean()));
        }

        return standalone;
    }

    @Override
    public Template visitTemplate(typescriptparser.TemplateContext ctx) {
        Template template = new Template();

        for (typescriptparser.ElementContext elemCtx : ctx.element()) {
            template.getElement().add(visitElement(elemCtx));
        }

        return template;
    }

    @Override
    public Element visitElement(typescriptparser.ElementContext ctx) {
        Element element = new Element();

        if (ctx.tag() != null) {
            element.setTag(visitTag(ctx.tag()));
        }
        if (ctx.interpolation() != null) {
            element.setInterpolation(visitInterpolation(ctx.interpolation()));
        }
        if (ctx.NAME_HTML() != null) {
            String htmlName = ctx.NAME_HTML().getText();
            element.setHtmlName(htmlName);
            if (!symbolTable.existsInCurrentScope(htmlName)) {
                symbolTable.addSymbol("HTML_ELEMENT", htmlName);
            }
        }

        return element;
    }

    @Override
    public Tag visitTag(typescriptparser.TagContext ctx) {
        Tag tag = new Tag();

        if (ctx.openingTag() != null) {
            tag.setOpeningTag(visitOpeningTag(ctx.openingTag()));
        }
        if (ctx.closingTag() != null) {
            tag.setClosingTag(visitClosingTag(ctx.closingTag()));
        }
        if (ctx.selfClosingTag() != null) {
            tag.setSelfClosingTag(visitSelfClosingTag(ctx.selfClosingTag()));
        }
        for (typescriptparser.ElementContext nested : ctx.element()) {
            tag.getElements().add(visitElement(nested));
        }

        return tag;
    }

    @Override
    public Interpolation visitInterpolation(typescriptparser.InterpolationContext ctx) {
        Interpolation interpolation = new Interpolation();

        if (ctx.NAME_HTML() != null) {
            String name = ctx.NAME_HTML().getText();
            interpolation.setNAME_HTML(name);

            if (!symbolTable.existsInCurrentScope(name)) {
                symbolTable.addSymbol("INTERPOLATION_ID", name);
            }
        }

        return interpolation;
    }
    @Override
    public OpeningTag visitOpeningTag(typescriptparser.OpeningTagContext ctx) {
        OpeningTag openingTag = new OpeningTag();

        for (typescriptparser.AttributesContext attrCtx : ctx.attributes()) {
            openingTag.getAttributes().add(visitAttributes(attrCtx));
        }

        return openingTag;
    }

    @Override
    public ClosingTag visitClosingTag(typescriptparser.ClosingTagContext ctx) {
        ClosingTag closingTag = new ClosingTag();

        if (ctx.TAG_CLOSE_START_HTML() != null) {
            String tagName = ctx.TAG_CLOSE_START_HTML().getText();
            closingTag.setNAME_HTML(tagName);
            if (!symbolTable.existsInCurrentScope(tagName)) {
                symbolTable.addSymbol("HTML_CLOSING_TAG", tagName);
            }
        }

        return closingTag;
    }

    // Updated visitAttributes method for your MyVisitor class

    @Override
    public Attributes visitAttributes(typescriptparser.AttributesContext ctx) {
        Attributes attributes = new Attributes();

        // Process NAME_HTML attributes (attribute names)
        if (ctx.NAME_HTML() != null) {
            String name = ctx.NAME_HTML().getText();
            attributes.setHtmlName(name);

            // Check for structural directives used without asterisk
            if (isStructuralDirectiveName(name)) {
                errorManager.checkDirectiveAttribute(
                        name,
                        ctx.getStart().getLine(),
                        ctx.getStart().getCharPositionInLine()
                );
            }
        }

        // Process STRING_HTML attributes (attribute values)
        if (ctx.STRING_HTML() != null) {
            String s = ctx.STRING_HTML().getText();
            attributes.setHtmlString(s);

            // NEW: Check for literal binding of property
            if (ctx.NAME_HTML() != null) {
                String attrName = ctx.NAME_HTML().getText();
                errorManager.checkLiteralBinding(
                        attrName,
                        s,
                        ctx.getStart().getLine(),
                        ctx.getStart().getCharPositionInLine()
                );
            }
        }

        // Process BINDING_HTML attributes (property bindings)
        if (ctx.BINDING_HTML() != null) {
            String bind = ctx.BINDING_HTML().getText();
            attributes.setBinding(bind);

            // Check for property binding mismatches
            String propertyName = bind.replace("[", "").replace("]", "");
            errorManager.checkPropertyBinding(
                    propertyName,
                    "RESOURCE_BINDING",
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );
        }

        // Process STRUCTURAL_DIR_HTML attributes (structural directives)
        if (ctx.STRUCTURAL_DIR_HTML() != null) {
            String dir = ctx.STRUCTURAL_DIR_HTML().getText();
            attributes.setStructuralDir(dir);

            // Check for structural directive errors
            errorManager.checkStructuralDirectiveVariable(
                    dir,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );
        }

        // Process EVENT_BINDING_HTML attributes (event bindings)
        if (ctx.EVENT_BINDING_HTML() != null) {
            String evt = ctx.EVENT_BINDING_HTML().getText();
            attributes.setEvent(evt);
        }

        // NEW: Enhanced literal binding detection
        if (ctx.NAME_HTML() != null && ctx.STRING_HTML() != null) {
            String attrName = ctx.NAME_HTML().getText();
            String attrValue = ctx.STRING_HTML().getText().replaceAll("['\"]", "");

            // Check common Angular properties that should use binding
            Set<String> bindableProperties = Set.of("src", "href", "value", "class", "style", "id");
            if (bindableProperties.contains(attrName)) {
                errorManager.checkLiteralBinding(
                        attrName,
                        attrValue,
                        ctx.getStart().getLine(),
                        ctx.getStart().getCharPositionInLine()
                );
            }
        }

        return attributes;
    }
    private boolean isStructuralDirectiveName(String name) {
        if (name == null) return false;

        // List of structural directives without asterisk
        Set<String> structuralDirectives = Set.of(
                "ngFor", "ngIf", "ngSwitch", "ngSwitchCase", "ngSwitchDefault",
                "ngTemplateOutlet", "ngComponentOutlet"
        );

        return structuralDirectives.contains(name);
    }
    private boolean isStructuralDirective(String name) {
        return name.equals("ngFor") ||
                name.equals("ngIf") ||
                name.equals("ngSwitch") ||
                name.equals("ngSwitchCase") ||
                name.equals("ngSwitchDefault");
    }
    @Override
    public SelfClosingTag visitSelfClosingTag(typescriptparser.SelfClosingTagContext ctx) {
        SelfClosingTag selfClosingTag = new SelfClosingTag();

        for (typescriptparser.AttributesContext attrCtx : ctx.attributes()) {
            selfClosingTag.getAttributes().add(visitAttributes(attrCtx));
        }

        return selfClosingTag;
    }

    @Override
    public Styles visitStyles(typescriptparser.StylesContext ctx) {
        Styles styles = new Styles();
        if (ctx.cssBody() != null) {
            styles.setCssBody(visitCssBody(ctx.cssBody()));
        }
        return styles;
    }

    @Override
    public CssBody visitCssBody(typescriptparser.CssBodyContext ctx) {
        CssBody cssBody = new CssBody();
        if (ctx.cssObjects() != null) {
            symbolTable.enterScope("CSS_OBJECTS");
            cssBody.setCssObjects(visitCssObjects(ctx.cssObjects()));
            symbolTable.exitScope();
        }
        return cssBody;
    }

    @Override
    public CssObjects visitCssObjects(typescriptparser.CssObjectsContext ctx) {
        CssObjects cssObjects = new CssObjects();

        for (typescriptparser.CsselementContext eCtx : ctx.csselement()) {
            symbolTable.enterScope("CSS_ELEMENT");
            cssObjects.getCssElementlist().add(visitCsselement(eCtx));
            symbolTable.exitScope();
        }

        return cssObjects;
    }
    @Override
    public CssElement visitCsselement(typescriptparser.CsselementContext ctx) {
        CssElement cssElement = new CssElement();

        for (typescriptparser.BodyelementContext beCtx : ctx.bodyelement()) {
            cssElement.getBodyCssElements().add(visitBodyelement(beCtx));
        }

        return cssElement;
    }
    @Override
    public Bodyelement visitBodyelement(typescriptparser.BodyelementContext ctx) {
        Bodyelement bodyelement = new Bodyelement();

        if (ctx.ID_CSS() != null) {
            String cssId = ctx.ID_CSS().getText();
            bodyelement.setId_css(cssId);

            // Add CSS property if not already in current scope
            if (!symbolTable.existsInCurrentScope(cssId)) {
                symbolTable.addSymbol("CSS_PROPERTY", cssId);
            }
        }

        if (ctx.cssValue() != null) {
            bodyelement.setCssValue(visitCssValue(ctx.cssValue()));
        }

        return bodyelement;
    }

    @Override
    public CssValue visitCssValue(typescriptparser.CssValueContext ctx) {
        CssValue cssValue = new CssValue();

        for (TerminalNode idCss : ctx.ID_CSS()) {
            String cssValueId = idCss.getText();
            cssValue.getID_CSS().add(cssValueId);

            // Add CSS value if not already in current scope
            if (!symbolTable.existsInCurrentScope(cssValueId)) {
                symbolTable.addSymbol("CSS_VALUE", cssValueId);
            }
        }

        return cssValue;
    }

    @Override
    public InterfaceDeclaration visitInterfaceDeclaration(typescriptparser.InterfaceDeclarationContext ctx) {
        InterfaceDeclaration interfaceDeclaration = new InterfaceDeclaration();

        if (ctx.ID() != null && ctx.ID().getText() != null) {
            String interfaceName = ctx.ID().getText();
            interfaceDeclaration.setNameInterface(interfaceName);

            // FIX: Add duplicate check before adding to symbol table
            if (symbolTable.existsInCurrentScope(interfaceName)) {
                int line = ctx.ID().getSymbol().getLine();
                int column = ctx.ID().getSymbol().getCharPositionInLine();
                errorManager.reportDuplicateInterface(interfaceName, line, column);
            } else {
                symbolTable.addSymbol("INTERFACE", interfaceName);
            }
        }

        // Process interface members
        for (int i = 0; i < ctx.interfaceMember().size(); i++) {
            typescriptparser.InterfaceMemberContext imCtx = ctx.interfaceMember(i);
            InterfaceMember member = visitInterfaceMember(imCtx);
            if (member != null) {
                interfaceDeclaration.getInterfaceMembers().add(member);
            }
        }

        return interfaceDeclaration;
    }



    @Override
    public InterfaceMember visitInterfaceMember(typescriptparser.InterfaceMemberContext ctx) {
        InterfaceMember interfaceMember = new InterfaceMember();

        if (ctx.propertyDeclaration() != null) {

            interfaceMember.setPropertyDeclaration(visitPropertyDeclaration(ctx.propertyDeclaration()));
        } else if (ctx.methodDeclaration() != null) {

            symbolTable.enterScope("INTERFACE_METHOD");
            interfaceMember.setMethodDeclaration(visitMethodDeclaration(ctx.methodDeclaration()));
            symbolTable.exitScope();
        }

        return interfaceMember;
    }


    @Override
    public BodyObject visitBodyobject(typescriptparser.BodyobjectContext ctx) {
        BodyObject bodyObject = new BodyObject();
        if (!ctx.initvalue().isEmpty()) {
            for (typescriptparser.InitvalueContext ivCtx : ctx.initvalue()) {
                bodyObject.getInitvalues().add(visitInitvalue(ivCtx));
            }
        }
        return bodyObject;
    }



    // Add this stack declaration
    private Stack<MethodContext> methodContextStack = new Stack<>();

    // Helper method to determine expression type
    private String determineExpressionType(Expression expr) {
        if (expr == null) return "void";

        // Correct method to check for boolean expressions
        if (expr.isIsboolean() != null) {
            return "boolean";
        }

        // Check string literals
        if (expr.getString() != null) {
            String value = expr.getString();
            if ((value.startsWith("\"") && value.endsWith("\"")) ||
                    (value.startsWith("'") && value.endsWith("'"))) {
                return "string";
            }
        }

        // Check identifiers (variables)
        if (expr.getString() != null) {
            String identifier = expr.getString();
            Row symbol = symbolTable.lookupSymbol(identifier);
            if (symbol != null) {
                return symbol.getType();
            }
        }

        // Check variable declarations
        if (expr.getVariableDeclaration() != null) {
            // For simplicity, assume variable declarations have a type
            // You might need to implement more sophisticated type inference
            return "any";
        }

        // Check function calls
        if (expr.getFunctionCall() != null) {
            // For simplicity, assume function calls return 'any'
            // You might need to implement function return type checking
            return "any";
        }

        // Default to "any" if type can't be determined
        return "any";
    }
    private static class MethodContext {
        private final String methodName;
        private final String returnType;
        private boolean hasReturnStatement;
        private final SemanticErrorManager.MethodInfo methodInfo;

        public MethodContext(String methodName, String returnType,
                             SemanticErrorManager.MethodInfo methodInfo) {
            this.methodName = methodName;
            this.returnType = returnType;
            this.methodInfo = methodInfo;
            this.hasReturnStatement = false;
        }

        public void markHasReturn() {
            this.hasReturnStatement = true;
        }

        public boolean hasReturnStatement() {
            return hasReturnStatement;
        }

        public SemanticErrorManager.MethodInfo getMethodInfo() {
            return methodInfo;
        }
    }
}
