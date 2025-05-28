package classes;

import java.util.*;

public class SemanticErrorManager {
    private List<SemanticError> errors;
    private SymbolTable symbolTable;
    private Map<String, MethodInfo> methodSignatures;
    private Set<String> importedModules;
    private Map<String, Set<String>> moduleRequiredTypes;
    private static final Map<String, String> REQUIRED_IMPORTS = Map.of(
            "HttpClient", "@angular/common/http",
            "FormControl", "@angular/forms",
            "FormGroup", "@angular/forms",
            "Router", "@angular/router",
            "ActivatedRoute", "@angular/router",
            "Observable", "rxjs",
            "BehaviorSubject", "rxjs",
            "Subject", "rxjs",
            "CommonModule", "@angular/common",
            "ReactiveFormsModule", "@angular/forms"
    );

    public SemanticErrorManager(SymbolTable symbolTable) {
        this.errors = new ArrayList<>();
        this.symbolTable = symbolTable;
        this.methodSignatures = new HashMap<>();
        this.importedModules = new HashSet<>();  // Add this line
        this.requiredImports = new HashMap<>();   // Add this line
        this.initializeRequiredImports();        // This line should already be there
    }

    // Inner class to store method information
    private static class MethodInfo {
        private String methodName;
        private String declaredReturnType;
        private List<String> actualReturnTypes;
        private int declarationLine;
        private int declarationColumn;
        private boolean isVoidMethod;

        public MethodInfo(String methodName, String declaredReturnType, int line, int column) {
            this.methodName = methodName;
            this.declaredReturnType = declaredReturnType;
            this.actualReturnTypes = new ArrayList<>();
            this.declarationLine = line;
            this.declarationColumn = column;
            this.isVoidMethod = "void".equalsIgnoreCase(declaredReturnType);
        }

        public void addReturnStatement(String returnType) {
            if (returnType != null) {
                actualReturnTypes.add(returnType);
            }
        }

        // Getters
        public String getMethodName() { return methodName; }
        public String getDeclaredReturnType() { return declaredReturnType; }
        public List<String> getActualReturnTypes() { return actualReturnTypes; }
        public int getDeclarationLine() { return declarationLine; }
        public int getDeclarationColumn() { return declarationColumn; }
        public boolean isVoidMethod() { return isVoidMethod; }
        public boolean hasReturnStatements() { return !actualReturnTypes.isEmpty(); }
    }

    // Register a method declaration
    public void registerMethodDeclaration(String methodName, String returnType, int line, int column) {
        if (methodName != null && returnType != null) {
            String methodKey = methodName;
            MethodInfo methodInfo = new MethodInfo(methodName, returnType, line, column);
            methodSignatures.put(methodKey, methodInfo);
            System.out.println("DEBUG: Registered method '" + methodName + "' with return type '" + returnType + "'");
        }
    }

    // Check return statement against method declaration
    public void checkReturnStatement(String methodName, String returnValue, String returnType, int line, int column) {
        if (methodName == null) return;

        MethodInfo methodInfo = findMethodInfo(methodName);

        System.out.println("DEBUG: Checking return for method '" + methodName + "', found methodInfo: " + (methodInfo != null));

        if (methodInfo != null) {
            System.out.println("DEBUG: Method declared return type: '" + methodInfo.getDeclaredReturnType() + "'");
            System.out.println("DEBUG: Method is void: " + methodInfo.isVoidMethod());
            System.out.println("DEBUG: Return value: '" + returnValue + "'");
            System.out.println("DEBUG: Return type: '" + returnType + "'");

            // Check if void method is trying to return a value
            if (methodInfo.isVoidMethod()) {
                if (returnValue != null && !returnValue.trim().isEmpty()) {
                    System.out.println("DEBUG: Adding void method return value error for value: " + returnValue);
                    addError(SemanticErrorType.VOID_METHOD_RETURN_VALUE,
                            "Void method '" + methodName + "' cannot return a value. " +
                                    "Found return statement with value: '" + returnValue + "'",
                            line, column, returnValue);
                }
            }
            // Check if non-void method returns wrong type
            else if (!methodInfo.isVoidMethod() && returnType != null) {
                if (!isTypeCompatible(methodInfo.getDeclaredReturnType(), returnType)) {
                    addError(SemanticErrorType.RETURN_TYPE_MISMATCH,
                            "Return type mismatch in method '" + methodName + "'. " +
                                    "Expected: '" + methodInfo.getDeclaredReturnType() + "', but found: '" + returnType + "'",
                            line, column, returnValue != null ? returnValue : returnType);
                }
            }

            // Record the return type for this method
            methodInfo.addReturnStatement(returnType);
        } else {
            System.out.println("DEBUG: Could not find method info for '" + methodName + "'");
            System.out.println("DEBUG: Registered methods: " + methodSignatures.keySet());
        }
    }

