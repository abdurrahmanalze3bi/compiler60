package classes;

import java.util.*;

/**
 * Variable Symbol Table using MAP
 * Optimized for fast variable lookups and scope resolution
 */
public class VariableSymbolTable implements ErrorSymbolTable {
    // MAP: Variable name -> VariableInfo for O(1) lookups
    private Map<String, VariableInfo> variableMap;
    // MAP: Scope -> Set of variables for scope-based queries
    private Map<String, Set<String>> scopeToVariables;
    // MAP: For typo detection - similar names
    private Map<String, List<String>> similarNameCache;

    public VariableSymbolTable() {
        this.variableMap = new HashMap<>();
        this.scopeToVariables = new HashMap<>();
        this.similarNameCache = new HashMap<>();
    }

    @Override
    public void addSymbol(String symbol, String type, String scope, int line, int column) {
        VariableInfo info = new VariableInfo(symbol, type, scope, line, column);
        variableMap.put(symbol, info);

        // Add to scope mapping
        scopeToVariables.computeIfAbsent(scope, k -> new HashSet<>()).add(symbol);
    }

    /**
     * Find variables with similar names (typo detection)
     */
    public List<String> findSimilarVariables(String variableName) {
        if (similarNameCache.containsKey(variableName)) {
            return similarNameCache.get(variableName);
        }

        List<String> similar = new ArrayList<>();
        for (String existing : variableMap.keySet()) {
            if (isSimilar(variableName, existing)) {
                similar.add(existing);
            }
        }
        similarNameCache.put(variableName, similar);
        return similar;
    }

    /**
     * Check for common programming typos
     */
    public String checkCommonTypos(String variableName) {
        Map<String, String> commonTypos = Map.of(
                "lenght", "length",
                "widht", "width",
                "heigth", "height",
                "colur", "color",
                "positon", "position"
        );
        return commonTypos.get(variableName.toLowerCase());
    }

    /**
     * Check if variable is defined in accessible scope
     */
    public boolean isVariableDefined(String variableName, String currentScope) {
        // Check current scope first
        Set<String> currentScopeVars = scopeToVariables.get(currentScope);
        if (currentScopeVars != null && currentScopeVars.contains(variableName)) {
            return true;
        }

        // Check parent scopes (simplified - you'd implement proper scope hierarchy)
        return variableMap.containsKey(variableName);
    }

    private boolean isSimilar(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int differences = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                differences++;
                if (differences > 1) return false;
            }
        }
        return differences == 1;
    }

    @Override
    public boolean hasRelevantSymbols() {
        return !variableMap.isEmpty();
    }

    @Override
    public String getFormattedSymbols() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Variable Context:\n");
        for (Map.Entry<String, VariableInfo> entry : variableMap.entrySet()) {
            VariableInfo info = entry.getValue();
            sb.append(String.format("    - %s [%s] in scope '%s' (Line %d)\n",
                    info.name, info.type, info.scope, info.line));
        }
        return sb.toString();
    }

    @Override
    public void clear() {
        variableMap.clear();
        scopeToVariables.clear();
        similarNameCache.clear();
    }

    @Override
    public int getSymbolCount() {
        return variableMap.size();
    }

    /**
     * Information about a variable
     */
    static class VariableInfo {
        String name;
        String type;
        String scope;
        int line;
        int column;

        VariableInfo(String name, String type, String scope, int line, int column) {
            this.name = name;
            this.type = type;
            this.scope = scope;
            this.line = line;
            this.column = column;
        }
    }
}