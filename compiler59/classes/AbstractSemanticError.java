package classes;

public abstract class AbstractSemanticError implements SemanticErrorBase {
    protected SemanticErrorType errorType;
    protected String message;
    protected int line;
    protected int column;
    protected String context;
    protected boolean shouldReport;
    protected ErrorSymbolTable symbolTable;

    public AbstractSemanticError(SemanticErrorType errorType, String message, int line, int column, String context) {
        this.errorType = errorType;
        this.message = message;
        this.line = line;
        this.column = column;
        this.context = context;
        this.shouldReport = true;
        this.symbolTable = createSymbolTable();
    }

    protected abstract ErrorSymbolTable createSymbolTable();

    @Override
    public SemanticErrorType getErrorType() {
        return errorType;
    }

    @Override
    public String getErrorMessage() {
        return message;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public String getContext() {
        return context;
    }

    @Override
    public boolean shouldReport() {
        return shouldReport;
    }

    @Override
    public ErrorSymbolTable getSymbolTable() {
        return symbolTable;
    }

    @Override
    public void addRelevantSymbol(String symbol, String type, String scope) {
        symbolTable.addSymbol(symbol, type, scope, line, column);
    }

    @Override
    public String getFormattedReport() {
        StringBuilder report = new StringBuilder();
        report.append(String.format("[%s] Line %d, Column %d: %s\n",
                errorType.getDisplayName(), line, column, message));
        if (symbolTable.hasRelevantSymbols()) {
            report.append("Relevant Symbols:\n");
            report.append(symbolTable.getFormattedSymbols());
        }
        return report.toString();
    }
}