package MyAst.AST;
import java.util.Map;

public class SelfClosingTagNode extends HtmlElementNode {
    private final String tagName;
    private final Map<String, String> attributes;

    public SelfClosingTagNode(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public String getTagName() { return tagName; }
    public Map<String, String> getAttributes() { return attributes; }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return null;
    }
}

