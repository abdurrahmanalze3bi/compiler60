package classes;

import java.util.*;

public class VoidMethodSymbolTable implements ErrorSymbolTable {

    private List<ReturnStatementInfo> returnStatements;

    private List<String> nonVoidPatterns;

    public VoidMethodSymbolTable() {
        this.returnStatements = new ArrayList<>();
        this.nonVoidPatterns = Arrays.asList(
                "return true", "return false", "return 0", "return 1",
                "return null", "return this", "return new"
        );
    }

    @Override
    public void addSymbol(String symbol, String type, String scope, int line, int column) {

        ReturnStatementInfo info = new ReturnStatementInfo(symbol, type, scope, line, column);
        returnStatements.add(info);
    }

    public void addReturnStatement(String returnValue, int line, int column) {
        ReturnStatementInfo info = new ReturnStatementInfo(returnValue, "RETURN_STATEMENT", "METHOD", line, column);
        returnStatements.add(info);
    }

    public int getReturnStatementCount() {
        return returnStatements.size();
    }

    public boolean suggestsNonVoidMethod() {
        for (ReturnStatementInfo stmt : returnStatements) {
            if (stmt.returnValue != null) {
                for (String pattern : nonVoidPatterns) {
                    if (stmt.returnValue.toLowerCase().contains(pattern.toLowerCase())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<String> getReturnValues() {
        List<String> values = new ArrayList<>();
        for (ReturnStatementInfo stmt : returnStatements) {
            if (stmt.returnValue != null && !stmt.returnValue.trim().isEmpty()) {
                values.add(stmt.returnValue);
            }
        }
        return values;
    }

    @Override
    public boolean hasRelevantSymbols() {
        return !returnStatements.isEmpty();
    }

    @Override
    public String getFormattedSymbols() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Void Method Return Context:\n");
        for (int i = 0; i < returnStatements.size(); i++) {
            ReturnStatementInfo stmt = returnStatements.get(i);
            sb.append(String.format("    %d. Return '%s' at line %d\n",
                    i + 1, stmt.returnValue != null ? stmt.returnValue : "void", stmt.line));
        }
        return sb.toString();
    }

    @Override
    public void clear() {
        returnStatements.clear();
    }

    @Override
    public int getSymbolCount() {
        return returnStatements.size();
    }

    static class ReturnStatementInfo {
        String returnValue;
        String type;
        String scope;
        int line;
        int column;

        ReturnStatementInfo(String returnValue, String type, String scope, int line, int column) {
            this.returnValue = returnValue;
            this.type = type;
            this.scope = scope;
            this.line = line;
            this.column = column;
        }
    }
}