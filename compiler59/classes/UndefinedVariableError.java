package classes;

import java.util.*;

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
        VariableSymbolTable varTable = (VariableSymbolTable) symbolTable;

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