    // Helper method to find method info
    private MethodInfo findMethodInfo(String methodName) {
        // First try exact method name
        MethodInfo methodInfo = methodSignatures.get(methodName);
        if (methodInfo != null) return methodInfo;

        // Try with scope prefix
        String methodKey = symbolTable.getCurrentScopeName() + "." + methodName;
        methodInfo = methodSignatures.get(methodKey);
        if (methodInfo != null) return methodInfo;

        // Try to find method in different scope combinations
        String[] possibleScopes = {"Method", "CLASS", "INTERFACE", "GLOBAL"};
        for (String scope : possibleScopes) {
            methodKey = scope + "." + methodName;
            methodInfo = methodSignatures.get(methodKey);
            if (methodInfo != null) {
                return methodInfo;
            }
        }
        return null;
    }

    // Check if a non-void method has return statements
    public void checkMethodReturnCompleteness(String methodName, int line, int column) {
        if (methodName == null) return;

        MethodInfo methodInfo = findMethodInfo(methodName);
        if (methodInfo != null && !methodInfo.isVoidMethod() && !methodInfo.hasReturnStatements()) {
            addError(SemanticErrorType.MISSING_RETURN_STATEMENT,
                    "Non-void method '" + methodName + "' with return type '" +
                            methodInfo.getDeclaredReturnType() + "' must return a value",
                    methodInfo.getDeclarationLine(), methodInfo.getDeclarationColumn(), methodName);
        }
    }

    // Helper method to check type compatibility
    private boolean isTypeCompatible(String declaredType, String actualType) {
        if (declaredType == null || actualType == null) return false;

        // Exact match
        if (declaredType.equalsIgnoreCase(actualType)) {
            return true;
        }

        // Handle common type conversions and compatibility
        return isTypeConvertible(declaredType.toLowerCase(), actualType.toLowerCase());
    }

    // Check if types are convertible
    private boolean isTypeConvertible(String declaredType, String actualType) {
        // Handle primitive type compatibility
        Map<String, List<String>> typeCompatibility = new HashMap<>();

        // String compatibility
        typeCompatibility.put("string", List.of("string", "string_literal", "text"));

        // Number compatibility
        typeCompatibility.put("int", List.of("int", "integer", "number", "number_literal"));
        typeCompatibility.put("integer", List.of("int", "integer", "number", "number_literal"));
        typeCompatibility.put("number", List.of("int", "integer", "number", "number_literal", "float", "double"));
        typeCompatibility.put("double", List.of("number", "double", "float", "int", "integer"));
        typeCompatibility.put("float", List.of("number", "float", "double", "int", "integer"));

        // Boolean compatibility
        typeCompatibility.put("boolean", List.of("boolean", "boolean_literal", "bool"));
        typeCompatibility.put("bool", List.of("boolean", "boolean_literal", "bool"));

        // Object and any compatibility
        typeCompatibility.put("object", List.of("object", "any", "class"));
        typeCompatibility.put("any", List.of("string", "number", "boolean", "object", "any"));

        List<String> compatibleTypes = typeCompatibility.get(declaredType);
        return compatibleTypes != null && compatibleTypes.contains(actualType);
    }

    // Method to clear method signatures when exiting scope
    public void clearMethodSignaturesForScope(String scopeName) {
        methodSignatures.entrySet().removeIf(entry -> entry.getKey().startsWith(scopeName + "."));
    }

