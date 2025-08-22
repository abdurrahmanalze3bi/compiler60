package classes;

/**
 * Enum for all semantic error types
 */
public enum SemanticErrorType {
    // Variable and reference errors
    UNDEFINED_VARIABLE("Undefined Variable"),
    UNDEFINED_STRUCTURAL_DIRECTIVE_VARIABLE("Undefined Structural Directive Variable"),

    // Method declaration and return errors
    DUPLICATE_METHOD("Duplicate Method Declaration"),
    RETURN_TYPE_MISMATCH("Return Type Mismatch"),
    VOID_METHOD_RETURN_VALUE("Void Method Returning Value"),
    MISSING_RETURN_STATEMENT("Missing Return Statement"),

    // Class and interface declaration errors
    DUPLICATE_CLASS("Duplicate Class Declaration"),
    DUPLICATE_INTERFACE("Duplicate Interface Declaration"),

    // Property and binding errors
    PROPERTY_BINDING_MISMATCH("Property Binding Mismatch"),
    LITERAL_BINDING_FOR_PROPERTY("Literal Binding Used for Property");

    private final String displayName;

    SemanticErrorType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}