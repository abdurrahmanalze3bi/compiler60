package classes;

import java.util.*;

/**
 * Duplicate Interface Error
 * Uses BINARY TREE (TreeSet) for sorted interface hierarchy and inheritance checking
 */
public class DuplicateInterfaceError extends AbstractSemanticError {
    private String interfaceName;
    private List<String> extendedInterfaces;

    public DuplicateInterfaceError(String interfaceName, List<String> extendedInterfaces,
                                   int line, int column, int previousLine) {
        super(SemanticErrorType.DUPLICATE_INTERFACE,
                "Duplicate interface '" + interfaceName + "'. Previous declaration at line " + previousLine,
                line, column, interfaceName);
        this.interfaceName = interfaceName;
        this.extendedInterfaces = new ArrayList<>(extendedInterfaces);
    }

    @Override
    protected ErrorSymbolTable createSymbolTable() {
        return new InterfaceSymbolTable();
    }

    @Override
    public void processError() {
        InterfaceSymbolTable interfaceTable = (InterfaceSymbolTable) symbolTable;

        // Check for circular inheritance
        if (interfaceTable.hasCircularInheritance(interfaceName)) {
            message += ". Warning: Circular inheritance detected";
        }

        // Check inheritance hierarchy conflicts
        List<String> inheritanceConflicts = interfaceTable.getInheritanceConflicts(interfaceName);
        if (!inheritanceConflicts.isEmpty()) {
            message += ". Inheritance conflicts: " + String.join(", ", inheritanceConflicts);
        }

        // Analyze method signature conflicts in hierarchy
        if (interfaceTable.hasMethodSignatureConflicts(interfaceName)) {
            message += ". Method signature conflicts detected in inheritance hierarchy";
        }
    }
}