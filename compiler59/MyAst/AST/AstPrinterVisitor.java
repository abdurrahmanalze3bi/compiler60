package MyAst.AST;

public class AstPrinterVisitor implements AstVisitor<String> {
    private final StringBuilder builder = new StringBuilder();
    private String indent = "";

    public void print(AstNode node) {
        node.accept(this);
        System.out.println(builder.toString());
    }

    private void println(String line) {
        builder.append(indent).append(line).append("\n");
    }

    private void indentMore() {
        indent += "  ";
    }

    private void indentLess() {
        if (indent.length() >= 2)
            indent = indent.substring(0, indent.length() - 2);
    }

    @Override
    public String visitProgram(ProgramNode node) {
        println("Program:");
        indentMore();
        for (AstNode stmt : node.getStatements()) {
            stmt.accept(this);
        }
        indentLess();
        return null;
    }

    @Override
    public String visitClassDeclaration(ClassDeclarationNode node) {
        println("Class: " + node.getName());
        indentMore();
        for (AstNode member : node.getMembers()) {
            member.accept(this);
        }
        indentLess();
        return null;
    }

    @Override
    public String visitInterfaceDeclaration(InterfaceDeclarationNode node) {
        println("Interface: " + node.getName());
        indentMore();
        for (AstNode member : node.getMembers()) {
            member.accept(this);
        }
        indentLess();
        return null;
    }

    @Override
    public String visitMethodDeclaration(MethodDeclarationNode node) {
        println("Method: " + node.getName());
        indentMore();
        for (ParameterNode param : node.getParameters()) {
            println("Param: " + param.getName() + " : " + param.getType());
        }
        for (AstNode stmt : node.getBody()) {
            stmt.accept(this);
        }
        indentLess();
        return null;
    }

    @Override
    public String visitParameter(ParameterNode node) {
        println("Parameter: " + node.getName() + " : " + node.getType());
        return null;
    }

    @Override
    public String visitAssignment(AssignmentNode node) {
        println("Assignment: " + node.getIdentifier() + " = ");
        indentMore();
        node.getExpression().accept(this);
        indentLess();
        return null;
    }

    @Override
    public String visitBinaryExpression(BinaryExpressionNode node) {
        println("Binary Expression: " + node.getOperator());
        indentMore();
        node.getLeft().accept(this);
        node.getRight().accept(this);
        indentLess();
        return null;
    }

    @Override
    public String visitLiteral(LiteralNode node) {
        println("Literal: " + node.getValue());
        return null;
    }

    @Override
    public String visitFunctionCall(FunctionCallNode node) {
        println("FunctionCall: " + node.getFunctionName());
        indentMore();
        for (AstNode arg : node.getArguments()) {
            arg.accept(this);
        }
        indentLess();
        return null;
    }

    @Override
    public String visitVariableDeclaration(VariableDeclarationNode node) {
        println("VariableDeclaration kind: " + node.getKind() + ", identifier: " + node.getIdentifier());
        indentMore();
        if (node.getInitializer() != null) {
            node.getInitializer().accept(this);
        }
        indentLess();
        return null;
    }


    @Override
    public String visitComponentDeclaration(ComponentDeclarationNode node) {
        println("Component: " + node.getSelector() + ", standalone: " + node.isStandalone());
        indentMore();

        // طباعة template
        if (node.getTemplate() != null) {
            node.getTemplate().accept(this);
        }

        // طباعة styles
        if (node.getStyles() != null) {
            for (StyleNode style : node.getStyles()) {
                style.accept(this);
            }
        }

        indentLess();
        return null;
    }




    @Override
    public String visitTextNode(TextNode node) {
        println("Text: " + node.getText());
        return null;
    }

    @Override
    public String visitInterpolationNode(InterpolationNode node) {
        println("Interpolation: {{ " + node.getExpression() + " }}");
        return null;
    }

    @Override
    public String visitCssRuleNode(CssRuleNode node) {
        println("CSS Rule: " + node.getSelector());
        indentMore();
        for (CssPropertyNode prop : node.getProperties()) {
            prop.accept(this);
        }
        indentLess();
        return null;
    }

    @Override
    public String visitCssPropertyNode(CssPropertyNode node) {
        println("CSS Property: " + node.getName() + " = " + node.getValue());
        return null;
    }

    @Override
    public String visitTagNode(TagNode node) {
        println("Tag: <" + node.getTagName() + ">");
        indentMore();
        for (var attr : node.getAttributes().entrySet()) {
            println("Attr: " + attr.getKey() + " = " + attr.getValue());
        }
        for (AstNode child : node.getChildren()) {
            child.accept(this);
        }
        indentLess();
        return null;
    }

    @Override
    public String visitSelfClosingTagNode(SelfClosingTagNode node) {
        println("SelfClosingTag: <" + node.getTagName() + " />");
        indentMore();
        for (var attr : node.getAttributes().entrySet()) {
            println("Attr: " + attr.getKey() + " = " + attr.getValue());
        }
        indentLess();
        return null;
    }

    @Override
    public String visitImportDeclaration(ImportDeclarationNode node) {
        println("Import: " + node.getImportName() + " from \"" + node.getFromPath() + "\"");
        return null;
    }




}