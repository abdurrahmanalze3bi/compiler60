package MyAst.AST;

public class AssignmentNode extends AstNode {
    private final String identifier;
    private final AstNode expression;

    public AssignmentNode(String identifier, AstNode expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    public String getIdentifier() { return identifier; }
    public AstNode getExpression() { return expression; }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitAssignment(this);
    }
}
