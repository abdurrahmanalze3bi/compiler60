package classes;

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

        voidTable.addReturnStatement(returnValue, line, column);

        if (voidTable.getReturnStatementCount() > 1) {
            message += ". Multiple return statements found - consider changing method return type";
        }

        if (voidTable.suggestsNonVoidMethod()) {
            message += ". Consider changing method return type based on return pattern";
        }
    }
}