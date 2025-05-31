package classes;

import java.util.*;

public class SemanticErrorManager {
    private SymbolTable symbolTable;
    private List<SemanticError> errors;
    private Set<String> structuralDirectivesUsed;
    private boolean hasCommonModuleImport;
    private Set<String> importedModules;
    private Set<String> usedDecorators;
    private Set<String> importedIdentifiers;

    // Method tracking structures
    private Map<String, MethodInfo> methodSignatures;
    private Set<String> processedMethods;
    private Set<String> componentProperties = new HashSet<>();
    public SemanticErrorManager(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        this.errors = new ArrayList<>();
        this.structuralDirectivesUsed = new HashSet<>();
        this.hasCommonModuleImport = false;
        this.importedModules = new HashSet<>();
        this.usedDecorators = new HashSet<>();
        this.importedIdentifiers = new HashSet<>();
        this.componentProperties = new HashSet<>();
        // Method tracking initialization
        this.methodSignatures = new HashMap<>();
        this.processedMethods = new HashSet<>();
        Set<String> componentProperties = new HashSet<>();

    }
    private static final Set<String> BINDABLE_ATTRIBUTES = Set.of(
            "src", "href", "style", "class", "value",
            "disabled", "checked", "selected", "id", "name",
            "alt", "title", "placeholder", "type", "ngModel"
    );
    private SymbolTable.SymbolTableSnapshot createSnapshot(Set<String> relevantTokens) {
        return symbolTable.createSnapshot(relevantTokens);
    }
    // Reset flags before analysis starts
    public void resetAnalysis() {
        // Existing resets
        this.hasCommonModuleImport = false;
        this.importedIdentifiers.clear();
        this.importedModules.clear();
        this.structuralDirectivesUsed.clear();
        this.usedDecorators.clear();
        this.errors.clear();
        this.methodSignatures.clear();
        this.processedMethods.clear();

        // NEW: Clear component properties tracking
        this.componentProperties.clear();


    }
    public void addComponentProperty(String propertyName) {
        if (propertyName != null && !propertyName.isEmpty()) {
            componentProperties.add(propertyName);

        }
    }

    public void reportLiteralBinding(String attribute, String value, int line, int column) {
        Set<String> relevantTokens = new HashSet<>();
        relevantTokens.add(attribute);
        relevantTokens.add(value);

        SemanticError error = new SemanticError(
                SemanticErrorType.LITERAL_BINDING_FOR_PROPERTY,
                "Literal string binding for '" + attribute + "' which should be property binding." +
                        " Use: [" + attribute + "]=\"" + value + "\"",
                line, column, value,
                createSnapshot(relevantTokens)
        );
        errors.add(error);
        System.err.println("SEMANTIC ERROR [Line " + line + ", Column " + column + "]: " + error.getMessage());
    }

    public void reportUndefinedBinding(String property, int line, int column) {
        Set<String> relevantTokens = new HashSet<>();
        relevantTokens.add(property);

        SemanticError error = new SemanticError(
                SemanticErrorType.UNDEFINED_BINDING,
                "Undefined property '" + property + "' used in template",
                line, column, property,
                createSnapshot(relevantTokens)
        );
        errors.add(error);
        System.err.println("SEMANTIC ERROR [Line " + line + ", Column " + column + "]: " + error.getMessage());
    }

    public boolean isComponentProperty(String name) {
        return componentProperties.contains(name);
    }

    // ========================================
    // METHOD SEMANTIC CHECKS (NEW FUNCTIONALITY)
    // ========================================

    static class MethodInfo {
        private String methodName;
        private String declaredReturnType;
        private List<String> actualReturnTypes;
        private List<String> parameterTypes;
        private int declarationLine;
        private int declarationColumn;
        private boolean isVoidMethod;
        private boolean hasBeenProcessed;
        private String scopeId;

        public MethodInfo(String methodName, String declaredReturnType, int line, int column, String scopeId) {
            this.methodName = methodName;
            this.declaredReturnType = declaredReturnType;
            this.actualReturnTypes = new ArrayList<>();
            this.parameterTypes = new ArrayList<>();
            this.declarationLine = line;
            this.declarationColumn = column;
            this.isVoidMethod = "void".equalsIgnoreCase(declaredReturnType);
            this.hasBeenProcessed = false;
            this.scopeId = scopeId;
        }

