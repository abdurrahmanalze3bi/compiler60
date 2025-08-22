package classes;

import java.util.*;

/**
 * Duplicate Class Error
 * Uses MAP data structure for fast class name lookups and namespace management
 */
public class DuplicateClassError extends AbstractSemanticError {
    private String className;
    private String namespace;

    public DuplicateClassError(String className, String namespace, int line, int column, int previousLine) {
        super(SemanticErrorType.DUPLICATE_CLASS,
                "Duplicate class '" + className + "' in namespace '" + namespace +
                        "'. Previous declaration at line " + previousLine,
                line, column, className);
        this.className = className;
        this.namespace = namespace;
    }

    @Override
    protected ErrorSymbolTable createSymbolTable() {
        return new ClassSymbolTable();
    }

    @Override
    public void processError() {
        ClassSymbolTable classTable = (ClassSymbolTable) symbolTable;

        // Check for naming conflicts in different namespaces
        List<String> conflictingNamespaces = classTable.getConflictingNamespaces(className);
        if (!conflictingNamespaces.isEmpty()) {
            message += ". Also found in namespaces: " + String.join(", ", conflictingNamespaces);
        }

        // Suggest alternative names
        List<String> suggestions = classTable.suggestAlternativeNames(className);
        if (!suggestions.isEmpty()) {
            message += ". Suggested names: " + String.join(", ", suggestions);
        }

        // Check for case sensitivity issues
        String caseSensitiveConflict = classTable.findCaseSensitiveConflict(className);
        if (caseSensitiveConflict != null) {
            message += ". Case-sensitive conflict with: " + caseSensitiveConflict;
        }
    }
}