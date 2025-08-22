package classes;

import java.util.*;

/**
 * Undefined Variable Error
 * Uses MAP data structure for fast lookups of variable definitions
 */
public class UndefinedVariableError extends AbstractSemanticError {
    public UndefinedVariableError(String variableName, int line, int column) {
        super(SemanticErrorType.UNDEFINED_VARIABLE,
                "Variable '" + variableName + "' is not defined",
                line, column, variableName);
    }

    @Override
    protected ErrorSymbolTable createSymbolTable() {
        return new VariableSymbolTable();
    }

    @Override
    public void processError() {
        // Check if variable exists in any accessible scope
        VariableSymbolTable varTable = (VariableSymbolTable) symbolTable;

        // Look for similar variable names (typo detection)
        List<String> suggestions = varTable.findSimilarVariables(context);
        if (!suggestions.isEmpty()) {
            message += ". Did you mean: " + String.join(", ", suggestions) + "?";
        }

        // Check if it's a common typo
        String commonTypo = varTable.checkCommonTypos(context);
        if (commonTypo != null) {
            message += ". Common typo detected, did you mean '" + commonTypo + "'?";
        }
    }
}