        public void addReturnStatement(String returnType) {
            if (returnType != null && !returnType.trim().isEmpty()) {
                actualReturnTypes.add(returnType.trim());
            }
        }
        // In SemanticErrorManager class

        private String extractNgForVariable(String directiveContent) {
            if (directiveContent == null) return null;

            // Extract content: "let item of products" -> look for "of" keyword
            String[] parts = directiveContent.split("\\s+");
            for (int i = 0; i < parts.length - 1; i++) {
                if ("of".equals(parts[i]) || "in".equals(parts[i])) {
                    return parts[i + 1].replace(";", "").trim();
                }
            }
            return null;
        }

        public void setParameterTypes(List<String> parameterTypes) {
            this.parameterTypes = parameterTypes != null ? new ArrayList<>(parameterTypes) : new ArrayList<>();
        }

        // Getters
        public String getMethodName() { return methodName; }
        public String getDeclaredReturnType() { return declaredReturnType; }
        public List<String> getActualReturnTypes() { return actualReturnTypes; }
        public List<String> getParameterTypes() { return parameterTypes; }
        public int getDeclarationLine() { return declarationLine; }
        public int getDeclarationColumn() { return declarationColumn; }
        public boolean isVoidMethod() { return isVoidMethod; }
        public boolean hasReturnStatements() { return !actualReturnTypes.isEmpty(); }
        public boolean hasBeenProcessed() { return hasBeenProcessed; }
        public void setProcessed(boolean processed) { this.hasBeenProcessed = processed; }
        public String getScopeId() { return scopeId; }
    }

    // Register method declaration
    public void registerMethodDeclaration(String methodName, String returnType, List<String> parameterTypes, int line, int column) {
        if (methodName == null || returnType == null) return;

        // Get current scope name
        String currentScopeName = symbolTable.getCurrentScopeName();
        String methodSignature = createMethodSignature(currentScopeName + "." + methodName, parameterTypes);

        // Check for exact duplicate in current scope
        if (methodSignatures.containsKey(methodSignature)) {
            MethodInfo existingMethod = methodSignatures.get(methodSignature);
            SemanticError error = new SemanticError(
                    SemanticErrorType.DUPLICATE_METHOD,
                    "Duplicate method '" + methodName + "' with same signature. " +
                            "Previous declaration at line " + existingMethod.getDeclarationLine(),
                    line, column, methodName
            );
            errors.add(error);
            System.err.println("SEMANTIC ERROR [Line " + line + ", Column " + column + "]: " + error.getMessage());
            return;
        }

        MethodInfo methodInfo = new MethodInfo(methodName, returnType, line, column,
                String.valueOf(symbolTable.getCurrentScopeIdPublic()));
        methodInfo.setParameterTypes(parameterTypes);
        methodSignatures.put(methodSignature, methodInfo);


    }
    public MethodInfo getMethodInfoBySignature(String signature) {
        return methodSignatures.get(signature);
    }

    public String createMethodSignature(String methodName, List<String> parameterTypes) {
        if (parameterTypes == null || parameterTypes.isEmpty()) {
            return methodName + "()";
        }
        return methodName + "(" + String.join(",", parameterTypes) + ")";
    }


    // Check return statements
    public void checkReturnStatement(MethodInfo methodInfo, String returnValue, String returnType, int line, int column) {
        if (methodInfo == null) return;

        // Void method returning value
        if (methodInfo.isVoidMethod()) {
            if (returnValue != null && !returnValue.trim().isEmpty() &&
                    !"void".equals(returnType) && !"null".equals(returnValue.trim())) {
                SemanticError error = new SemanticError(
                        SemanticErrorType.VOID_METHOD_RETURN_VALUE,
                        "Void method '" + methodInfo.getMethodName() + "' cannot return a value. " +
                                "Found return statement with value: '" + returnValue + "'",
                        line, column, returnValue
                );
                errors.add(error);
                System.err.println("SEMANTIC ERROR [Line " + line + ", Column " + column + "]: " + error.getMessage());
            }
        }
        // Type mismatch
        else if (!methodInfo.isVoidMethod() && returnType != null && !"void".equals(returnType)) {
            if (!isTypeCompatible(methodInfo.getDeclaredReturnType(), returnType)) {
                SemanticError error = new SemanticError(
                        SemanticErrorType.RETURN_TYPE_MISMATCH,
                        "Return type mismatch in method '" + methodInfo.getMethodName() + "'. " +
                                "Expected: '" + methodInfo.getDeclaredReturnType() + "', but found: '" + returnType + "'",
                        line, column, returnValue != null ? returnValue : returnType
                );
                errors.add(error);
                System.err.println("SEMANTIC ERROR [Line " + line + ", Column " + column + "]: " + error.getMessage());
            }
        }
        methodInfo.addReturnStatement(returnType);
    }


