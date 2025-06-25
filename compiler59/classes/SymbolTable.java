package classes;

import java.util.*;

public class SymbolTable {
    private Stack<Scope> scopeStack;
    private List<Scope> allScopes;
    private int currentScopeId;
    private List<SemanticError> errors = new ArrayList<>();

    public SymbolTable() {
        this.scopeStack = new Stack<>();
        this.allScopes = new ArrayList<>();
        this.currentScopeId = 0;
        // Create global scope
        enterScope("GLOBAL");
    }

    // Enhanced scope management with proper scope types
    public void enterScope(String scopeName) {
        enterScope(scopeName, scopeName); // Default: scope name is also the type
    }
    public void enterScope(String scopeName, String scopeType) {
        // Normalize scope names to avoid inconsistencies
        String normalizedName = normalizeScopeName(scopeName, scopeType);

        Scope newScope = new Scope(currentScopeId++, normalizedName, scopeType, getCurrentScopeId());
        scopeStack.push(newScope);
        allScopes.add(newScope);
    }private String normalizeScopeName(String scopeName, String scopeType) {
        switch (scopeType.toUpperCase()) {
            case "CLASS":
                return "CLASS"; // Don't use specific class names in scope names
            case "METHOD":
                return "METHOD"; // Don't use specific method names in scope names
            case "INTERFACE":
                return "INTERFACE";
            case "TEMPLATE":
                return "TEMPLATE";
            case "CSS":
                return "CSS";
            case "GLOBAL":
                return "GLOBAL";
            default:
                return scopeName;
        }
    }

    public void exitScope() {
        if (!scopeStack.isEmpty() && scopeStack.size() > 1) { // Keep global scope
            Scope exitedScope = scopeStack.pop();
        }
    }


    // Enhanced symbol addition with better scope context
    public void addSymbol(String type, String value) {
        addSymbol(type, value, getCurrentScopeName());
    }

    public void addSymbol(String type, String value, String contextScope) {
        if (!scopeStack.isEmpty()) {
            Scope currentScope = scopeStack.peek();

            // Use the actual scope type, not a concatenated name
            String actualScopeName = currentScope.getScopeType();

            Row row = new Row(type, value, currentScope.getScopeId(), actualScopeName);
            currentScope.addSymbol(row);
        }
    }

