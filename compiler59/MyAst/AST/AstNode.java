package MyAst.AST;

public abstract class AstNode {
    public abstract <T> T accept(AstVisitor<T> visitor);
}
