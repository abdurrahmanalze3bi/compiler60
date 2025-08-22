package classes;

/**
 * Void Method Return Value Error
 * Uses LIST for tracking return statements in void methods
 */
public class VoidMethodReturnValueError extends AbstractSemanticError {
    private String returnValue;

    public VoidMethodReturnValueError(String methodName, String returnValue, int line, int column) {
        super(SemanticErrorType.VOID_METHOD_RETURN_VALUE,
                "Void method '" + methodName + "' cannot return value '" + returnValue + "'",
                line, column, methodName);
        this.returnValue = returnValue;
    }

    @Override
    protected ErrorSymbolTable createSymbolTable() {
        return new VoidMethodSymbolTable();
    }

    @Override
    public void processError() {
        VoidMethodSymbolTable voidTable = (VoidMethodSymbolTable) symbolTable;

        // Track all return statements in this void method
        voidTable.addReturnStatement(returnValue, line, column);

        // Check if this is an accidental return or if method should not be void
        if (voidTable.getReturnStatementCount() > 1) {
            message += ". Multiple return statements found - consider changing method return type";
        }

        // Suggest fixing the method signature if pattern indicates non-void intent
        if (voidTable.suggestsNonVoidMethod()) {
            message += ". Consider changing method return type based on return pattern";
        }
    }
}