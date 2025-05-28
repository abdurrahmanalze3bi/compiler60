package classes;

import gen.typescriptparser;
import gen.typescriptparserBaseVisitor;
import jdk.dynalink.Operation;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

public class MyVisitor extends typescriptparserBaseVisitor {

    SymbolTable symbolTable = new SymbolTable();
    private SemanticErrorManager errorManager;
    private String currentMethodName = null;
    private String currentMethodReturnType = null;
    public MyVisitor() {
        this.errorManager = new SemanticErrorManager(symbolTable);
        // Add this line:
        this.errorManager.initializeRequiredImports();
    }
    @Override
    public Program visitProgram(typescriptparser.ProgramContext ctx) {
        Program prog = new Program();




        // Visit all statements in the program
        for (int i = 0; i < ctx.statement().size(); i++) {
            if (ctx.statement(i) != null) {

                typescriptparser.StatementContext stmtCtx = ctx.statement(i);
                /*System.out.println("Statement " + i + ":");
                System.out.println("  - componentDeclaration: " + (stmtCtx.componentDeclaration() != null));
                System.out.println("  - importDeclaration: " + (stmtCtx.importDeclaration() != null));
                System.out.println("  - classDeclaration: " + (stmtCtx.classDeclaration() != null));
                System.out.println("  - methodDeclaration: " + (stmtCtx.methodDeclaration() != null));
                System.out.println("  - variableDeclaration: " + (stmtCtx.variableDeclaration() != null));
                System.out.println("  - interfaceDeclaration: " + (stmtCtx.interfaceDeclaration() != null));
                System.out.println("  - Raw text: " + stmtCtx.getText());
                System.out.println();
*/
                prog.getStatments().add(visitStatement(ctx.statement(i)));
            }
        }



        // Print final symbol table
        this.symbolTable.print();

        // Print semantic errors found during analysis
        this.errorManager.printErrorsWithSymbolTable();

        return prog;
    }
    private boolean shouldCheckForImport(String identifier) {
        // Define which identifiers typically require imports
        return identifier.equals("Component") ||
                identifier.equals("Injectable") ||
                identifier.equals("OnInit") ||
                identifier.equals("Router") ||
                identifier.equals("HttpClient");
        // Add more based on your needs
    }

