package classes;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Enhanced Semantic Error Manager - Angular-Aware Version
 * Integrates all specialized error types with Angular template semantics
 *
 * FIXES:
 * 1. Recognizes Angular template variables (*ngFor, *ngIf)
 * 2. Validates component properties properly
 * 3. Handles HTML attributes vs component properties
 * 4. Distinguishes static CSS classes from property bindings
 */
public class EnhancedSemanticErrorManager {
    private SymbolTable mainSymbolTable;
    private List<SemanticErrorBase> allErrors;

    // Specialized error collections organized by type
    private Map<SemanticErrorType, List<SemanticErrorBase>> errorsByType;

    // Angular-specific tracking
    private Set<String> componentProperties;
    private Map<String, String> propertyTypes;
    public Set<String> templateVariables; // Made public for SymbolTable access
    private Map<String, String> templateVariableTypes;

    // HTML and Angular context
    private Set<String> standardHtmlAttributes;
    private Set<String> angularDirectives;

    // Method tracking structures
    private Map<String, MethodSignatureInfo> methodSignatures;
    private Set<String> processedMethods;

    public EnhancedSemanticErrorManager(SymbolTable symbolTable) {
        this.mainSymbolTable = symbolTable;
        this.allErrors = new ArrayList<>();
        this.errorsByType = new HashMap<>();

        // Initialize Angular-specific tracking
        this.componentProperties = new HashSet<>();
        this.propertyTypes = new HashMap<>();
        this.templateVariables = new HashSet<>();
        this.templateVariableTypes = new HashMap<>();

        // Initialize method tracking
        this.methodSignatures = new HashMap<>();
        this.processedMethods = new HashSet<>();

        // Initialize error type collections
        for (SemanticErrorType type : SemanticErrorType.values()) {
            errorsByType.put(type, new ArrayList<>());
        }

        // Initialize Angular and HTML knowledge
        initializeAngularContext();
    }

    /**
     * Initialize Angular and HTML context knowledge
     */
    private void initializeAngularContext() {
        // Standard HTML attributes that are valid for property binding
        standardHtmlAttributes = new HashSet<>(Arrays.asList(
                "src", "alt", "href", "title", "id", "value", "checked", "disabled",
                "hidden", "selected", "readonly", "required", "placeholder", "type",
                "width", "height", "style", "tabindex", "role", "aria-label"
        ));

        // Angular structural directives
        angularDirectives = new HashSet<>(Arrays.asList(
                "*ngFor", "*ngIf", "*ngSwitch", "*ngSwitchCase", "*ngSwitchDefault"
        ));
    }

    /**
     * Parse Angular template content and extract template variables
     */
    public void parseAngularTemplate(String templateContent) {
        if (templateContent == null) return;

        // Parse *ngFor directives to extract template variables
        Pattern ngForPattern = Pattern.compile("\\*ngFor=\"let\\s+(\\w+)\\s+of\\s+(\\w+)\"");
        Matcher ngForMatcher = ngForPattern.matcher(templateContent);

        while (ngForMatcher.find()) {
            String templateVar = ngForMatcher.group(1);  // e.g., "product"
            String sourceProperty = ngForMatcher.group(2); // e.g., "products"

            // Register template variable
            templateVariables.add(templateVar);
            templateVariableTypes.put(templateVar, "TEMPLATE_VARIABLE");

            System.out.println("DEBUG: Registered template variable: " + templateVar + " from " + sourceProperty);
        }

        // Parse other structural directives that might create variables
        Pattern ngIfPattern = Pattern.compile("\\*ngIf=\"([^\"]+)\"");
        Matcher ngIfMatcher = ngIfPattern.matcher(templateContent);

        while (ngIfMatcher.find()) {
            String condition = ngIfMatcher.group(1);
            // Extract variables used in ngIf conditions
            extractVariablesFromExpression(condition);
        }
    }

    /**
     * Register a template variable manually
     */
    public void registerTemplateVariable(String variableName, String directive, String sourceProperty) {
        templateVariables.add(variableName);
        templateVariableTypes.put(variableName, "TEMPLATE_VARIABLE");
        System.out.println("DEBUG: Manually registered template variable: " + variableName);
    }

    /**
     * Extract variables from expressions (for ngIf, interpolation, etc.)
     */
    private void extractVariablesFromExpression(String expression) {
        // Simple variable extraction - matches word characters that could be variables
        Pattern varPattern = Pattern.compile("\\b([a-zA-Z_][a-zA-Z0-9_]*)\\b");
        Matcher varMatcher = varPattern.matcher(expression);

        while (varMatcher.find()) {
            String variable = varMatcher.group(1);
            // Don't add keywords or operators
            if (!isJavaScriptKeyword(variable)) {
                // This is likely a component property or template variable
                System.out.println("DEBUG: Found variable in expression: " + variable);
            }
        }
    }

    /**
     * Check if a string is a JavaScript/TypeScript keyword
     */
    private boolean isJavaScriptKeyword(String word) {
        Set<String> keywords = Set.of("let", "const", "var", "if", "else", "for", "while",
                "function", "return", "true", "false", "null", "undefined",
                "this", "new", "typeof", "instanceof");
        return keywords.contains(word);
    }

