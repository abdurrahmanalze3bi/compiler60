package classes;

import java.util.*;

/**
 * Complete Symbol Table System - Angular-Aware Version
 * Enhanced to properly handle Angular template syntax and component semantics
 *
 * Features:
 * 1. All original SymbolTable functionality (scopes, symbols, lookups)
 * 2. Angular template variable recognition (*ngFor, *ngIf)
 * 3. Component property tracking
 * 4. HTML attribute validation
 * 5. Fixed semantic error reporting for Angular
 */
public class SymbolTable {
    // Core symbol table components
    private Stack<Scope> scopeStack;
    private List<Scope> allScopes;
    private int currentScopeId;
    private Map<String, Map<String, String>> cssRules; // selector -> {property: value}
    private Map<String, String> templateInterpolations; // interpolation -> property


    // Error management

    private String currentCSSSelector;
    private StringBuilder currentCSSValue = new StringBuilder();
    private String currentCSSProperty;

    private EnhancedSemanticErrorManager errorManager;
    private Map<String, List<String>> cssHierarchy = new HashMap<>();
    // Angular-specific component tracking
    private Set<String> componentProperties;
    private Map<String, String> propertyTypes;

    public SymbolTable() {
        // Initialize core symbol table
        this.scopeStack = new Stack<>();
        this.allScopes = new ArrayList<>();
        this.currentScopeId = 0;

        // Initialize Angular-aware error management
        this.componentProperties = new HashSet<>();
        this.propertyTypes = new HashMap<>();
        this.cssRules = new HashMap<>();
        this.templateInterpolations = new HashMap<>();
        // Create global scope
        enterScope("GLOBAL");

        // Initialize error manager after basic setup
        this.errorManager = new EnhancedSemanticErrorManager(this);
    }

    // ============================================
    // ORIGINAL SYMBOLTABLE METHODS - UNCHANGED
    // ============================================

    public void enterScope(String scopeName) {
        enterScope(scopeName, scopeName);
    }

    public void enterScope(String scopeName, String scopeType) {
        String normalizedName = normalizeScopeName(scopeName, scopeType);
        Scope newScope = new Scope(currentScopeId++, normalizedName, scopeType, getCurrentScopeId());
        scopeStack.push(newScope);
        allScopes.add(newScope);
    }

    private String normalizeScopeName(String scopeName, String scopeType) {
        switch (scopeType.toUpperCase()) {
            case "CLASS": return "CLASS";
            case "METHOD": return "METHOD";
            case "INTERFACE": return "INTERFACE";
            case "TEMPLATE": return "TEMPLATE";
            case "CSS": return "CSS";
            case "GLOBAL": return "GLOBAL";
            default: return scopeName;
        }
    }

    public void exitScope() {
        if (!scopeStack.isEmpty() && scopeStack.size() > 1) {
            scopeStack.pop();
        }
    }
    public void setCSSProperty(String property) {
        this.currentCSSProperty = property;
        this.currentCSSValue.setLength(0); // Reset value builder
        System.out.println(">>> Set CSS property: " + property);
    }
    public void addCSSValueToken(String token) {
        if (currentCSSValue.length() > 0) {
            currentCSSValue.append(" ");
        }
        currentCSSValue.append(token);
        System.out.println(">>> Added CSS value token: " + token + " (building: " + currentCSSValue.toString() + ")");
    }
    public void finalizeCSSProperty() {
        if (currentCSSSelector != null && currentCSSProperty != null && currentCSSValue.length() > 0) {
            String completeValue = currentCSSValue.toString().trim();

            // Store in CSS rules
            cssRules.get(currentCSSSelector).put(currentCSSProperty, completeValue);

            // Add to symbol table
            addSymbol("CSS_PROPERTY", currentCSSProperty);
            addSymbol("CSS_VALUE", completeValue);

            System.out.println(">>> FINALIZED CSS: " + currentCSSSelector + " { " + currentCSSProperty + ": " + completeValue + "; }");

            // Reset for next property
            currentCSSProperty = null;
            currentCSSValue.setLength(0);
        }
    }

    public void addSymbol(String type, String value) {
        addSymbol(type, value, getCurrentScopeName());
    }