    private String getRequiredImport(String identifier) {
        Map<String, String> imports = new HashMap<>();
        imports.put("Component", "@angular/core");
        imports.put("Injectable", "@angular/core");
        imports.put("OnInit", "@angular/core");
        imports.put("Router", "@angular/router");
        imports.put("HttpClient", "@angular/common/http");

        return imports.get(identifier);
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
            if (ctx.classDeclaration().ID() != null) {
                String className = ctx.classDeclaration().ID().getText();

                // FIXED: Check for duplicate BEFORE entering CLASS scope
                errorManager.checkDuplicateDeclaration(className, "CLASS",
                        ctx.classDeclaration().getStart().getLine(),
                        ctx.classDeclaration().getStart().getCharPositionInLine());

                // Add to current scope (GLOBAL) if not duplicate
                if (!symbolTable.existsInCurrentScope(className)) {
                    symbolTable.addSymbol("CLASS", className);
                }
            }

            // Now enter class scope for processing class body
            symbolTable.enterScope("CLASS");
            statment.setClassDeclaration(visitClassDeclaration(ctx.classDeclaration()));
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
            if (ctx.interfaceDeclaration().ID() != null) {
                String interfaceName = ctx.interfaceDeclaration().ID().getText();

                // FIXED: Check for duplicate BEFORE entering INTERFACE scope
                errorManager.checkDuplicateDeclaration(interfaceName, "INTERFACE",
                        ctx.interfaceDeclaration().getStart().getLine(),
                        ctx.interfaceDeclaration().getStart().getCharPositionInLine());

                // Add to current scope if not duplicate
                if (!symbolTable.existsInCurrentScope(interfaceName)) {
                    symbolTable.addSymbol("INTERFACE", interfaceName);
                }
            }

            // Now enter interface scope for processing interface body
            symbolTable.enterScope("INTERFACE");
            statment.setInterfaceDeclaration(visitInterfaceDeclaration(ctx.interfaceDeclaration()));
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

            // CRITICAL FIX: Check if the variable is defined in any accessible scope
            Row existingSymbol = symbolTable.lookupSymbol(variableName);
            if (existingSymbol == null) {
                // Variable is not defined - add semantic error for undefined variable
                errorManager.checkUndefinedReference(variableName,
                        ctx.ID().getSymbol().getLine(),
                        ctx.ID().getSymbol().getCharPositionInLine());

                // Still add it to symbol table as an undefined reference
                symbolTable.addSymbol("UNDEFINED_VARIABLE", variableName);
            } else {
                // Variable exists - add it as a reference in current scope if not already present
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

        if (ctx.ID() != null && ctx.ID().getText() != null) {
            String idValue = ctx.ID().getText();
            importDeclaration.setId(idValue);
            errorManager.registerImport(idValue);
            // Add to symbol table with scope information if not already exists
            if (!symbolTable.existsInCurrentScope(idValue)) {
                symbolTable.addSymbol("IMPORT_ID", idValue);
            }
        }

        if (ctx.STRING_LIT() != null && ctx.STRING_LIT().getText() != null) {
            String stringValue = ctx.STRING_LIT().getText();
            importDeclaration.setString_lit(stringValue);

            // Add import path to symbol table
            symbolTable.addSymbol("IMPORT_PATH", stringValue);
        }

        return importDeclaration;
    }

    @Override
    public ClassDeclaration visitClassDeclaration(typescriptparser.ClassDeclarationContext ctx) {
        ClassDeclaration classDeclaration = new ClassDeclaration();

        if (ctx.ID() != null && ctx.ID().getText() != null) {
            String className = ctx.ID().getText();
            // REMOVED: Duplicate check is now handled in visitStatement before entering CLASS scope
            classDeclaration.setNameClass(className);
        }

        if (ctx.classDeclarationBody() != null) {
            classDeclaration.setClassDeclarationBody(
                    visitClassDeclarationBody(ctx.classDeclarationBody())
            );
        }

        return classDeclaration;
    }
    @Override
    public ClassDeclarationBody visitClassDeclarationBody(typescriptparser.ClassDeclarationBodyContext ctx) {
        ClassDeclarationBody classDeclarationBody = new ClassDeclarationBody();

        // Don't enter a new scope here - we're already in the CLASS scope from visitStatement
        // Just process the class members directly in the current CLASS scope
        if(ctx.classMember() != null) {
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
        boolean hasContent = false;

        if (ctx.propertyDeclaration() != null) {
            classMember.setPropertyDeclaration(visitPropertyDeclaration(ctx.propertyDeclaration()));
            hasContent = true;
        }

        if (ctx.methodDeclaration() != null) {
            // Method declarations within classes create their own scope
            symbolTable.enterScope("METHOD");
            classMember.setMethodDeclaration(visitMethodDeclaration(ctx.methodDeclaration()));
            symbolTable.exitScope();
            hasContent = true;
        }

        return hasContent ? classMember : null;
    }

    @Override
    public PropertyDeclaration visitPropertyDeclaration(typescriptparser.PropertyDeclarationContext ctx) {
        PropertyDeclaration propertyDeclaration = new PropertyDeclaration();

        for (TerminalNode idNode : ctx.ID()) {
            String propertyId = idNode.getText();
            propertyDeclaration.getID().add(propertyId);

            // Guard against duplicates in current scope
            if (!symbolTable.existsInCurrentScope(propertyId)) {
                symbolTable.addSymbol("PROPERTY", propertyId);
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

        if (ctx.ID() != null && ctx.ID().getText() != null) {
            String methodName = ctx.ID().getText();

            // Check for duplicate declaration
            errorManager.checkDuplicateDeclaration(methodName, "METHOD",
                    ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());

            methodDeclaration.setName(methodName);

            // Guard against duplicates in current scope
            if (!symbolTable.existsInCurrentScope(methodName)) {
                symbolTable.addSymbol("METHOD", methodName);
            }

            // Get return type for method registration
            String returnType = "void"; // Default to void
            if (ctx.type() != null) {
                returnType = ctx.type().getText();
            }

            // Register method declaration for return type checking
            errorManager.registerMethodDeclaration(methodName, returnType,
                    ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());

            // **CRITICAL**: Store current method info for return statement checking
            this.currentMethodName = methodName;
            this.currentMethodReturnType = returnType;


            // Check method signature
            boolean hasReturnType = (ctx.type() != null);
            boolean hasParameters = (ctx.parameterList() != null);
            errorManager.checkMethodSignature(methodName, hasReturnType, hasParameters,
                    ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }

        if (ctx.parameterList() != null) {
            methodDeclaration.setParameterLists(visitParameterList(ctx.parameterList()));
        }

        if (ctx.type() != null) {
            methodDeclaration.setTypeReturn(visitType(ctx.type()));
        }

        if (ctx.methodBody() != null) {
            // New scope for local variables
            symbolTable.enterScope("METHOD_BODY");
            methodDeclaration.setMethodBody(visitMethodBody(ctx.methodBody()));

            // After visiting method body, check for missing return statements
            if (currentMethodName != null) {
                errorManager.checkMethodReturnCompleteness(currentMethodName,
                        ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            }

            symbolTable.exitScope();

            // **CRITICAL**: Clear current method info after processing
            this.currentMethodName = null;
            this.currentMethodReturnType = null;
        }

        return methodDeclaration;
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

            // CHECK FOR REQUIRED IMPORT - ADD THIS LINE
            checkIdentifierForRequiredImport(idType, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());

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
        symbolTable.enterScope("PARAMETERS");
        for (typescriptparser.ParameterContext pCtx : ctx.parameter()) {
            parameterList.getParameters().add(visitParameter(pCtx));
        }
        symbolTable.exitScope();
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

if(ctx.expression()!=null){
returnN.setExpressionReturn(visitExpression(ctx.expression()));
}

        // **CRITICAL FIX**: Get the actual return value from the context
        String returnValue = null;
        String returnType = null;

        // Handle ID return value (like 'return x;')
        if (ctx.ID() != null && ctx.ID().getText() != null) {
            returnValue = ctx.ID().getText();
            returnType = "ID";
            returnN.setValueReturn(returnValue);

            // Check if the returned variable exists in symbol table
            Row existingSymbol = symbolTable.lookupSymbol(returnValue);
            if (existingSymbol == null) {
                errorManager.checkUndefinedReference(returnValue, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            }

            // Add as return value reference if not already in current scope
            if (!symbolTable.existsInCurrentScope(returnValue)) {
                symbolTable.addSymbol("RETURN_VALUE", returnValue);
            }
        }

        // Handle boolean return value
        if (ctx.isboolean() != null) {
            returnN.setBoolReturn(visitIsboolean(ctx.isboolean()));
            returnType = "boolean";
            returnValue = ctx.isboolean().getText();
        }

        // **ENHANCED FIX**: Check for any non-empty return in void methods
        // This handles cases where the parser might not capture the return value properly
        String contextText = ctx.getText();


        if (contextText != null && !contextText.equals("return") && !contextText.equals("return;")) {
            // Extract potential return value from context text
            String potentialReturnValue = contextText.replace("return", "").replace(";", "").trim();


            if (!potentialReturnValue.isEmpty()) {
                // If we haven't already captured a return value, use this one
                if (returnValue == null) {
                    returnValue = potentialReturnValue;
                    returnType = "unknown";
                    returnN.setValueReturn(returnValue); // **ADD THIS LINE**
                }
            }
        }

        // **CRITICAL**: Use current method name to check return statement
        if (currentMethodName != null) {


            errorManager.checkReturnStatement(currentMethodName, returnValue, returnType,
                    ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
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
            symbolTable.enterScope("OBJECT");
            object.setBodyObject(visitBodyobject(ctx.bodyobject()));
            symbolTable.exitScope();
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

            // CHECK FOR REQUIRED IMPORT - ADD THIS LINE
            checkIdentifierForRequiredImport(functionName, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());

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

            // Add decorator symbol if not already present
            if (!symbolTable.existsInCurrentScope(decoratorValue)) {
                symbolTable.addSymbol("DECORATOR", decoratorValue);
            }
        }

        if (ctx.componentDeclarationBody() != null) {
            // Cast the result to ComponentDeclarationBody
            ComponentDeclarationBody body = (ComponentDeclarationBody) visitComponentDeclarationBody(ctx.componentDeclarationBody());
            componentDeclaration.setComponentDeclarationBody(body);

            // Check component requirements
            boolean hasSelector = body.getComponentBodyElements().stream()
                    .anyMatch(element -> element.getSelector() != null);
            boolean hasTemplate = body.getComponentBodyElements().stream()
                    .anyMatch(element -> element.getTemplate() != null);

            if (ctx.DECORATOR() != null) {
                errorManager.checkComponentDecorator(ctx.DECORATOR().getText(),
                        hasSelector, hasTemplate,
                        ctx.getStart().getLine(),
                        ctx.getStart().getCharPositionInLine());
            }
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
    private void checkIdentifierForRequiredImport(String identifier, int line, int column) {
        if (identifier == null) return;

        // Check if this identifier requires an import
        if (shouldCheckForImport(identifier)) {
            String requiredImport = getRequiredImport(identifier);
            if (requiredImport != null && !errorManager.isImported(identifier)) {
                errorManager.checkMissingImport(identifier, requiredImport, line, column);
            }
        }
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

        // Add 'standalone' property to symbol table
        if (!symbolTable.existsInCurrentScope("standalone")) {
            symbolTable.addSymbol("COMPONENT_PROPERTY", "standalone");
        }

        if (ctx.isboolean() != null) {
            standalone.setIsboolean(visitIsboolean(ctx.isboolean()));

            // Get the boolean value and add it to symbol table
            String booleanValue = ctx.isboolean().getText();
            if (booleanValue != null) {
                // Add the specific boolean value (true/false)
                if (!symbolTable.existsInCurrentScope(booleanValue)) {
                    symbolTable.addSymbol("STANDALONE_VALUE", booleanValue);
                }

                // Semantic validation: Check if the boolean value is valid
                if (!booleanValue.equals("true") && !booleanValue.equals("false")) {
                    errorManager.checkInvalidStandaloneValue(booleanValue,
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine());
                }
            }
        } else {
            // Semantic validation: standalone property should have a boolean value
            errorManager.checkMissingStandaloneValue(
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());
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

            // Check if the interpolated variable is defined
            errorManager.checkUndefinedReference(name,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());

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

        if (ctx.STRING_HTML() != null) {
            String s = ctx.STRING_HTML().getText();
            attributes.setHtmlString(s);
            if (!symbolTable.existsInCurrentScope(s)) {
                symbolTable.addSymbol("HTML_STRING_ATTRIBUTE", s);
            }
        }

        if (ctx.NAME_HTML() != null) {
            String name = ctx.NAME_HTML().getText();
            attributes.setHtmlName(name);

            // **KEY FIX**: Check for structural directives here
            // This is where ngFor without * would be detected
            if (name != null) {
                // Check if this is a structural directive without *
                if (name.equals("ngFor") || name.equals("ngIf") || name.equals("ngSwitch") ||
                        name.equals("ngSwitchCase") || name.equals("ngSwitchDefault")) {
                    errorManager.checkMissingStructuralDirective(name,
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine());
                }
            }

            if (!symbolTable.existsInCurrentScope(name)) {
                symbolTable.addSymbol("HTML_NAME_ATTRIBUTE", name);
            }
        }

        if (ctx.BINDING_HTML() != null) {
            String bind = ctx.BINDING_HTML().getText();
            attributes.setBinding(bind);
            if (!symbolTable.existsInCurrentScope(bind)) {
                symbolTable.addSymbol("RESOURCE_BINDING", bind);
            }
        }

        if (ctx.STRUCTURAL_DIR_HTML() != null) {
            String dir = ctx.STRUCTURAL_DIR_HTML().getText();
            attributes.setStructuralDir(dir);

            // This should catch *ngFor, *ngIf etc. (the correct form)
            // But also validate that * is present
            if (dir != null && !dir.startsWith("*")) {
                errorManager.checkMissingStructuralDirective(dir,
                        ctx.getStart().getLine(),
                        ctx.getStart().getCharPositionInLine());
            }

            if (!symbolTable.existsInCurrentScope(dir)) {
                symbolTable.addSymbol("ANGULAR_STRUCTURAL_DIRECTIVE", dir);
            }
        }

        if (ctx.EVENT_BINDING_HTML() != null) {
            String evt = ctx.EVENT_BINDING_HTML().getText();
            attributes.setEvent(evt);
            if (!symbolTable.existsInCurrentScope(evt)) {
                symbolTable.addSymbol("EVENT_BINDING", evt);
            }
        }

        return attributes;
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

        // Set the interface name
        if (ctx.ID() != null && ctx.ID().getText() != null) {
            String interfaceName = ctx.ID().getText();
            interfaceDeclaration.setNameInterface(interfaceName);

        }



        // Process interface members
        for (int i = 0; i < ctx.interfaceMember().size(); i++) {
            typescriptparser.InterfaceMemberContext imCtx = ctx.interfaceMember(i);

            System.out.println("  - propertyDeclaration: " + (imCtx.propertyDeclaration() != null));
            System.out.println("  - methodDeclaration: " + (imCtx.methodDeclaration() != null));
            System.out.println("  - Raw text: " + imCtx.getText());

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
            symbolTable.enterScope("OBJECT_BODY");
            for (typescriptparser.InitvalueContext ivCtx : ctx.initvalue()) {
                bodyObject.getInitvalues().add(visitInitvalue(ivCtx));
            }
            symbolTable.exitScope();
        }

        return bodyObject;
    }

    }