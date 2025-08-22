package classes;

import java.util.*;

/**
 * Interface Symbol Table using BINARY TREE (TreeSet/TreeMap)
 * Optimized for inheritance hierarchy analysis and sorted interface management
 */
public class InterfaceSymbolTable implements ErrorSymbolTable {
    // BINARY TREE: For sorted interface hierarchy
    private TreeMap<String, InterfaceInfo> interfaceHierarchy;
    // BINARY TREE: For inheritance relationships (parent -> children)
    private TreeMap<String, TreeSet<String>> inheritanceTree;
    // BINARY TREE: For reverse inheritance (child -> parents)
    private TreeMap<String, TreeSet<String>> reverseInheritanceTree;
    // MAP: For method signature tracking per interface
    private Map<String, Set<String>> interfaceMethodSignatures;

    public InterfaceSymbolTable() {
        this.interfaceHierarchy = new TreeMap<>();
        this.inheritanceTree = new TreeMap<>();
        this.reverseInheritanceTree = new TreeMap<>();
        this.interfaceMethodSignatures = new HashMap<>();
    }

    @Override
    public void addSymbol(String symbol, String type, String scope, int line, int column) {
        InterfaceInfo info = new InterfaceInfo(symbol, type, scope, line, column);
        interfaceHierarchy.put(symbol, info);

        // Initialize inheritance tracking
        inheritanceTree.put(symbol, new TreeSet<>());
        reverseInheritanceTree.put(symbol, new TreeSet<>());
        interfaceMethodSignatures.put(symbol, new HashSet<>());
    }

    public void addInheritanceRelationship(String child, String parent) {
        // Add to inheritance tree (parent -> children)
        inheritanceTree.computeIfAbsent(parent, k -> new TreeSet<>()).add(child);

        // Add to reverse inheritance tree (child -> parents)
        reverseInheritanceTree.computeIfAbsent(child, k -> new TreeSet<>()).add(parent);
    }

    public boolean hasCircularInheritance(String interfaceName) {
        Set<String> visited = new HashSet<>();
        Set<String> recursionStack = new HashSet<>();
        return hasCircularInheritanceDFS(interfaceName, visited, recursionStack);
    }

    public List<String> getInheritanceConflicts(String interfaceName) {
        List<String> conflicts = new ArrayList<>();
        TreeSet<String> parents = reverseInheritanceTree.get(interfaceName);

        if (parents != null && parents.size() > 1) {
            // Check for diamond problem or conflicting method signatures
            for (String parent1 : parents) {
                for (String parent2 : parents) {
                    if (!parent1.equals(parent2) && hasMethodSignatureConflict(parent1, parent2)) {
                        conflicts.add(parent1 + " <-> " + parent2);
                    }
                }
            }
        }
        return conflicts;
    }

    public boolean hasMethodSignatureConflicts(String interfaceName) {
        TreeSet<String> parents = reverseInheritanceTree.get(interfaceName);
        if (parents == null || parents.size() <= 1) return false;

        // Check for conflicting method signatures from multiple parents
        Set<String> allSignatures = new HashSet<>();
        Map<String, String> signatureToInterface = new HashMap<>();

        for (String parent : parents) {
            Set<String> parentSignatures = interfaceMethodSignatures.get(parent);
            if (parentSignatures != null) {
                for (String signature : parentSignatures) {
                    if (allSignatures.contains(signature)) {
                        String existingInterface = signatureToInterface.get(signature);
                        if (!existingInterface.equals(parent)) {
                            return true; // Conflict found
                        }
                    }
                    allSignatures.add(signature);
                    signatureToInterface.put(signature, parent);
                }
            }
        }
        return false;
    }

    public void addMethodSignature(String interfaceName, String methodSignature) {
        interfaceMethodSignatures.computeIfAbsent(interfaceName, k -> new HashSet<>()).add(methodSignature);
    }

    public TreeSet<String> getInterfaceHierarchy(String interfaceName) {
        TreeSet<String> hierarchy = new TreeSet<>();
        collectHierarchy(interfaceName, hierarchy);
        return hierarchy;
    }

    private boolean hasCircularInheritanceDFS(String current, Set<String> visited, Set<String> recursionStack) {
        if (recursionStack.contains(current)) {
            return true; // Circular dependency found
        }
        if (visited.contains(current)) {
            return false; // Already processed
        }

        visited.add(current);
        recursionStack.add(current);

        TreeSet<String> parents = reverseInheritanceTree.get(current);
        if (parents != null) {
            for (String parent : parents) {
                if (hasCircularInheritanceDFS(parent, visited, recursionStack)) {
                    return true;
                }
            }
        }

        recursionStack.remove(current);
        return false;
    }

    private boolean hasMethodSignatureConflict(String interface1, String interface2) {
        Set<String> signatures1 = interfaceMethodSignatures.get(interface1);
        Set<String> signatures2 = interfaceMethodSignatures.get(interface2);

        if (signatures1 == null || signatures2 == null) return false;

        // Check for intersection (same method signatures)
        Set<String> intersection = new HashSet<>(signatures1);
        intersection.retainAll(signatures2);
        return !intersection.isEmpty();
    }

    private void collectHierarchy(String interfaceName, TreeSet<String> hierarchy) {
        if (hierarchy.contains(interfaceName)) return; // Avoid infinite recursion

        hierarchy.add(interfaceName);
        TreeSet<String> parents = reverseInheritanceTree.get(interfaceName);
        if (parents != null) {
            for (String parent : parents) {
                collectHierarchy(parent, hierarchy);
            }
        }
    }

    @Override
    public boolean hasRelevantSymbols() {
        return !interfaceHierarchy.isEmpty();
    }

    @Override
    public String getFormattedSymbols() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Interface Hierarchy Context:\n");
        for (Map.Entry<String, InterfaceInfo> entry : interfaceHierarchy.entrySet()) {
            InterfaceInfo info = entry.getValue();
            sb.append(String.format("    - Interface '%s' [%s] in scope '%s' (Line %d)\n",
                    entry.getKey(), info.type, info.scope, info.line));

            // Show inheritance relationships
            TreeSet<String> parents = reverseInheritanceTree.get(entry.getKey());
            if (parents != null && !parents.isEmpty()) {
                sb.append(String.format("      Extends: %s\n", String.join(", ", parents)));
            }

            TreeSet<String> children = inheritanceTree.get(entry.getKey());
            if (children != null && !children.isEmpty()) {
                sb.append(String.format("      Extended by: %s\n", String.join(", ", children)));
            }

            // Show method signatures
            Set<String> methods = interfaceMethodSignatures.get(entry.getKey());
            if (methods != null && !methods.isEmpty()) {
                sb.append(String.format("      Methods: %s\n", String.join(", ", methods)));
            }
        }
        return sb.toString();
    }

    @Override
    public void clear() {
        interfaceHierarchy.clear();
        inheritanceTree.clear();
        reverseInheritanceTree.clear();
        interfaceMethodSignatures.clear();
    }

    @Override
    public int getSymbolCount() {
        return interfaceHierarchy.size();
    }

    static class InterfaceInfo {
        String interfaceName;
        String type;
        String scope;
        int line;
        int column;
        TreeSet<String> extendedInterfaces;
        TreeSet<String> methodSignatures;

        InterfaceInfo(String interfaceName, String type, String scope, int line, int column) {
            this.interfaceName = interfaceName;
            this.type = type;
            this.scope = scope;
            this.line = line;
            this.column = column;
            this.extendedInterfaces = new TreeSet<>();
            this.methodSignatures = new TreeSet<>();
        }
    }
}