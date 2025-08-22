package classes;
import gen.typescriptlexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import gen.typescriptparser;
import gen.typescriptparserBaseVisitor;
import jdk.dynalink.Operation;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Stack;


public class MyVisitor extends typescriptparserBaseVisitor {
    // NEW METHOD - ADD THIS
    public String generateVanillaWebCode() {
        VanillaWebCodeGenerator generator = new VanillaWebCodeGenerator(symbolTable);
        // Note: VanillaWebCodeGenerator doesn't have generateCode() method
        // It uses generateFromAST() which is called from Main
        return "Vanilla Web code generation initiated";
    }
    private SymbolTable symbolTable = new SymbolTable();


    public MyVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }
    public SymbolTable getSymbolTable() {
        return symbolTable;
    }
    // UNIFIED SYMBOL TABLE - This is the main app-wide symbol table

    // Method tracking for return analysis
    private Stack<MethodContext> currentMethodStack = new Stack<>();

    // Method signature tracking for duplicate detection
    private Map<String, EnhancedSemanticErrorManager.MethodSignatureInfo> methodSignatures = new HashMap<>();

    // Class tracking for duplicate detection
    private Set<String> declaredClasses = new HashSet<>();
    private Map<String, Integer> classDeclarationLines = new HashMap<>();

    // Interface tracking for duplicate detection
    private Set<String> declaredInterfaces = new HashSet<>();
    private Map<String, Integer> interfaceDeclarationLines = new HashMap<>();

    public MyVisitor() {
        // The unified symbol table now handles all error reporting internally
        // Each error type will create its own specialized symbol table
    }

    @Override
    public Program visitProgram(typescriptparser.ProgramContext ctx) {
        Program prog = new Program();

        for (int i = 0; i < ctx.statement().size(); i++) {
            if (ctx.statement(i) != null) {
                prog.getStatments().add((Statment) visit(ctx.statement(i)));
            }
        }

        // Print unified symbol table and comprehensive error report
        this.symbolTable.print();

        // Print comprehensive error report with specialized symbol tables
        if (symbolTable.hasErrors()) {
            System.out.println("\n" + symbolTable.getComprehensiveReport());
            symbolTable.printErrorReport();
        } else {
            System.out.println("\n=== NO SEMANTIC ERRORS DETECTED ===");
            System.out.println("All symbols and references are properly defined.");
        }

        return prog;
    }


    // =============== COMPONENT STATEMENT ===============
    @Override
    public Statment visitComponentStmt(typescriptparser.ComponentStmtContext ctx) {
        Statment statment = new Statment();
        symbolTable.enterScope("COMPONENT");
        statment.setComponentDeclaration((ComponentDeclaration) visit(ctx.componentDeclaration()));
        symbolTable.exitScope();
        return statment;
    }
    // =============== CLASS STATEMENT ===============
    @Override
    public Statment visitClassStmt(typescriptparser.ClassStmtContext ctx) {
        Statment statment = new Statment();
        typescriptparser.ClassDeclarationContext classCtx = ctx.classDeclaration();
        typescriptparser.ClassDeclRuleContext classRuleCtx = (typescriptparser.ClassDeclRuleContext) classCtx;

        String className = classRuleCtx.ID().getText();
        int line = classRuleCtx.ID().getSymbol().getLine();
        int column = classRuleCtx.ID().getSymbol().getCharPositionInLine();

        // Check for duplicate class using NEW ENHANCED SYSTEM
        if (declaredClasses.contains(className)) {
            int previousLine = classDeclarationLines.get(className);
            // This creates a DuplicateClassError with ClassSymbolTable (MAP)
            symbolTable.reportDuplicateClass(className, line, column, previousLine);
        } else {
            declaredClasses.add(className);
            classDeclarationLines.put(className, line);
            symbolTable.addSymbol("CLASS", className);
        }

        symbolTable.enterScope("CLASS");
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
        int line = interfaceCtx.ID().getSymbol().getLine();
        int column = interfaceCtx.ID().getSymbol().getCharPositionInLine();

        // Extract extended interfaces if any
        List<String> extendedInterfaces = new ArrayList<>();
        // TODO: Extract from context if your grammar supports interface inheritance

        // Check for duplicate interface using NEW ENHANCED SYSTEM
        if (declaredInterfaces.contains(interfaceName)) {
            int previousLine = interfaceDeclarationLines.get(interfaceName);
            // This creates a DuplicateInterfaceError with InterfaceSymbolTable (BINARY TREE)
            symbolTable.reportDuplicateInterface(interfaceName, extendedInterfaces, line, column, previousLine);
        } else {
            declaredInterfaces.add(interfaceName);
            interfaceDeclarationLines.put(interfaceName, line);
            symbolTable.addSymbol("INTERFACE", interfaceName);
        }

        symbolTable.enterScope("INTERFACE");
        statment.setInterfaceDeclaration((InterfaceDeclaration) visit(interfaceCtx));
        symbolTable.exitScope();
        return statment;
    }

    // =============== VARIABLE DECLARATION STATEMENT ===============
    @Override
    public Statment visitVariableDeclStmt(typescriptparser.VariableDeclStmtContext ctx) {
        Statment statment = new Statment();
        statment.setVariableDeclaration((VariableDeclaration) visit(ctx.variableDeclaration()));
        return statment;
    }

    // =============== ASSIGNMENT STATEMENT ===============
    @Override
    public Statment visitAssignmentStmt(typescriptparser.AssignmentStmtContext ctx) {
        Statment statment = new Statment();
        statment.setAssignmentStatement((AssignmentStatement) visit(ctx.assignmentStatement()));
        return statment;
    }
    // =============== FUNCTION CALL STATEMENT ===============
    @Override
    public Statment visitFunctionCallStmt(typescriptparser.FunctionCallStmtContext ctx) {
        Statment statment = new Statment();
        statment.setFunctionCall((FunctionCall) visit(ctx.functionCall()));
        return statment;
    }

    // =============== METHOD STATEMENT ===============
    @Override
    public Statment visitMethodStmt(typescriptparser.MethodStmtContext ctx) {
        Statment statment = new Statment();
        symbolTable.enterScope("METHOD");
        statment.setMethodDeclaration((MethodDeclaration) visit(ctx.methodDeclaration()));
        symbolTable.exitScope();
        return statment;
    }

    // =============== IMPORT STATEMENT ===============
    @Override
    public Statment visitImportStmt(typescriptparser.ImportStmtContext ctx) {
        Statment statement = new Statment();
        statement.setImportDeclaration((ImportDeclaration) visit(ctx.importDeclaration()));
        return statement;
    }
    @Override
    public AssignmentStatement visitAssignmentRule(typescriptparser.AssignmentRuleContext ctx) {
        AssignmentStatement assignment = new AssignmentStatement();

        String variableName = ctx.ID().getText();
        assignment.setVariable(variableName);

        int line = ctx.ID().getSymbol().getLine();
        int column = ctx.ID().getSymbol().getCharPositionInLine();

        // Check for undefined variable using NEW ENHANCED SYSTEM
        Row existingSymbol = symbolTable.lookupSymbol(variableName);
        if (existingSymbol == null) {
            // This creates an UndefinedVariableError with VariableSymbolTable (MAP)
            symbolTable.reportUndefinedVariable(variableName, line, column);
        } else if (!symbolTable.existsInCurrentScope(variableName)) {
            symbolTable.addSymbol("VARIABLE_REFERENCE", variableName);
        }

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
        // Process standard import
        if (ctx.ID() != null) {
            String importId = ctx.ID().getText();
            symbolTable.addSymbol("IMPORT_ID", importId);
        }
        if (ctx.STRING_LIT() != null) {
            String importPath = ctx.STRING_LIT().getText();
            symbolTable.addSymbol("IMPORT_PATH", importPath);
        }
        return importDecl;
    }
    @Override
    public ImportDeclaration visitComponentImportDecl(typescriptparser.ComponentImportDeclContext ctx) {
        ImportDeclaration importDecl = new ImportDeclaration();

        // Process component import - use COMPONENT() instead of ID()
        if (ctx.COMPONENT() != null) {
            String componentId = ctx.COMPONENT().getText(); // This gets "Component"
            symbolTable.addSymbol("COMPONENT", componentId);
            importDecl.setId(componentId);
        }

        if (ctx.STRING_LIT() != null) {
            String importPath = ctx.STRING_LIT().getText();
            symbolTable.addSymbol("IMPORT_PATH", importPath);
            importDecl.setString_lit(importPath);
        }

        return importDecl;
    }

    @Override
    public ImportDeclaration visitImportArrayDecl(typescriptparser.ImportArrayDeclContext ctx) {
        ImportDeclaration importDecl = new ImportDeclaration();
        // Process array import
        return importDecl;
    }

    @Override
    public ClassDeclaration visitClassDeclRule(typescriptparser.ClassDeclRuleContext ctx) {
        ClassDeclaration classDeclaration = new ClassDeclaration();

        String className = ctx.ID().getText();
        classDeclaration.setNameClass(className);

        // Enter class scope for processing class body
        symbolTable.enterScope("CLASS");

        // Process class body
        classDeclaration.setClassDeclarationBody(
                (ClassDeclarationBody) visit(ctx.classDeclarationBody())
        );

        // Handle optional export modifier
        if (ctx.EXPORT() != null) {
            classDeclaration.setExported(true);
            symbolTable.addSymbol("EXPORT", className);
        } else {
            classDeclaration.setExported(false);
        }

        symbolTable.exitScope();
        return classDeclaration;
    }

    @Override
    public ClassDeclarationBody visitClassBodyRule(typescriptparser.ClassBodyRuleContext ctx) {
        ClassDeclarationBody classDeclarationBody = new ClassDeclarationBody();

        for (typescriptparser.ClassMemberContext memberCtx : ctx.classMember()) {
            classDeclarationBody.getClassMembers().add((ClassMember) visit(memberCtx));
        }

        return classDeclarationBody;
    }



    // =============== CLASS METHOD MEMBER ===============
    @Override
    public ClassMember visitClassMethodMember(typescriptparser.ClassMethodMemberContext ctx) {
        ClassMember classMember = new ClassMember();
        classMember.setMethodDeclaration((MethodDeclaration) visit(ctx.methodDeclaration()));
        return classMember;
    }

    @Override
    public ClassMember visitClassPropertyMember(typescriptparser.ClassPropertyMemberContext ctx) {
        ClassMember classMember = new ClassMember();
        classMember.setPropertyDeclaration((PropertyDeclaration) visit(ctx.propertyDeclaration()));
        return classMember;
    }

    @Override
    public ClassMember visitNestedClassMember(typescriptparser.NestedClassMemberContext ctx) {
        ClassMember classMember = new ClassMember();
        classMember.setClassDeclaration((ClassDeclaration) visit(ctx.classDeclaration()));
        return classMember;
    }
    // =============== PROPERTY WITH INITIAL VALUE ===============
    @Override
    public PropertyDeclaration visitPropertyWithoutInit(typescriptparser.PropertyWithoutInitContext ctx) {
        PropertyDeclaration prop = new PropertyDeclaration();

        // Get the first ID (property name)
        String propName = ctx.ID(0).getText();
        prop.getID().add(propName);

        // Handle type if present
        if (ctx.type() != null) {
            TypeV typeV = (TypeV) visit(ctx.type());
            prop.setTypeV(typeV);
        }

        // Add to symbol table - let the system handle type inference
        symbolTable.addComponentProperty(propName, "any");

        if (!symbolTable.existsInCurrentScope(propName)) {
            symbolTable.addSymbol("PROPERTY", propName);
        }

        return prop;
    }


    @Override
    public PropertyDeclaration visitPropertyWithInit(typescriptparser.PropertyWithInitContext ctx) {
        PropertyDeclaration prop = new PropertyDeclaration();

        // Get the property name
        String propName = ctx.ID().getText();
        prop.getID().add(propName);

        System.out.println(">>> Processing property: " + propName);

        // Handle type if present
        if (ctx.type() != null) {
            TypeV typeV = (TypeV) visit(ctx.type());
            prop.setTypeV(typeV);
        }

        // Handle initial value - ENHANCED EXTRACTION
        if (ctx.initvalue() != null) {
            System.out.println(">>> Property has initial value, extracting...");

            Initvalue initVal = (Initvalue) visit(ctx.initvalue());
            prop.setInitvalue(initVal);

            // Debug: Print what was extracted
            String extractedInfo = getInitValueInfo(initVal);
            System.out.println(">>> Extracted property: " + propName + " = " + extractedInfo);
        } else {
            System.out.println(">>> Property has no initial value");
            System.out.println(">>> Extracted property: " + propName + " = null");
        }

        // Add to symbol table
        symbolTable.addComponentProperty(propName, "any");
        if (!symbolTable.existsInCurrentScope(propName)) {
            symbolTable.addSymbol("PROPERTY", propName);
        }

        return prop;
    }
    @Override
    public MethodDeclaration visitMethodDeclRule(typescriptparser.MethodDeclRuleContext ctx) {
        MethodDeclaration methodDeclaration = new MethodDeclaration();
        String methodName = ctx.ID().getText();
        methodDeclaration.setName(methodName);
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        // Handle return type
        String returnType = "void";
        if (ctx.type() != null) {
            TypeV typeV = (TypeV) visit(ctx.type());
            methodDeclaration.setTypeReturn(typeV);
            returnType = extractTypeFromTypeV(typeV);
        }

        // Handle parameters
        List<String> parameterTypes = new ArrayList<>();
        if (ctx.parameterList() != null) {
            ParameterList params = (ParameterList) visit(ctx.parameterList());
            methodDeclaration.setParameterLists(params);
            parameterTypes = extractParameterTypes(params);
        }

        // Create method signature
        String methodSignature = createMethodSignature(methodName, parameterTypes);

        // Check for duplicate method using NEW ENHANCED SYSTEM
        if (methodSignatures.containsKey(methodSignature)) {
            EnhancedSemanticErrorManager.MethodSignatureInfo existing = methodSignatures.get(methodSignature);
            // This creates a DuplicateMethodError with MethodSymbolTable (MAP)
            symbolTable.reportDuplicateMethod(methodName, parameterTypes, line, column, existing.getLine());
        } else {
            methodSignatures.put(methodSignature, new EnhancedSemanticErrorManager.MethodSignatureInfo(methodName, methodSignature, returnType, line));
        }

        // Create method context for tracking returns
        MethodContext methodContext = new MethodContext(methodName, returnType, methodSignature);
        currentMethodStack.push(methodContext);
        symbolTable.enterScope("METHOD");

        if (!symbolTable.existsInCurrentScope(methodName)) {
            symbolTable.addSymbol("METHOD", methodName);
        }

        // Process method body
        methodDeclaration.setMethodBody((MethodBody) visit(ctx.methodBody()));

        // Check for missing return statement using NEW ENHANCED SYSTEM
        String currentScopeType = symbolTable.getCurrentScopeType();
        boolean isInterfaceMethod = currentScopeType != null &&
                (currentScopeType.equals("INTERFACE") || currentScopeType.equals("INTERFACE_METHOD"));

        if (!isInterfaceMethod && !returnType.equals("void") && !methodContext.hasReturnStatement()) {
            // This creates a MissingReturnStatementError with ReturnPathSymbolTable (BINARY TREE)
            symbolTable.reportMissingReturnStatement(methodName, returnType, line, column);
        }

        symbolTable.exitScope();
        currentMethodStack.pop();
        return methodDeclaration;
    }





    private String extractTypeFromTypeV(TypeV typeV) {
        if (typeV == null) return "any";

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
                return "Array";
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
        symbolTable.addSymbol("STRING_TYPE", typeName);
        return typeV;
    }

    @Override
    public TypeV visitNumberType(typescriptparser.NumberTypeContext ctx) {
        TypeV typeV = new TypeV();
        String typeName = ctx.NUMBER_TYPE().getText();
        typeV.setNumber_type(typeName);
        symbolTable.addSymbol("NUMBER_TYPE", typeName);
        return typeV;
    }

    @Override
    public TypeV visitBooleanType(typescriptparser.BooleanTypeContext ctx) {
        TypeV typeV = new TypeV();
        String typeName = ctx.BOOLEAN_TYPE().getText();
        typeV.setIsboolean(typeName);
        symbolTable.addSymbol("BOOLEAN_TYPE", typeName);
        return typeV;
    }

    @Override
    public TypeV visitAnyType(typescriptparser.AnyTypeContext ctx) {
        TypeV typeV = new TypeV();
        String typeName = ctx.ANY_TYPE().getText();
        typeV.setString_type(typeName);
        symbolTable.addSymbol("ANY_TYPE", typeName);
        return typeV;
    }

    @Override
    public TypeV visitVoidType(typescriptparser.VoidTypeContext ctx) {
        TypeV typeV = new TypeV();
        String typeName = ctx.VOID_TYPE().getText();
        typeV.setString_type(typeName);
        symbolTable.addSymbol("VOID_TYPE", typeName);
        return typeV;
    }

    @Override
    public TypeV visitIdType(typescriptparser.IdTypeContext ctx) {
        TypeV typeV = new TypeV();
        String typeName = ctx.ID().getText();
        typeV.setString_type(typeName);
        symbolTable.addSymbol("TYPE", typeName);
        return typeV;
    }

    @Override
    public TypeV visitListType(typescriptparser.ListTypeContext ctx) {
        TypeV typeV = new TypeV();
        typeV.setListV((ListV) visit(ctx.list()));
        return typeV;
    }

    // =============== PLUS OPERATOR ===============
    @Override
    public Operator visitPlusOp(typescriptparser.PlusOpContext ctx) {
        Operator operator = new Operator();
        String op = ctx.PLUS().getText();
        operator.setPlus(op);
        symbolTable.addSymbol("ARITHMETIC_OPERATOR", op);
        return operator;
    }

    @Override
    public Operator visitMinusOp(typescriptparser.MinusOpContext ctx) {
        Operator operator = new Operator();
        String op = ctx.MINUS().getText();
        operator.setMinus(op);
        symbolTable.addSymbol("ARITHMETIC_OPERATOR", op);
        return operator;
    }

    @Override
    public Operator visitStarOp(typescriptparser.StarOpContext ctx) {
        Operator operator = new Operator();
        String op = ctx.STAR().getText();
        operator.setMult(op);
        symbolTable.addSymbol("ARITHMETIC_OPERATOR", op);
        return operator;
    }

    @Override
    public Operator visitSlashOp(typescriptparser.SlashOpContext ctx) {
        Operator operator = new Operator();
        String op = ctx.SLASH().getText();
        operator.setDiv(op);
        symbolTable.addSymbol("ARITHMETIC_OPERATOR", op);
        return operator;
    }

    @Override
    public MemberAccess visitThisMemberAccess(typescriptparser.ThisMemberAccessContext ctx) {
        MemberAccess memberAccess = new MemberAccess();
        memberAccess.setThis(true);
        symbolTable.addSymbol("KEYWORD", "this");

        String memberName = ctx.ID().getText();
        memberAccess.setMemberName(memberName);
        symbolTable.addSymbol("PROPERTY_REFERENCE", memberName);
        return memberAccess;
    }

    @Override
    public MemberAccess visitSimpleMemberAccess(typescriptparser.SimpleMemberAccessContext ctx) {
        MemberAccess memberAccess = new MemberAccess();
        String memberName = ctx.ID().getText();
        memberAccess.setMemberName(memberName);

        Row existingSymbol = symbolTable.lookupSymbol(memberName);
        if (existingSymbol != null) {
            symbolTable.addSymbol("MEMBER_REFERENCE", memberName);
        } else {
            symbolTable.addSymbol("MEMBER_ACCESS", memberName);
        }
        return memberAccess;
    }
    @Override
    public ListV visitListDeclaration(typescriptparser.ListDeclarationContext ctx) {
        ListV listV = new ListV();
        String listName = ctx.ID().getText();
        listV.setNameList(listName);
        symbolTable.addSymbol("LIST_TYPE", listName);
        return listV;
    }
    @Override
    public ParameterList visitParameterListRule(typescriptparser.ParameterListRuleContext ctx) {
        ParameterList parameterList = new ParameterList();
        for (typescriptparser.ParameterContext pCtx : ctx.parameter()) {
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

        System.out.println(">>> Found number value: " + numberValue);
        symbolTable.addSymbol("NUMBER_LITERAL", numberValue);
        return initvalue;
    }
    // =============== STRING INIT VALUE ===============
    @Override
    public Initvalue visitStringInitValue(typescriptparser.StringInitValueContext ctx) {
        Initvalue initvalue = new Initvalue();
        String stringValue = ctx.STRING_LIT().getText();
        initvalue.setString(stringValue);

        System.out.println(">>> Found string value: " + stringValue);
        symbolTable.addSymbol("STRING_LITERAL", stringValue);
        return initvalue;
    }

    @Override
    public Initvalue visitBooleanInitValue(typescriptparser.BooleanInitValueContext ctx) {
        Initvalue initvalue = new Initvalue();
        initvalue.setIsBoolean((IsBoolean) visit(ctx.isboolean()));

        System.out.println(">>> Found boolean value: " + ctx.isboolean().getText());
        return initvalue;
    }
    @Override
    public Initvalue visitListInitValue(typescriptparser.ListInitValueContext ctx) {
        Initvalue initvalue = new Initvalue();

        System.out.println(">>> Found list/array value");
        initvalue.setBodyList((BodyList) visit(ctx.bodylist()));

        return initvalue;
    }


    @Override
    public Initvalue visitObjectInitValue(typescriptparser.ObjectInitValueContext ctx) {
        Initvalue initvalue = new Initvalue();

        System.out.println(">>> Found nested object, entering scope...");
        symbolTable.enterScope("OBJECT");
        initvalue.setObjectV((ObjectV) visit(ctx.object()));
        symbolTable.exitScope();
        System.out.println(">>> Exited nested object scope");

        return initvalue;
    }

    @Override
    public MethodBody visitMethodBodyRule(typescriptparser.MethodBodyRuleContext ctx) {
        MethodBody methodBody = new MethodBody();
        for (typescriptparser.StatementMethodContext smCtx : ctx.statementMethod()) {
            methodBody.getStatementMethods().add((StatementMethod) visit(smCtx));
        }
        return methodBody;
    }

    // =============== METHOD ASSIGNMENT ===============
    @Override
    public StatementMethod visitMethodAssignment(typescriptparser.MethodAssignmentContext ctx) {
        StatementMethod stmt = new StatementMethod();
        String varName = ctx.ID().getText();
        stmt.getVariable().add(varName);
        symbolTable.addSymbol("VARIABLE", varName);
        stmt.setExpression((Expression) visit(ctx.expression()));

        if (ctx.returnStatment() != null) {
            handleReturn(stmt, ctx.returnStatment());
        }
        return stmt;
    }

    @Override
    public StatementMethod visitMethodThisPropertyAssignment(typescriptparser.MethodThisPropertyAssignmentContext ctx) {
        StatementMethod stmt = new StatementMethod();
        symbolTable.addSymbol("KEYWORD", "this");

        String propName = ctx.ID().getText();
        stmt.getVariable().add(propName);
        symbolTable.addSymbol("PROPERTY", propName);
        stmt.setExpression((Expression) visit(ctx.expression()));

        if (ctx.returnStatment() != null) {
            handleReturn(stmt, ctx.returnStatment());
        }
        return stmt;
    }

    @Override
    public StatementMethod visitMethodExpression(typescriptparser.MethodExpressionContext ctx) {
        StatementMethod stmt = new StatementMethod();
        stmt.setExpression((Expression) visit(ctx.expression()));

        if (ctx.returnStatment() != null) {
            handleReturn(stmt, ctx.returnStatment());
        }
        return stmt;
    }

    @Override
    public StatementMethod visitMethodReturnOnly(typescriptparser.MethodReturnOnlyContext ctx) {
        StatementMethod stmt = new StatementMethod();
        stmt.setIsreturn(true);
        symbolTable.addSymbol("KEYWORD", "return");
        stmt.setReturnN((ReturnN) visit(ctx.returnStatment()));
        return stmt;
    }

    private void handleReturn(StatementMethod stmt, typescriptparser.ReturnStatmentContext returnCtx) {
        stmt.setIsreturn(true);
        symbolTable.addSymbol("KEYWORD", "return");
        stmt.setReturnN((ReturnN) visit(returnCtx));
    }
    // =============== RETURN EXPRESSION ===============
    @Override
    public ReturnN visitReturnExpression(typescriptparser.ReturnExpressionContext ctx) {
        ReturnN returnN = new ReturnN();
        Expression expr = (Expression) visit(ctx.expression());
        returnN.setExpressionReturn(expr);

        String returnType = determineExpressionType(expr);
        String returnValue = ctx.expression().getText();
        processReturnStatement(returnN, returnValue, returnType, ctx);
        return returnN;
    }

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

    @Override
    public ReturnN visitReturnBoolean(typescriptparser.ReturnBooleanContext ctx) {
        ReturnN returnN = new ReturnN();
        returnN.setBoolReturn((IsBoolean) visit(ctx.isboolean()));
        processReturnStatement(returnN, ctx.isboolean().getText(), "boolean", ctx);
        return returnN;
    }

    @Override
    public ReturnN visitReturnVoid(typescriptparser.ReturnVoidContext ctx) {
        ReturnN returnN = new ReturnN();
        processReturnStatement(returnN, null, "void", ctx);
        return returnN;
    }


    // Common helper method for return processing
    private void processReturnStatement(ReturnN returnN, String returnValue, String returnType, ParserRuleContext ctx) {
        if (!currentMethodStack.isEmpty()) {
            MethodContext currentMethod = currentMethodStack.peek();
            currentMethod.markHasReturn();

            String methodName = currentMethod.getMethodName();
            String expectedReturnType = currentMethod.getReturnType();

            int line = ctx.getStart().getLine();
            int column = ctx.getStart().getCharPositionInLine();

            // Check return type mismatch using NEW ENHANCED SYSTEM
            if (!expectedReturnType.equals("void") && returnValue != null) {
                if (!areTypesCompatible(expectedReturnType, returnType)) {
                    // This creates a ReturnTypeMismatchError with TypeSymbolTable (BINARY TREE)
                    symbolTable.reportReturnTypeMismatch(methodName, expectedReturnType, returnType, line, column);
                }
            }

            // Check void method returning value using NEW ENHANCED SYSTEM
            if (expectedReturnType.equals("void") && returnValue != null && !returnValue.trim().isEmpty()) {
                // This creates a VoidMethodReturnValueError with VoidMethodSymbolTable (LIST)
                symbolTable.reportVoidMethodReturnValue(methodName, returnValue, line, column);
            }
        }
    }


    private List<String> extractParameterTypes(ParameterList parameterList) {
        List<String> types = new ArrayList<>();
        if (parameterList == null || parameterList.getParameters() == null) {
            return types;
        }

        try {
            for (Parameter parameter : parameterList.getParameters()) {
                if (parameter != null && parameter.getTypeV() != null) {
                    String paramType = extractTypeFromTypeV(parameter.getTypeV());
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

        // Add to unified symbol table
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

        // Add to unified symbol table
        if (!symbolTable.existsInCurrentScope(falseValue)) {
            symbolTable.addSymbol("BOOLEAN_LITERAL", falseValue);
        }
        return isBoolean;
    }

    @Override
    public BodyList visitBodyListRule(typescriptparser.BodyListRuleContext ctx) {
        BodyList bodyList = new BodyList();

        System.out.println(">>> Processing BodyList...");
        symbolTable.enterScope("BODY_LIST");

        int itemCount = ctx.initvalue().size();
        System.out.println(">>> BodyList has " + itemCount + " items");

        // Process all initvalues
        for (int i = 0; i < ctx.initvalue().size(); i++) {
            System.out.println(">>> Processing array item " + i + "...");

            typescriptparser.InitvalueContext ivCtx = ctx.initvalue(i);
            Initvalue initValue = (Initvalue) visit(ivCtx);
            bodyList.getInitvalues().add(initValue);

            // Debug: Print what was extracted
            String extractedInfo = getInitValueInfo(initValue);
            System.out.println(">>> Array item " + i + " extracted: " + extractedInfo);
        }

        symbolTable.exitScope();
        System.out.println(">>> Array extraction completed with " + itemCount + " items");

        return bodyList;
    }
    private String getInitValueInfo(Initvalue initValue) {
        if (initValue == null) return "null";

        // Check what type of value this is
        if (initValue.getNumber() != null) {
            return "number(" + initValue.getNumber() + ")";
        }
        if (initValue.getString() != null) {
            return "string(" + initValue.getString() + ")";
        }
        if (initValue.getIsBoolean() != null) {
            return "boolean(" + initValue.getIsBoolean() + ")";
        }
        if (initValue.getObjectV() != null) {
            // Count properties in the object
            BodyObject bodyObj = initValue.getObjectV().getBodyObject();
            if (bodyObj != null) {
                int propCount = bodyObj.getInitvalues() != null ? bodyObj.getInitvalues().size() : 0;
                return "{" + propCount + " props}";
            }
            return "{object}";
        }
        if (initValue.getBodyList() != null) {
            int listSize = initValue.getBodyList().getInitvalues() != null ?
                    initValue.getBodyList().getInitvalues().size() : 0;
            return "[" + listSize + " items]";
        }

        return "unknown";
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
            String keywordType) {

        VariableDeclaration vd = new VariableDeclaration();
        String varName = "";

        // Get variable name from specific context
        if (ctx instanceof typescriptparser.ConstDeclarationContext) {
            varName = ((typescriptparser.ConstDeclarationContext) ctx).ID().getText();
        } else if (ctx instanceof typescriptparser.LetDeclarationContext) {
            varName = ((typescriptparser.LetDeclarationContext) ctx).ID().getText();
        } else if (ctx instanceof typescriptparser.VarDeclarationContext) {
            varName = ((typescriptparser.VarDeclarationContext) ctx).ID().getText();
        }

        vd.setName(varName);

        // Check for duplicate variable in current scope
        if (symbolTable.existsInCurrentScope(varName)) {
            // This would trigger duplicate variable error - but that's handled by variable management
            // For now, just add to symbol table
        }

        // Add variable to unified symbol table
        symbolTable.addSymbol("VARIABLE", varName);

        // Set keyword-specific property
        switch (keywordType) {
            case "const":
                vd.setConstv(keyword);
                break;
            case "let":
                vd.setLet(keyword);
                break;
            case "var":
                vd.setVar(keyword);
                break;
        }

        // Add keyword to symbol table
        if (!symbolTable.existsInCurrentScope(keyword)) {
            symbolTable.addSymbol("KEYWORD", keyword);
        }

        // Handle expression if present
        if (ctx instanceof typescriptparser.ConstDeclarationContext) {
            typescriptparser.ConstDeclarationContext constCtx = (typescriptparser.ConstDeclarationContext) ctx;
            if (constCtx.expression() != null) {
                vd.setExpression((Expression) visit(constCtx.expression()));
            }
        } else if (ctx instanceof typescriptparser.LetDeclarationContext) {
            typescriptparser.LetDeclarationContext letCtx = (typescriptparser.LetDeclarationContext) ctx;
            if (letCtx.expression() != null) {
                vd.setExpression((Expression) visit(letCtx.expression()));
            }
        } else if (ctx instanceof typescriptparser.VarDeclarationContext) {
            typescriptparser.VarDeclarationContext varCtx = (typescriptparser.VarDeclarationContext) ctx;
            if (varCtx.expression() != null) {
                vd.setExpression((Expression) visit(varCtx.expression()));
            }
        }

        return vd;
    }

    // String literal
    @Override
    public Expression visitIdentifierExpr(typescriptparser.IdentifierExprContext ctx) {
        Expression expr = new Expression();
        String id = ctx.ID().getText();
        expr.setString(id);

        // NEW: Check if identifier is defined using the new error system
        if (symbolTable.lookupSymbol(id) == null) {
            // Report undefined variable using new system (creates VariableSymbolTable with MAP)
            symbolTable.reportUndefinedVariable(
                    id,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );
        } else {
            // Add as reference if it exists
            symbolTable.addSymbol("ID_REFERENCE", id);
        }

        return expr;
    }

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

    @Override
    public Expression visitBooleanLiteralExpr(typescriptparser.BooleanLiteralExprContext ctx) {
        Expression expr = new Expression();
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

        String decoratorValue = ctx.DECORATOR().getText();
        componentDeclaration.setDecorato(decoratorValue);

        // Check for missing @ symbol
        if (!decoratorValue.startsWith("@")) {
            // This could be handled by a specialized error type if needed
            System.err.println("Warning: Missing @ symbol in decorator at line " + ctx.getStart().getLine());
        }

        // Add to symbol table
        if (!symbolTable.existsInCurrentScope(decoratorValue)) {
            symbolTable.addSymbol("DECORATOR", decoratorValue);
        }

        // Process component body
        symbolTable.enterScope("COMPONENT");
        ComponentDeclarationBody body = (ComponentDeclarationBody) visit(ctx.componentDeclarationBody());
        componentDeclaration.setComponentDeclarationBody(body);
        symbolTable.exitScope();

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

        // Extract tag name from TAG_OPEN_START_HTML token
        if (ctx.TAG_OPEN_START_HTML() != null) {
            String tagOpenText = ctx.TAG_OPEN_START_HTML().getText();
            // TAG_OPEN_START_HTML should contain something like "<div" or "<span"
            if (tagOpenText.startsWith("<")) {
                String tagName = tagOpenText.substring(1); // Remove the "<"
                openingTag.setName(tagName);
            }
        }

        // Process attributes
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
        String attrName = ctx.NAME_HTML().getText();
        String attrValue = ctx.STRING_HTML().getText();

        attributes.setHtmlName(attrName);
        attributes.setHtmlString(attrValue);

        // NEW: Check for literal binding that should be property binding
        String cleanValue = attrValue.replaceAll("['\"]", "");
        Set<String> bindableProperties = Set.of("src", "href", "value", "class", "style", "id");

        if (bindableProperties.contains(attrName)) {
            if (cleanValue.matches("[a-zA-Z_][a-zA-Z0-9_]*") || cleanValue.contains(".")) {
                // Report literal binding error (creates LiteralBindingSymbolTable with LIST)
                symbolTable.reportLiteralBindingForProperty(
                        attrName,
                        cleanValue,
                        ctx.NAME_HTML().getSymbol().getLine(),
                        ctx.NAME_HTML().getSymbol().getCharPositionInLine()
                );
            }
        }

        if (!symbolTable.existsInCurrentScope(attrName)) {
            symbolTable.addSymbol("HTML_ATTRIBUTE", attrName);
        }

        return attributes;
    }




    // =============== STRUCTURAL DIRECTIVE ATTRIBUTE ===============

    @Override
    public Attributes visitStructuralDirectiveAttribute(typescriptparser.StructuralDirectiveAttributeContext ctx) {
        Attributes attributes = new Attributes();
        String directive = ctx.STRUCTURAL_DIR_HTML().getText();
        String value = ctx.STRING_HTML().getText();

        attributes.setStructuralDir(directive);
        attributes.setHtmlString(value);

        // Extract and validate structural directive variables
        String cleanValue = value.replaceAll("['\"]", "");
        String variableName = extractVariableFromDirective(cleanValue, directive);

        if (variableName != null) {
            // ✅ Use unified symbolTable interface - creates DirectiveSymbolTable (LIST)
            symbolTable.reportUndefinedStructuralDirective(
                    variableName,
                    directive,
                    ctx.STRUCTURAL_DIR_HTML().getSymbol().getLine(),
                    ctx.STRUCTURAL_DIR_HTML().getSymbol().getCharPositionInLine()
            );
        }

        if (!symbolTable.existsInCurrentScope(directive)) {
            symbolTable.addSymbol("STRUCTURAL_DIRECTIVE", directive);
        }

        return attributes;
    }

    // =============== BINDING ATTRIBUTE ===============
    @Override
    public Attributes visitBindingAttribute(typescriptparser.BindingAttributeContext ctx) {
        Attributes attributes = new Attributes();
        String binding = ctx.BINDING_HTML().getText();
        String value = ctx.STRING_HTML().getText();

        attributes.setBinding(binding);
        attributes.setHtmlString(value);

        // Extract property name and check binding
        String propertyName = binding.replace("[", "").replace("]", "");
        String cleanValue = value.replaceAll("['\"]", "");

        // CORRECT WAY: Use symbolTable's error reporting method
        // This creates a PropertyBindingMismatchError with PropertyBindingSymbolTable (MAP)
        symbolTable.reportPropertyBindingMismatch(
                propertyName,
                "PROPERTY_BINDING",
                "any", // Expected type - you might want to infer this
                ctx.BINDING_HTML().getSymbol().getLine(),
                ctx.BINDING_HTML().getSymbol().getCharPositionInLine()
        );

        // Add symbol to main symbol table for tracking
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
                // ✅ Fixed: Use symbolTable instead of errorManager
                symbolTable.reportDuplicateInterface(
                        interfaceName,
                        new ArrayList<>(), // empty extends list
                        line,
                        column,
                        1 // placeholder previous line
                );
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
    // ====================== FIXED OBJECT BODY RULE ======================
    @Override
    public BodyObject visitObjectBodyRule(typescriptparser.ObjectBodyRuleContext ctx) {
        BodyObject bodyObject = new BodyObject();
        System.out.println(">>> Processing ObjectBodyRule...");

        // Debug: Print the actual parse tree structure
        System.out.println(">>> Parse tree child count: " + ctx.getChildCount());
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            System.out.println(">>> Child " + i + ": " + child.getClass().getSimpleName() + " = '" + child.getText() + "'");
        }

        // Check if the object body is empty
        if (ctx.getChildCount() == 0) {
            System.out.println(">>> Empty object body - no children found");
            return bodyObject;
        }

        // Try different approaches to extract data
        try {
            // Approach 1: Try calling the methods (might work if grammar is correct)
            try {
                java.lang.reflect.Method idMethod = ctx.getClass().getMethod("ID");
                java.lang.reflect.Method initvalueMethod = ctx.getClass().getMethod("initvalue");

                @SuppressWarnings("unchecked")
                List<TerminalNode> ids = (List<TerminalNode>) idMethod.invoke(ctx);
                @SuppressWarnings("unchecked")
                List<typescriptparser.InitvalueContext> values = (List<typescriptparser.InitvalueContext>) initvalueMethod.invoke(ctx);

                if (ids != null && values != null) {
                    System.out.println(">>> Reflection approach worked! Found " + ids.size() + " keys, " + values.size() + " values");

                    for (int i = 0; i < ids.size() && i < values.size(); i++) {
                        String key = ids.get(i).getText();
                        typescriptparser.InitvalueContext valueCtx = values.get(i);

                        System.out.println(">>> Processing property: " + key);

                        Initvalue initValue = (Initvalue) visit(valueCtx);
                        initValue.setObjectKey(key);

                        if (!symbolTable.existsInCurrentScope(key)) {
                            symbolTable.addSymbol("OBJECT_KEY", key);
                        }

                        bodyObject.getInitvalues().add(initValue);
                        System.out.println(">>> Added property: " + key + " = " + getInitValueInfo(initValue));
                    }
                }
            } catch (Exception reflectionEx) {
                System.out.println(">>> Reflection approach failed: " + reflectionEx.getMessage());

                // Approach 2: Manual parsing with better logic
                List<String> keys = new ArrayList<>();
                List<typescriptparser.InitvalueContext> values = new ArrayList<>();

                // Look for the pattern: ID COLON initvalue
                for (int i = 0; i < ctx.getChildCount() - 2; i++) {
                    ParseTree child1 = ctx.getChild(i);
                    ParseTree child2 = ctx.getChild(i + 1);
                    ParseTree child3 = ctx.getChild(i + 2);

                    // Check for ID : initvalue pattern
                    if (child1 instanceof TerminalNode && child3 instanceof typescriptparser.InitvalueContext) {
                        TerminalNode idNode = (TerminalNode) child1;
                        if (child2.getText().equals(":") && idNode.getSymbol().getType() == typescriptlexer.ID) {
                            String key = idNode.getText();
                            typescriptparser.InitvalueContext valueCtx = (typescriptparser.InitvalueContext) child3;

                            keys.add(key);
                            values.add(valueCtx);

                            System.out.println(">>> Found pattern at position " + i + ": " + key + " : " + valueCtx.getText());
                        }
                    }
                }

                System.out.println(">>> Manual parsing found " + keys.size() + " property keys");

                // Process the found pairs
                for (int i = 0; i < keys.size(); i++) {
                    String key = keys.get(i);
                    typescriptparser.InitvalueContext valueCtx = values.get(i);

                    System.out.println(">>> Processing property: " + key);

                    Initvalue initValue = (Initvalue) visit(valueCtx);
                    initValue.setObjectKey(key);

                    if (!symbolTable.existsInCurrentScope(key)) {
                        symbolTable.addSymbol("OBJECT_KEY", key);
                    }

                    bodyObject.getInitvalues().add(initValue);
                    System.out.println(">>> Added property: " + key + " = " + getInitValueInfo(initValue));
                }
            }
        } catch (Exception e) {
            System.err.println(">>> Error processing object body: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println(">>> Object extraction completed with " + bodyObject.getInitvalues().size() + " properties");
        return bodyObject;
    }

    // Add this stack declaration

    // Helper method to determine expression type

    private String determineExpressionType(Expression expr) {
        if (expr == null) return "void";

        if (expr.isIsboolean() != null) {
            return "boolean";
        }

        if (expr.getString() != null) {
            String value = expr.getString();
            if ((value.startsWith("\"") && value.endsWith("\"")) ||
                    (value.startsWith("'") && value.endsWith("'"))) {
                return "string";
            }

            // Check if it's a number
            try {
                Double.parseDouble(value);
                return "number";
            } catch (NumberFormatException e) {
                // Not a number, might be identifier
                Row symbol = symbolTable.lookupSymbol(value);
                if (symbol != null) {
                    return symbol.getType();
                }
            }
        }

        if (expr.getVariableDeclaration() != null) {
            return "any";
        }

        if (expr.getFunctionCall() != null) {
            return "any";
        }

        return "any";
    }


    private String createMethodSignature(String methodName, List<String> parameterTypes) {
        return methodName + "(" + String.join(",", parameterTypes) + ")";
    }

    private boolean isMethodDuplicate(String signature) {
        // Check if method signature already exists in symbol table
        List<Row> allSymbols = symbolTable.getAllSymbols();
        for (Row row : allSymbols) {
            if ("METHOD".equals(row.getType()) && signature.equals(row.getValue())) {
                return true;
            }
        }
        return false;
    }

    private String extractVariableFromDirective(String value, String directive) {
        if (directive.contains("ngFor")) {
            // Extract variable from "let item of items"
            String[] parts = value.split("\\s+");
            for (int i = 0; i < parts.length; i++) {
                if ("let".equals(parts[i]) && i + 1 < parts.length) {
                    return parts[i + 1];
                }
                if ("of".equals(parts[i]) && i + 1 < parts.length) {
                    return parts[i + 1]; // This is the collection variable
                }
            }
        } else if (directive.contains("ngIf")) {
            // The whole value is the condition variable
            return value.trim();
        }
        return null;
    }
    private boolean areTypesCompatible(String expected, String actual) {
        if (expected.equals(actual)) return true;
        if ("any".equals(expected) || "any".equals(actual)) return true;

        // Basic type compatibility
        if ("number".equals(expected) && ("int".equals(actual) || "float".equals(actual) || "double".equals(actual))) {
            return true;
        }
        if ("string".equals(expected) && ("text".equals(actual) || "varchar".equals(actual))) {
            return true;
        }

        return false;
    }
    private static class MethodContext {
        private final String methodName;
        private final String returnType;
        private final String signature;
        private boolean hasReturnStatement;

        public MethodContext(String methodName, String returnType, String signature) {
            this.methodName = methodName;
            this.returnType = returnType;
            this.signature = signature;
            this.hasReturnStatement = false;
        }

        public void markHasReturn() {
            this.hasReturnStatement = true;
        }

        public boolean hasReturnStatement() {
            return hasReturnStatement;
        }

        public String getMethodName() {
            return methodName;
        }

        public String getReturnType() {
            return returnType;
        }

        public String getSignature() {
            return signature;
        }
    }

}
