package MyAst.AST;

public class InterpolationNode extends HtmlElementNode {
    private final String expression;

    public InterpolationNode(String expression) {
        this.expression = expression;
    }

    public String getExpression() { return expression; }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return null;
    }
}

