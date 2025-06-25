package MyAst.AST;

public class ImportDeclarationNode extends AstNode {
    private final String importName;
    private final String fromPath;

    public ImportDeclarationNode(String importName, String fromPath) {
        this.importName = importName;
        this.fromPath = fromPath;
    }

    public String getImportName() {
        return importName;
    }

    public String getFromPath() {
        return fromPath;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return null;
    }
}