    private MethodInfo findMethodInfo(String methodName) {
        if (methodName == null) return null;
        String currentScope = symbolTable.getCurrentScopeName();

        // Build scope-specific keys
        String[] lookupKeys = {
                currentScope + "." + methodName,  // Most specific
                "CLASS." + methodName,            // Class-level
                "METHOD." + methodName,           // Method-level
                "GLOBAL." + methodName            // Global
        };

        for (String key : lookupKeys) {
            MethodInfo methodInfo = methodSignatures.get(key);
            if (methodInfo != null) return methodInfo;
        }

        return null;
    }

    public static boolean isTypeCompatible(String declaredType, String actualType) {
        if (declaredType == null || actualType == null) return false;

        // Normalize types
        declaredType = declaredType.toLowerCase().replace("[]", "array");
        actualType = actualType.toLowerCase().replace("[]", "array");

        // Handle primitive types
        if (declaredType.equals(actualType)) {
            return true;
        }

        // Handle "any" type
        if (declaredType.equals("any")) {
            return true;
        }

        // Handle number compatibility
        if (declaredType.equals("number")) {
            return actualType.matches("int|integer|float|double|number");
        }

        // Handle boolean compatibility
        if (declaredType.equals("boolean")) {
            return actualType.equals("bool");
        }

        // Handle string compatibility
        if (declaredType.equals("string")) {
            return actualType.equals("text") || actualType.equals("string");
        }

        return false;
    }

    private boolean isTypeConvertible(String declaredType, String actualType) {
        Map<String, List<String>> typeCompatibility = new HashMap<>();
        typeCompatibility.put("string", List.of("string", "string_literal", "text"));
        typeCompatibility.put("number", List.of("int", "integer", "number", "number_literal", "float", "double"));
        typeCompatibility.put("boolean", List.of("boolean", "boolean_literal", "bool"));
        typeCompatibility.put("object", List.of("object", "any", "class"));
        typeCompatibility.put("any", List.of("string", "number", "boolean", "object", "any"));

        List<String> compatibleTypes = typeCompatibility.get(declaredType);
        return compatibleTypes != null && compatibleTypes.contains(actualType);
    }

    // Check for missing return statements
    private void checkMethodReturnCompleteness(MethodInfo method) {
        if (method == null) return;

        if (!method.isVoidMethod() && !method.hasReturnStatements()) {
            SemanticError error = new SemanticError(
                    SemanticErrorType.MISSING_RETURN_STATEMENT,
                    "Non-void method '" + method.getMethodName() + "' must return a value",
                    method.getDeclarationLine(),
                    method.getDeclarationColumn(),
                    method.getMethodName()
            );
            errors.add(error);
        }
    }

    // ========================================
    // EXISTING ANGULAR CHECKS (PRESERVED AS-IS)
    // ========================================

    // Track when decorators are used
    public void trackDecoratorUsage(String decoratorName, int line, int column) {
        if (decoratorName != null) {
            String cleanDecorator = decoratorName.replace("@", "");
            usedDecorators.add(cleanDecorator);

            // Check if the decorator is imported
            if (!importedIdentifiers.contains(cleanDecorator)) {
                SemanticError error = new SemanticError(
                        SemanticErrorType.MISSING_DECORATOR_IMPORT,
                        "Decorator '@" + cleanDecorator + "' is used but not imported. Add: import { " + cleanDecorator + " } from '@angular/core';",
                        line, column, cleanDecorator
                );
                errors.add(error);
                System.err.println("SEMANTIC ERROR [Line " + line + ", Column " + column + "]: " + error.getMessage());
            }
        }
    }