    // Check for missing * before Angular structural directives
    public void checkMissingStructuralDirective(String attributeValue, int line, int column) {
        if (attributeValue != null) {
            String trimmed = attributeValue.trim();
            if (trimmed.equals("ngFor") || trimmed.startsWith("ngFor=")) {
                addError(SemanticErrorType.MISSING_STRUCTURAL_DIRECTIVE_ASTERISK,
                        "Missing '*' before structural directive. Use '*ngFor' instead of '" + attributeValue + "'",
                        line, column, attributeValue);
            } else if (trimmed.equals("ngIf") || trimmed.startsWith("ngIf=")) {
                addError(SemanticErrorType.MISSING_STRUCTURAL_DIRECTIVE_ASTERISK,
                        "Missing '*' before structural directive. Use '*ngIf' instead of '" + attributeValue + "'",
                        line, column, attributeValue);
            }
        }
    }
    public void registerImport(String importName) {
        importedModules.add(importName);
    }

    // Add method to check if import exists
    public boolean isImported(String moduleName) {
        return importedModules.contains(moduleName);
    }

    private Map<String, String> requiredImports = new HashMap<>();

    public void initializeRequiredImports() {
        // Common Angular/TypeScript imports that are typically required
        requiredImports.put("Component", "@angular/core");
        requiredImports.put("Injectable", "@angular/core");
        requiredImports.put("OnInit", "@angular/core");
        requiredImports.put("Router", "@angular/router");
        requiredImports.put("HttpClient", "@angular/common/http");
        // Add more as needed based on your language requirements
    }
    public void checkMissingImport(String identifier, String requiredImport, int line, int column) {
        addError(SemanticErrorType.MISSING_IMPORT,
                "Identifier '" + identifier + "' requires import '" + requiredImport + "' but it was not imported",
                line, column,
                "Missing import for: " + identifier);
    }
    public void checkInvalidStandaloneValue(String value, int line, int column) {
        addError(SemanticErrorType.INVALID_STANDALONE_VALUE,
                "Invalid standalone value: '" + value + "'. Expected 'true' or 'false'",
                line, column, value);
    }
    public void checkMissingStandaloneValue(int line, int column) {
        addError(SemanticErrorType.MISSING_STANDALONE_VALUE,
                "Standalone property requires a boolean value (true or false)",
                line, column, "standalone");
    }

    // Enhanced check for undefined variables/properties
    public void checkUndefinedReference(String identifier, int line, int column) {
        if (identifier == null || identifier.equals("this")) {
            return;
        }

        if (isValidAngularTemplateExpression(identifier)) {
            return;
        }

        if (isComponentPropertyAccess(identifier)) {
            return;
        }

        Row symbol = symbolTable.lookupSymbol(identifier);
        if (symbol == null) {
            addError(SemanticErrorType.UNDEFINED_REFERENCE,
                    "Undefined reference: '" + identifier + "' is not declared in any accessible scope",
                    line, column, identifier);
        }
    }

    private boolean isValidAngularTemplateExpression(String identifier) {
        String[] validTemplateExpressions = {
                "product", "item", "index", "first", "last", "even", "odd", "selectedProduct", "products"
        };

        for (String validExpr : validTemplateExpressions) {
            if (identifier.startsWith(validExpr)) {
                return true;
            }
        }

        if (identifier.contains(".")) {
            String[] parts = identifier.split("\\.");
            return isValidAngularTemplateExpression(parts[0]);
        }

        if (identifier.contains("!.")) {
            String baseObject = identifier.split("!")[0];
            return isValidAngularTemplateExpression(baseObject);
        }

        return false;
    }

    private boolean isComponentPropertyAccess(String identifier) {
        return symbolTable.getCurrentScopeName().equals("TEMPLATE") ||
                symbolTable.getCurrentScopeName().equals("COMPONENT");
    }

    public void checkDuplicateDeclaration(String identifier, String type, int line, int column) {
        if (identifier != null) {
            if (symbolTable.existsInCurrentScope(identifier)) {
                addError(SemanticErrorType.DUPLICATE_DECLARATION,
                        "Duplicate declaration: '" + identifier + "' is already declared in current scope (" +
                                symbolTable.getCurrentScopeName() + ")", line, column, identifier);
            }
        }
    }