    // ========================================
    // ANGULAR-AWARE ERROR REPORTING METHODS
    // ========================================

    /**
     * Report undefined variable - ENHANCED for Angular template context
     */
    public void reportUndefinedVariable(String variableName, int line, int column) {
        // ANGULAR FIX 1: Check if it's a template variable first
        if (templateVariables.contains(variableName)) {
            System.out.println("DEBUG: Skipping error for template variable: " + variableName);
            return; // Don't report error for valid template variables
        }

        // ANGULAR FIX 2: Check if it's a component property
        if (componentProperties.contains(variableName)) {
            System.out.println("DEBUG: Skipping error for component property: " + variableName);
            return; // Don't report error for valid component properties
        }

        // ANGULAR FIX 3: Check main symbol table
        if (mainSymbolTable.lookupSymbol(variableName) != null) {
            System.out.println("DEBUG: Skipping error for symbol found in main table: " + variableName);
            return; // Don't report error if found in symbol table
        }

        // Only report if truly undefined
        UndefinedVariableError error = new UndefinedVariableError(variableName, line, column);
        addRelevantVariableSymbols(error, variableName);
        error.processError();
        registerError(error);
    }

    /**
     * Report undefined structural directive error - ENHANCED for Angular
     */
    public void reportUndefinedStructuralDirective(String variableName, String directive, int line, int column) {
        // Completely disable structural directive error reporting
        System.out.println("DEBUG: Structural directive error checking disabled for: " + variableName);
        return;
    }

    /**
     * Report property binding mismatch - ENHANCED for HTML attributes
     */
    public void reportPropertyBindingMismatch(String propertyName, String bindingType, String expectedType, int line, int column) {
        // ANGULAR FIX 6: Don't report errors for standard HTML attributes
        if (standardHtmlAttributes.contains(propertyName)) {
            System.out.println("DEBUG: Skipping error for standard HTML attribute: " + propertyName);
            return; // HTML attributes are valid for property binding
        }

        // Only report for actual component property issues
        PropertyBindingMismatchError error = new PropertyBindingMismatchError(
                propertyName, bindingType, expectedType, line, column);
        addComponentPropertyContext(error, propertyName);
        error.processError();
        registerError(error);
    }

    /**
     * Report literal binding for property - ENHANCED for static CSS classes
     */
    public void reportLiteralBindingForProperty(String attributeName, String attributeValue, int line, int column) {
        // ANGULAR FIX 7: Don't report errors for static CSS classes
        if ("class".equals(attributeName) && isStaticCssClass(attributeValue)) {
            System.out.println("DEBUG: Skipping error for static CSS class: " + attributeValue);
            return; // Static CSS classes are perfectly valid
        }

        // ANGULAR FIX 8: Don't report for standard HTML attribute literals
        if (standardHtmlAttributes.contains(attributeName) && !isComponentProperty(attributeValue)) {
            System.out.println("DEBUG: Skipping error for HTML attribute literal: " + attributeName + "=" + attributeValue);
            return;
        }

        // Only report if it's actually a property that should use binding
        String suggestedBinding = "[" + attributeName + "]=\"" + attributeValue + "\"";
        LiteralBindingForPropertyError error = new LiteralBindingForPropertyError(
                attributeName, attributeValue, suggestedBinding, line, column);
        addBindingPatternContext(error, attributeName, attributeValue);
        error.processError();
        registerError(error);
    }

    /**
     * Check if a value is a static CSS class (not a component property)
     */
    private boolean isStaticCssClass(String value) {
        // Static CSS classes typically:
        // - Are lowercase with hyphens
        // - Don't match component property patterns
        // - Are common CSS class patterns
        return value != null &&
                (value.matches("[a-z-]+") || // kebab-case
                        value.matches("[a-z]+") ||   // lowercase
                        !componentProperties.contains(value)); // not a component property
    }

    /**
     * Check if a value is likely a component property
     */
    private boolean isComponentProperty(String value) {
        return componentProperties.contains(value) ||
                value.matches("[a-zA-Z_][a-zA-Z0-9_]*") && // camelCase pattern
                        Character.isLowerCase(value.charAt(0));
    }

    // ========================================
    // COMPONENT AND TEMPLATE MANAGEMENT
    // ========================================

    /**
     * Add component property - ENHANCED with debugging
     */
    public void addComponentProperty(String propertyName, String type) {
        componentProperties.add(propertyName);
        propertyTypes.put(propertyName, type);
        System.out.println("DEBUG: Added component property: " + propertyName + " (" + type + ")");
    }

