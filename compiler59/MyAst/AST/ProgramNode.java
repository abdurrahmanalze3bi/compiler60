package MyAst.AST;

import java.util.List;

public class ProgramNode extends AstNode {
    private final List<AstNode> statements;

    public ProgramNode(List<AstNode> statements) {
        this.statements = statements;
    }

    public List<AstNode> getStatements() {
        return statements;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitProgram(this);
    }
}
