package classes;

/**
 * Base interface for specialized symbol tables
 */
public interface ErrorSymbolTable {
    void addSymbol(String symbol, String type, String scope, int line, int column);
    boolean hasRelevantSymbols();
    String getFormattedSymbols();
    void clear();
    int getSymbolCount();
}