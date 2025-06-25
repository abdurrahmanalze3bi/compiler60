package MyAst.AST;

import java.util.List;

public class FunctionCallNode extends AstNode {
    private final String functionName;
    private final List<AstNode> arguments;

    public FunctionCallNode(String functionName, List<AstNode> arguments) {
        this.functionName = functionName;
        this.arguments = arguments;
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<AstNode> getArguments() {
        return arguments;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitFunctionCall(this);
    }
}

