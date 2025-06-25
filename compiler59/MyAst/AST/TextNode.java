package MyAst.AST;

public class TextNode extends HtmlElementNode {
    private final String text;

    public TextNode(String text) {
        this.text = text;
    }

    public String getText() { return text; }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return null;
    }
}
