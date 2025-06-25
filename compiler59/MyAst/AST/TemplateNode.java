package MyAst.AST;

import java.util.List;

public class TemplateNode extends AstNode {
    private final List<HtmlElementNode> elements;

    public TemplateNode(List<HtmlElementNode> elements) {
        this.elements = elements;
    }

    public List<HtmlElementNode> getElements() {
        return elements;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return null;
    }
}