    // Check undefined variables
    public void checkUndefinedVariable(String variableName, int line, int column) {
        Row symbol = symbolTable.lookupSymbol(variableName);
        if (symbol == null || "UNDEFINED_VARIABLE".equals(symbol.getType())) {
            Set<String> relevantTokens = new HashSet<>();
            relevantTokens.add(variableName);

            SemanticError error = new SemanticError(
                    SemanticErrorType.UNDEFINED_VARIABLE,
                    "Undefined variable '" + variableName + "'",
                    line, column, variableName,
                    createSnapshot(relevantTokens)
            );
            errors.add(error);
            System.err.println("SEMANTIC ERROR [Line " + line + ", Column " + column + "]: " + error.getMessage());
        }
    }


    // NEW: Method to check any directive usage - call this for ALL directive attributes
    public void checkDirectiveAttribute(String attributeName, int line, int column) {
        if (attributeName == null) return;

        Set<String> relevantTokens = new HashSet<>();
        String cleanAttribute = attributeName.replaceAll("['\"]", "").trim();
        relevantTokens.add(cleanAttribute);

        // Add the base directive name (without asterisk) to relevant tokens
        String baseDirective = cleanAttribute.startsWith("*") ?
                cleanAttribute.substring(1) : cleanAttribute;
        relevantTokens.add(baseDirective);

        // Also include CommonModule since it's required for structural directives
        relevantTokens.add("CommonModule");

        // Include the current scope name for context
        relevantTokens.add(symbolTable.getCurrentScopeName());

        if (isStructuralDirective(cleanAttribute)) {
            if (!cleanAttribute.startsWith("*")) {
                // Create enhanced error message with more context
                String errorMsg = "Missing '*' before structural directive '" + cleanAttribute + "'. " +
                        "Should be '*" + cleanAttribute + "'. " +
                        "Structural directives like *ngFor require the asterisk syntax.";

                SemanticError error = new SemanticError(
                        SemanticErrorType.MISSING_STRUCTURAL_DIRECTIVE_ASTERISK,
                        errorMsg,
                        line, column, cleanAttribute,
                        createSnapshot(relevantTokens)
                );
                errors.add(error);
                System.err.println("SEMANTIC ERROR [Line " + line + ", Column " + column + "]: " + error.getMessage());
            }

            structuralDirectivesUsed.add(baseDirective);
        }
    }

    // DEPRECATED: Use checkDirectiveAttribute instead
    public void checkMissingStructuralDirective(String directiveName, int line, int column) {
        checkDirectiveAttribute(directiveName, line, column);
    }

    // FIXED: Check for missing CommonModule import when structural directives are used
    public void checkMissingCommonModule() {
        System.out.println("DEBUG: Final check - Structural directives: " + structuralDirectivesUsed +
                ", CommonModule imported: " + hasCommonModuleImport);
        System.out.println("DEBUG: Imported identifiers: " + importedIdentifiers);

        // Only check if we actually have structural directives AND no CommonModule import
        if (!structuralDirectivesUsed.isEmpty() && !hasCommonModuleImport) {
            SemanticError error = new SemanticError(
                    SemanticErrorType.MISSING_COMMON_MODULE,
                    "Missing CommonModule import. Structural directives like *ngFor, *ngIf require CommonModule to be imported. Add: import { CommonModule } from '@angular/common';",
                    0, 0, // Global error
                    String.join(", ", structuralDirectivesUsed)
            );
            errors.add(error);
            System.err.println("SEMANTIC ERROR: " + error.getMessage());
        }

        // Additional validation: if CommonModule is not in imported identifiers but we think it's imported
        if (hasCommonModuleImport && !importedIdentifiers.contains("CommonModule")) {
            System.out.println("DEBUG: WARNING - hasCommonModuleImport is true but CommonModule not in importedIdentifiers");
            hasCommonModuleImport = false; // Reset the flag

            // Re-check after reset
            if (!structuralDirectivesUsed.isEmpty()) {
                SemanticError error = new SemanticError(
                        SemanticErrorType.MISSING_COMMON_MODULE,
                        "Missing CommonModule import. Structural directives like *ngFor, *ngIf require CommonModule to be imported. Add: import { CommonModule } from '@angular/common';",
                        0, 0, // Global error
                        String.join(", ", structuralDirectivesUsed)
                );
                errors.add(error);
                System.err.println("SEMANTIC ERROR: " + error.getMessage());
            }
        }
    }

