package MyAst.AST;

public interface AstVisitor<T> {
    T visitProgram(ProgramNode node);
    T visitComponentDeclaration(ComponentDeclarationNode node);
    T visitClassDeclaration(ClassDeclarationNode node);
    T visitInterfaceDeclaration(InterfaceDeclarationNode node);
    T visitMethodDeclaration(MethodDeclarationNode node);
    T visitAssignment(AssignmentNode node);
    T visitBinaryExpression(BinaryExpressionNode node);
    T visitLiteral(LiteralNode node);
    T visitVariableDeclaration(VariableDeclarationNode node);
    T visitFunctionCall(FunctionCallNode node);
    T visitParameter(ParameterNode node);
    T visitImportDeclaration(ImportDeclarationNode node);

    // HTML Template Nodes
    T visitTagNode(TagNode node);
    T visitSelfClosingTagNode(SelfClosingTagNode node);
    T visitTextNode(TextNode node);
    T visitInterpolationNode(InterpolationNode node);

    // CSS Nodes
    T visitCssRuleNode(CssRuleNode node);
    T visitCssPropertyNode(CssPropertyNode node);
}
