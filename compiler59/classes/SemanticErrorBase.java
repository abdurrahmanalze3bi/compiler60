package classes;

import java.util.*;

public interface SemanticErrorBase {
    SemanticErrorType getErrorType();

    String getErrorMessage();

    int getLine();

    int getColumn();

    String getContext();

    boolean shouldReport();

    ErrorSymbolTable getSymbolTable();

    void addRelevantSymbol(String symbol, String type, String scope);

    void processError();

    String getFormattedReport();
}