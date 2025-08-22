package classes;

import java.util.*;

/**
 * Enhanced Semantic Error Manager
 * Integrates all specialized error types with their specific symbol tables
 */
public class EnhancedSemanticErrorManager {
    private SymbolTable mainSymbolTable;
    private List<SemanticErrorBase> allErrors;

    // Specialized error collections organized by type
    private Map<SemanticErrorType, List<SemanticErrorBase>> errorsByType;

    // Component tracking
    private Set<String> componentProperties;
    private Map<String, String> propertyTypes;

    // Method tracking structures
    private Map<String, MethodSignatureInfo> methodSignatures;
    private Set<String> processedMethods;

    public EnhancedSemanticErrorManager(SymbolTable symbolTable) {
        this.mainSymbolTable = symbolTable;
        this.allErrors = new ArrayList<>();
        this.errorsByType = new HashMap<>();
        this.componentProperties = new HashSet<>();
        this.propertyTypes = new HashMap<>();
        this.methodSignatures = new HashMap<>();
        this.processedMethods = new HashSet<>();

        // Initialize error type collections
        for (SemanticErrorType type : SemanticErrorType.values()) {
            errorsByType.put(type, new ArrayList<>());
        }
    }

    // ========================================
    // Variable Error Creation Methods
    // ========================================

    /**
     * Create and register undefined variable error
     */
    public void reportUndefinedVariable(String variableName, int line, int column) {
        UndefinedVariableError error = new UndefinedVariableError(variableName, line, column);

        // Add relevant symbols from main symbol table
        addRelevantVariableSymbols(error, variableName);

        // Process the error (this triggers analysis and suggestions)
        error.processError();

        // Register the error
        registerError(error);
    }

    /**
     * Create and register undefined structural directive error
     */
    public void reportUndefinedStructuralDirective(String variableName, String directive, int line, int column) {
        UndefinedStructuralDirectiveError error = new UndefinedStructuralDirectiveError(
                variableName, directive, line, column);

        // Add component properties to error context
        addComponentPropertiesToError(error);

        // Add directive chain context
        addDirectiveChainContext(error, directive);

        error.processError();
        registerError(error);
    }

    // ========================================
    // Method Error Creation Methods
    // ========================================

    /**
     * Create and register duplicate method error
     */
    public void reportDuplicateMethod(String methodName, List<String> parameterTypes,
                                      int line, int column, int previousLine) {
        DuplicateMethodError error = new DuplicateMethodError(
                methodName, parameterTypes, line, column, previousLine);

        // Add method context from main symbol table
        addMethodContextToError(error, methodName);

        error.processError();
        registerError(error);
    }

    /**
     * Create and register return type mismatch error
     */
    public void reportReturnTypeMismatch(String methodName, String expectedType,
                                         String actualType, int line, int column) {
        ReturnTypeMismatchError error = new ReturnTypeMismatchError(
                methodName, expectedType, actualType, line, column);

        // Add type hierarchy context
        addTypeHierarchyContext(error, expectedType, actualType);

        error.processError();
        registerError(error);
    }

    /**
     * Create and register void method return value error
     */
    public void reportVoidMethodReturnValue(String methodName, String returnValue, int line, int column) {
        VoidMethodReturnValueError error = new VoidMethodReturnValueError(
                methodName, returnValue, line, column);

        // Add method context
        addMethodContextToError(error, methodName);

        error.processError();
        registerError(error);
    }

    /**
     * Create and register missing return statement error
     */
    public void reportMissingReturnStatement(String methodName, String expectedReturnType, int line, int column) {
        MissingReturnStatementError error = new MissingReturnStatementError(
                methodName, expectedReturnType, line, column);

        // Add code path analysis context
        addCodePathContext(error, methodName);

        error.processError();
        registerError(error);
    }

    // ========================================
    // Declaration Error Creation Methods
    // ========================================

    /**
     * Create and register duplicate class error
     */
    public void reportDuplicateClass(String className, int line, int column, int previousLine) {
        String currentScope = mainSymbolTable.getCurrentScopeName();
        DuplicateClassError error = new DuplicateClassError(
                className, currentScope, line, column, previousLine);

        // Add class registry context
        addClassRegistryContext(error, className);

        error.processError();
        registerError(error);
    }

    /**
     * Create and register duplicate interface error
     */
    public void reportDuplicateInterface(String interfaceName, List<String> extendedInterfaces,
                                         int line, int column, int previousLine) {
        DuplicateInterfaceError error = new DuplicateInterfaceError(
                interfaceName, extendedInterfaces, line, column, previousLine);

        // Add interface hierarchy context
        addInterfaceHierarchyContext(error, interfaceName, extendedInterfaces);

        error.processError();
        registerError(error);
    }

