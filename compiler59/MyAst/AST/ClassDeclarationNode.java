package MyAst.AST;

import java.util.List;

public class ClassDeclarationNode extends AstNode {
    private final String name;
    private final List<AstNode> members;
    private final boolean isExported;

    public ClassDeclarationNode(String name, List<AstNode> members, boolean isExported) {
        this.name = name;
        this.members = members;
        this.isExported = isExported;
    }

    public String getName() { return name; }
    public List<AstNode> getMembers() { return members; }
    public boolean isExported() { return isExported; }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitClassDeclaration(this);
    }
}
