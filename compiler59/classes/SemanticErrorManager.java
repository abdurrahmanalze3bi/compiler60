package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SemanticErrorManager {
    private List<SemanticError> errors;
    private SymbolTable symbolTable;

    public SemanticErrorManager(SymbolTable symbolTable) {
        this.errors = new ArrayList<>();
        this.symbolTable = symbolTable;
    }

    // Check for missing * before Angular structural directives (ngFor, ngIf, etc.)
    public void checkMissingStructuralDirective(String attributeValue, int line, int column) {
        if (attributeValue != null) {
            // Check for ngFor without *
            if (attributeValue.contains("ngFor") && !attributeValue.startsWith("*")) {
                addError(SemanticErrorType.MISSING_STRUCTURAL_DIRECTIVE_ASTERISK,
                        "Missing '*' before structural directive: " + attributeValue +
                                ". Should be '*ngFor' instead of '" + attributeValue + "'",
                        line, column, attributeValue);
            }
            // Check for ngIf without *
            else if (attributeValue.contains("ngIf") && !attributeValue.startsWith("*")) {
                addError(SemanticErrorType.MISSING_STRUCTURAL_DIRECTIVE_ASTERISK,
                        "Missing '*' before structural directive: " + attributeValue +
                                ". Should be '*ngIf' instead of '" + attributeValue + "'",
                        line, column, attributeValue);
            }
            // Check for ngSwitch without *
            else if (attributeValue.contains("ngSwitch") && !attributeValue.startsWith("*")) {
                addError(SemanticErrorType.MISSING_STRUCTURAL_DIRECTIVE_ASTERISK,
                        "Missing '*' before structural directive: " + attributeValue +
                                ". Should be '*ngSwitch' instead of '" + attributeValue + "'",
                        line, column, attributeValue);
            }
        }
    }

    // Check for undefined variables/properties being used
    public void checkUndefinedReference(String identifier, int line, int column) {
        if (identifier != null && !identifier.equals("this")) {
            Row symbol = symbolTable.lookupSymbol(identifier);
            if (symbol == null) {
                addError(SemanticErrorType.UNDEFINED_REFERENCE,
                        "Undefined reference: '" + identifier + "' is not declared in any accessible scope",
                        line, column, identifier);
            }
        }
    }

    // Check for duplicate declarations in the same scope
    public void checkDuplicateDeclaration(String identifier, String type, int line, int column) {
        if (identifier != null) {
            if (symbolTable.existsInCurrentScope(identifier)) {
                addError(SemanticErrorType.DUPLICATE_DECLARATION,
                        "Duplicate declaration: '" + identifier + "' is already declared in current scope (" +
                                symbolTable.getCurrentScopeName() + ")",
                        line, column, identifier);
            }
        }
    }

    // Check for incorrect method signatures (missing return type, parameters)
    public void checkMethodSignature(String methodName, boolean hasReturnType, boolean hasParameters, int line, int column) {
        if (methodName != null) {
            if (!hasReturnType) {
                addError(SemanticErrorType.MISSING_RETURN_TYPE,
                        "Method '" + methodName + "' is missing return type declaration",
                        line, column, methodName);
            }
        }
    }

    // Check for improper component decorator usage
    public void checkComponentDecorator(String decoratorValue, boolean hasSelector, boolean hasTemplate,
                                        int line, int column) {
        if (decoratorValue != null && decoratorValue.contains("@Component")) {
            if (!hasSelector) {
                addError(SemanticErrorType.MISSING_COMPONENT_PROPERTY,
                        "Component decorator is missing required 'selector' property",
                        line, column, decoratorValue);
            }
            if (!hasTemplate) {
                addError(SemanticErrorType.MISSING_COMPONENT_PROPERTY,
                        "Component decorator is missing required 'template' or 'templateUrl' property",
                        line, column, decoratorValue);
            }
        }
    }

    // Add error to the list
    private void addError(SemanticErrorType type, String message, int line, int column, String context) {
        SemanticError error = new SemanticError(type, message, line, column, context,
                symbolTable.getCurrentScopeName());
        errors.add(error);
    }

    // Get all errors
    public List<SemanticError> getErrors() {
        return new ArrayList<>(errors);
    }

    // Check if there are any errors
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    // Get errors by type
    public List<SemanticError> getErrorsByType(SemanticErrorType type) {
        return errors.stream()
                .filter(error -> error.getType() == type)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    // Print all errors with symbol table context
    public void printErrorsWithSymbolTable() {
        if (errors.isEmpty()) {
            System.out.println("\n=== SEMANTIC ANALYSIS ===");
            System.out.println("No semantic errors found.");
            System.out.println("==========================\n");
            return;
        }

        System.out.println("\n=== SEMANTIC ERRORS FOUND ===");
        System.out.println("Total errors: " + errors.size());
        System.out.println();

        for (int i = 0; i < errors.size(); i++) {
            SemanticError error = errors.get(i);
            System.out.println("Error #" + (i + 1) + ":");
            System.out.println("  Type: " + error.getType());
            System.out.println("  Message: " + error.getMessage());
            System.out.println("  Location: Line " + error.getLine() + ", Column " + error.getColumn());
            System.out.println("  Context: " + error.getContext());
            System.out.println("  Scope: " + error.getScope());
            System.out.println();
        }

        System.out.println("=== CURRENT SYMBOL TABLE STATE ===");
        symbolTable.print();
        symbolTable.printScopeHierarchy();
        System.out.println("===================================\n");
    }

    // Clear all errors
    public void clearErrors() {
        errors.clear();
    }

    // Get error count by type
    public int getErrorCount(SemanticErrorType type) {
        return (int) errors.stream().filter(error -> error.getType() == type).count();
    }
}

// Enum for different types of semantic errors
enum SemanticErrorType {
    MISSING_STRUCTURAL_DIRECTIVE_ASTERISK,
    UNDEFINED_REFERENCE,
    DUPLICATE_DECLARATION,
    MISSING_RETURN_TYPE,
    MISSING_COMPONENT_PROPERTY
}

// Class to represent a semantic error
class SemanticError {
    private SemanticErrorType type;
    private String message;
    private int line;
    private int column;
    private String context;
    private String scope;

    public SemanticError(SemanticErrorType type, String message, int line, int column,
                         String context, String scope) {
        this.type = type;
        this.message = message;
        this.line = line;
        this.column = column;
        this.context = context;
        this.scope = scope;
    }

    // Getters
    public SemanticErrorType getType() { return type; }
    public String getMessage() { return message; }
    public int getLine() { return line; }
    public int getColumn() { return column; }
    public String getContext() { return context; }
    public String getScope() { return scope; }

    @Override
    public String toString() {
        return String.format("[%s] %s at line %d, column %d (Scope: %s, Context: %s)",
                type, message, line, column, scope, context);
    }
}