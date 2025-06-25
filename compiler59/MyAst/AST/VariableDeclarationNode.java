package MyAst.AST;

public class VariableDeclarationNode extends AstNode {
    private final String kind;
    private final String identifier;
    private final AstNode initializer;

    public VariableDeclarationNode(String kind, String identifier, AstNode initializer) {
        this.kind = kind;
        this.identifier = identifier;
        this.initializer = initializer;
    }

    public String getKind() { return kind; }
    public String getIdentifier() { return identifier; }
    public AstNode getInitializer() { return initializer; }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitVariableDeclaration(this);
    }
}