    // Check for property binding mismatches
    public void checkPropertyBinding(String propertyName, String bindingType, int line, int column) {
        if (propertyName == null) return;

        Set<String> relevantTokens = new HashSet<>();
        String cleanProperty = propertyName.replaceAll("['\"]", "");
        relevantTokens.add(cleanProperty);

        if (bindingType != null && bindingType.equals("RESOURCE_BINDING")) {
            if (cleanProperty.startsWith("[") && cleanProperty.endsWith("]")) {
                String actualProperty = cleanProperty.substring(1, cleanProperty.length() - 1);
                relevantTokens.add(actualProperty);

                Row propertySymbol = symbolTable.lookupSymbol(actualProperty);
                if (propertySymbol == null) {
                    SemanticError error = new SemanticError(
                            SemanticErrorType.PROPERTY_BINDING_MISMATCH,
                            "Property '" + actualProperty + "' used in property binding [" + actualProperty + "] is not defined in component",
                            line, column, actualProperty,
                            createSnapshot(relevantTokens)
                    );
                    errors.add(error);
                    System.err.println("SEMANTIC ERROR [Line " + line + ", Column " + column + "]: " + error.getMessage());
                }
            }
        }
    }


    // Check interpolation variables
    public void checkInterpolationVariable(String variableName, int line, int column) {
        if (variableName == null) return;

        Set<String> relevantTokens = new HashSet<>();
        String cleanVariable = variableName.replaceAll("['\"]", "");
        relevantTokens.add(cleanVariable);

        Row variableSymbol = symbolTable.lookupSymbol(cleanVariable);
        if (variableSymbol == null) {
            SemanticError error = new SemanticError(
                    SemanticErrorType.UNDEFINED_INTERPOLATION_VARIABLE,
                    "Interpolation variable '{{ " + cleanVariable + " }}' is not defined in component",
                    line, column, cleanVariable,
                    createSnapshot(relevantTokens)
            );
            errors.add(error);
            System.err.println("SEMANTIC ERROR [Line " + line + ", Column " + column + "]: " + error.getMessage());
        }
    }


    // Check for missing decorator symbol (@)
    public void checkMissingDecoratorSymbol(String decoratorName, int line, int column) {
        if (decoratorName != null && !decoratorName.startsWith("@")) {
            Set<String> relevantTokens = new HashSet<>();
            relevantTokens.add(decoratorName);

            SemanticError error = new SemanticError(
                    SemanticErrorType.MISSING_DECORATOR_SYMBOL,
                    "Missing '@' symbol before decorator '" + decoratorName + "'. Should be '@" + decoratorName + "'",
                    line, column, decoratorName,
                    createSnapshot(relevantTokens)
            );
            errors.add(error);
            System.err.println("SEMANTIC ERROR [Line " + line + ", Column " + column + "]: " + error.getMessage());
        }
    }

    // Check for missing required imports at the end of analysis
    private void checkMissingRequiredImports() {
        // Check for missing Angular core imports
        for (String decorator : usedDecorators) {
            if (!importedIdentifiers.contains(decorator)) {
                SemanticError error = new SemanticError(
                        SemanticErrorType.MISSING_DECORATOR_IMPORT,
                        "Missing import for decorator '@" + decorator + "'. Add: import { " + decorator + " } from '@angular/core';",
                        0, 0, // Global error
                        decorator
                );
                errors.add(error);
                System.err.println("SEMANTIC ERROR: " + error.getMessage());
            }
        }
    }

    // FIXED: Helper method to determine if a directive is structural
    private boolean isStructuralDirective(String directive) {
        if (directive == null) return false;

        // Remove * if present for comparison
        String cleanDirective = directive.startsWith("*") ?
                directive.substring(1) : directive;

        Set<String> structuralDirectives = Set.of(
                "ngFor", "ngIf", "ngSwitch", "ngSwitchCase", "ngSwitchDefault",
                "ngTemplateOutlet", "ngComponentOutlet"
        );
        return structuralDirectives.contains(cleanDirective);
    }