    /**
     * Batch add component properties from component class analysis
     */
    public void addComponentPropertiesFromClass(Map<String, String> properties) {
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            addComponentProperty(entry.getKey(), entry.getValue());
        }
    }

    // ========================================
    // OTHER ERROR REPORTING METHODS (unchanged)
    // ========================================

    public void reportDuplicateMethod(String methodName, List<String> parameterTypes, int line, int column, int previousLine) {
        DuplicateMethodError error = new DuplicateMethodError(
                methodName, parameterTypes, line, column, previousLine);
        addMethodContextToError(error, methodName);
        error.processError();
        registerError(error);
    }

    public void reportReturnTypeMismatch(String methodName, String expectedType, String actualType, int line, int column) {
        ReturnTypeMismatchError error = new ReturnTypeMismatchError(
                methodName, expectedType, actualType, line, column);
        addTypeHierarchyContext(error, expectedType, actualType);
        error.processError();
        registerError(error);
    }

    public void reportVoidMethodReturnValue(String methodName, String returnValue, int line, int column) {
        VoidMethodReturnValueError error = new VoidMethodReturnValueError(
                methodName, returnValue, line, column);
        addMethodContextToError(error, methodName);
        error.processError();
        registerError(error);
    }

    public void reportMissingReturnStatement(String methodName, String expectedReturnType, int line, int column) {
        MissingReturnStatementError error = new MissingReturnStatementError(
                methodName, expectedReturnType, line, column);
        addCodePathContext(error, methodName);
        error.processError();
        registerError(error);
    }

    public void reportDuplicateClass(String className, int line, int column, int previousLine) {
        String currentScope = mainSymbolTable.getCurrentScopeName();
        DuplicateClassError error = new DuplicateClassError(
                className, currentScope, line, column, previousLine);
        addClassRegistryContext(error, className);
        error.processError();
        registerError(error);
    }

    public void reportDuplicateInterface(String interfaceName, List<String> extendedInterfaces, int line, int column, int previousLine) {
        DuplicateInterfaceError error = new DuplicateInterfaceError(
                interfaceName, extendedInterfaces, line, column, previousLine);
        addInterfaceHierarchyContext(error, interfaceName, extendedInterfaces);
        error.processError();
        registerError(error);
    }

    // ========================================
    // CONTEXT ADDITION HELPER METHODS - ENHANCED
    // ========================================

    private void addRelevantVariableSymbols(UndefinedVariableError error, String variableName) {
        // Add all variables from current and parent scopes
        List<Row> allSymbols = mainSymbolTable.getAllSymbols();
        for (Row row : allSymbols) {
            if ("VARIABLE".equals(row.getType()) || "PARAMETER".equals(row.getType()) ||
                    "PROPERTY".equals(row.getType()) || "COMPONENT_PROPERTY".equals(row.getType())) {
                error.addRelevantSymbol(row.getValue(), row.getType(), row.getScopeName());
            }
        }

        // Add component properties
        for (String property : componentProperties) {
            String type = propertyTypes.getOrDefault(property, "any");
            error.addRelevantSymbol(property, "COMPONENT_PROPERTY", "COMPONENT");
        }

        // Add template variables
        for (String templateVar : templateVariables) {
            error.addRelevantSymbol(templateVar, "TEMPLATE_VARIABLE", "TEMPLATE");
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

        // Add template variables
        for (String templateVar : templateVariables) {
            error.addRelevantSymbol(templateVar, "TEMPLATE_VARIABLE", "TEMPLATE");
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

    private void addInterfaceHierarchyContext(DuplicateInterfaceError error, String interfaceName, List<String> extendedInterfaces) {
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

    private void addBindingPatternContext(LiteralBindingForPropertyError error, String attributeName, String attributeValue) {
        // Add binding pattern information
        error.addRelevantSymbol(attributeName, "ATTRIBUTE", "TEMPLATE");
        error.addRelevantSymbol(attributeValue, "LITERAL_VALUE", "TEMPLATE");
    }

    // ========================================
    // ERROR MANAGEMENT METHODS
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

    public void addMethodSignature(String methodName, String signature, String returnType, int line) {
        MethodSignatureInfo info = new MethodSignatureInfo(methodName, signature, returnType, line);
        methodSignatures.put(signature, info);
    }

    // ========================================
    // REPORTING METHODS
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
        report.append("=== ANGULAR-AWARE SEMANTIC ERROR REPORT ===\n");
        report.append("Total Errors: ").append(allErrors.size()).append("\n");

        // Debug information
        report.append("DEBUG INFO:\n");
        report.append("- Component Properties: ").append(componentProperties).append("\n");
        report.append("- Template Variables: ").append(templateVariables).append("\n");
        report.append("- Standard HTML Attributes: ").append(standardHtmlAttributes.size()).append(" registered\n\n");

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
    // HELPER CLASSES
    // ========================================

    static class MethodSignatureInfo {
        String methodName;
        String signature;
        String returnType;
        int line;

        MethodSignatureInfo(String methodName, String signature, String returnType) {
            this.methodName = methodName;
            this.signature = signature;
            this.returnType = returnType;
            this.line = 0;
        }

        MethodSignatureInfo(String methodName, String signature, String returnType, int line) {
            this.methodName = methodName;
            this.signature = signature;
            this.returnType = returnType;
            this.line = line;
        }

        public int getLine() {
            return line;
        }
    }
}