    public void addSymbol(String type, String value, String contextScope) {
        if (!scopeStack.isEmpty()) {
            Scope currentScope = scopeStack.peek();
            String actualScopeName = currentScope.getScopeType();
            Row row = new Row(type, value, currentScope.getScopeId(), actualScopeName);
            currentScope.addSymbol(row);
        }
    }

    /**
     * ENHANCED lookup that includes Angular template variables and component properties
     */
    public Row lookupSymbol(String value) {
        // Check component properties first
        if (componentProperties.contains(value)) {
            String type = propertyTypes.getOrDefault(value, "any");
            return new Row("COMPONENT_PROPERTY", value, getCurrentScopeId(), "COMPONENT");
        }

        // Check template variables if in template context
        if ("TEMPLATE".equals(getCurrentScopeType()) && errorManager != null && errorManager.templateVariables.contains(value)) {
            return new Row("TEMPLATE_VARIABLE", value, getCurrentScopeId(), "TEMPLATE");
        }

        // Original scope-based lookup
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            Scope scope = scopeStack.get(i);
            Row symbol = scope.findSymbol(value);
            if (symbol != null) {
                return symbol;
            }
        }
        return null;
    }

    public boolean existsInCurrentScope(String value) {
        if (!scopeStack.isEmpty()) {
            return scopeStack.peek().findSymbol(value) != null;
        }
        return false;
    }

    public String getCurrentScopeName() {
        return scopeStack.isEmpty() ? "NONE" : scopeStack.peek().getScopeName();
    }

    public String getCurrentScopeType() {
        return scopeStack.isEmpty() ? null : scopeStack.peek().getScopeType();
    }

    public int getCurrentScopeIdPublic() {
        return getCurrentScopeId();
    }

    private int getCurrentScopeId() {
        return scopeStack.isEmpty() ? -1 : scopeStack.peek().getScopeId();
    }

    public List<Row> getAllSymbols() {
        List<Row> allSymbols = new ArrayList<>();
        for (Scope scope : allScopes) {
            allSymbols.addAll(scope.getSymbols());
        }
        return allSymbols;
    }

    public List<ScopeInfo> getCurrentScopeStack() {
        List<ScopeInfo> scopeInfoList = new ArrayList<>();
        for (Scope scope : scopeStack) {
            scopeInfoList.add(new ScopeInfo(
                    scope.getScopeId(),
                    scope.getScopeName(),
                    scope.getScopeType(),
                    scope.getParentScopeId(),
                    scope.getSymbolCount()
            ));
        }
        return scopeInfoList;
    }

    public SymbolTableSnapshot createSnapshot(Set<String> relevantTokens) {
        List<ScopeInfo> currentScopeStackInfo = getCurrentScopeStack();
        List<Row> relevantSymbols = new ArrayList<>();
        Set<String> expandedTokens = new HashSet<>(relevantTokens);

        for (String token : relevantTokens) {
            String cleanToken = token.replaceAll("[\"'*]", "");
            expandedTokens.add(cleanToken);
            expandedTokens.add("*" + cleanToken);
            expandedTokens.add(cleanToken + "*");
        }

        for (Row row : getAllSymbols()) {
            String cleanRowValue = row.getValue().replaceAll("[\"'*]", "");
            if (expandedTokens.contains(cleanRowValue) ||
                    expandedTokens.contains(row.getValue()) ||
                    relevantTokens.contains(row.getValue())) {
                relevantSymbols.add(row);
            }
        }

        return new SymbolTableSnapshot(relevantTokens, relevantSymbols, currentScopeStackInfo);
    }

    public void print() {
        System.out.println("\n=== SYMBOL TABLE ===");
        List<Row> allSymbols = getAllSymbols();
        if (allSymbols.isEmpty()) {
            System.out.println("No symbols found.");
            return;
        }

        System.out.println("| Identifier         | Kind             | Data Type        | Scope                |");
        System.out.println("| ------------------ | ---------------- | ---------------- | -------------------- |");

        for (Row row : allSymbols) {
            if (row != null) {
                String identifier = formatIdentifier(row.getValue());
                String kind = formatKind(row.getType());
                String dataType = formatDataType(row.getType());
                String scope = formatScope(row.getScopeName());
                System.out.printf("| %-18s | %-16s | %-16s | %-20s |%n",
                        identifier, kind, dataType, scope);
            }
        }

        System.out.println();
        System.out.println("Total symbols: " + allSymbols.size());
        System.out.println("Current scope: " + getCurrentScopeName() + " (ID: " + getCurrentScopeId() + ")");
        System.out.println("===================\n");
    }

    // ============================================
    // ANGULAR TEMPLATE PARSING AND ANALYSIS
    // ============================================

    /**
     * Parse Angular template and extract semantic information
     */
    public void parseAngularTemplate(String templateContent) {
        if (errorManager != null) {
            errorManager.parseAngularTemplate(templateContent);
        }
    }

    /**
     * Register a template variable from structural directives
     */
    public void registerTemplateVariable(String variableName, String directive, String sourceProperty) {
        if (errorManager != null) {
            errorManager.registerTemplateVariable(variableName, directive, sourceProperty);
        }
    }

    // ============================================
    // ANGULAR-AWARE ERROR REPORTING METHODS
    // ============================================

    /**
     * Report undefined variable - FIXED for Angular template variables
     */
    public void reportUndefinedVariable(String variableName, int line, int column) {
        if (lookupSymbol(variableName) == null) {
            errorManager.reportUndefinedVariable(variableName, line, column);
            enhanceVariableErrorContext(variableName);
        }
    }
    // Add these methods to your existing SymbolTable class:
    public void enterCSSRule(String selector) {
        String cleanSelector = selector.replace(".", "").replace("#", "").trim();
        this.currentCSSSelector = cleanSelector;
        cssRules.computeIfAbsent(cleanSelector, k -> new HashMap<>());
        addSymbol("CSS_SELECTOR", cleanSelector);
        System.out.println(">>> Entered CSS rule: " + cleanSelector);
    }
    public void storeCSSHierarchy(String fullSelector) {
        String[] parts = fullSelector.split(" ");
        if (parts.length > 1) {
            String mainSelector = parts[0];
            List<String> hierarchy = new ArrayList<>();
            for (int i = 1; i < parts.length; i++) {
                hierarchy.add(parts[i]);
            }
            cssHierarchy.put(mainSelector, hierarchy);
        }
    }
    public Map<String, List<String>> getCSSHierarchy() {
        return cssHierarchy;
    }



    private boolean isValidCSSPropertyValuePair(String property, String value) {
        if (property == null || value == null || value.trim().isEmpty()) {
            return false;
        }

        // Allow all reasonable CSS values - don't be overly restrictive
        boolean valid = !value.contains("undefined") &&
                !value.contains("null") &&
                value.length() > 0;

        System.out.println(">>> CSS Validation: " + property + ": " + value + " -> " + valid);
        return valid;
    }

    public void addTemplateInterpolation(String interpolation, String property) {
        templateInterpolations.put(interpolation, property);
        addSymbol("INTERPOLATION_ID", interpolation);
    }

    // Getters for new data:
    public Map<String, Map<String, String>> getCSSRules() { return cssRules; }
    public Map<String, String> getTemplateInterpolations() { return templateInterpolations; }
    /**
     * Report structural directive error - ENHANCED for Angular
     */
    public void reportUndefinedStructuralDirective(String variableName, String directive, int line, int column) {
        // Check if this is an *ngFor template variable
        if (directive.contains("*ngFor") && directive.contains("let " + variableName)) {
            // This is valid Angular syntax - register the template variable and don't report error
            if (errorManager != null) {
                errorManager.registerTemplateVariable(variableName, directive, "ngFor");
            }
            return;
        }

        // Check if this is an *ngIf with a component property
        if (directive.contains("*ngIf") && componentProperties.contains(variableName)) {
            // This is valid - referencing a component property in *ngIf
            return;
        }

        // Only report if truly invalid
        errorManager.reportUndefinedStructuralDirective(variableName, directive, line, column);
    }

    /**
     * Report property binding - ENHANCED for HTML attributes
     */
    public void reportPropertyBindingMismatch(String propertyName, String bindingType, String expectedType, int line, int column) {
        // Check if this is a standard HTML attribute
        Set<String> standardHtmlAttributes = Set.of(
                "src", "href", "alt", "title", "id", "class", "style",
                "width", "height", "disabled", "checked", "selected", "hidden",
                "value", "type", "name", "placeholder", "required", "readonly"
        );

        if (standardHtmlAttributes.contains(propertyName.toLowerCase())) {
            // This is a valid HTML attribute binding - don't report as error
            return;
        }

        // Only report for non-standard attributes that aren't component properties
        if (!componentProperties.contains(propertyName)) {
            errorManager.reportPropertyBindingMismatch(propertyName, bindingType, expectedType, line, column);
        }
    }

    /**
     * Report literal binding - ENHANCED for CSS classes
     */
    public void reportLiteralBindingForProperty(String attributeName, String attributeValue, int line, int column) {
        // Check if this is a static CSS class
        if ("class".equals(attributeName) && isValidCssClassName(attributeValue)) {
            // This is valid static CSS - don't report as error
            return;
        }

        // Check if this is a standard HTML attribute with literal value
        if (isStandardHtmlAttributeWithLiteralValue(attributeName, attributeValue)) {
            // This is valid HTML - don't report as error
            return;
        }

        // Only report if this looks like it should be property binding
        if (componentProperties.contains(attributeValue)) {
            errorManager.reportLiteralBindingForProperty(attributeName, attributeValue, line, column);
        }
    }

    // ============================================
    // REMAINING ERROR REPORTING METHODS
    // ============================================

    public void reportDuplicateClass(String className, int line, int column, int previousLine) {
        errorManager.reportDuplicateClass(className, line, column, previousLine);
    }

    public void reportDuplicateMethod(String methodName, List<String> parameterTypes, int line, int column, int previousLine) {
        errorManager.reportDuplicateMethod(methodName, parameterTypes, line, column, previousLine);
    }

    public void reportDuplicateInterface(String interfaceName, List<String> extendedInterfaces, int line, int column, int previousLine) {
        errorManager.reportDuplicateInterface(interfaceName, extendedInterfaces, line, column, previousLine);
    }

    public void reportReturnTypeMismatch(String methodName, String expectedType, String actualType, int line, int column) {
        errorManager.reportReturnTypeMismatch(methodName, expectedType, actualType, line, column);
    }

    public void reportMissingReturnStatement(String methodName, String expectedReturnType, int line, int column) {
        errorManager.reportMissingReturnStatement(methodName, expectedReturnType, line, column);
    }

    public void reportVoidMethodReturnValue(String methodName, String returnValue, int line, int column) {
        errorManager.reportVoidMethodReturnValue(methodName, returnValue, line, column);
    }

    // ============================================
    // COMPONENT PROPERTY MANAGEMENT
    // ============================================

    public void addComponentProperty(String propertyName, String type) {
        addSymbol("COMPONENT_PROPERTY", propertyName);
        componentProperties.add(propertyName);
        propertyTypes.put(propertyName, type);
        errorManager.addComponentProperty(propertyName, type);
    }

    // ============================================
    // ERROR REPORTING AND ANALYSIS
    // ============================================

    public void printErrorReport() {
        System.out.println("\n=== SEMANTIC ERROR REPORT ===");
        System.out.println(errorManager.getFormattedReport());
    }

    public List<SemanticErrorBase> getAllErrors() {
        return errorManager.getAllErrors();
    }

    public List<SemanticErrorBase> getErrorsByType(SemanticErrorType type) {
        return errorManager.getErrorsByType(type);
    }

    public int getErrorCount() {
        return errorManager.getErrorCount();
    }

    public boolean hasErrors() {
        return errorManager.getErrorCount() > 0;
    }

    public void clearErrors() {
        errorManager.clearErrors();
    }

    public String getComprehensiveReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== SYMBOL TABLE STATUS ===\n");
        report.append("Total symbols: ").append(getAllSymbols().size()).append("\n");
        report.append("Current scope: ").append(getCurrentScopeName()).append("\n");
        report.append("Component properties: ").append(componentProperties.size()).append("\n\n");

        report.append("=== ERROR SUMMARY ===\n");
        report.append("Total errors: ").append(errorManager.getErrorCount()).append("\n");

        for (SemanticErrorType type : SemanticErrorType.values()) {
            int count = errorManager.getErrorCountByType(type);
            if (count > 0) {
                report.append("- ").append(type.getDisplayName()).append(": ").append(count).append("\n");
            }
        }

        return report.toString();
    }

    // ============================================
    // HELPER METHODS
    // ============================================

    private void enhanceVariableErrorContext(String variableName) {
        List<SemanticErrorBase> varErrors = errorManager.getErrorsByType(SemanticErrorType.UNDEFINED_VARIABLE);
        for (SemanticErrorBase error : varErrors) {
            if (error.getContext().equals(variableName)) {
                for (Row row : getAllSymbols()) {
                    if ("VARIABLE".equals(row.getType()) ||
                            "PROPERTY".equals(row.getType()) ||
                            "COMPONENT_PROPERTY".equals(row.getType())) {
                        error.addRelevantSymbol(row.getValue(), row.getType(), row.getScopeName());
                    }
                }
                break;
            }
        }
    }

    private boolean isValidCssClassName(String className) {
        // Check if it's a valid CSS class name (starts with letter, contains letters/numbers/hyphens)
        return className != null &&
                className.matches("^[a-zA-Z][a-zA-Z0-9_-]*$") &&
                !componentProperties.contains(className);
    }

    private boolean isStandardHtmlAttributeWithLiteralValue(String attributeName, String attributeValue) {
        // Common HTML attributes that commonly have literal values
        Set<String> literalAttributes = Set.of("id", "type", "name", "role", "aria-label");
        return literalAttributes.contains(attributeName.toLowerCase());
    }

    // ============================================
    // FORMATTING METHODS (unchanged from original)
    // ============================================

    private static String formatIdentifier(String value) {
        if (value == null) return "N/A";
        if ((value.startsWith("'") && value.endsWith("'")) ||
                (value.startsWith("\"") && value.endsWith("\""))) {
            return value.substring(1, value.length() - 1);
        }
        if (value.length() > 18) {
            return value.substring(0, 15) + "...";
        }
        return value;
    }

    private static String formatKind(String type) {
        if (type == null) return "Unknown";
        switch (type.toUpperCase()) {
            case "IMPORT_ID": return "Import";
            case "IMPORT_PATH": return "Import Path";
            case "VARIABLE": return "Variable";
            case "FUNCTION":
            case "METHOD": return "Function";
            case "CLASS": return "Class";
            case "INTERFACE": return "Interface";
            case "COMPONENT": return "Component";
            case "PROPERTY": return "Property";
            case "PARAMETER": return "Parameter";
            case "CSS_PROPERTY": return "CSS Property";
            case "CSS_VALUE": return "CSS Value";
            case "CSS_SELECTOR": return "CSS Selector";
            case "CSS_RULE": return "CSS Rule";
            case "HTML_ELEMENT": return "HTML Element";
            case "HTML_STRING_ATTRIBUTE":
            case "HTML_NAME_ATTRIBUTE": return "HTML Attribute";
            case "HTML_CLOSING_TAG": return "HTML Tag";
            case "RESOURCE_BINDING": return "Resource Binding";
            case "EVENT_BINDING": return "Event Binding";
            case "INTERPOLATION_ID": return "Interpolation";
            case "ANGULAR_STRUCTURAL_DIRECTIVE": return "Angular Directive";
            case "DECORATOR": return "Decorator";
            case "SELECTOR_STRING": return "Selector";
            case "STRING_LITERAL": return "String Literal";
            case "NUMBER_LITERAL": return "Number Literal";
            case "BOOLEAN_LITERAL": return "Boolean Literal";
            case "ARITHMETIC_OPERATOR": return "Operator";
            case "PROPERTY_REFERENCE": return "Property Ref";
            case "MEMBER_REFERENCE": return "Member Ref";
            case "MEMBER_ACCESS": return "Member Access";
            case "LIST_TYPE": return "Array Type";
            case "TYPE": return "Type";
            case "ID_REFERENCE": return "Reference";
            case "UNDEFINED_VARIABLE": return "Variable";
            case "CSS_LENGTH": return "CSS Length";
            case "CSS_COLOR": return "CSS Color";
            case "CSS_PERCENTAGE": return "CSS Percentage";
            case "CSS_NUMBER": return "CSS Number";
            case "CSS_BORDER_STYLE": return "CSS Border Style";
            case "COMPONENT_PROPERTY": return "Component Prop";
            case "TEMPLATE_VARIABLE": return "Template Var";
            default: return type;
        }
    }

    private String formatDataType(String type) {
        if (type == null) return "N/A";
        switch (type.toUpperCase()) {
            case "IMPORT_ID": return "module";
            case "IMPORT_PATH": return "string";
            case "VARIABLE":
            case "UNDEFINED_VARIABLE": return "any";
            case "ID_REFERENCE": return "reference";
            case "PROPERTY_REFERENCE": return "property";
            case "MEMBER_REFERENCE": return "member";
            case "MEMBER_ACCESS": return "member";
            case "FUNCTION":
            case "METHOD": return "function";
            case "PARAMETER": return "parameter";
            case "CLASS": return "class";
            case "INTERFACE": return "interface";
            case "COMPONENT": return "component";
            case "PROPERTY":
            case "COMPONENT_PROPERTY": return "property";
            case "TEMPLATE_VARIABLE": return "template-var";
            case "STRING_LITERAL": return "string";
            case "NUMBER_LITERAL": return "number";
            case "BOOLEAN_LITERAL": return "boolean";
            case "NUMBER_TYPE": return "number";
            case "BOOLEAN_TYPE": return "boolean";
            case "STRING_TYPE": return "string";
            case "LIST_TYPE": return "array";
            case "TYPE": return "type";
            case "CSS_PROPERTY": return "css-property";
            case "CSS_VALUE": return "css-value";
            case "HTML_ELEMENT": return "html-element";
            case "HTML_STRING_ATTRIBUTE": return "html-attribute";
            case "ANGULAR_STRUCTURAL_DIRECTIVE": return "directive";
            case "ARITHMETIC_OPERATOR": return "operator";
            default: return "any";
        }
    }

    public void debugCSSParsing() {
        System.out.println("\n=== CSS PARSING DEBUG ===");
        System.out.println("CSS Rules stored: " + cssRules.size());

        for (Map.Entry<String, Map<String, String>> rule : cssRules.entrySet()) {
            System.out.println("\nCSS Selector: ." + rule.getKey());
            Map<String, String> properties = rule.getValue();

            if (properties.isEmpty()) {
                System.out.println("  ❌ NO PROPERTIES STORED!");
            } else {
                for (Map.Entry<String, String> prop : properties.entrySet()) {
                    System.out.println("  ✓ " + prop.getKey() + ": " + prop.getValue());
                }
            }
        }

        System.out.println("\n=== SYMBOL TABLE CSS ENTRIES ===");
        List<Row> cssSymbols = getAllSymbols().stream()
                .filter(row -> row.getType().startsWith("CSS_"))
                .collect(java.util.stream.Collectors.toList());

        for (Row symbol : cssSymbols) {
            System.out.println(symbol.getType() + ": " + symbol.getValue());
        }

        System.out.println("========================\n");
    }

    public void validateStoredCSSData() {
        System.out.println("\n=== CSS DATA VALIDATION ===");

        boolean hasErrors = false;

        for (Map.Entry<String, Map<String, String>> rule : cssRules.entrySet()) {
            String selector = rule.getKey();
            Map<String, String> properties = rule.getValue();

            for (Map.Entry<String, String> prop : properties.entrySet()) {
                String property = prop.getKey();
                String value = prop.getValue();

                // Check for common parsing errors
                if (value.length() < 2) {
                    System.out.println("❌ SUSPICIOUS: " + selector + " { " + property + ": " + value + " } - Value too short");
                    hasErrors = true;
                }

                if (value.matches("^[0-9]+$") && !property.matches("(z-index|opacity|order|flex-grow|flex-shrink)")) {
                    System.out.println("❌ SUSPICIOUS: " + selector + " { " + property + ": " + value + " } - Missing units");
                    hasErrors = true;
                }

                if (property.matches("(width|height)") && value.matches("^[0-9]+(px)$") && Integer.parseInt(value.replaceAll("[^0-9]", "")) < 20) {
                    System.out.println("❌ SUSPICIOUS: " + selector + " { " + property + ": " + value + " } - Unrealistically small");
                    hasErrors = true;
                }
            }
        }

        if (!hasErrors) {
            System.out.println("✓ CSS data validation passed");
        }

        System.out.println("========================\n");
    }
    private static String formatScope(String scopeName) {
        if (scopeName == null) return "Unknown";
        switch (scopeName.toUpperCase()) {
            case "GLOBAL": return "Global";
            case "CLASS": return "Class";
            case "INTERFACE": return "Interface";
            case "METHOD": return "Method";
            case "COMPONENT": return "Component";
            case "TEMPLATE": return "Template";
            case "CSS_ELEMENT": return "CSS";
            default:
                String formatted = scopeName.toLowerCase().replace("_", " ");
                return formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
        }
    }

    // ============================================
    // INNER CLASSES (unchanged from original)
    // ============================================

    public static class SymbolTableSnapshot {
        private final Set<String> relevantTokens;
        private final List<Row> relevantSymbols;
        private final List<ScopeInfo> currentScopeStack;

        public SymbolTableSnapshot(Set<String> relevantTokens, List<Row> relevantSymbols, List<ScopeInfo> currentScopeStack) {
            this.relevantTokens = relevantTokens;
            this.relevantSymbols = relevantSymbols;
            this.currentScopeStack = currentScopeStack;
        }

        public void print() {
            if (relevantSymbols.isEmpty()) {
                System.out.println("  No relevant symbols found");
                return;
            }

            System.out.println("  | Identifier         | Kind             | Scope                |");
            System.out.println("  | ------------------ | ---------------- | -------------------- |");

            for (Row row : relevantSymbols) {
                String identifier = formatIdentifier(row.getValue());
                String kind = formatKind(row.getType());
                String scope = formatScope(row.getScopeName());
                System.out.printf("  | %-18s | %-16s | %-20s |%n", identifier, kind, scope);
            }

            System.out.println("  Current scope stack:");
            for (ScopeInfo scope : currentScopeStack) {
                System.out.println("    - " + scope.getScopeName() +
                        " [" + scope.getScopeType() + "] (ID: " + scope.getScopeId() + ")");
            }
        }
    }
}