    // Snapshot creation with better token expansion
    public SymbolTableSnapshot createSnapshot(Set<String> relevantTokens) {
        List<ScopeInfo> currentScopeStackInfo = getCurrentScopeStack();
        List<Row> relevantSymbols = new ArrayList<>();

        // Better token expansion logic
        Set<String> expandedTokens = new HashSet<>(relevantTokens);
        for (String token : relevantTokens) {
            // Remove quotes and special characters for matching
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


    private int getCurrentScopeId() {
        return scopeStack.isEmpty() ? -1 : scopeStack.peek().getScopeId();
    }

    public String getCurrentScopeType() {
        return scopeStack.isEmpty() ? null : scopeStack.peek().getScopeType();
    }

    public void setCurrentScopeName(String name) {
        if (!scopeStack.isEmpty()) {
            Scope currentScope = scopeStack.peek();
            currentScope.setScopeName(name);
        }
    }

    public Row lookupSymbol(String value) {
        // Search from current scope up to global scope
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



    public int getCurrentScopeIdPublic() {
        return getCurrentScopeId();
    }

    // Enhanced print method with better scope categorization
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

    // Enhanced error printing


    // Enhanced formatting methods
    private static String formatIdentifier(String value) {
        if (value == null) return "N/A";

        // Remove surrounding quotes
        if ((value.startsWith("'") && value.endsWith("'")) ||
                (value.startsWith("\"") && value.endsWith("\""))) {
            return value.substring(1, value.length() - 1);
        }

        // Truncate very long identifiers for display
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
            case "FUNCTION": case "METHOD": return "Function";
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
            case "HTML_STRING_ATTRIBUTE": case "HTML_NAME_ATTRIBUTE": return "HTML Attribute";
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
            default: return type;
        }
    }

    private String formatDataType(String type) {
        if (type == null) return "N/A";

        switch (type.toUpperCase()) {
            // Import types
            case "IMPORT_ID": return "module";
            case "IMPORT_PATH": return "string";

            // Variable and reference types
            case "VARIABLE": case "UNDEFINED_VARIABLE": return "any";
            case "ID_REFERENCE": return "reference";
            case "PROPERTY_REFERENCE": return "property";
            case "MEMBER_REFERENCE": return "member";
            case "MEMBER_ACCESS": return "member";

            // Function and method types
            case "FUNCTION": case "METHOD": return "function";
            case "PARAMETER": return "parameter";

            // Class and interface types
            case "CLASS": return "class";
            case "INTERFACE": return "interface";
            case "COMPONENT": return "component";
            case "PROPERTY": return "property";

            // Literal types
            case "STRING_LITERAL": return "string";
            case "NUMBER_LITERAL": return "number";
            case "BOOLEAN_LITERAL": return "boolean";

            // Explicit type declarations
            case "NUMBER_TYPE": return "number";
            case "BOOLEAN_TYPE": return "boolean";
            case "STRING_TYPE": return "string";
            case "LIST_TYPE": return "array";
            case "TYPE": return "type";

            // CSS types
            case "CSS_PROPERTY": return "css-property";
            case "CSS_VALUE": return "css-value";
            case "CSS_SELECTOR": return "css-selector";
            case "CSS_RULE": return "css-rule";
            case "CSS_LENGTH": return "length";
            case "CSS_COLOR": return "color";
            case "CSS_PERCENTAGE": return "percentage";
            case "CSS_NUMBER": return "css-number";
            case "CSS_BORDER_STYLE": return "border-style";

            // HTML types
            case "HTML_ELEMENT": return "html-element";
            case "HTML_STRING_ATTRIBUTE": return "html-attribute";
            case "HTML_NAME_ATTRIBUTE": return "html-attribute";
            case "HTML_CLOSING_TAG": return "html-tag";

            // Angular specific types
            case "RESOURCE_BINDING": return "binding";
            case "EVENT_BINDING": return "event-binding";
            case "INTERPOLATION_ID": return "interpolation";
            case "ANGULAR_STRUCTURAL_DIRECTIVE": return "directive";
            case "DECORATOR": return "decorator";
            case "SELECTOR_STRING": return "selector";

            // Operator types
            case "ARITHMETIC_OPERATOR": return "operator";

            // Default case
            default: return "any";
        }
    }

    private static String formatScope(String scopeName) {
        if (scopeName == null) return "Unknown";

        // Better scope name formatting
        switch (scopeName.toUpperCase()) {
            case "GLOBAL": return "Global";
            case "CLASS": return "Class";
            case "INTERFACE": return "Interface";
            case "METHOD": return "Method";
            case "COMPONENT": return "Component";
            case "TEMPLATE": return "Template";
            case "CSS_ELEMENT": return "CSS";

            default:
                // Capitalize first letter and handle underscores
                String formatted = scopeName.toLowerCase().replace("_", " ");
                return formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
        }
    }

    // Snapshot class
    public static class SymbolTableSnapshot {
        private final Set<String> relevantTokens;
        private final List<Row> relevantSymbols;
        private final List<ScopeInfo> currentScopeStack;

        public SymbolTableSnapshot(Set<String> relevantTokens, List<Row> relevantSymbols,
                                   List<ScopeInfo> currentScopeStack) {
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

// Enhanced ScopeInfo class
class ScopeInfo {
    private int scopeId;
    private String scopeName;
    private String scopeType;
    private int parentScopeId;
    private int symbolCount;

    public ScopeInfo(int scopeId, String scopeName, String scopeType,
                     int parentScopeId, int symbolCount) {
        this.scopeId = scopeId;
        this.scopeName = scopeName;
        this.scopeType = scopeType;
        this.parentScopeId = parentScopeId;
        this.symbolCount = symbolCount;
    }

    // Getters
    public int getScopeId() { return scopeId; }
    public String getScopeName() { return scopeName; }
    public String getScopeType() { return scopeType; }
    public int getParentScopeId() { return parentScopeId; }
    public int getSymbolCount() { return symbolCount; }
}

// Enhanced Scope class
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

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    public void setScopeType(String scopeType) {
        this.scopeType = scopeType;
    }

    public void addSymbol(Row symbol) {
        symbols.put(symbol.getValue(), symbol);
    }

    public Row findSymbol(String value) {
        return symbols.get(value);
    }

    public List<Row> getSymbols() {
        return new ArrayList<>(symbols.values());
    }

    public int getSymbolCount() {
        return symbols.size();
    }

    // Getters
    public int getScopeId() { return scopeId; }
    public String getScopeName() { return scopeName; }
    public String getScopeType() { return scopeType; }
    public int getParentScopeId() { return parentScopeId; }
}