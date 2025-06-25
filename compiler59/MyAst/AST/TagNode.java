package MyAst.AST;

import java.util.List;
import java.util.Map;

public class TagNode extends HtmlElementNode {
    private final String tagName;
    private final Map<String, String> attributes;
    private final List<HtmlElementNode> children;

    public TagNode(String tagName, Map<String, String> attributes, List<HtmlElementNode> children) {
        this.tagName = tagName;
        this.attributes = attributes;
        this.children = children;
    }

    public String getTagName() { return tagName; }
    public Map<String, String> getAttributes() { return attributes; }
    public List<HtmlElementNode> getChildren() { return children; }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        // يمكن تنفيذ visitTagNode إن لزم
        return null;
    }
}
