package classes;

public enum SemanticErrorType {
    UNDEFINED_VARIABLE("Undefined Variable"),
    UNDEFINED_STRUCTURAL_DIRECTIVE_VARIABLE("Undefined Structural Directive Variable"),

    DUPLICATE_METHOD("Duplicate Method Declaration"),
    RETURN_TYPE_MISMATCH("Return Type Mismatch"),
    VOID_METHOD_RETURN_VALUE("Void Method Returning Value"),
    MISSING_RETURN_STATEMENT("Missing Return Statement"),

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