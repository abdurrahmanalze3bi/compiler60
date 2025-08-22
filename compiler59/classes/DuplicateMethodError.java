package classes;

import java.util.*;

/**
 * Duplicate Method Error
 * Uses MAP data structure for fast method signature lookups
 */
public class DuplicateMethodError extends AbstractSemanticError {
    private String methodSignature;
    private List<String> parameterTypes;

    public DuplicateMethodError(String methodName, List<String> parameterTypes,
                                int line, int column, int previousLine) {
        super(SemanticErrorType.DUPLICATE_METHOD,
                "Duplicate method '" + methodName + "' with same signature. Previous declaration at line " + previousLine,
                line, column, methodName);
        this.methodSignature = createSignature(methodName, parameterTypes);
        this.parameterTypes = new ArrayList<>(parameterTypes);
    }

    @Override
    protected ErrorSymbolTable createSymbolTable() {
        return new MethodSymbolTable();
    }

    @Override
    public void processError() {
        MethodSymbolTable methodTable = (MethodSymbolTable) symbolTable;

        // Check for method overloading possibilities
        if (methodTable.canBeOverloaded(context, parameterTypes)) {
            message += ". Consider method overloading with different parameter types";
        }

        // Check for signature conflicts
        List<String> conflictingSignatures = methodTable.getConflictingSignatures(methodSignature);
        if (!conflictingSignatures.isEmpty()) {
            message += ". Conflicts with: " + String.join(", ", conflictingSignatures);
        }
    }

    private String createSignature(String methodName, List<String> paramTypes) {
        return methodName + "(" + String.join(",", paramTypes) + ")";
    }
}