package classes;
import gen.typescriptlexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
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
                // Use generic visit() instead of visitStatement()
                prog.getStatments().add((Statment) visit(ctx.statement(i)));
            }
        }

        this.symbolTable.print();
        this.errorManager.finalizeAnalysis();
        this.errorManager.printErrors();
        return prog;
    }

    // =============== COMPONENT STATEMENT ===============
    @Override
    public Statment visitComponentStmt(typescriptparser.ComponentStmtContext ctx) {
        Statment statment = new Statment();
        symbolTable.enterScope("COMPONENT");
        // Use generic visit() instead of specific method
        statment.setComponentDeclaration((ComponentDeclaration) visit(ctx.componentDeclaration()));
        symbolTable.exitScope();
        return statment;
    }
    // =============== CLASS STATEMENT ===============
    @Override
    public Statment visitClassStmt(typescriptparser.ClassStmtContext ctx) {
        Statment statment = new Statment();
        typescriptparser.ClassDeclarationContext classCtx = ctx.classDeclaration();

        // Cast to specific context to access ID
        typescriptparser.ClassDeclRuleContext classRuleCtx = (typescriptparser.ClassDeclRuleContext) classCtx;
        String className = classRuleCtx.ID().getText();

        // Check for duplicate in current scope
        if (symbolTable.existsInCurrentScope(className)) {
            int line = classRuleCtx.ID().getSymbol().getLine();
            int column = classRuleCtx.ID().getSymbol().getCharPositionInLine();
            errorManager.reportDuplicateClass(className, line, column);
        } else {
            symbolTable.addSymbol("CLASS", className);
        }

        // Process class body
        symbolTable.enterScope("CLASS");
        // Use generic visit() instead of specific method
        statment.setClassDeclaration((ClassDeclaration) visit(classCtx));
        symbolTable.exitScope();
        return statment;
    }

    // =============== INTERFACE STATEMENT ===============
    @Override
    public Statment visitInterfaceStmt(typescriptparser.InterfaceStmtContext ctx) {
        Statment statment = new Statment();
        typescriptparser.InterfaceDeclarationContext interfaceCtx = ctx.interfaceDeclaration();
        String interfaceName = interfaceCtx.ID().getText();

        // Check for duplicate in current scope
        if (symbolTable.existsInCurrentScope(interfaceName)) {
            int line = interfaceCtx.ID().getSymbol().getLine();
            int column = interfaceCtx.ID().getSymbol().getCharPositionInLine();
            errorManager.reportDuplicateInterface(interfaceName, line, column);
        } else {
            symbolTable.addSymbol("INTERFACE", interfaceName);
        }

        // Process interface body
        symbolTable.enterScope("INTERFACE");
        // Use generic visit() instead of specific method
        statment.setInterfaceDeclaration((InterfaceDeclaration) visit(interfaceCtx));
        symbolTable.exitScope();
        return statment;
    }

    // =============== VARIABLE DECLARATION STATEMENT ===============
    @Override
    public Statment visitVariableDeclStmt(typescriptparser.VariableDeclStmtContext ctx) {
        Statment statment = new Statment();
        // Use generic visit() instead of specific method
        statment.setVariableDeclaration((VariableDeclaration) visit(ctx.variableDeclaration()));
        return statment;
    }

    // =============== ASSIGNMENT STATEMENT ===============
    @Override
    public Statment visitAssignmentStmt(typescriptparser.AssignmentStmtContext ctx) {
        Statment statment = new Statment();
        // Use generic visit() instead of specific method
        statment.setAssignmentStatement((AssignmentStatement) visit(ctx.assignmentStatement()));
        return statment;
    }
    // =============== FUNCTION CALL STATEMENT ===============
    @Override
    public Statment visitFunctionCallStmt(typescriptparser.FunctionCallStmtContext ctx) {
        Statment statment = new Statment();
        // Use generic visit() instead of specific method
        statment.setFunctionCall((FunctionCall) visit(ctx.functionCall()));
        return statment;
    }

    // =============== METHOD STATEMENT ===============
    @Override
    public Statment visitMethodStmt(typescriptparser.MethodStmtContext ctx) {
        Statment statment = new Statment();
        symbolTable.enterScope("METHOD");
        // Use generic visit() instead of specific method
        statment.setMethodDeclaration((MethodDeclaration) visit(ctx.methodDeclaration()));
        symbolTable.exitScope();
        return statment;
    }

    // =============== IMPORT STATEMENT ===============
    @Override
    public Statment visitImportStmt(typescriptparser.ImportStmtContext ctx) {
        Statment statement = new Statment();
        // Use generic visit with casting
        statement.setImportDeclaration((ImportDeclaration) visit(ctx.importDeclaration()));
        return statement;
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
        assignment.setExpression((Expression) visit(ctx.expression()));

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
    public ClassDeclaration visitClassDeclRule(typescriptparser.ClassDeclRuleContext ctx) {
        ClassDeclaration classDeclaration = new ClassDeclaration();

        // Mandatory elements (guaranteed non-null by rule structure)
        String className = ctx.ID().getText();
        classDeclaration.setNameClass(className);

        // Check for duplicate class in current scope
        if (symbolTable.existsInCurrentScope(className)) {
            errorManager.reportDuplicateClass(
                    className,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );
        } else {
            // Add class to current scope (should be Global)
            symbolTable.addSymbol("CLASS", className);
        }

        // Enter class scope for processing class body
        symbolTable.enterScope("CLASS");
        symbolTable.setCurrentScopeName("CLASS." + className);

        // Process class body (guaranteed non-null by rule structure)
        classDeclaration.setClassDeclarationBody(
                (ClassDeclarationBody) visit(ctx.classDeclarationBody())
        );

        // Exit class scope after processing
        symbolTable.exitScope();

        // Handle optional export modifier - FIXED
        if (ctx.EXPORT() != null) {
            classDeclaration.setExported(true);  // Now works
            symbolTable.addSymbol("EXPORT", className);
        } else {
            classDeclaration.setExported(false);  // Explicitly set to false
        }

        return classDeclaration;
    }

    @Override
    public ClassDeclarationBody visitClassBodyRule(typescriptparser.ClassBodyRuleContext ctx) {
        ClassDeclarationBody classDeclarationBody = new ClassDeclarationBody();

        // Directly access classMember list (guaranteed non-null by ANTLR)
        for (typescriptparser.ClassMemberContext memberCtx : ctx.classMember()) {
            // Safe cast due to classMember labeling
            classDeclarationBody.getClassMembers().add(
                    (ClassMember) visit(memberCtx)
            );
        }

        return classDeclarationBody;
    }


    // =============== CLASS METHOD MEMBER ===============
    @Override
    public ClassMember visitClassMethodMember(typescriptparser.ClassMethodMemberContext ctx) {
        ClassMember classMember = new ClassMember();

        // Process method within current CLASS scope
        classMember.setMethodDeclaration(
                (MethodDeclaration) visit(ctx.methodDeclaration())
        );

        return classMember;
    }

    // =============== CLASS PROPERTY MEMBER ===============
    @Override
    public ClassMember visitClassPropertyMember(typescriptparser.ClassPropertyMemberContext ctx) {
        ClassMember classMember = new ClassMember();

        // Process property within current CLASS scope
        classMember.setPropertyDeclaration(
                (PropertyDeclaration) visit(ctx.propertyDeclaration())
        );

        return classMember;
    }

    // =============== NESTED CLASS MEMBER ===============
    @Override
    public ClassMember visitNestedClassMember(typescriptparser.NestedClassMemberContext ctx) {
        ClassMember classMember = new ClassMember();

        // Process nested class
        classMember.setClassDeclaration(
                (ClassDeclaration) visit(ctx.classDeclaration())
        );

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

        // Process first ID (property name - guaranteed)
        String propName = ctx.ID(0).getText();
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
            // Get second ID (union type)
            String unionType = ctx.ID(1).getText();
            prop.setUnionType(unionType);

            // Add union type to symbol table
            if (!symbolTable.existsInCurrentScope(unionType)) {
                symbolTable.addSymbol("UNION_TYPE", unionType);
            }
        }

        return prop;
    }

    @Override
    public MethodDeclaration visitMethodDeclRule(typescriptparser.MethodDeclRuleContext ctx) {
        MethodDeclaration methodDeclaration = new MethodDeclaration();
        String methodName = ctx.ID().getText();
        methodDeclaration.setName(methodName);

        // Handle optional return type - FIXED
        String returnType = "void";
        if (ctx.type() != null) {
            // Use generic visit() for type
            TypeV typeV = (TypeV) visit(ctx.type());
            methodDeclaration.setTypeReturn(typeV);
            returnType = typeV.toString();
        }

        // Handle optional parameters
        List<String> parameterTypes = new ArrayList<>();
        if (ctx.parameterList() != null) {
            // Use generic visit for labeled rule dispatch
            ParameterList params = (ParameterList) visit(ctx.parameterList());
            methodDeclaration.setParameterLists(params);
            parameterTypes = extractParameterTypes(params);
        }

        // Process method body (mandatory)
        methodDeclaration.setMethodBody((MethodBody) visit(ctx.methodBody()));

        // === Symbol Table & Error Handling (keep your existing logic) ===
        SemanticErrorManager.MethodInfo methodInfo = null;
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

        MethodContext methodContext = new MethodContext(methodName, returnType, methodInfo);
        methodContextStack.push(methodContext);

        symbolTable.enterScope("METHOD");
        if (!symbolTable.existsInCurrentScope(methodName)) {
            symbolTable.addSymbol("METHOD", methodName);
        }

        // ... rest of your method body processing ...

        // Interface method check
        String currentScopeType = symbolTable.getCurrentScopeType();
        boolean isInterfaceMethod = currentScopeType != null &&
                (currentScopeType.equals("INTERFACE") || currentScopeType.equals("INTERFACE_METHOD"));

        // Return statement validation
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
        // FIX: Use generic visit() for list
        typeV.setListV((ListV) visit(ctx.list()));
        return typeV;
    }
    // =============== PLUS OPERATOR ===============
    @Override
    public Operator visitPlusOp(typescriptparser.PlusOpContext ctx) {
        Operator operator = new Operator();
        String op = ctx.PLUS().getText();
        operator.setPlus(op);

        if (!symbolTable.existsInCurrentScope(op)) {
            symbolTable.addSymbol("ARITHMETIC_OPERATOR", op);
        }

        return operator;
    }

    // =============== MINUS OPERATOR ===============
    @Override
    public Operator visitMinusOp(typescriptparser.MinusOpContext ctx) {
        Operator operator = new Operator();
        String op = ctx.MINUS().getText();
        operator.setMinus(op);

        if (!symbolTable.existsInCurrentScope(op)) {
            symbolTable.addSymbol("ARITHMETIC_OPERATOR", op);
        }

        return operator;
    }

    // =============== STAR OPERATOR ===============
    @Override
    public Operator visitStarOp(typescriptparser.StarOpContext ctx) {
        Operator operator = new Operator();
        String op = ctx.STAR().getText();
        operator.setMult(op);

        if (!symbolTable.existsInCurrentScope(op)) {
            symbolTable.addSymbol("ARITHMETIC_OPERATOR", op);
        }

        return operator;
    }

    // =============== SLASH OPERATOR ===============
    @Override
    public Operator visitSlashOp(typescriptparser.SlashOpContext ctx) {
        Operator operator = new Operator();
        String op = ctx.SLASH().getText();
        operator.setDiv(op);

        if (!symbolTable.existsInCurrentScope(op)) {
            symbolTable.addSymbol("ARITHMETIC_OPERATOR", op);
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
    public ParameterList visitParameterListRule(typescriptparser.ParameterListRuleContext ctx) {
        ParameterList parameterList = new ParameterList();
        for (typescriptparser.ParameterContext pCtx : ctx.parameter()) {
            // Use generic visit() for parameter
            parameterList.getParameters().add((Parameter) visit(pCtx));
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
        // Use generic visit() for bodylist
        initvalue.setBodyList((BodyList) visit(ctx.bodylist()));
        return initvalue;
    }

    // =============== OBJECT INIT VALUE ===============
    @Override
    public Initvalue visitObjectInitValue(typescriptparser.ObjectInitValueContext ctx) {
        Initvalue initvalue = new Initvalue();
        symbolTable.enterScope("OBJECT");
        // Use generic visit() for object
        initvalue.setObjectV((ObjectV) visit(ctx.object()));
        symbolTable.exitScope();
        return initvalue;
    }

    @Override
    public MethodBody visitMethodBodyRule(typescriptparser.MethodBodyRuleContext ctx) {
        MethodBody methodBody = new MethodBody();

        // Visit each labeled statement directly - no type checks needed!
        for (typescriptparser.StatementMethodContext smCtx : ctx.statementMethod()) {
            methodBody.getStatementMethods().add(
                    (StatementMethod) visit(smCtx)  // Safe cast due to labels
            );
        }

        return methodBody;
    }


    // =============== METHOD ASSIGNMENT ===============
    @Override
    public StatementMethod visitMethodAssignment(typescriptparser.MethodAssignmentContext ctx) {
        StatementMethod stmt = new StatementMethod();
        String varName = ctx.ID().getText();
        stmt.getVariable().add(varName);

        if (!symbolTable.existsInCurrentScope(varName)) {
            symbolTable.addSymbol("VARIABLE", varName);
        }

        // FIX: Use generic visit() instead of visitExpression()
        stmt.setExpression((Expression) visit(ctx.expression()));

        if (ctx.returnStatment() != null) {
            handleReturn(stmt, ctx.returnStatment());
        }

        return stmt;
    }
    // =============== METHOD THIS PROPERTY ASSIGNMENT ===============
    @Override
    public StatementMethod visitMethodThisPropertyAssignment(typescriptparser.MethodThisPropertyAssignmentContext ctx) {
        StatementMethod stmt = new StatementMethod();

        if (!symbolTable.existsInCurrentScope("this")) {
            symbolTable.addSymbol("KEYWORD", "this");
        }

        String propName = ctx.ID().getText();
        stmt.getVariable().add(propName);

        if (!symbolTable.existsInCurrentScope(propName)) {
            symbolTable.addSymbol("PROPERTY", propName);
        }

        // FIX: Use generic visit() instead of visitExpression()
        stmt.setExpression((Expression) visit(ctx.expression()));

        if (ctx.returnStatment() != null) {
            handleReturn(stmt, ctx.returnStatment());
        }

        return stmt;
    }

    // =============== METHOD EXPRESSION ===============
    @Override
    public StatementMethod visitMethodExpression(typescriptparser.MethodExpressionContext ctx) {
        StatementMethod stmt = new StatementMethod();
        // Use generic visit() for expression
        stmt.setExpression((Expression) visit(ctx.expression()));

        if (ctx.returnStatment() != null) {
            handleReturn(stmt, ctx.returnStatment());
        }

        return stmt;
    }

    // =============== METHOD RETURN ONLY ===============
    @Override
    public StatementMethod visitMethodReturnOnly(typescriptparser.MethodReturnOnlyContext ctx) {
        StatementMethod stmt = new StatementMethod();
        stmt.setIsreturn(true);

        if (!symbolTable.existsInCurrentScope("return")) {
            symbolTable.addSymbol("KEYWORD", "return");
        }

        // Use generic visit() for return
        stmt.setReturnN((ReturnN) visit(ctx.returnStatment()));
        return stmt;
    }

    // Helper method remains the same
    private void handleReturn(StatementMethod stmt, typescriptparser.ReturnStatmentContext returnCtx) {
        stmt.setIsreturn(true);

        if (!symbolTable.existsInCurrentScope("return")) {
            symbolTable.addSymbol("KEYWORD", "return");
        }

        // Use generic visit() for return
        stmt.setReturnN((ReturnN) visit(returnCtx));
    }
    // =============== RETURN EXPRESSION ===============
    @Override
    public ReturnN visitReturnExpression(typescriptparser.ReturnExpressionContext ctx) {
        ReturnN returnN = new ReturnN();
        // Use generic visit() for expression
        Expression expr = (Expression) visit(ctx.expression());
        returnN.setExpressionReturn(expr);
        String returnType = determineExpressionType(expr);
        processReturnStatement(returnN, ctx.expression().getText(), returnType, ctx);
        return returnN;
    }

    // =============== RETURN IDENTIFIER ===============
    @Override
    public ReturnN visitReturnIdentifier(typescriptparser.ReturnIdentifierContext ctx) {
        ReturnN returnN = new ReturnN();
        String idValue = ctx.ID().getText();
        returnN.setValueReturn(idValue);

        Row symbol = symbolTable.lookupSymbol(idValue);
        String returnType = symbol != null ? symbol.getType() : "any";

        processReturnStatement(returnN, idValue, returnType, ctx);
        return returnN;
    }

    // =============== RETURN BOOLEAN ===============
    @Override
    public ReturnN visitReturnBoolean(typescriptparser.ReturnBooleanContext ctx) {
        ReturnN returnN = new ReturnN();
        // Use generic visit() for isboolean
        returnN.setBoolReturn((IsBoolean) visit(ctx.isboolean()));
        processReturnStatement(returnN, ctx.isboolean().getText(), "boolean", ctx);
        return returnN;
    }

    // =============== RETURN VOID ===============
    @Override
    public ReturnN visitReturnVoid(typescriptparser.ReturnVoidContext ctx) {
        ReturnN returnN = new ReturnN();
        processReturnStatement(returnN, null, "void", ctx);
        return returnN;
    }

    // Common helper method for return processing
    private void processReturnStatement(ReturnN returnN, String returnValue,
                                        String returnType, ParserRuleContext ctx) {
        if (!methodContextStack.isEmpty()) {
            MethodContext currentMethod = methodContextStack.peek();
            currentMethod.markHasReturn();

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
        object.setBodyObject((BodyObject) visit(ctx.bodyobject()));
        return object;
    }

    // Const declaration
    @Override
    public VariableDeclaration visitConstDeclaration(typescriptparser.ConstDeclarationContext ctx) {
        return handleVarDeclaration(ctx, ctx.CONST().getText(), "const");
    }

    // Let declaration
    @Override
    public VariableDeclaration visitLetDeclaration(typescriptparser.LetDeclarationContext ctx) {
        return handleVarDeclaration(ctx, ctx.LET().getText(), "let");
    }

    // Var declaration
    private VariableDeclaration handleVarDeclaration(
            typescriptparser.VariableDeclarationContext ctx,
            String keyword,
            String keywordType
    ) {
        VariableDeclaration vd = new VariableDeclaration();
        String varName = "";

        // Get variable name from specific context
        if (ctx instanceof typescriptparser.ConstDeclarationContext) {
            varName = ((typescriptparser.ConstDeclarationContext) ctx).ID().getText();
        }
        else if (ctx instanceof typescriptparser.LetDeclarationContext) {
            varName = ((typescriptparser.LetDeclarationContext) ctx).ID().getText();
        }
        else if (ctx instanceof typescriptparser.VarDeclarationContext) {
            varName = ((typescriptparser.VarDeclarationContext) ctx).ID().getText();
        }

        vd.setName(varName);

        // Add to symbol table
        if (!symbolTable.existsInCurrentScope(varName)) {
            symbolTable.addSymbol("VARIABLE", varName);
        }

        // Set keyword-specific property
        switch (keywordType) {
            case "const": vd.setConstv(keyword); break;
            case "let": vd.setLet(keyword); break;
            case "var": vd.setVar(keyword); break;
        }

        // Add keyword to symbol table
        if (!symbolTable.existsInCurrentScope(keyword)) {
            symbolTable.addSymbol("KEYWORD", keyword);
        }

        // Handle expression if present - use specific context types
        if (ctx instanceof typescriptparser.ConstDeclarationContext) {
            typescriptparser.ConstDeclarationContext constCtx =
                    (typescriptparser.ConstDeclarationContext) ctx;
            if (constCtx.expression() != null) {
                vd.setExpression((Expression) visit(constCtx.expression()));
            }
        }
        else if (ctx instanceof typescriptparser.LetDeclarationContext) {
            typescriptparser.LetDeclarationContext letCtx =
                    (typescriptparser.LetDeclarationContext) ctx;
            if (letCtx.expression() != null) {
                vd.setExpression((Expression) visit(letCtx.expression()));
            }
        }
        else if (ctx instanceof typescriptparser.VarDeclarationContext) {
            typescriptparser.VarDeclarationContext varCtx =
                    (typescriptparser.VarDeclarationContext) ctx;
            if (varCtx.expression() != null) {
                vd.setExpression((Expression) visit(varCtx.expression()));
            }
        }

        return vd;
    }
    // String literal
    @Override
    public Expression visitStringLiteralExpr(typescriptparser.StringLiteralExprContext ctx) {
        Expression expr = new Expression();
        String value = ctx.STRING_LIT().getText();
        expr.setString(value);

        if (!symbolTable.existsInCurrentScope(value)) {
            symbolTable.addSymbol("STRING_LITERAL", value);
        }

        return expr;
    }

    // Number literal
    @Override
    public Expression visitNumberLiteralExpr(typescriptparser.NumberLiteralExprContext ctx) {
        Expression expr = new Expression();
        String value = ctx.NUMBER_LIT().getText();
        expr.setString(value);

        if (!symbolTable.existsInCurrentScope(value)) {
            symbolTable.addSymbol("NUMBER_LITERAL", value);
        }

        return expr;
    }

    // Identifier
    @Override
    public Expression visitIdentifierExpr(typescriptparser.IdentifierExprContext ctx) {
        Expression expr = new Expression();
        String id = ctx.ID().getText();
        expr.setString(id);

        if (!symbolTable.existsInCurrentScope(id)) {
            symbolTable.addSymbol("ID_REFERENCE", id);
        }

        return expr;
    }

    // Boolean literal
    @Override
    public Expression visitBooleanLiteralExpr(typescriptparser.BooleanLiteralExprContext ctx) {
        Expression expr = new Expression();
        // Change BooleanValue to IsBoolean
        expr.setIsboolean((IsBoolean) visit(ctx.isboolean()));
        return expr;
    }
    // Function call expression

    @Override
    public Expression visitFunctionCallExpr(typescriptparser.FunctionCallExprContext ctx) {
        Expression expr = new Expression();
        // Use generic visit() for function call
        expr.setFunctionCall((FunctionCall) visit(ctx.functionCall()));
        return expr;
    }

    // Variable declaration expression
    @Override
    public Expression visitVariableDeclarationExpr(typescriptparser.VariableDeclarationExprContext ctx) {
        Expression expr = new Expression();
        // Use generic visit() for variable declaration
        expr.setVariableDeclaration((VariableDeclaration) visit(ctx.variableDeclaration()));
        return expr;
    }

    // Member access expression
    @Override
    public Expression visitMemberAccessExpr(typescriptparser.MemberAccessExprContext ctx) {
        Expression expr = new Expression();
        // Use generic visit() for member access
        expr.setMemberAccess((MemberAccess) visit(ctx.memberAccess()));
        return expr;
    }

    // Binary expression
    @Override
    public Expression visitBinaryExpr(typescriptparser.BinaryExprContext ctx) {
        Expression expr = new Expression();
        // Use generic visit() for left/right expressions
        Expression left = (Expression) visit(ctx.expression(0));
        Expression right = (Expression) visit(ctx.expression(1));

        // Handle operator directly (no visit needed)
        String op = ctx.operator().getText();
        expr.setString(left.getString() + " " + op + " " + right.getString());
        return expr;
    }

    // Parenthesized expression
    @Override
    public Expression visitParenthesizedExpr(typescriptparser.ParenthesizedExprContext ctx) {
        // Use generic visit() for expression
        return (Expression) visit(ctx.expression());
    }



    @Override
    public FunctionCall visitStandardFunctionCall(typescriptparser.StandardFunctionCallContext ctx) {
        FunctionCall fc = new FunctionCall();
        String name = ctx.ID().getText();
        fc.setNameFun(name);

        if (!symbolTable.existsInCurrentScope(name)) {
            symbolTable.addSymbol("FUNCTION_CALL", name);
        }

        for (typescriptparser.ArgumentContext argCtx : ctx.argument()) {
            // Use generic visit() for arguments
            fc.getArguments().add((Argument) visit(argCtx));
        }

        return fc;
    }

    @Override
    public Argument visitExpressionArgument(typescriptparser.ExpressionArgumentContext ctx) {
        Argument argument = new Argument();
        // Use generic visit() for expression
        argument.setExpression((Expression) visit(ctx.expression()));
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
            // Use generic visit() for elements
            template.getElement().add((Element) visit(elemCtx));
        }
        return template;
    }

    // =============== TAG ELEMENT ===============
    @Override
    public Element visitTagElement(typescriptparser.TagElementContext ctx) {
        Element element = new Element();
        // Use generic visit() for tag
        element.setTag((Tag) visit(ctx.tag()));
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

        // Use generic visit() for opening/closing tags
        tag.setOpeningTag((OpeningTag) visit(ctx.openingTag()));
        tag.setClosingTag((ClosingTag) visit(ctx.closingTag()));

        // Process nested elements with generic visit()
        for (typescriptparser.ElementContext nested : ctx.element()) {
            tag.getElements().add((Element) visit(nested));
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

        if (ctx.ID() != null) {
            String interfaceName = ctx.ID().getText();
            interfaceDeclaration.setNameInterface(interfaceName);

            if (symbolTable.existsInCurrentScope(interfaceName)) {
                int line = ctx.ID().getSymbol().getLine();
                int column = ctx.ID().getSymbol().getCharPositionInLine();
                errorManager.reportDuplicateInterface(interfaceName, line, column);
            } else {
                symbolTable.addSymbol("INTERFACE", interfaceName);
            }
        }

        // Fixed: Use generic visit() instead of visitInterfaceMember()
        for (typescriptparser.InterfaceMemberContext imCtx : ctx.interfaceMember()) {
            InterfaceMember member = (InterfaceMember) visit(imCtx);
            if (member != null) {
                interfaceDeclaration.getInterfaceMembers().add(member);
            }
        }

        return interfaceDeclaration;
    }


    // =============== INTERFACE PROPERTY MEMBER ===============
    @Override
    public InterfaceMember visitInterfacePropertyMember(typescriptparser.InterfacePropertyMemberContext ctx) {
        InterfaceMember interfaceMember = new InterfaceMember();

        // Guaranteed to be PropertyDeclaration by rule structure
        interfaceMember.setPropertyDeclaration(
                (PropertyDeclaration) visit(ctx.propertyDeclaration())
        );

        return interfaceMember;
    }

    // =============== INTERFACE METHOD MEMBER ===============
    @Override
    public InterfaceMember visitInterfaceMethodMember(typescriptparser.InterfaceMethodMemberContext ctx) {
        InterfaceMember interfaceMember = new InterfaceMember();

        symbolTable.enterScope("INTERFACE_METHOD");

        // Guaranteed to be MethodDeclaration by rule structure
        interfaceMember.setMethodDeclaration(
                (MethodDeclaration) visit(ctx.methodDeclaration())
        );

        symbolTable.exitScope();
        return interfaceMember;
    }


    // ====================== OBJECT BODY RULE ======================
    @Override
    public BodyObject visitObjectBodyRule(typescriptparser.ObjectBodyRuleContext ctx) {
        BodyObject bodyObject = new BodyObject();
        List<ParseTree> children = ctx.children;

        String currentKey = null;

        for (ParseTree child : children) {
            // Get key (ID)
            if (child instanceof TerminalNode) {
                TerminalNode node = (TerminalNode) child;
                if (node.getSymbol().getType() == typescriptlexer.ID) {
                    currentKey = node.getText();
                }
            }
            // Get value (initvalue)
            else if (child instanceof typescriptparser.InitvalueContext) {
                if (currentKey != null) {
                    Initvalue value = (Initvalue) visit(child);
                    value.setObjectKey(currentKey);

                    if (!symbolTable.existsInCurrentScope(currentKey)) {
                        symbolTable.addSymbol("OBJECT_KEY", currentKey);
                    }

                    bodyObject.getInitvalues().add(value);
                    currentKey = null;
                }
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