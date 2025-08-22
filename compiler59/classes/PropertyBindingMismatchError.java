package classes;

import java.util.*;

/**
 * Property Binding Mismatch Error
 * Uses MAP data structure for fast property lookups and binding validation
 */
public class PropertyBindingMismatchError extends AbstractSemanticError {
    private String propertyName;
    private String bindingType;
    private String expectedType;

    public PropertyBindingMismatchError(String propertyName, String bindingType,
                                        String expectedType, int line, int column) {
        super(SemanticErrorType.PROPERTY_BINDING_MISMATCH,
                "Property '" + propertyName + "' used in " + bindingType +
                        " binding is not defined or type mismatch. Expected: " + expectedType,
                line, column, propertyName);
        this.propertyName = propertyName;
        this.bindingType = bindingType;
        this.expectedType = expectedType;
    }

    @Override
    protected ErrorSymbolTable createSymbolTable() {
        return new PropertyBindingSymbolTable();
    }

    @Override
    public void processError() {
        PropertyBindingSymbolTable bindingTable = (PropertyBindingSymbolTable) symbolTable;

        // Check if property exists in component
        if (!bindingTable.isPropertyDefined(propertyName)) {
            message += ". Property '" + propertyName + "' is not defined in component";
        }

        // Check binding compatibility
        String actualType = bindingTable.getPropertyType(propertyName);
        if (actualType != null && !bindingTable.areTypesCompatible(expectedType, actualType)) {
            message += ". Type mismatch: expected '" + expectedType + "', found '" + actualType + "'";
        }

        // Suggest alternative bindings
        List<String> suggestions = bindingTable.suggestAlternativeBindings(propertyName, bindingType);
        if (!suggestions.isEmpty()) {
            message += ". Suggested bindings: " + String.join(", ", suggestions);
        }

        // Check for common binding patterns
        String bindingPattern = bindingTable.analyzeBindingPattern(propertyName, bindingType);
        if (bindingPattern != null) {
            message += ". " + bindingPattern;
        }
    }
}