    // NEW: Method to simulate detecting directives without CommonModule import
    public void simulateDirectiveUsageWithoutCommonModule() {
        // This method can be used for testing
        // Force check structural directives without CommonModule
        hasCommonModuleImport = false;
        importedIdentifiers.remove("CommonModule");

        // Add some structural directives to trigger the error
        structuralDirectivesUsed.add("ngFor");
        structuralDirectivesUsed.add("ngIf");

        System.out.println("DEBUG: Simulating directive usage without CommonModule");
        System.out.println("DEBUG: hasCommonModuleImport: " + hasCommonModuleImport);
        System.out.println("DEBUG: structuralDirectivesUsed: " + structuralDirectivesUsed);
    }

    // FIXED: Check for missing required imports at the end of analysis
    public void checkImportDeclaration(String importId, String importPath) {
        if (importId != null) {
            String cleanId = importId.replaceAll("['\"]", "").trim();
            importedIdentifiers.add(cleanId);

        }

        if (importPath != null) {
            String cleanPath = importPath.replaceAll("['\"]", "").trim();
            importedModules.add(cleanPath);


            // Only set hasCommonModuleImport if it's an actual import path
            if (cleanPath.contains("@angular/common")) {
                hasCommonModuleImport = true;

            }
        }
    }

    public void finalizeAnalysis() {


        // Check if structural directives are used without CommonModule import
        if (!structuralDirectivesUsed.isEmpty() && !hasCommonModuleImport) {
            SemanticError error = new SemanticError(
                    SemanticErrorType.MISSING_COMMON_MODULE,
                    "Missing CommonModule import. Structural directives like *ngFor, *ngIf require CommonModule. " +
                            "Add: import { CommonModule } from '@angular/common';",
                    0, 0,
                    String.join(", ", structuralDirectivesUsed)
            );
            errors.add(error);
            System.err.println("SEMANTIC ERROR: " + error.getMessage());
        }

        // Check method completeness
        for (MethodInfo method : methodSignatures.values()) {
            if (!method.hasBeenProcessed()) {
                checkMethodReturnCompleteness(method);
                method.setProcessed(true);
            }
        }

        checkMissingRequiredImports();


    }


    // Print all semantic errors
    public void printErrors() {
        if (errors.isEmpty()) {
            System.out.println("\n=== SEMANTIC ANALYSIS ===");
            System.out.println("No semantic errors found.");
            System.out.println("========================\n");
            return;
        }

        System.out.println("\n=== SEMANTIC ERRORS ===");
        System.out.println("Found " + errors.size() + " semantic error(s):");

        // Group errors by type
        Map<SemanticErrorType, List<SemanticError>> errorsByType = new HashMap<>();
        for (SemanticError error : errors) {
            errorsByType.computeIfAbsent(error.getType(), k -> new ArrayList<>()).add(error);
        }

        // Print errors grouped by type
        for (Map.Entry<SemanticErrorType, List<SemanticError>> entry : errorsByType.entrySet()) {
            System.out.println("\n" + entry.getKey().getDisplayName() + ":");
            for (SemanticError error : entry.getValue()) {
                if (error.getLine() > 0) {
                    System.out.println("  - Line " + error.getLine() + ", Column " + error.getColumn() + ": " + error.getMessage());
                } else {
                    System.out.println("  - " + error.getMessage());
                }

                // ADD THIS: Print snapshot if available
                if (error.getSnapshot() != null) {
                    System.out.println("  Relevant Symbol Context:");
                    error.getSnapshot().print();
                }
            }
        }

        System.out.println("\nTotal: " + errors.size() + " semantic error(s)");
        System.out.println("======================\n");
    }



    // NEW: Track component properties

    // NEW: Check for literal binding when property binding should be used
    public void checkLiteralBinding(String attributeName, String attributeValue, int line, int column) {
        if (attributeName == null || attributeValue == null) return;

        // Remove quotes from attribute value
        String cleanValue = attributeValue.replace("\"", "").replace("'", "");

        // Check if this is a common bindable attribute and the value matches a component property
        if (BINDABLE_ATTRIBUTES.contains(attributeName) &&
                componentProperties.contains(cleanValue)) {

            SemanticError error = new SemanticError(
                    SemanticErrorType.LITERAL_BINDING_FOR_PROPERTY,
                    "Literal string binding for attribute '" + attributeName +
                            "' with value matching component property '" + cleanValue +
                            "'. This binds a static string. For property binding, use: [" + attributeName + "]=\"" + cleanValue + "\"",
                    line, column, attributeName
            );
            errors.add(error);
            System.err.println("SEMANTIC ERROR [Line " + line + ", Column " + column + "]: " + error.getMessage());
        }
    }

