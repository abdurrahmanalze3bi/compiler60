package classes;

import java.util.*;

/**
 * Property Binding Symbol Table using MAP
 * Optimized for property lookups, type checking, and binding validation
 */
public class PropertyBindingSymbolTable implements ErrorSymbolTable {
    // MAP: Property name -> PropertyInfo for fast lookups
    private Map<String, PropertyInfo> componentProperties;
    // MAP: Binding type -> Set of compatible property types
    private Map<String, Set<String>> bindingCompatibility;
    // MAP: Property name -> Set of valid binding types
    private Map<String, Set<String>> propertyBindingTypes;
    // MAP: Type -> Type for type conversion suggestions
    private Map<String, String> typeConversions;

    public PropertyBindingSymbolTable() {
        this.componentProperties = new HashMap<>();
        this.bindingCompatibility = new HashMap<>();
        this.propertyBindingTypes = new HashMap<>();
        this.typeConversions = new HashMap<>();
        initializeBindingRules();
    }

    @Override
    public void addSymbol(String symbol, String type, String scope, int line, int column) {
        PropertyInfo info = new PropertyInfo(symbol, type, scope, line, column);
        componentProperties.put(symbol, info);

        // Update binding types for this property
        updatePropertyBindingTypes(symbol, type);
    }

    public boolean isPropertyDefined(String propertyName) {
        return componentProperties.containsKey(propertyName);
    }

    public String getPropertyType(String propertyName) {
        PropertyInfo info = componentProperties.get(propertyName);
        return info != null ? info.type : null;
    }

    public boolean areTypesCompatible(String expectedType, String actualType) {
        if (expectedType.equals(actualType)) return true;

        // Check direct compatibility
        Set<String> compatibleTypes = bindingCompatibility.get(expectedType);
        if (compatibleTypes != null && compatibleTypes.contains(actualType)) {
            return true;
        }

        // Check type conversions
        String convertedType = typeConversions.get(actualType);
        return convertedType != null && convertedType.equals(expectedType);
    }

    public List<String> suggestAlternativeBindings(String propertyName, String bindingType) {
        List<String> suggestions = new ArrayList<>();
        Set<String> validBindings = propertyBindingTypes.get(propertyName);

        if (validBindings != null) {
            for (String validBinding : validBindings) {
                if (!validBinding.equals(bindingType)) {
                    suggestions.add(createBindingSuggestion(propertyName, validBinding));
                }
            }
        }
        return suggestions;
    }

    public String analyzeBindingPattern(String propertyName, String bindingType) {
        PropertyInfo info = componentProperties.get(propertyName);
        if (info == null) return null;

        // Analyze common binding patterns
        switch (bindingType.toUpperCase()) {
            case "PROPERTY_BINDING":
                if ("boolean".equals(info.type)) {
                    return "Consider using attribute binding for boolean properties";
                }
                break;
            case "EVENT_BINDING":
                if (!"function".equals(info.type)) {
                    return "Event binding should reference a method, not a property";
                }
                break;
            case "TWO_WAY_BINDING":
                if (!isTwoWayBindingCompatible(info.type)) {
                    return "Two-way binding requires properties with getter and setter";
                }
                break;
        }
        return null;
    }

    private void initializeBindingRules() {
        // Initialize binding compatibility rules
        bindingCompatibility.put("string", Set.of("text", "varchar", "char"));
        bindingCompatibility.put("number", Set.of("int", "integer", "float", "double"));
        bindingCompatibility.put("boolean", Set.of("bool"));
        bindingCompatibility.put("object", Set.of("any", "unknown"));

        // Initialize type conversions
        typeConversions.put("string", "text");
        typeConversions.put("int", "number");
        typeConversions.put("bool", "boolean");
    }

    private void updatePropertyBindingTypes(String propertyName, String type) {
        Set<String> validBindings = new HashSet<>();

        // All properties support property binding
        validBindings.add("PROPERTY_BINDING");

        // Functions support event binding
        if ("function".equals(type) || "method".equals(type)) {
            validBindings.add("EVENT_BINDING");
        }

        // Certain types support two-way binding
        if (isTwoWayBindingCompatible(type)) {
            validBindings.add("TWO_WAY_BINDING");
        }

        // String and number types support interpolation
        if ("string".equals(type) || "number".equals(type)) {
            validBindings.add("INTERPOLATION");
        }

        propertyBindingTypes.put(propertyName, validBindings);
    }

    private boolean isTwoWayBindingCompatible(String type) {
        return Set.of("string", "number", "boolean", "object").contains(type);
    }

    private String createBindingSuggestion(String propertyName, String bindingType) {
        switch (bindingType) {
            case "PROPERTY_BINDING": return "[" + propertyName + "]=\"value\"";
            case "EVENT_BINDING": return "(" + propertyName + ")=\"handler()\"";
            case "TWO_WAY_BINDING": return "[(ngModel)]=\"" + propertyName + "\"";
            case "INTERPOLATION": return "{{ " + propertyName + " }}";
            default: return propertyName;
        }
    }

    @Override
    public boolean hasRelevantSymbols() {
        return !componentProperties.isEmpty();
    }

    @Override
    public String getFormattedSymbols() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Component Properties Context:\n");
        for (Map.Entry<String, PropertyInfo> entry : componentProperties.entrySet()) {
            PropertyInfo info = entry.getValue();
            sb.append(String.format("    - Property '%s' [%s] in scope '%s' (Line %d)\n",
                    entry.getKey(), info.type, info.scope, info.line));

            // Show valid binding types
            Set<String> bindings = propertyBindingTypes.get(entry.getKey());
            if (bindings != null && !bindings.isEmpty()) {
                sb.append(String.format("      Valid bindings: %s\n", String.join(", ", bindings)));
            }
        }
        return sb.toString();
    }

    @Override
    public void clear() {
        componentProperties.clear();
        // Keep binding rules as they are system-wide
    }

    @Override
    public int getSymbolCount() {
        return componentProperties.size();
    }

    static class PropertyInfo {
        String propertyName;
        String type;
        String scope;
        int line;
        int column;
        boolean isReadonly;
        boolean hasGetter;
        boolean hasSetter;

        PropertyInfo(String propertyName, String type, String scope, int line, int column) {
            this.propertyName = propertyName;
            this.type = type;
            this.scope = scope;
            this.line = line;
            this.column = column;
            this.isReadonly = false;
            this.hasGetter = true; // Assume true by default
            this.hasSetter = true; // Assume true by default
        }
    }
}