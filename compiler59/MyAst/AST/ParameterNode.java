package MyAst.AST;

public class ParameterNode extends AstNode {
    private final String name;
    private final String type;

    public ParameterNode(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        // يمكن استخدامه في زيارة الميثود أو التجميع
        return null;
    }
}
