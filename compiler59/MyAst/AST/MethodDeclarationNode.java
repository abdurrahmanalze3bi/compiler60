package MyAst.AST;

import java.util.List;

public class MethodDeclarationNode extends AstNode {
    private final String name;
    private final List<ParameterNode> parameters;
    private final String returnType;
    private final List<AstNode> body;

    public MethodDeclarationNode(String name, List<ParameterNode> parameters, String returnType, List<AstNode> body) {
        this.name = name;
        this.parameters = parameters;
        this.returnType = returnType;
        this.body = body;
    }

    public String getName() { return name; }
    public List<ParameterNode> getParameters() { return parameters; }
    public String getReturnType() { return returnType; }
    public List<AstNode> getBody() { return body; }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitMethodDeclaration(this);
    }
}

