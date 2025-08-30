package classes;

public class UndefinedStructuralDirectiveError extends AbstractSemanticError {
    private String directiveType;

    public UndefinedStructuralDirectiveError(String variableName, String directive, int line, int column) {
        super(SemanticErrorType.UNDEFINED_STRUCTURAL_DIRECTIVE_VARIABLE,
                "Variable '" + variableName + "' in directive '" + directive + "' is not defined",
                line, column, variableName);
        this.directiveType = extractDirectiveType(directive);
    }

    @Override
    protected ErrorSymbolTable createSymbolTable() {
        return new DirectiveSymbolTable();
    }

    @Override
    public void processError() {
        DirectiveSymbolTable dirTable = (DirectiveSymbolTable) symbolTable;

        if ("ngFor".equals(directiveType)) {
            dirTable.validateNgForVariable(context);
        } else if ("ngIf".equals(directiveType)) {
            dirTable.validateNgIfCondition(context);
        }

        if (!dirTable.isComponentPropertyAvailable(context)) {
            message += ". Make sure '" + context + "' is declared as a component property";
        }
    }

    private String extractDirectiveType(String directive) {
        if (directive.contains("ngFor")) return "ngFor";
        if (directive.contains("ngIf")) return "ngIf";
        return "unknown";
    }
}