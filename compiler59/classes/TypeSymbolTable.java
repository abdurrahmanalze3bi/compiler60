package classes;

import java.util.*;

/**
 * Type Symbol Table using BINARY TREE (TreeMap)
 * Optimized for type hierarchy and compatibility checking
 */
public class TypeSymbolTable implements ErrorSymbolTable {
    // BINARY TREE: For type hierarchy (TreeMap maintains sorted order)
    private TreeMap<String, TypeHierarchyNode> typeHierarchy;
    // MAP: For quick type compatibility lookups
    private Map<String, Set<String>> compatibilityMap;
    // BINARY TREE: For conversion suggestions
    private TreeMap<String, List<String>> conversionPaths;

    public TypeSymbolTable() {
        this.typeHierarchy = new TreeMap<>();
        this.compatibilityMap = new HashMap<>();
        this.conversionPaths = new TreeMap<>();
        initializeTypeSystem();
    }

    @Override
    public void addSymbol(String symbol, String type, String scope, int line, int column) {
        // Add type to hierarchy
        TypeHierarchyNode node = new TypeHierarchyNode(symbol, type, scope, line, column);
        typeHierarchy.put(symbol, node);

        // Update compatibility mappings
        updateCompatibilityMap(symbol, type);
    }

    public boolean areTypesCompatible(String expectedType, String actualType) {
        if (expectedType.equals(actualType)) return true;
        Set<String> compatibleTypes = compatibilityMap.get(expectedType);
        return compatibleTypes != null && compatibleTypes.contains(actualType);
    }

    public String suggestTypeConversion(String fromType, String toType) {
        List<String> conversions = conversionPaths.get(fromType + "->" + toType);
        if (conversions != null && !conversions.isEmpty()) {
            return "Try: " + conversions.get(0);
        }

        // Check for common conversions
        if ("string".equals(toType) && "number".equals(fromType)) {
            return "Use .toString() method";
        }
        if ("number".equals(toType) && "string".equals(fromType)) {
            return "Use parseInt() or parseFloat()";
        }
        return null;
    }

    public int getTypeHierarchyDistance(String type1, String type2) {
        // Simple hierarchy distance calculation
        TypeHierarchyNode node1 = typeHierarchy.get(type1);
        TypeHierarchyNode node2 = typeHierarchy.get(type2);
        if (node1 == null || node2 == null) return -1;

        // Calculate distance in type hierarchy tree
        return calculateDistance(node1, node2);
    }

    private void initializeTypeSystem() {
        // Initialize basic type compatibility
        addCompatibility("any", Arrays.asList("string", "number", "boolean", "object"));
        addCompatibility("number", Arrays.asList("int", "float", "double"));
        addCompatibility("string", Arrays.asList("char", "text"));

        // Initialize conversion paths
        conversionPaths.put("number->string", Arrays.asList("value.toString()", "String(value)"));
        conversionPaths.put("string->number", Arrays.asList("parseInt(value)", "Number(value)"));
        conversionPaths.put("boolean->string", Arrays.asList("value.toString()"));
    }

    private void addCompatibility(String baseType, List<String> compatibleTypes) {
        compatibilityMap.put(baseType, new HashSet<>(compatibleTypes));
    }

    private void updateCompatibilityMap(String symbol, String type) {
        // Update compatibility based on new type information
        compatibilityMap.computeIfAbsent(type, k -> new HashSet<>()).add(symbol);
    }

    private int calculateDistance(TypeHierarchyNode node1, TypeHierarchyNode node2) {
        // Simplified distance calculation - in reality this would traverse the type tree
        if (node1.type.equals(node2.type)) return 0;
        if (areDirectlyRelated(node1.type, node2.type)) return 1;
        return 2; // Assume distance 2 for non-directly related types
    }

    private boolean areDirectlyRelated(String type1, String type2) {
        Set<String> compatible1 = compatibilityMap.get(type1);
        Set<String> compatible2 = compatibilityMap.get(type2);
        return (compatible1 != null && compatible1.contains(type2)) ||
                (compatible2 != null && compatible2.contains(type1));
    }

    @Override
    public boolean hasRelevantSymbols() {
        return !typeHierarchy.isEmpty();
    }

    @Override
    public String getFormattedSymbols() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Type Hierarchy Context:\n");
        for (Map.Entry<String, TypeHierarchyNode> entry : typeHierarchy.entrySet()) {
            TypeHierarchyNode node = entry.getValue();
            sb.append(String.format("    - %s [%s] in scope '%s' (Line %d)\n",
                    entry.getKey(), node.type, node.scope, node.line));
        }
        return sb.toString();
    }

    @Override
    public void clear() {
        typeHierarchy.clear();
        // Don't clear compatibility map as it contains system types
    }

    @Override
    public int getSymbolCount() {
        return typeHierarchy.size();
    }

    static class TypeHierarchyNode {
        String typeName;
        String type;
        String scope;
        int line;
        int column;

        TypeHierarchyNode(String typeName, String type, String scope, int line, int column) {
            this.typeName = typeName;
            this.type = type;
            this.scope = scope;
            this.line = line;
            this.column = column;
        }
    }
}