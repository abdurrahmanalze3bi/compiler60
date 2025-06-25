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
    public AssignmentStatement visitAssignmentRule(typescriptparser.AssignmentRuleContext ctx) {
        AssignmentStatement assignment = new AssignmentStatement();

        // ID is guaranteed by rule structure
        String variableName = ctx.ID().getText();
        assignment.setVariable(variableName);

        // Error checking
        errorManager.checkUndefinedVariable(
                variableName,
                ctx.ID().getSymbol().getLine(),
                ctx.ID().getSymbol().getCharPositionInLine()
        );

        // Symbol table logic
        Row existingSymbol = symbolTable.lookupSymbol(variableName);
        if (existingSymbol == null) {
            symbolTable.addSymbol("UNDEFINED_VARIABLE", variableName);
        } else if (!symbolTable.existsInCurrentScope(variableName)) {
            symbolTable.addSymbol("VARIABLE_REFERENCE", variableName);
        }

        // Expression is guaranteed
        assignment.setExpression(visitExpression(ctx.expression()));

        return assignment;
    }



    // OLD METHOD (DELETE)
// @Override
// public ImportDeclaration visitImportDeclaration(ImportDeclarationContext ctx) {...}

    // NEW METHODS
    @Override
    public ImportDeclaration visitStandardImportDecl(typescriptparser.StandardImportDeclContext ctx) {
        ImportDeclaration importDecl = new ImportDeclaration();
        // Your existing import handling logic here
        return importDecl;
    }

    @Override
    public ImportDeclaration visitComponentImportDecl(typescriptparser.ComponentImportDeclContext ctx) {
        ImportDeclaration importDecl = new ImportDeclaration();
        // Your existing import handling logic here
        return importDecl;
    }

    @Override
    public ImportDeclaration visitImportArrayDecl(typescriptparser.ImportArrayDeclContext ctx) {
        ImportDeclaration importDecl = new ImportDeclaration();
        // Your existing import handling logic here
        return importDecl;
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
    // =============== PROPERTY WITH INITIAL VALUE ===============
    @Override
    public PropertyDeclaration visitPropertyWithInit(typescriptparser.PropertyWithInitContext ctx) {
        PropertyDeclaration prop = new PropertyDeclaration();

        // Process ID (guaranteed)
        String propName = ctx.ID().getText();
        prop.getID().add(propName);

        // Semantic analysis
        errorManager.addComponentProperty(propName);

        // Symbol table
        if (!symbolTable.existsInCurrentScope(propName)) {
            symbolTable.addSymbol("PROPERTY", propName);
        }

        // Process type (guaranteed)
        prop.setTypeV((TypeV) visit(ctx.type()));

        // Process initvalue (guaranteed)
        prop.setInitvalue((Initvalue) visit(ctx.initvalue()));

        return prop;
    }

    // =============== PROPERTY WITHOUT INITIAL VALUE ===============
    @Override
    public PropertyDeclaration visitPropertyWithoutInit(typescriptparser.PropertyWithoutInitContext ctx) {
        PropertyDeclaration prop = new PropertyDeclaration();

        // Process ID (guaranteed)
        String propName = ctx.ID().getText();
        prop.getID().add(propName);

        // Semantic analysis
        errorManager.addComponentProperty(propName);

        // Symbol table
        if (!symbolTable.existsInCurrentScope(propName)) {
            symbolTable.addSymbol("PROPERTY", propName);
        }

        // Process type (guaranteed)
        prop.setTypeV((TypeV) visit(ctx.type()));

        // Handle optional union type (OR ID ASSIGN ID)
        if (ctx.OR() != null && ctx.ID().size() > 1) {
            String unionType = ctx.ID(1).getText();
            prop.setUnionType(unionType);  // Add this field to PropertyDeclaration

            // Add union type to symbol table
            if (!symbolTable.existsInCurrentScope(unionType)) {
                symbolTable.addSymbol("UNION_TYPE", unionType);
            }
        }

        return prop;
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
    // =============== STRING TYPE ===============
    @Override
    public TypeV visitStringType(typescriptparser.StringTypeContext ctx) {
        TypeV typeV = new TypeV();
        String typeName = ctx.STRING_TYPE().getText();
        typeV.setString_type(typeName);

        if (!symbolTable.existsInCurrentScope(typeName)) {
            symbolTable.addSymbol("STRING_TYPE", typeName);
        }

        return typeV;
    }

    // =============== NUMBER TYPE ===============
    @Override
    public TypeV visitNumberType(typescriptparser.NumberTypeContext ctx) {
        TypeV typeV = new TypeV();
        String typeName = ctx.NUMBER_TYPE().getText();
        typeV.setNumber_type(typeName);

        if (!symbolTable.existsInCurrentScope(typeName)) {
            symbolTable.addSymbol("NUMBER_TYPE", typeName);
        }

        return typeV;
    }

    // =============== BOOLEAN TYPE ===============
    @Override
    public TypeV visitBooleanType(typescriptparser.BooleanTypeContext ctx) {
        TypeV typeV = new TypeV();
        String typeName = ctx.BOOLEAN_TYPE().getText();
        typeV.setIsboolean(typeName);

        if (!symbolTable.existsInCurrentScope(typeName)) {
            symbolTable.addSymbol("BOOLEAN_TYPE", typeName);
        }

        return typeV;
    }

    // =============== ANY TYPE ===============
    @Override
    public TypeV visitAnyType(typescriptparser.AnyTypeContext ctx) {
        TypeV typeV = new TypeV();
        String typeName = ctx.ANY_TYPE().getText();
        typeV.setString_type(typeName);  // Or create a specific field if needed

        if (!symbolTable.existsInCurrentScope(typeName)) {
            symbolTable.addSymbol("ANY_TYPE", typeName);
        }

        return typeV;
    }

    // =============== VOID TYPE ===============
    @Override
    public TypeV visitVoidType(typescriptparser.VoidTypeContext ctx) {
        TypeV typeV = new TypeV();
        String typeName = ctx.VOID_TYPE().getText();
        typeV.setString_type(typeName);  // Or create a specific field if needed

        if (!symbolTable.existsInCurrentScope(typeName)) {
            symbolTable.addSymbol("VOID_TYPE", typeName);
        }

        return typeV;
    }

    // =============== ID TYPE ===============
    @Override
    public TypeV visitIdType(typescriptparser.IdTypeContext ctx) {
        TypeV typeV = new TypeV();
        String typeName = ctx.ID().getText();
        typeV.setString_type(typeName);

        Row typeSymbol = symbolTable.lookupSymbol(typeName);
        if (!symbolTable.existsInCurrentScope(typeName)) {
            symbolTable.addSymbol("TYPE", typeName);
        }

        return typeV;
    }

    // =============== LIST TYPE ===============
    @Override
    public TypeV visitListType(typescriptparser.ListTypeContext ctx) {
        TypeV typeV = new TypeV();
        typeV.setListV(visitList(ctx.list()));
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
    public MemberAccess visitThisMemberAccess(typescriptparser.ThisMemberAccessContext ctx) {
        MemberAccess memberAccess = new MemberAccess();

        // THIS is guaranteed
        memberAccess.setThis(true);

        // Add 'this' keyword to symbol table
        if (!symbolTable.existsInCurrentScope("this")) {
            symbolTable.addSymbol("KEYWORD", "this");
        }

        // ID is guaranteed
        String memberName = ctx.ID().getText();
        memberAccess.setMemberName(memberName);

        // Add as property reference
        if (!symbolTable.existsInCurrentScope(memberName)) {
            symbolTable.addSymbol("PROPERTY_REFERENCE", memberName);
        }

        return memberAccess;
    }

    @Override
    public MemberAccess visitSimpleMemberAccess(typescriptparser.SimpleMemberAccessContext ctx) {
        MemberAccess memberAccess = new MemberAccess();
        String memberName = ctx.ID().getText();
        memberAccess.setMemberName(memberName);

        // Symbol table logic
        Row existingSymbol = symbolTable.lookupSymbol(memberName);
        if (existingSymbol != null) {
            if (!symbolTable.existsInCurrentScope(memberName)) {
                symbolTable.addSymbol("MEMBER_REFERENCE", memberName);
            }
        } else {
            if (!symbolTable.existsInCurrentScope(memberName)) {
                symbolTable.addSymbol("MEMBER_ACCESS", memberName);
            }
        }

        return memberAccess;
    }
    @Override
    public ListV visitListDeclaration(typescriptparser.ListDeclarationContext ctx) {
        ListV listV = new ListV();

        // ID is guaranteed
        String listName = ctx.ID().getText();
        listV.setNameList(listName);

        if (!symbolTable.existsInCurrentScope(listName)) {
            symbolTable.addSymbol("LIST_TYPE", listName);
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

    // =============== NUMBER INIT VALUE ===============
    @Override
    public Initvalue visitNumberInitValue(typescriptparser.NumberInitValueContext ctx) {
        Initvalue initvalue = new Initvalue();
        String numberValue = ctx.NUMBER_LIT().getText();
        initvalue.setNumber(numberValue);

        if (!symbolTable.existsInCurrentScope(numberValue)) {
            symbolTable.addSymbol("NUMBER_LITERAL", numberValue);
        }

        return initvalue;
    }

    // =============== STRING INIT VALUE ===============
    @Override
    public Initvalue visitStringInitValue(typescriptparser.StringInitValueContext ctx) {
        Initvalue initvalue = new Initvalue();
        String stringValue = ctx.STRING_LIT().getText();
        initvalue.setString(stringValue);

        if (!symbolTable.existsInCurrentScope(stringValue)) {
            symbolTable.addSymbol("STRING_LITERAL", stringValue);
        }

        return initvalue;
    }

    // =============== BOOLEAN INIT VALUE ===============
    @Override
    public Initvalue visitBooleanInitValue(typescriptparser.BooleanInitValueContext ctx) {
        Initvalue initvalue = new Initvalue();
        initvalue.setIsBoolean((IsBoolean) visit(ctx.isboolean()));
        return initvalue;
    }

    // =============== LIST INIT VALUE ===============
    @Override
    public Initvalue visitListInitValue(typescriptparser.ListInitValueContext ctx) {
        Initvalue initvalue = new Initvalue();
        initvalue.setBodyList(visitBodylist(ctx.bodylist()));
        return initvalue;
    }

    // =============== OBJECT INIT VALUE ===============
    @Override
    public Initvalue visitObjectInitValue(typescriptparser.ObjectInitValueContext ctx) {
        Initvalue initvalue = new Initvalue();
        symbolTable.enterScope("OBJECT");
        initvalue.setObjectV(visitObject(ctx.object()));
        symbolTable.exitScope();
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
    public Parameter visitParameterRule(typescriptparser.ParameterRuleContext ctx) {
        Parameter parameter = new Parameter();

        // ID is guaranteed by rule structure
        String paramName = ctx.ID().getText();
        parameter.setName(paramName);

        // Add to symbol table
        if (!symbolTable.existsInCurrentScope(paramName)) {
            symbolTable.addSymbol("PARAMETER", paramName);
        }

        // Type is guaranteed
        parameter.setTypeV((TypeV) visit(ctx.type()));

        return parameter;
    }

    @Override
    public IsBoolean visitTrueBoolean(typescriptparser.TrueBooleanContext ctx) {
        IsBoolean isBoolean = new IsBoolean();
        String trueValue = ctx.TRUE().getText();
        isBoolean.setTruev(trueValue);

        // Add to symbol table
        if (!symbolTable.existsInCurrentScope(trueValue)) {
            symbolTable.addSymbol("BOOLEAN_LITERAL", trueValue);
        }

        return isBoolean;
    }

    @Override
    public IsBoolean visitFalseBoolean(typescriptparser.FalseBooleanContext ctx) {
        IsBoolean isBoolean = new IsBoolean();
        String falseValue = ctx.FALSE().getText();
        isBoolean.setFalsev(falseValue);

        // Add to symbol table
        if (!symbolTable.existsInCurrentScope(falseValue)) {
            symbolTable.addSymbol("BOOLEAN_LITERAL", falseValue);
        }

        return isBoolean;
    }
    @Override
    public BodyList visitBodyListRule(typescriptparser.BodyListRuleContext ctx) {
        BodyList bodyList = new BodyList();
        symbolTable.enterScope("BODY_LIST");

        // Process all initvalues
        for (typescriptparser.InitvalueContext ivCtx : ctx.initvalue()) {
            bodyList.getInitvalues().add((Initvalue) visit(ivCtx));
        }

        symbolTable.exitScope();
        return bodyList;
    }


    @Override
    public ObjectV visitObjectRule(typescriptparser.ObjectRuleContext ctx) {
        ObjectV object = new ObjectV();
        object.setBodyObject(visitBodyobject(ctx.bodyobject()));
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
    public ComponentDeclaration visitComponentDeclarationRule(typescriptparser.ComponentDeclarationRuleContext ctx) {
        ComponentDeclaration componentDeclaration = new ComponentDeclaration();

        // DECORATOR is guaranteed by the rule structure
        String decoratorValue = ctx.DECORATOR().getText();
        componentDeclaration.setDecorato(decoratorValue);

        // Check for missing @ symbol
        if (!decoratorValue.startsWith("@")) {
            errorManager.checkMissingDecoratorSymbol(
                    decoratorValue,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );
        }

        // Add to symbol table
        if (!symbolTable.existsInCurrentScope(decoratorValue)) {
            symbolTable.addSymbol("DECORATOR", decoratorValue);
        }

        // Process body (guaranteed by rule structure)
        ComponentDeclarationBody body = (ComponentDeclarationBody) visit(ctx.componentDeclarationBody());
        componentDeclaration.setComponentDeclarationBody(body);

        return componentDeclaration;
    }

    @Override
    public ComponentDeclarationBody visitComponentBody(typescriptparser.ComponentBodyContext ctx) {
        ComponentDeclarationBody body = new ComponentDeclarationBody();

        for (typescriptparser.ComponentBodyElementContext elemCtx : ctx.componentBodyElement()) {
            // Use automatic dispatching to the correct method
            ComponentBodyElement element = (ComponentBodyElement) visit(elemCtx);
            if (element != null) {
                body.getComponentBodyElements().add(element);
            }
        }

        return body;
    }

// OLD METHOD (DELETE)
// @Override
// public ComponentBodyElement visitComponentBodyElement(ComponentBodyElementContext ctx) {...}

    // NEW METHODS
    @Override
    public ComponentBodyElement visitComponentSelector(typescriptparser.ComponentSelectorContext ctx) {
        ComponentBodyElement element = new ComponentBodyElement();
        element.setSelector((Selector) visit(ctx.selector()));
        return element;
    }

    @Override
    public ComponentBodyElement visitComponentStandalone(typescriptparser.ComponentStandaloneContext ctx) {
        ComponentBodyElement element = new ComponentBodyElement();
        element.setStandalone((Standalone) visit(ctx.standalone()));
        return element;
    }

    @Override
    public ComponentBodyElement visitComponentTemplate(typescriptparser.ComponentTemplateContext ctx) {
        ComponentBodyElement element = new ComponentBodyElement();
        symbolTable.enterScope("TEMPLATE");
        element.setTemplate((Template) visit(ctx.template()));
        symbolTable.exitScope();
        return element;
    }

    @Override
    public ComponentBodyElement visitComponentStyles(typescriptparser.ComponentStylesContext ctx) {
        ComponentBodyElement element = new ComponentBodyElement();
        symbolTable.enterScope("STYLES");
        element.setStyles((Styles) visit(ctx.styles()));
        symbolTable.exitScope();
        return element;
    }

    @Override
    public ComponentBodyElement visitComponentImportElement(typescriptparser.ComponentImportElementContext ctx) {
        ComponentBodyElement element = new ComponentBodyElement();
        element.setImportDeclaration((ImportDeclaration) visit(ctx.importDeclaration()));
        return element;
    }
    // OLD METHOD (DELETE)
// @Override
// public Selector visitSelector(SelectorContext ctx) {...}

    // NEW METHOD
    @Override
    public Selector visitSelectorDeclaration(typescriptparser.SelectorDeclarationContext ctx) {
        Selector selector = new Selector();
        String value = ctx.STRING_LIT().getText();
        selector.setSTRING_LIT(value);

        // Symbol table logic remains
        if (!symbolTable.existsInCurrentScope(value)) {
            symbolTable.addSymbol("SELECTOR_STRING", value);
        }

        return selector;
    }
    // OLD METHOD (DELETE)
// @Override
// public Standalone visitStandalone(StandaloneContext ctx) {...}

    // NEW METHOD

    @Override
    public Standalone visitStandaloneProperty(typescriptparser.StandalonePropertyContext ctx) {
        Standalone standalone = new Standalone();

        // Use automatic dispatching to visit the isboolean rule
        standalone.setIsboolean((IsBoolean) visit(ctx.isboolean()));

        return standalone;
    }
    // OLD METHOD (DELETE)
// @Override
// public Template visitTemplate(TemplateContext ctx) {...}

    // NEW METHOD
    @Override
    public Template visitTemplateDefinition(typescriptparser.TemplateDefinitionContext ctx) {
        Template template = new Template();
        for (typescriptparser.ElementContext elemCtx : ctx.element()) {
            template.getElement().add(visitElement(elemCtx));
        }
        return template;
    }

    // =============== TAG ELEMENT ===============
    @Override
    public Element visitTagElement(typescriptparser.TagElementContext ctx) {
        Element element = new Element();
        element.setTag(visitTag(ctx.tag()));
        return element;
    }

    // =============== HTML NAME ELEMENT ===============
    @Override
    public Element visitHtmlNameElement(typescriptparser.HtmlNameElementContext ctx) {
        Element element = new Element();
        String htmlName = ctx.NAME_HTML().getText();
        element.setHtmlName(htmlName);

        if (!symbolTable.existsInCurrentScope(htmlName)) {
            symbolTable.addSymbol("HTML_ELEMENT", htmlName);
        }

        return element;
    }

    // =============== INTERPOLATION ELEMENT ===============
    @Override
    public Element visitInterpolationElement(typescriptparser.InterpolationElementContext ctx) {
        Element element = new Element();
        // Cast to specific rule context and use labeled method
        element.setInterpolation(
                visitInterpolationRule((typescriptparser.InterpolationRuleContext) ctx.interpolation())
        );
        return element;
    }
    @Override
    public Tag visitOpenCloseTag(typescriptparser.OpenCloseTagContext ctx) {
        Tag tag = new Tag();

        // Directly use the specific rule contexts
        tag.setOpeningTag(visitOpeningTagRule((typescriptparser.OpeningTagRuleContext) ctx.openingTag()));
        tag.setClosingTag(visitClosingTagRule((typescriptparser.ClosingTagRuleContext) ctx.closingTag()));

        // Process nested elements
        for (typescriptparser.ElementContext nested : ctx.element()) {
            tag.getElements().add(visitElement(nested));
        }

        return tag;
    }
    // =============== SELF-CLOSING TAG ===============
    @Override
    public Tag visitSelfClosingTagElement(typescriptparser.SelfClosingTagElementContext ctx) {
        Tag tag = new Tag();
        // Directly use the specific rule context
        tag.setSelfClosingTag(visitSelfClosingTagRule((typescriptparser.SelfClosingTagRuleContext) ctx.selfClosingTag()));
        return tag;
    }

    @Override
    public Interpolation visitInterpolationRule(typescriptparser.InterpolationRuleContext ctx) {
        Interpolation interpolation = new Interpolation();
        String name = ctx.NAME_HTML().getText();
        interpolation.setNAME_HTML(name);

        if (!symbolTable.existsInCurrentScope(name)) {
            symbolTable.addSymbol("INTERPOLATION_ID", name);
        }

        return interpolation;
    }
    @Override
    public OpeningTag visitOpeningTagRule(typescriptparser.OpeningTagRuleContext ctx) {
        OpeningTag openingTag = new OpeningTag();

        // Process all attributes (if any)
        for (typescriptparser.AttributesContext attrCtx : ctx.attributes()) {
            openingTag.getAttributes().add((Attributes) visit(attrCtx));
        }

        return openingTag;
    }

    @Override
    public ClosingTag visitClosingTagRule(typescriptparser.ClosingTagRuleContext ctx) {
        ClosingTag closingTag = new ClosingTag();

        // NAME_HTML is guaranteed
        String tagName = ctx.NAME_HTML().getText();
        closingTag.setNAME_HTML(tagName);

        // Add to symbol table
        if (!symbolTable.existsInCurrentScope(tagName)) {
            symbolTable.addSymbol("HTML_CLOSING_TAG", tagName);
        }

        return closingTag;
    }

    // Updated visitAttributes method for your MyVisitor class

    // =============== HTML ATTRIBUTE ===============
    @Override
    public Attributes visitHtmlAttribute(typescriptparser.HtmlAttributeContext ctx) {
        Attributes attributes = new Attributes();

        // Process attribute name (guaranteed)
        String attrName = ctx.NAME_HTML().getText();
        attributes.setHtmlName(attrName);

        // Process attribute value (guaranteed)
        String attrValue = ctx.STRING_HTML().getText();
        attributes.setHtmlString(attrValue);

        // Check for structural directives used without asterisk
        if (isStructuralDirectiveName(attrName)) {
            errorManager.checkDirectiveAttribute(
                    attrName,
                    ctx.NAME_HTML().getSymbol().getLine(),
                    ctx.NAME_HTML().getSymbol().getCharPositionInLine()
            );
        }

        // Check for literal binding of property
        String cleanValue = attrValue.replaceAll("['\"]", "");
        Set<String> bindableProperties = Set.of("src", "href", "value", "class", "style", "id");
        if (bindableProperties.contains(attrName)) {
            errorManager.checkLiteralBinding(
                    attrName,
                    cleanValue,
                    ctx.NAME_HTML().getSymbol().getLine(),
                    ctx.NAME_HTML().getSymbol().getCharPositionInLine()
            );
        }

        // Add to symbol table
        if (!symbolTable.existsInCurrentScope(attrName)) {
            symbolTable.addSymbol("HTML_ATTRIBUTE", attrName);
        }

        return attributes;
    }

    // =============== STRUCTURAL DIRECTIVE ATTRIBUTE ===============
    @Override
    public Attributes visitStructuralDirectiveAttribute(typescriptparser.StructuralDirectiveAttributeContext ctx) {
        Attributes attributes = new Attributes();

        // Process directive (guaranteed)
        String directive = ctx.STRUCTURAL_DIR_HTML().getText();
        attributes.setStructuralDir(directive);

        // Process value (guaranteed)
        String value = ctx.STRING_HTML().getText();
        attributes.setHtmlString(value);

        // Check for structural directive errors
        errorManager.checkStructuralDirectiveVariable(
                directive,
                ctx.STRUCTURAL_DIR_HTML().getSymbol().getLine(),
                ctx.STRUCTURAL_DIR_HTML().getSymbol().getCharPositionInLine()
        );

        // Add to symbol table
        if (!symbolTable.existsInCurrentScope(directive)) {
            symbolTable.addSymbol("STRUCTURAL_DIRECTIVE", directive);
        }

        return attributes;
    }

    // =============== BINDING ATTRIBUTE ===============
    @Override
    public Attributes visitBindingAttribute(typescriptparser.BindingAttributeContext ctx) {
        Attributes attributes = new Attributes();

        // Process binding (guaranteed)
        String binding = ctx.BINDING_HTML().getText();
        attributes.setBinding(binding);

        // Process value (guaranteed)
        String value = ctx.STRING_HTML().getText();
        attributes.setHtmlString(value);

        // Check for property binding mismatches
        String propertyName = binding.replace("[", "").replace("]", "");
        errorManager.checkPropertyBinding(
                propertyName,
                "RESOURCE_BINDING",
                ctx.BINDING_HTML().getSymbol().getLine(),
                ctx.BINDING_HTML().getSymbol().getCharPositionInLine()
        );

        // Add to symbol table
        if (!symbolTable.existsInCurrentScope(propertyName)) {
            symbolTable.addSymbol("BINDING_PROPERTY", propertyName);
        }

        return attributes;
    }

    // =============== EVENT BINDING ATTRIBUTE ===============
    @Override
    public Attributes visitEventBindingAttribute(typescriptparser.EventBindingAttributeContext ctx) {
        Attributes attributes = new Attributes();

        // Process event binding (guaranteed)
        String event = ctx.EVENT_BINDING_HTML().getText();
        attributes.setEvent(event);

        // Process value (guaranteed)
        String value = ctx.STRING_HTML().getText();
        attributes.setHtmlString(value);

        // Add to symbol table
        if (!symbolTable.existsInCurrentScope(event)) {
            symbolTable.addSymbol("EVENT_BINDING", event);
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
    public SelfClosingTag visitSelfClosingTagRule(typescriptparser.SelfClosingTagRuleContext ctx) {
        SelfClosingTag selfClosingTag = new SelfClosingTag();

        // Process all attributes (if any)
        for (typescriptparser.AttributesContext attrCtx : ctx.attributes()) {
            selfClosingTag.getAttributes().add((Attributes) visit(attrCtx));
        }

        return selfClosingTag;
    }






















































    // OLD METHOD (DELETE)
// @Override
// public Styles visitStyles(StylesContext ctx) {...}

    // NEW METHOD
    @Override
    public Styles visitStylesBlock(typescriptparser.StylesBlockContext ctx) {
        Styles styles = new Styles();
        symbolTable.enterScope("STYLES");
        styles.setCssBody((CssBody) visit(ctx.cssBody()));
        symbolTable.exitScope();
        return styles;
    }

    @Override
    public CssBody visitCssBodyRule(typescriptparser.CssBodyRuleContext ctx) {
        CssBody cssBody = new CssBody();

        // Process CSS objects (guaranteed to exist)
        symbolTable.enterScope("CSS_OBJECTS");
        cssBody.setCssObjects((CssObjects) visit(ctx.cssObjects()));
        symbolTable.exitScope();

        return cssBody;
    }

    @Override
    public CssObjects visitCssObjectsRule(typescriptparser.CssObjectsRuleContext ctx) {
        CssObjects cssObjects = new CssObjects();

        // Process all CSS elements (guaranteed to be 0 or more)
        for (typescriptparser.CsselementContext eCtx : ctx.csselement()) {
            symbolTable.enterScope("CSS_ELEMENT");
            // Dispatch to visitCssElementRule automatically
            cssObjects.getCssElementlist().add((CssElement) visit(eCtx));
            symbolTable.exitScope();
        }

        return cssObjects;
    }
    @Override
    public CssElement visitCssElementRule(typescriptparser.CssElementRuleContext ctx) {
        CssElement cssElement = new CssElement();

        // Process CSS selectors
        for (TerminalNode idNode : ctx.ID_CSS()) {
            String selector = idNode.getText();

            // Add selector to CSS element using new method
            cssElement.addSelector(selector);

            // Add to symbol table
            if (!symbolTable.existsInCurrentScope(selector)) {
                symbolTable.addSymbol("CSS_SELECTOR", selector);
            }
        }


        for (typescriptparser.BodyelementContext beCtx : ctx.bodyelement()) {
            // This will route to visitCssDeclaration
            Bodyelement bodyElement = (Bodyelement) visit(beCtx);
            cssElement.addBodyCssElement(bodyElement);
        }

        return cssElement;
    }
    @Override
    public Bodyelement visitCssDeclaration(typescriptparser.CssDeclarationContext ctx) {
        Bodyelement bodyelement = new Bodyelement();

        // Process CSS property name (guaranteed to exist)
        String cssId = ctx.ID_CSS().getText();
        bodyelement.setId_css(cssId);

        // Add CSS property to symbol table
        if (!symbolTable.existsInCurrentScope(cssId)) {
            symbolTable.addSymbol("CSS_PROPERTY", cssId);
        }

        // Process CSS value (guaranteed to exist)
        CssValue cssValue = (CssValue) visit(ctx.cssValue());
        bodyelement.setCssValue(cssValue);

        return bodyelement;
    }

    // Remove the old visitCssValue method and replace with these two methods:

    @Override
    public CssValue visitPercentValue(typescriptparser.PercentValueContext ctx) {
        CssValue cssValue = new CssValue();

        // Handle PERCENT token - guaranteed to exist
        String percentValue = ctx.PERCENT().getText();
        cssValue.getID_CSS().add(percentValue);

        // Add percent value to symbol table if not already in current scope
        if (!symbolTable.existsInCurrentScope(percentValue)) {
            symbolTable.addSymbol("CSS_PERCENT_VALUE", percentValue);
        }

        // Handle optional ID_CSS tokens
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
    public CssValue visitIdValue(typescriptparser.IdValueContext ctx) {
        CssValue cssValue = new CssValue();

        // Handle all ID_CSS tokens - first one is guaranteed to exist
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


    // ====================== OBJECT BODY RULE ======================
    @Override
    public BodyObject visitObjectBodyRule(typescriptparser.ObjectBodyRuleContext ctx) {
        BodyObject bodyObject = new BodyObject();

        for (typescriptparser.KeyValuePairContext kvCtx : ctx.keyValuePair()) {
            // Visit each key-value pair and add to bodyObject
            bodyObject.getInitvalues().add((Initvalue) visit(kvCtx));
        }

        return bodyObject;
    }

    // ====================== KEY VALUE PAIR ======================
    @Override
    public Initvalue visitKeyValue(typescriptparser.KeyValueContext ctx) {
        // Create a special Initvalue that preserves key information
        Initvalue initvalue = (Initvalue) visit(ctx.initvalue());

        // Store the key in the initvalue object
        initvalue.setObjectKey(ctx.ID().getText());

        // Add key to symbol table
        if (!symbolTable.existsInCurrentScope(initvalue.getObjectKey())) {
            symbolTable.addSymbol("OBJECT_KEY", initvalue.getObjectKey());
        }

        return initvalue;
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