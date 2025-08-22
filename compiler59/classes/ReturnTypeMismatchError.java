package classes;

/**
 * Return Type Mismatch Error
 * Uses BINARY TREE (TreeMap) for type hierarchy and compatibility checking
 */
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

        // Check if types are compatible through inheritance or conversion
        if (typeTable.areTypesCompatible(expectedType, actualType)) {
            shouldReport = false; // Don't report if types are actually compatible
            return;
        }

        // Suggest possible conversions
        String conversionSuggestion = typeTable.suggestTypeConversion(actualType, expectedType);
        if (conversionSuggestion != null) {
            message += ". " + conversionSuggestion;
        }

        // Check type hierarchy distance
        int hierarchyDistance = typeTable.getTypeHierarchyDistance(actualType, expectedType);
        if (hierarchyDistance > 0 && hierarchyDistance <= 3) {
            message += ". Types are related in hierarchy (distance: " + hierarchyDistance + ")";
        }
    }
}