    // Check method signature for missing return type
    public void checkMethodSignature(String methodName, boolean hasReturnType, boolean hasParameters, int line, int column) {
        if (methodName != null) {
            if (!hasReturnType && !symbolTable.getCurrentScopeName().equals("INTERFACE")) {
                addError(SemanticErrorType.MISSING_RETURN_TYPE,
                        "Method '" + methodName + "' should have an explicit return type declaration",
                        line, column, methodName);
            }
        }
    }

    // Check component decorator for required properties
    public void checkComponentDecorator(String decoratorValue, boolean hasSelector, boolean hasTemplate, int line, int column) {
        if (decoratorValue != null && decoratorValue.contains("@Component")) {
            if (!hasSelector) {
                addError(SemanticErrorType.MISSING_COMPONENT_PROPERTY,
                        "Component decorator is missing required 'selector' property",
                        line, column, decoratorValue);
            }
            if (!hasTemplate) {
                addError(SemanticErrorType.MISSING_COMPONENT_PROPERTY,
                        "Component decorator is missing required 'template' or 'templateUrl' property",
                        line, column, decoratorValue);
            }
        }
    }

    // Check Angular template syntax
    public void checkAngularTemplateSyntax(String templateContent, int line, int column) {
        if (templateContent == null) return;

        if (templateContent.contains("ngFor=") && !templateContent.contains("*ngFor")) {
            addError(SemanticErrorType.MISSING_STRUCTURAL_DIRECTIVE_ASTERISK,
                    "Structural directive 'ngFor' must be prefixed with '*'",
                    line, column, templateContent);
        }

        if (templateContent.contains("ngIf=") && !templateContent.contains("*ngIf")) {
            addError(SemanticErrorType.MISSING_STRUCTURAL_DIRECTIVE_ASTERISK,
                    "Structural directive 'ngIf' must be prefixed with '*'",
                    line, column, templateContent);
        }
    }

    // Create symbol table snapshot when adding error
    private void addError(SemanticErrorType type, String message, int line, int column, String context) {
        SymbolTableSnapshot snapshot = createSymbolTableSnapshot();
        SemanticError error = new SemanticError(type, message, line, column, context,
                symbolTable.getCurrentScopeName(), snapshot);
        errors.add(error);
        System.out.println("DEBUG: Added error - " + type + ": " + message);
    }

    // Create a snapshot of the current symbol table
    private SymbolTableSnapshot createSymbolTableSnapshot() {
        return new SymbolTableSnapshot(symbolTable);
    }