    // ========================================
    // Binding Error Creation Methods
    // ========================================

    /**
     * Create and register property binding mismatch error
     */
    public void reportPropertyBindingMismatch(String propertyName, String bindingType,
                                              String expectedType, int line, int column) {
        PropertyBindingMismatchError error = new PropertyBindingMismatchError(
                propertyName, bindingType, expectedType, line, column);

        // Add component property context
        addComponentPropertyContext(error, propertyName);

        error.processError();
        registerError(error);
    }

    /**
     * Create and register literal binding for property error
     */
    public void reportLiteralBindingForProperty(String attributeName, String attributeValue,
                                                int line, int column) {
        String suggestedBinding = "[" + attributeName + "]=\"" + attributeValue + "\"";
        LiteralBindingForPropertyError error = new LiteralBindingForPropertyError(
                attributeName, attributeValue, suggestedBinding, line, column);

        // Add binding pattern context
        addBindingPatternContext(error, attributeName, attributeValue);

        error.processError();
        registerError(error);
    }

    // ========================================
    // Context Addition Helper Methods
    // ========================================

    private void addRelevantVariableSymbols(UndefinedVariableError error, String variableName) {
        // Add all variables from current and parent scopes
        List<Row> allSymbols = mainSymbolTable.getAllSymbols();
        for (Row row : allSymbols) {
            if ("VARIABLE".equals(row.getType()) || "PARAMETER".equals(row.getType()) ||
                    "PROPERTY".equals(row.getType())) {
                error.addRelevantSymbol(row.getValue(), row.getType(), row.getScopeName());
            }
        }

        // Add similar variable names for typo detection
        for (Row row : allSymbols) {
            if (isSimilarName(variableName, row.getValue())) {
                error.addRelevantSymbol(row.getValue(), "SIMILAR_NAME", row.getScopeName());
            }
        }
    }

    private void addComponentPropertiesToError(UndefinedStructuralDirectiveError error) {
        // Add all component properties
        for (String property : componentProperties) {
            String type = propertyTypes.getOrDefault(property, "any");
            error.addRelevantSymbol(property, "COMPONENT_PROPERTY", "COMPONENT");
        }
    }

    private void addDirectiveChainContext(UndefinedStructuralDirectiveError error, String directive) {
        // Add directive-specific context based on directive type
        if (directive.contains("ngFor")) {
            error.addRelevantSymbol("*ngFor", "STRUCTURAL_DIRECTIVE", "TEMPLATE");
            error.addRelevantSymbol("let", "DIRECTIVE_KEYWORD", "TEMPLATE");
            error.addRelevantSymbol("of", "DIRECTIVE_KEYWORD", "TEMPLATE");
        } else if (directive.contains("ngIf")) {
            error.addRelevantSymbol("*ngIf", "STRUCTURAL_DIRECTIVE", "TEMPLATE");
        }
    }

    private void addMethodContextToError(SemanticErrorBase error, String methodName) {
        // Add method information from main symbol table
        List<Row> allSymbols = mainSymbolTable.getAllSymbols();
        for (Row row : allSymbols) {
            if ("METHOD".equals(row.getType()) && row.getValue().contains(methodName)) {
                error.addRelevantSymbol(row.getValue(), row.getType(), row.getScopeName());
            }
        }
    }

    private void addTypeHierarchyContext(ReturnTypeMismatchError error, String expectedType, String actualType) {
        // Add type information from symbol table
        error.addRelevantSymbol(expectedType, "EXPECTED_TYPE", "TYPE_SYSTEM");
        error.addRelevantSymbol(actualType, "ACTUAL_TYPE", "TYPE_SYSTEM");

        // Add related types
        List<Row> allSymbols = mainSymbolTable.getAllSymbols();
        for (Row row : allSymbols) {
            if ("TYPE".equals(row.getType()) &&
                    (row.getValue().contains(expectedType) || row.getValue().contains(actualType))) {
                error.addRelevantSymbol(row.getValue(), row.getType(), row.getScopeName());
            }
        }
    }

    private void addCodePathContext(MissingReturnStatementError error, String methodName) {
        // Add code path information
        error.addRelevantSymbol("main_path", "HAS_RETURN", "METHOD");
        error.addRelevantSymbol("if_branch", "MISSING_RETURN", "METHOD");
        error.addRelevantSymbol("else_branch", "HAS_RETURN", "METHOD");
    }

