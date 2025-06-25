package MyAst.AST;

public class LiteralNode extends AstNode {
    private final Object value;

    public LiteralNode(Object value) {
        this.value = value;
    }

    public Object getValue() { return value; }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitLiteral(this);
    }
}

