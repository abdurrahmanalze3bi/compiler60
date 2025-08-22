package classes;

import java.util.*;

/**
 * Base interface for all semantic error types
 * Defines common structure and operations
 */
public interface SemanticErrorBase {
    /**
     * Get the error type
     */
    SemanticErrorType getErrorType();

    /**
     * Get the error message
     */
    String getErrorMessage();

    /**
     * Get line number where error occurred
     */
    int getLine();

    /**
     * Get column number where error occurred
     */
    int getColumn();

    /**
     * Get the context (variable name, method name, etc.)
     */
    String getContext();

    /**
     * Check if this error should be reported
     */
    boolean shouldReport();

    /**
     * Get the specialized symbol table for this error type
     */
    ErrorSymbolTable getSymbolTable();

    /**
     * Add relevant symbol to this error's context
     */
    void addRelevantSymbol(String symbol, String type, String scope);

    /**
     * Validate and process the error
     */
    void processError();

    /**
     * Get formatted error report
     */
    String getFormattedReport();
}