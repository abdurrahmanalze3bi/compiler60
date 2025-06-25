package MyAst.AST;

public class CssPropertyNode extends CssElementNode {
    private final String name;
    private final String value;

    public CssPropertyNode(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() { return name; }
    public String getValue() { return value; }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return null;
    }
}