    // CHANGED: Updated to support both ngFor and ngIf directives
    public void checkStructuralDirectiveVariable(String directive, int line, int column) {
        if (directive == null || !directive.startsWith("*")) return;

        Set<String> relevantTokens = new HashSet<>();
        relevantTokens.add(directive);

        String cleanDirective = directive.substring(1);
        String variable = null;

        if (cleanDirective.startsWith("ngFor")) {
            variable = extractNgForVariable(directive);
            if (variable != null) {
                relevantTokens.add(variable);

                if (!componentProperties.contains(variable)) {
                    SemanticError error = new SemanticError(
                            SemanticErrorType.UNDEFINED_STRUCTURAL_DIRECTIVE_VARIABLE,
                            "Undefined variable '" + variable + "' in *ngFor directive",
                            line, column, directive,
                            createSnapshot(relevantTokens)
                    );
                    errors.add(error);
                    System.err.println("SEMANTIC ERROR [Line " + line + ", Column " + column + "]: " + error.getMessage());
                }
            }
        }
        else if (cleanDirective.startsWith("ngIf")) {
            String condition = extractNgIfCondition(directive);
            if (condition != null) {
                relevantTokens.add(condition);

                if (!componentProperties.contains(condition) &&
                        !condition.matches("true|false|\\d+")) {
                    SemanticError error = new SemanticError(
                            SemanticErrorType.UNDEFINED_STRUCTURAL_DIRECTIVE_VARIABLE,
                            "Undefined variable '" + condition + "' in *ngIf directive",
                            line, column, directive,
                            createSnapshot(relevantTokens)
                    );
                    errors.add(error);
                    System.err.println("SEMANTIC ERROR [Line " + line + ", Column " + column + "]: " + error.getMessage());
                }
            }
        }
    }

    // CHANGED: Enhanced to handle both 'of' and 'in' syntax
    private String extractNgForVariable(String directive) {
        try {
            // Extract content inside quotes
            int startQuote = directive.indexOf('"');
            int endQuote = directive.lastIndexOf('"');
            if (startQuote == -1 || endQuote == -1) return null;

            String content = directive.substring(startQuote + 1, endQuote);

            // Split into tokens: ["let", "item", "of", "items"]
            String[] tokens = content.split("\\s+");
            for (int i = 0; i < tokens.length - 2; i++) {
                if (tokens[i].equals("of") || tokens[i].equals("in")) {
                    String variable = tokens[i + 1];
                    // Remove trailing semicolon if present
                    if (variable.endsWith(";")) {
                        variable = variable.substring(0, variable.length() - 1);
                    }
                    return variable;
                }
            }
        } catch (Exception e) {
            System.err.println("Error parsing ngFor directive: " + e.getMessage());
        }
        return null;
    }

    // NEW: Method to extract ngIf condition
    private String extractNgIfCondition(String directive) {
        try {
            // Extract content inside quotes
            int startQuote = directive.indexOf('"');
            int endQuote = directive.lastIndexOf('"');
            if (startQuote == -1 || endQuote == -1) return null;

            return directive.substring(startQuote + 1, endQuote).trim();
        } catch (Exception e) {
            System.err.println("Error parsing ngIf directive: " + e.getMessage());
            return null;
        }
    }
    // Print errors with symbol table information
    public void printErrorsWithSymbolTable() {
        printErrors();
        if (!errors.isEmpty()) {
            System.out.println("=== ANALYSIS SUMMARY ===");
            System.out.println("Structural directives used: " + (structuralDirectivesUsed.isEmpty() ? "None" : String.join(", ", structuralDirectivesUsed)));
            System.out.println("CommonModule imported: " + hasCommonModuleImport);
            System.out.println("Used decorators: " + (usedDecorators.isEmpty() ? "None" : String.join(", ", usedDecorators)));
            System.out.println("Imported identifiers: " + (importedIdentifiers.isEmpty() ? "None" : String.join(", ", importedIdentifiers)));
            System.out.println("All imported modules: " + (importedModules.isEmpty() ? "None" : String.join(", ", importedModules)));
            System.out.println("=======================\n");
        }
    }

