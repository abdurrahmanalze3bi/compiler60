package classes;

import java.util.*;

/**
 * Missing Return Statement Error
 * Uses BINARY TREE for tracking code paths and return statement coverage
 */
public class MissingReturnStatementError extends AbstractSemanticError {
    private String expectedReturnType;

    public MissingReturnStatementError(String methodName, String expectedReturnType, int line, int column) {
        super(SemanticErrorType.MISSING_RETURN_STATEMENT,
                "Non-void method '" + methodName + "' must return a value of type '" + expectedReturnType + "'",
                line, column, methodName);
        this.expectedReturnType = expectedReturnType;
    }

    @Override
    protected ErrorSymbolTable createSymbolTable() {
        return new ReturnPathSymbolTable();
    }

    @Override
    public void processError() {
        ReturnPathSymbolTable pathTable = (ReturnPathSymbolTable) symbolTable;

        // Analyze code paths to see if all paths return
        if (!pathTable.allPathsReturn()) {
            List<String> missingPaths = pathTable.getMissingReturnPaths();
            if (!missingPaths.isEmpty()) {
                message += ". Missing returns in: " + String.join(", ", missingPaths);
            }
        }

        // Suggest default return value based on type
        String defaultValue = pathTable.suggestDefaultReturnValue(expectedReturnType);
        if (defaultValue != null) {
            message += ". Consider adding: return " + defaultValue + ";";
        }
    }
}