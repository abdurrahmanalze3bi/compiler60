package MyAst.AST;

import java.util.List;

public class InterfaceDeclarationNode extends AstNode {
    private final String name;
    private final List<AstNode> members;

    public InterfaceDeclarationNode(String name, List<AstNode> members) {
        this.name = name;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public List<AstNode> getMembers() {
        return members;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitInterfaceDeclaration(this);
    }

}