    // Getters
    public List<SemanticError> getErrors() {
        return new ArrayList<>(errors);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public int getErrorCount() {
        return errors.size();
    }

    public Set<String> getUsedDecorators() {
        return new HashSet<>(usedDecorators);
    }

    public Set<String> getImportedIdentifiers() {
        return new HashSet<>(importedIdentifiers);
    }

    public Set<String> getStructuralDirectivesUsed() {
        return new HashSet<>(structuralDirectivesUsed);
    }

    public boolean hasCommonModuleImport() {
        return hasCommonModuleImport;
    }

    public void reportDuplicateClass(String className, int line, int column) {
        SemanticError error = new SemanticError(
                SemanticErrorType.DUPLICATE_CLASS,
                "Duplicate class declaration '" + className + "'",
                line, column, className
        );
        errors.add(error);
        System.err.println("SEMANTIC ERROR [Line " + line + ", Column " + column + "]: " + error.getMessage());
    }

    public void reportDuplicateInterface(String interfaceName, int line, int column) {
        SemanticError error = new SemanticError(
                SemanticErrorType.DUPLICATE_INTERFACE,
                "Duplicate interface declaration '" + interfaceName + "'",
                line, column, interfaceName
        );
        errors.add(error);
        System.err.println("SEMANTIC ERROR [Line " + line + ", Column " + column + "]: " + error.getMessage());
    }
}



// Enum for semantic error types
enum SemanticErrorType {
    // Existing types
    MISSING_STRUCTURAL_DIRECTIVE_ASTERISK("Missing Structural Directive Asterisk"),
    MISSING_COMMON_MODULE("Missing CommonModule Import"),
    UNDEFINED_VARIABLE("Undefined Variable"),
    PROPERTY_BINDING_MISMATCH("Property Binding Mismatch"),
    UNDEFINED_INTERPOLATION_VARIABLE("Undefined Interpolation Variable"),
    MISSING_DECORATOR_IMPORT("Missing Decorator Import"),
    MISSING_DECORATOR_SYMBOL("Missing Decorator Symbol"),
    DUPLICATE_CLASS("Duplicate Class Declaration"),
    LITERAL_BINDING_FOR_PROPERTY("Literal Binding Used for Property"),
    UNDEFINED_STRUCTURAL_DIRECTIVE_VARIABLE("Undefined Structural Directive Variable"),
    DUPLICATE_INTERFACE("Duplicate Interface Declaration"),
    UNDEFINED_BINDING("Undefined Template Binding"),
    DUPLICATE_METHOD("Duplicate Method Declaration"),
    RETURN_TYPE_MISMATCH("Return Type Mismatch"),
    VOID_METHOD_RETURN_VALUE("Void Method Returning Value"),
    MISSING_RETURN_STATEMENT("Missing Return Statement");

    private final String displayName;

    SemanticErrorType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

// Class to represent individual semantic errors
class SemanticError {
    private SemanticErrorType type;
    private String message;
    private int line;
    private int column;
    private String context;
    private SymbolTable.SymbolTableSnapshot snapshot;
    public SemanticError(SemanticErrorType type, String message, int line, int column, String context) {
        this(type, message, line, column, context, null);
    }
    public SemanticError(SemanticErrorType type, String message, int line, int column,
                         String context, SymbolTable.SymbolTableSnapshot snapshot) {
        this.type = type;
        this.message = message;
        this.line = line;
        this.column = column;
        this.context = context;
        this.snapshot = snapshot;
    }
    public SymbolTable.SymbolTableSnapshot getSnapshot() {
        return snapshot;
    }
    public SemanticErrorType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public String getContext() {
        return context;
    }

    @Override
    public String toString() {
        return String.format("[%s] Line %d, Column %d: %s", type.getDisplayName(), line, column, message);
    }
    public void printWithContext() {
        System.out.println("[" + type.getDisplayName() + "] Line " + line + ", Column " + column + ": " + message);
        if (snapshot != null) {
            System.out.println("Relevant Symbol Context:");
            snapshot.print();
        }
    }
}