    private void addClassRegistryContext(DuplicateClassError error, String className) {
        // Add class information from symbol table
        List<Row> allSymbols = mainSymbolTable.getAllSymbols();
        for (Row row : allSymbols) {
            if ("CLASS".equals(row.getType()) && row.getValue().contains(className)) {
                error.addRelevantSymbol(row.getValue(), row.getType(), row.getScopeName());
            }
        }
    }

    private void addInterfaceHierarchyContext(DuplicateInterfaceError error, String interfaceName,
                                              List<String> extendedInterfaces) {
        // Add interface information
        error.addRelevantSymbol(interfaceName, "INTERFACE", "CURRENT");
        for (String extended : extendedInterfaces) {
            error.addRelevantSymbol(extended, "EXTENDED_INTERFACE", "HIERARCHY");
        }
    }

    private void addComponentPropertyContext(PropertyBindingMismatchError error, String propertyName) {
        // Add component property information
        if (componentProperties.contains(propertyName)) {
            String type = propertyTypes.get(propertyName);
            error.addRelevantSymbol(propertyName, type, "COMPONENT");
        }
    }

    private void addBindingPatternContext(LiteralBindingForPropertyError error,
                                          String attributeName, String attributeValue) {
        // Add binding pattern information
        error.addRelevantSymbol(attributeName, "ATTRIBUTE", "TEMPLATE");
        error.addRelevantSymbol(attributeValue, "LITERAL_VALUE", "TEMPLATE");
    }

    // ========================================
    // Error Management Methods
    // ========================================

    private void registerError(SemanticErrorBase error) {
        allErrors.add(error);
        errorsByType.get(error.getErrorType()).add(error);
    }

    private boolean isSimilarName(String name1, String name2) {
        if (name1.length() != name2.length()) return false;
        int differences = 0;
        for (int i = 0; i < name1.length(); i++) {
            if (name1.charAt(i) != name2.charAt(i)) {
                differences++;
                if (differences > 1) return false;
            }
        }
        return differences == 1;
    }

    // ========================================
    // Component Management Methods
    // ========================================

    public void addComponentProperty(String propertyName, String type) {
        componentProperties.add(propertyName);
        propertyTypes.put(propertyName, type);
    }

    public void addMethodSignature(String methodName, String signature, String returnType, int line) {
        MethodSignatureInfo info = new MethodSignatureInfo(methodName, signature, returnType, line);
        methodSignatures.put(signature, info);
    }
    // ========================================
    // Reporting Methods
    // ========================================

    public List<SemanticErrorBase> getAllErrors() {
        return new ArrayList<>(allErrors);
    }

    public List<SemanticErrorBase> getErrorsByType(SemanticErrorType type) {
        return new ArrayList<>(errorsByType.get(type));
    }

    public int getErrorCount() {
        return allErrors.size();
    }

    public int getErrorCountByType(SemanticErrorType type) {
        return errorsByType.get(type).size();
    }

    public String getFormattedReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== SEMANTIC ERROR REPORT ===\n");
        report.append("Total Errors: ").append(allErrors.size()).append("\n\n");

        for (SemanticErrorType type : SemanticErrorType.values()) {
            List<SemanticErrorBase> typeErrors = errorsByType.get(type);
            if (!typeErrors.isEmpty()) {
                report.append(type.getDisplayName()).append(" (").append(typeErrors.size()).append("):\n");
                for (SemanticErrorBase error : typeErrors) {
                    report.append(error.getFormattedReport()).append("\n");
                }
            }
        }

        return report.toString();
    }

    public void clearErrors() {
        allErrors.clear();
        for (List<SemanticErrorBase> typeErrors : errorsByType.values()) {
            typeErrors.clear();
        }
    }

    // ========================================
    // Helper Classes
    // ========================================

    static
    class MethodSignatureInfo {
        String methodName;
        String signature;
        String returnType;
        int line;  // Add line field

        MethodSignatureInfo(String methodName, String signature, String returnType) {
            this.methodName = methodName;
            this.signature = signature;
            this.returnType = returnType;
            this.line = 0;  // Default line
        }

        // Updated constructor with line parameter
        MethodSignatureInfo(String methodName, String signature, String returnType, int line) {
            this.methodName = methodName;
            this.signature = signature;
            this.returnType = returnType;
            this.line = line;
        }

        // Add getter method for line
        public int getLine() {
            return line;
        }

    }}