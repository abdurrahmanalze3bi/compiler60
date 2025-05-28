package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
    private Stack<Scope> scopeStack;
    private List<Scope> allScopes; // Keep track of all scopes created
    private int currentScopeId;

    public SymbolTable() {
        this.scopeStack = new Stack<>();
        this.allScopes = new ArrayList<>();
        this.currentScopeId = 0;
        // Create global scope
        enterScope("GLOBAL");
    }

    // Enter a new scope
    public void enterScope(String scopeName) {
        Scope newScope = new Scope(currentScopeId++, scopeName, getCurrentScopeId());
        scopeStack.push(newScope);
        allScopes.add(newScope); // Keep track of all scopes
        // System.out.println("Entered scope: " + scopeName + " (ID: " + newScope.getScopeId() + ")");
    }

    // Exit current scope
    public void exitScope() {
        if (!scopeStack.isEmpty() && scopeStack.size() > 1) { // Keep global scope
            Scope exitedScope = scopeStack.pop();
            // System.out.println("Exited scope: " + exitedScope.getScopeName() + " (ID: " + exitedScope.getScopeId() + ")");
        }
    }

    // Get current scope ID
    private int getCurrentScopeId() {
        return scopeStack.isEmpty() ? -1 : scopeStack.peek().getScopeId();
    }

    // Add symbol to current scope
    public void addSymbol(String type, String value) {
        if (!scopeStack.isEmpty()) {
            Scope currentScope = scopeStack.peek();
            Row row = new Row(type, value, currentScope.getScopeId(), currentScope.getScopeName());
            currentScope.addSymbol(row);
        }
    }

    // Look up symbol in current scope and parent scopes
    public Row lookupSymbol(String value) {
        // Search from current scope up to global scope
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            Scope scope = scopeStack.get(i);
            Row symbol = scope.findSymbol(value);
            if (symbol != null) {
                return symbol;
            }
        }
        return null; // Symbol not found
    }

    // Check if symbol exists in current scope only
    public boolean existsInCurrentScope(String value) {
        if (!scopeStack.isEmpty()) {
            return scopeStack.peek().findSymbol(value) != null;
        }
        return false;
    }

    // Get current scope name
    public String getCurrentScopeName() {
        return scopeStack.isEmpty() ? "NONE" : scopeStack.peek().getScopeName();
    }

    // NEW: Get all symbols from all scopes (needed for snapshots)
    public List<Row> getAllSymbols() {
        List<Row> allSymbols = new ArrayList<>();
        for (Scope scope : allScopes) {
            allSymbols.addAll(scope.getSymbols());
        }
        return allSymbols;
    }

    // NEW: Get all active scopes in the current scope stack (needed for snapshots)
    public List<ScopeInfo> getCurrentScopeStack() {
        List<ScopeInfo> scopeInfoList = new ArrayList<>();
        for (Scope scope : scopeStack) {
            scopeInfoList.add(new ScopeInfo(
                    scope.getScopeId(),
                    scope.getScopeName(),
                    scope.getParentScopeId(),
                    scope.getSymbolCount()
            ));
        }
        return scopeInfoList;
    }

    // NEW: Get all scopes ever created (needed for comprehensive snapshots)
    public List<ScopeInfo> getAllScopes() {
        List<ScopeInfo> scopeInfoList = new ArrayList<>();
        for (Scope scope : allScopes) {
            scopeInfoList.add(new ScopeInfo(
                    scope.getScopeId(),
                    scope.getScopeName(),
                    scope.getParentScopeId(),
                    scope.getSymbolCount()
            ));
        }
        return scopeInfoList;
    }

    // NEW: Get current scope ID (public version)
    public int getCurrentScopeIdPublic() {
        return getCurrentScopeId();
    }

    // Print all symbols with improved table formatting - now includes ALL scopes
    public void print() {
        System.out.println("\n=== SYMBOL TABLE ===");

        // Collect all symbols from ALL scopes (not just current stack)
        List<Row> allSymbols = getAllSymbols();

        if (allSymbols.isEmpty()) {
            System.out.println("No symbols found.");
            return;
        }

        // Print table header with proper formatting
        System.out.println("| Identifier         | Kind             | Data Type        | Scope                |");
        System.out.println("| ------------------ | ---------------- | ---------------- | -------------------- |");

        // Print each symbol as a table row
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

    // Helper method to format identifier (remove quotes if present)
    private String formatIdentifier(String value) {
        if (value == null) return "N/A";
        // Remove surrounding quotes if present
        if (value.startsWith("'") && value.endsWith("'")) {
            return value.substring(1, value.length() - 1);
        }
        if (value.startsWith("\"") && value.endsWith("\"")) {
            return value.substring(1, value.length() - 1);
        }
        return value;
    }

    // Helper method to format kind based on type
    private String formatKind(String type) {
        if (type == null) return "Unknown";

        switch (type.toUpperCase()) {
            // Existing cases
            case "IMPORT_ID":
                return "Import";
            case "IMPORT_PATH":
                return "Import Path";
            case "VARIABLE":
                return "Variable";
            case "FUNCTION":
            case "METHOD":
                return "Function";
            case "CLASS":
                return "Class";
            case "INTERFACE":
                return "Interface";
            case "COMPONENT":
                return "Component";
            case "PROPERTY":
                return "Property";
            case "PARAMETER":
                return "Parameter";

            // CSS-related kinds
            case "CSS_PROPERTY":
                return "CSS Property";
            case "CSS_VALUE":
                return "CSS Value";
            case "CSS_SELECTOR":
                return "CSS Selector";
            case "CSS_RULE":
                return "CSS Rule";

            // HTML-related kinds
            case "HTML_ELEMENT":
                return "HTML Element";
            case "HTML_STRING_ATTRIBUTE":
                return "HTML Attribute";
            case "HTML_NAME_ATTRIBUTE":
                return "HTML Attribute";
            case "HTML_CLOSING_TAG":
                return "HTML Tag";
            case "RESOURCE_BINDING":
                return "Resource Binding";
            case "EVENT_BINDING":
                return "Event Binding";
            case "INTERPOLATION_ID":
                return "Interpolation";

            // Angular-specific kinds
            case "ANGULAR_STRUCTURAL_DIRECTIVE":
                return "Angular Directive";
            case "DECORATOR":
                return "Decorator";
            case "SELECTOR_STRING":
                return "Selector";

            // Literal kinds
            case "STRING_LITERAL":
                return "String Literal";
            case "NUMBER_LITERAL":
                return "Number Literal";
            case "BOOLEAN_LITERAL":
                return "Boolean Literal";
            case "ARITHMETIC_OPERATOR":
                return "Operator";
            case "PROPERTY_REFERENCE":
                return "Property Ref";
            case "MEMBER_REFERENCE":
                return "Member Ref";
            case "MEMBER_ACCESS":
                return "Member Access";
            // Other kinds
            case "LIST_TYPE":
                return "Array Type";
            case "TYPE":
                return "Type";
            case "ID_REFERENCE":
                return "Reference";
            case "UNDEFINED_VARIABLE": return "Variable";
            default:
                return type;
        }
    }

    // Helper method to format data type
    private String formatDataType(String type) {
        if (type == null) return "N/A";

        switch (type.toUpperCase()) {
            // Existing cases
            case "IMPORT_ID":
                return "module";
            case "IMPORT_PATH":
                return "string";
            case "VARIABLE":
                return "any";
            case "FUNCTION":
            case "METHOD":
                return "function";
            case "CLASS":
                return "class";
            case "INTERFACE":
                return "interface";
            case "COMPONENT":
                return "component";
            case "PROPERTY":
                return "property";
            case "PARAMETER":
                return "parameter";
            case "NUMBER_TYPE":
                return "number";
            case "BOOLEAN_TYPE":
                return "boolean";
            case "ARITHMETIC_OPERATOR":
                return "operator";
            case "PROPERTY_REFERENCE":
                return "property-ref";
            case "MEMBER_REFERENCE":
                return "member-ref";
            case "MEMBER_ACCESS":
                return "member-access";
            // CSS-related data types
            case "CSS_PROPERTY":
                return "css-property";
            case "CSS_VALUE":
                return "css-value";
            case "CSS_SELECTOR":
                return "css-selector";
            case "CSS_RULE":
                return "css-rule";
            case "UNDEFINED_VARIABLE": return "any";
            // HTML-related data types
            case "HTML_ELEMENT":
                return "html-element";
            case "HTML_STRING_ATTRIBUTE":
                return "html-attribute";
            case "HTML_NAME_ATTRIBUTE":
                return "html-attribute";
            case "HTML_CLOSING_TAG":
                return "html-tag";
            case "RESOURCE_BINDING":
                return "binding";
            case "EVENT_BINDING":
                return "event-binding";
            case "INTERPOLATION_ID":
                return "interpolation";

            // Angular-specific data types
            case "ANGULAR_STRUCTURAL_DIRECTIVE":
                return "directive";
            case "DECORATOR":
                return "decorator";
            case "SELECTOR_STRING":
                return "selector";

            // Literal data types
            case "STRING_LITERAL":
                return "string";
            case "NUMBER_LITERAL":
                return "number";
            case "BOOLEAN_LITERAL":
                return "boolean";

            // Other types
            case "LIST_TYPE":
                return "array";
            case "TYPE":
                return "type";
            case "ID_REFERENCE":
                return "reference";

            default:
                return "unknown";
        }
    }

    // Helper method to format scope name
    private String formatScope(String scopeName) {
        if (scopeName == null) return "Unknown";

        switch (scopeName.toUpperCase()) {
            case "GLOBAL":
                return "Global";
            case "CLASS":
                return "Class";
            case "INTERFACE":
                return "Interface";
            case "METHOD":
                return "Method";
            case "COMPONENT":
                return "Component";
            default:
                return scopeName.toLowerCase();
        }
    }

    // Print scope hierarchy - now shows ALL scopes created
    public void printScopeHierarchy() {
        System.out.println("\n=== SCOPE HIERARCHY ===");
        System.out.println("Current scope stack:");
        for (int i = 0; i < scopeStack.size(); i++) {
            Scope scope = scopeStack.get(i);
            String indent = "  ".repeat(i);
            System.out.println(indent + "Scope: " + scope.getScopeName() +
                    " (ID: " + scope.getScopeId() +
                    ", Symbols: " + scope.getSymbolCount() + ")");
        }

        System.out.println("\nAll scopes created:");
        for (Scope scope : allScopes) {
            System.out.println("  Scope: " + scope.getScopeName() +
                    " (ID: " + scope.getScopeId() +
                    ", Symbols: " + scope.getSymbolCount() + ")");
        }
        System.out.println("=======================\n");
    }
}

// NEW: ScopeInfo class for transferring scope information
class ScopeInfo {
    private int scopeId;
    private String scopeName;
    private int parentScopeId;
    private int symbolCount;

    public ScopeInfo(int scopeId, String scopeName, int parentScopeId, int symbolCount) {
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

// Scope class remains the same
class Scope {
    private int scopeId;
    private String scopeName;
    private int parentScopeId;
    private Map<String, Row> symbols; // Use Map for efficient lookup

    public Scope(int scopeId, String scopeName, int parentScopeId) {
        this.scopeId = scopeId;
        this.scopeName = scopeName;
        this.parentScopeId = parentScopeId;
        this.symbols = new HashMap<>();
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
    public int getParentScopeId() { return parentScopeId; }
}