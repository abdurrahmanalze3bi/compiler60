package classes;

import java.util.List;

/**
 * Literal Binding for Property Error
 * Uses LIST data structure for tracking binding patterns and suggestions
 */
public class LiteralBindingForPropertyError extends AbstractSemanticError {
    private String attributeName;
    private String attributeValue;
    private String suggestedBinding;

    public LiteralBindingForPropertyError(String attributeName, String attributeValue,
                                          String suggestedBinding, int line, int column) {
        super(SemanticErrorType.LITERAL_BINDING_FOR_PROPERTY,
                "Literal string binding for attribute '" + attributeName +
                        "' with value matching component property '" + attributeValue +
                        "'. For property binding, use: [" + attributeName + "]=\"" + attributeValue + "\"",
                line, column, attributeName);
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
        this.suggestedBinding = suggestedBinding;
    }

    @Override
    protected ErrorSymbolTable createSymbolTable() {
        return new LiteralBindingSymbolTable();
    }

    @Override
    public void processError() {
        LiteralBindingSymbolTable literalTable = (LiteralBindingSymbolTable) symbolTable;

        // Add this binding pattern for analysis
        literalTable.addBindingPattern(attributeName, attributeValue, "LITERAL", line);

        // Check if this is a common pattern that should be property binding
        if (literalTable.isCommonPropertyPattern(attributeName, attributeValue)) {
            message += ". This is a common pattern that should use property binding";
        }

        // Get binding recommendations based on patterns
        List<String> recommendations = literalTable.getBindingRecommendations(attributeName);
        if (!recommendations.isEmpty()) {
            message += ". Recommended patterns: " + String.join(", ", recommendations);
        }

        // Check for interpolation alternatives
        String interpolationSuggestion = literalTable.suggestInterpolation(attributeValue);
        if (interpolationSuggestion != null) {
            message += ". Alternative: use interpolation " + interpolationSuggestion;
        }
    }
}