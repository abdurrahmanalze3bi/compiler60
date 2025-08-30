package classes;

public class ReturnTypeMismatchError extends AbstractSemanticError {
    private String expectedType;
    private String actualType;

    public ReturnTypeMismatchError(String methodName, String expectedType,
                                   String actualType, int line, int column) {
        super(SemanticErrorType.RETURN_TYPE_MISMATCH,
                "Method '" + methodName + "' expects return type '" + expectedType +
                        "' but found '" + actualType + "'",
                line, column, methodName);
        this.expectedType = expectedType;
        this.actualType = actualType;
    }

    @Override
    protected ErrorSymbolTable createSymbolTable() {
        return new TypeSymbolTable();
    }

    @Override
    public void processError() {
        TypeSymbolTable typeTable = (TypeSymbolTable) symbolTable;

        if (typeTable.areTypesCompatible(expectedType, actualType)) {
            shouldReport = false;
            return;
        }

        String conversionSuggestion = typeTable.suggestTypeConversion(actualType, expectedType);
        if (conversionSuggestion != null) {
            message += ". " + conversionSuggestion;
        }

        int hierarchyDistance = typeTable.getTypeHierarchyDistance(actualType, expectedType);
        if (hierarchyDistance > 0 && hierarchyDistance <= 3) {
            message += ". Types are related in hierarchy (distance: " + hierarchyDistance + ")";
        }
    }
}