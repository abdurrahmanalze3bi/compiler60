package MyAst.AST;
import java.util.List;

public class CssRuleNode extends CssElementNode {
    private final String selector;
    private final List<CssPropertyNode> properties;

    public CssRuleNode(String selector, List<CssPropertyNode> properties) {
        this.selector = selector;
        this.properties = properties;
    }

    public String getSelector() { return selector; }
    public List<CssPropertyNode> getProperties() { return properties; }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return null;
    }
}

