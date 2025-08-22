package classes;

import java.util.*;

/**
 * Directive Symbol Table using LIST
 * Optimized for tracking directive variable chains and dependencies
 */
public class DirectiveSymbolTable implements ErrorSymbolTable {
    // LIST: For tracking directive variable chains in order
    private List<DirectiveVariableInfo> directiveChain;
    // LIST: For tracking component properties that can be used
    private List<String> availableProperties;
    // LIST: For tracking directive validation rules
    private List<DirectiveRule> validationRules;

    public DirectiveSymbolTable() {
        this.directiveChain = new ArrayList<>();
        this.availableProperties = new ArrayList<>();
        this.validationRules = new ArrayList<>();
        initializeValidationRules();
    }

    @Override
    public void addSymbol(String symbol, String type, String scope, int line, int column) {
        DirectiveVariableInfo info = new DirectiveVariableInfo(symbol, type, scope, line, column);
        directiveChain.add(info);

        // If it's a component property, add to available properties
        if ("PROPERTY".equals(type)) {
            availableProperties.add(symbol);
        }
    }

    /**
     * Validate ngFor variable usage
     */
    public void validateNgForVariable(String variable) {
        // Check if variable follows ngFor patterns
        for (DirectiveRule rule : validationRules) {
            if (rule.directive.equals("ngFor") && !rule.isValid(variable)) {
                // Add validation error context
            }
        }
    }

    /**
     * Validate ngIf condition
     */
    public void validateNgIfCondition(String condition) {
        // Check if condition is a valid expression
        for (DirectiveRule rule : validationRules) {
            if (rule.directive.equals("ngIf") && !rule.isValid(condition)) {
                // Add validation error context
            }
        }
    }

    /**
     * Check if a component property is available for use
     */
    public boolean isComponentPropertyAvailable(String property) {
        return availableProperties.contains(property);
    }

    /**
     * Get the sequence of directive variables (useful for debugging chains)
     */
    public List<String> getDirectiveSequence() {
        List<String> sequence = new ArrayList<>();
        for (DirectiveVariableInfo info : directiveChain) {
            sequence.add(info.name);
        }
        return sequence;
    }

    private void initializeValidationRules() {
        // Initialize common directive validation rules
        validationRules.add(new DirectiveRule("ngFor", var -> var != null && !var.trim().isEmpty()));
        validationRules.add(new DirectiveRule("ngIf", var -> var != null && !var.trim().isEmpty()));
    }

    @Override
    public boolean hasRelevantSymbols() {
        return !directiveChain.isEmpty();
    }

    @Override
    public String getFormattedSymbols() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Directive Context:\n");
        for (int i = 0; i < directiveChain.size(); i++) {
            DirectiveVariableInfo info = directiveChain.get(i);
            sb.append(String.format("    %d. %s [%s] in scope '%s' (Line %d)\n",
                    i + 1, info.name, info.type, info.scope, info.line));
        }

        if (!availableProperties.isEmpty()) {
            sb.append("  Available Properties:\n");
            for (String prop : availableProperties) {
                sb.append("    - ").append(prop).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public void clear() {
        directiveChain.clear();
        availableProperties.clear();
    }

    @Override
    public int getSymbolCount() {
        return directiveChain.size();
    }

    /**
     * Information about directive variables
     */
    static class DirectiveVariableInfo {
        String name;
        String type;
        String scope;
        int line;
        int column;

        DirectiveVariableInfo(String name, String type, String scope, int line, int column) {
            this.name = name;
            this.type = type;
            this.scope = scope;
            this.line = line;
            this.column = column;
        }
    }

    /**
     * Validation rules for directives
     */
    static class DirectiveRule {
        String directive;
        java.util.function.Predicate<String> validator;

        DirectiveRule(String directive, java.util.function.Predicate<String> validator) {
            this.directive = directive;
            this.validator = validator;
        }

        boolean isValid(String value) {
            return validator.test(value);
        }
    }
}