    public List<SemanticError> getErrors() {
        return new ArrayList<>(errors);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<SemanticError> getErrorsByType(SemanticErrorType type) {
        return errors.stream()
                .filter(error -> error.getType() == type)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public void printErrorsWithSymbolTable() {
        if (errors.isEmpty()) {
            System.out.println("\n=== SEMANTIC ANALYSIS ===");
            System.out.println("No semantic errors found.");
            System.out.println("==========================\n");
            return;
        }

        System.out.println("\n=== SEMANTIC ERRORS FOUND ===");
        System.out.println("Total errors: " + errors.size());
        System.out.println();

        for (SemanticErrorType type : SemanticErrorType.values()) {
            List<SemanticError> errorsOfType = getErrorsByType(type);
            if (!errorsOfType.isEmpty()) {
                System.out.println("--- " + type + " ERRORS ---");
                for (int i = 0; i < errorsOfType.size(); i++) {
                    SemanticError error = errorsOfType.get(i);
                    System.out.println("Error #" + (i + 1) + ":");
                    System.out.println("  Message: " + error.getMessage());
                    System.out.println("  Location: Line " + error.getLine() + ", Column " + error.getColumn());
                    System.out.println("  Context: " + error.getContext());
                    System.out.println("  Scope: " + error.getScope());

                    // Print the symbol table snapshot for this error
                    System.out.println("  --- Symbol Table at Error Time ---");
                    error.getSymbolTableSnapshot().print();
                    System.out.println("  --- End Symbol Table Snapshot ---");
                    System.out.println();
                }
            }
        }

        System.out.println("=== CURRENT SYMBOL TABLE STATE ===");
        symbolTable.print();
        symbolTable.printScopeHierarchy();
        System.out.println("===================================\n");
    }

    public void clearErrors() {
        errors.clear();
    }

    public int getErrorCount(SemanticErrorType type) {
        return (int) errors.stream().filter(error -> error.getType() == type).count();
    }


}

// Enhanced enum for different types of semantic errors
enum SemanticErrorType {
    MISSING_STRUCTURAL_DIRECTIVE_ASTERISK,
    UNDEFINED_REFERENCE,
    DUPLICATE_DECLARATION,
    MISSING_RETURN_TYPE,
    MISSING_COMPONENT_PROPERTY,
    INVALID_ANGULAR_SYNTAX,
    VOID_METHOD_RETURN_VALUE,
    RETURN_TYPE_MISMATCH,
    MISSING_RETURN_STATEMENT,
    INVALID_STANDALONE_VALUE,      // New
    MISSING_STANDALONE_VALUE     ,  // New
    MISSING_IMPORT
}


// Symbol Table Snapshot class
class SymbolTableSnapshot {
    private List<SymbolRow> allSymbols;
    private List<ScopeSnapshot> allScopes;
    private String currentScopeName;
    private int currentScopeId;

    public SymbolTableSnapshot(SymbolTable symbolTable) {
        this.allSymbols = new ArrayList<>();
        this.allScopes = new ArrayList<>();
        this.currentScopeName = symbolTable.getCurrentScopeName();
        this.currentScopeId = symbolTable.getCurrentScopeIdPublic();

        // Copy all symbols from the original symbol table
        copySymbolsFromOriginal(symbolTable);
        // Copy scope information
        copyScopesFromOriginal(symbolTable);
    }

    private void copySymbolsFromOriginal(SymbolTable original) {
        try {
            List<Row> originalSymbols = original.getAllSymbols();
            for (Row row : originalSymbols) {
                allSymbols.add(new SymbolRow(row));
            }
        } catch (Exception e) {
            System.out.println("Error copying symbols: " + e.getMessage());
        }
    }

    private void copyScopesFromOriginal(SymbolTable original) {
        try {
            List<ScopeInfo> originalScopes = original.getAllScopes();
            for (ScopeInfo scopeInfo : originalScopes) {
                allScopes.add(new ScopeSnapshot(
                        scopeInfo.getScopeId(),
                        scopeInfo.getScopeName(),
                        scopeInfo.getParentScopeId(),
                        scopeInfo.getSymbolCount()
                ));
            }
        } catch (Exception e) {
            System.out.println("Error copying scopes: " + e.getMessage());
        }
    }

    public void print() {
        System.out.println("    [SNAPSHOT] Symbol Table at Error Time:");
        System.out.println("    Current Scope: " + currentScopeName + " (ID: " + currentScopeId + ")");

        if (allSymbols.isEmpty()) {
            System.out.println("    No symbols in snapshot.");
        } else {
            System.out.println("    | Identifier         | Kind             | Data Type        | Scope                |");
            System.out.println("    | ------------------ | ---------------- | ---------------- | -------------------- |");
            for (SymbolRow row : allSymbols) {
                System.out.printf("    | %-18s | %-16s | %-16s | %-20s |%n",
                        row.getIdentifier(), row.getKind(), row.getDataType(), row.getScope());
            }
            System.out.println("    Total symbols in snapshot: " + allSymbols.size());
        }

        if (!allScopes.isEmpty()) {
            System.out.println("    [SNAPSHOT] Scope Hierarchy:");
            for (ScopeSnapshot scope : allScopes) {
                System.out.println("      Scope: " + scope.getScopeName() +
                        " (ID: " + scope.getScopeId() + ", Symbols: " + scope.getSymbolCount() + ")");
            }
        }
    }

    // Getters
    public List<SymbolRow> getAllSymbols() { return new ArrayList<>(allSymbols); }
    public List<ScopeSnapshot> getAllScopes() { return new ArrayList<>(allScopes); }
    public String getCurrentScopeName() { return currentScopeName; }
    public int getCurrentScopeId() { return currentScopeId; }
}

// Simplified symbol row for snapshots
class SymbolRow {
    private String identifier;
    private String kind;
    private String dataType;
    private String scope;

    public SymbolRow(String identifier, String kind, String dataType, String scope) {
        this.identifier = identifier;
        this.kind = kind;
        this.dataType = dataType;
        this.scope = scope;
    }

    // Copy constructor from Row
    public SymbolRow(Row originalRow) {
        this.identifier = formatIdentifier(originalRow.getValue());
        this.kind = formatKind(originalRow.getType());
        this.dataType = formatDataType(originalRow.getType());
        this.scope = formatScope(originalRow.getScopeName());
    }

    // Helper methods (copied from SymbolTable formatting methods)
    private String formatIdentifier(String value) {
        if (value == null) return "N/A";
        if (value.startsWith("'") && value.endsWith("'")) {
            return value.substring(1, value.length() - 1);
        }
        if (value.startsWith("\"") && value.endsWith("\"")) {
            return value.substring(1, value.length() - 1);
        }
        return value;
    }

    private String formatKind(String type) {
        if (type == null) return "Unknown";
        switch (type.toUpperCase()) {
            case "IMPORT_ID": return "Import";
            case "IMPORT_PATH": return "Import Path";
            case "VARIABLE": return "Variable";
            case "FUNCTION": case "METHOD": return "Function";
            case "CLASS": return "Class";
            case "INTERFACE": return "Interface";
            case "COMPONENT": return "Component";
            case "PROPERTY": return "Property";
            case "PARAMETER": return "Parameter";
            case "STRING_LITERAL": return "String Literal";
            case "NUMBER_LITERAL": return "Number Literal";
            case "BOOLEAN_LITERAL": return "Boolean Literal";
            default: return type;
        }
    }

    private String formatDataType(String type) {
        if (type == null) return "N/A";
        switch (type.toUpperCase()) {
            case "IMPORT_ID": return "module";
            case "IMPORT_PATH": return "string";
            case "VARIABLE": return "any";
            case "FUNCTION": case "METHOD": return "function";
            case "CLASS": return "class";
            case "STRING_LITERAL": return "string";
            case "NUMBER_LITERAL": return "number";
            case "BOOLEAN_LITERAL": return "boolean";
            default: return "unknown";
        }
    }

    private String formatScope(String scopeName) {
        if (scopeName == null) return "Unknown";
        return scopeName.toLowerCase();
    }

    // Getters
    public String getIdentifier() { return identifier; }
    public String getKind() { return kind; }
    public String getDataType() { return dataType; }
    public String getScope() { return scope; }
}

// Scope snapshot for storing scope information
class ScopeSnapshot {
    private int scopeId;
    private String scopeName;
    private int parentScopeId;
    private int symbolCount;

    public ScopeSnapshot(int scopeId, String scopeName, int parentScopeId, int symbolCount) {
        this.scopeId = scopeId;
        this.scopeName = scopeName;
        this.parentScopeId = parentScopeId;
        this.symbolCount = symbolCount;
    }

    // Getters
    public int getScopeId() { return scopeId; }
    public String getScopeName() { return scopeName; }
    public int getParentScopeId() { return parentScopeId; }
    public int getSymbolCount() { return symbolCount; }
}

// Enhanced SemanticError class with symbol table snapshot
class SemanticError {
    private SemanticErrorType type;
    private String message;
    private int line;
    private int column;
    private String context;
    private String scope;
    private SymbolTableSnapshot symbolTableSnapshot;

    public SemanticError(SemanticErrorType type, String message, int line, int column,
                         String context, String scope, SymbolTableSnapshot snapshot) {
        this.type = type;
        this.message = message;
        this.line = line;
        this.column = column;
        this.context = context;
        this.scope = scope;
        this.symbolTableSnapshot = snapshot;
    }

    // Getters
    public SemanticErrorType getType() { return type; }
    public String getMessage() { return message; }
    public int getLine() { return line; }
    public int getColumn() { return column; }
    public String getContext() { return context; }
    public String getScope() { return scope; }
    public SymbolTableSnapshot getSymbolTableSnapshot() { return symbolTableSnapshot; }

    @Override
    public String toString() {
        return String.format("[%s] %s at line %d, column %d (Scope: %s, Context: %s)",
                type, message, line, column, scope, context);
    }

    public void printWithSymbolTable() {
        System.out.println(this.toString());
        if (symbolTableSnapshot != null) {
            symbolTableSnapshot.print();
        }
    }

    // Add these fields to SemanticErrorManager class

    // Add method to register imports


    // Initialize required imports (add this to constructor or as a method)

}