// Supporting classes remain the same...
class ScopeInfo {
    private int scopeId;
    private String scopeName;
    private String scopeType;
    private int parentScopeId;
    private int symbolCount;

    public ScopeInfo(int scopeId, String scopeName, String scopeType, int parentScopeId, int symbolCount) {
        this.scopeId = scopeId;
        this.scopeName = scopeName;
        this.scopeType = scopeType;
        this.parentScopeId = parentScopeId;
        this.symbolCount = symbolCount;
    }

    public int getScopeId() { return scopeId; }
    public String getScopeName() { return scopeName; }
    public String getScopeType() { return scopeType; }
    public int getParentScopeId() { return parentScopeId; }
}

class Scope {
    private int scopeId;
    private String scopeName;
    private String scopeType;
    private int parentScopeId;
    private Map<String, Row> symbols;

    public Scope(int scopeId, String scopeName, String scopeType, int parentScopeId) {
        this.scopeId = scopeId;
        this.scopeName = scopeName;
        this.scopeType = scopeType;
        this.parentScopeId = parentScopeId;
        this.symbols = new HashMap<>();
    }

    public void setScopeName(String scopeName) { this.scopeName = scopeName; }
    public void addSymbol(Row symbol) { symbols.put(symbol.getValue(), symbol); }
    public Row findSymbol(String value) { return symbols.get(value); }
    public List<Row> getSymbols() { return new ArrayList<>(symbols.values()); }
    public int getSymbolCount() { return symbols.size(); }
    public int getScopeId() { return scopeId; }
    public String getScopeName() { return scopeName; }
    public String getScopeType() { return scopeType; }
    public int getParentScopeId() { return parentScopeId; }
}