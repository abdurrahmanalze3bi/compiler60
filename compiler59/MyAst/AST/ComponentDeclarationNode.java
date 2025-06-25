package MyAst.AST;
import java.util.List;

public class ComponentDeclarationNode extends AstNode {
    private final String selector;
    private final boolean standalone;
    private final TemplateNode template;
    private final List<StyleNode> styles;

    public ComponentDeclarationNode(String selector, boolean standalone, TemplateNode template, List<StyleNode> styles) {
        this.selector = selector;
        this.standalone = standalone;
        this.template = template;
        this.styles = styles;
    }

    public String getSelector() { return selector; }
    public boolean isStandalone() { return standalone; }
    public TemplateNode getTemplate() { return template; }
    public List<StyleNode> getStyles() { return styles; }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitComponentDeclaration(this);
    }
}

