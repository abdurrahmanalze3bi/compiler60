package classes;

import java.util.*;

public class ReturnPathSymbolTable implements ErrorSymbolTable {
    private TreeMap<String, CodePath> codePaths;
    private List<String> missingReturnPaths;
    private Map<String, String> defaultReturnValues;

    public ReturnPathSymbolTable() {
        this.codePaths = new TreeMap<>();
        this.missingReturnPaths = new ArrayList<>();
        this.defaultReturnValues = new HashMap<>();
        initializeDefaults();
    }

    @Override
    public void addSymbol(String symbol, String type, String scope, int line, int column) {
                CodePath path = new CodePath(symbol, type.equals("HAS_RETURN"), scope, line, column);
        codePaths.put(symbol, path);

        if (!path.hasReturn) {
            missingReturnPaths.add(symbol);
        }
    }

    public boolean allPathsReturn() {
        if (codePaths.isEmpty()) return false;

        for (CodePath path : codePaths.values()) {
            if (!path.hasReturn) {
                return false;
            }
        }
        return true;
    }

    public List<String> getMissingReturnPaths() {
        return new ArrayList<>(missingReturnPaths);
    }

    public String suggestDefaultReturnValue(String returnType) {
        return defaultReturnValues.get(returnType.toLowerCase());
    }

    public void addCodePath(String pathName, boolean hasReturn, int line, int column) {
        CodePath path = new CodePath(pathName, hasReturn, "METHOD", line, column);
        codePaths.put(pathName, path);
        if (!hasReturn) {
            missingReturnPaths.add(pathName);
        }
    }

    private void initializeDefaults() {
        defaultReturnValues.put("string", "\"\"");
        defaultReturnValues.put("number", "0");
        defaultReturnValues.put("boolean", "false");
        defaultReturnValues.put("object", "null");
        defaultReturnValues.put("array", "[]");
        defaultReturnValues.put("any", "null");
    }

    @Override
    public boolean hasRelevantSymbols() {
        return !codePaths.isEmpty();
    }

    @Override
    public String getFormattedSymbols() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Code Path Analysis:\n");
        for (Map.Entry<String, CodePath> entry : codePaths.entrySet()) {
            CodePath path = entry.getValue();
            sb.append(String.format("    - Path '%s': %s (Line %d)\n",
                    entry.getKey(), path.hasReturn ? "HAS RETURN" : "MISSING RETURN", path.line));
        }
        return sb.toString();
    }

    @Override
    public void clear() {
        codePaths.clear();
        missingReturnPaths.clear();
    }

    @Override
    public int getSymbolCount() {
        return codePaths.size();
    }

    static class CodePath {
        String pathName;
        boolean hasReturn;
        String scope;
        int line;
        int column;

        CodePath(String pathName, boolean hasReturn, String scope, int line, int column) {
            this.pathName = pathName;
            this.hasReturn = hasReturn;
            this.scope = scope;
            this.line = line;
            this.column = column;
        }
    }
}