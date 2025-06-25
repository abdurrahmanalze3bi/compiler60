package MyAst.AST;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import gen.typescriptparser;
import gen.typescriptparserBaseVisitor;

public class AstBuilderVisitor extends typescriptparserBaseVisitor<AstNode> {

    @Override
    public AstNode visitProgram(typescriptparser.ProgramContext ctx) {
        List<AstNode> statements = new ArrayList<>();
        for (var stmtCtx : ctx.statement()) {
            AstNode stmt = visit(stmtCtx);
            if (stmt != null) {
                statements.add(stmt);
            }
        }
        return new ProgramNode(statements);
    }

    @Override
    public AstNode visitClassDeclaration(typescriptparser.ClassDeclarationContext ctx) {
        String name = ctx.ID().getText();
        List<AstNode> members = new ArrayList<>();
        if (ctx.classDeclarationBody() != null) {
            for (var memberCtx : ctx.classDeclarationBody().classMember()) {
                AstNode member = visit(memberCtx);
                if (member != null) {
                    members.add(member);
                }
            }
        }

        boolean isExported = ctx.EXPORT() != null; //
        return new ClassDeclarationNode(name, members, isExported);
    }


    @Override
    public AstNode visitInterfaceDeclaration(typescriptparser.InterfaceDeclarationContext ctx) {
        String name = ctx.ID().getText();
        List<AstNode> members = new ArrayList<>();
        for (var memberCtx : ctx.interfaceMember()) {
            AstNode member = visit(memberCtx);
            if (member != null) {
                members.add(member);
            }
        }
        return new InterfaceDeclarationNode(name, members);
    }

    @Override
    public AstNode visitMethodDeclaration(typescriptparser.MethodDeclarationContext ctx) {
        String name = ctx.ID().getText();

        List<ParameterNode> params = new ArrayList<>();
        if (ctx.parameterList() != null) {
            for (var paramCtx : ctx.parameterList().parameter()) {
                params.add((ParameterNode) visit(paramCtx));
            }
        }

        // ✅ استخراج نوع الإرجاع
        String returnType = ctx.type() != null ? ctx.type().getText() : "void";

        List<AstNode> body = new ArrayList<>();
        if (ctx.methodBody() != null) {
            for (var stmt : ctx.methodBody().statementMethod()) {
                AstNode statement = visit(stmt);
                if (statement != null) {
                    body.add(statement);
                }
            }
        }

        // ✅ تمرير كل القيم المطلوبة
        return new MethodDeclarationNode(name, params, returnType, body);
    }


    @Override
    public AstNode visitParameter(typescriptparser.ParameterContext ctx) {
        return new ParameterNode(ctx.ID().getText(), ctx.type().getText());
    }

    @Override
    public AstNode visitAssignmentStatement(typescriptparser.AssignmentStatementContext ctx) {
        String id = ctx.ID().getText();
        AstNode expr = visit(ctx.expression());
        return new AssignmentNode(id, expr);
    }

    @Override
    public AstNode visitExpression(typescriptparser.ExpressionContext ctx) {
        if (ctx.NUMBER_LIT() != null) {
            return new LiteralNode(Integer.parseInt(ctx.NUMBER_LIT().getText()));
        } else if (ctx.STRING_LIT() != null) {
            return new LiteralNode(ctx.STRING_LIT().getText());
        } else if (ctx.ID() != null) {
            return new LiteralNode(ctx.ID().getText());
        } else if (ctx.operator() != null) {
            AstNode left = visit(ctx.expression(0));
            String op = ctx.operator().getText();
            AstNode right = visit(ctx.expression(1));
            return new BinaryExpressionNode(left, op, right);
        } else if (ctx.functionCall() != null) {
            return visit(ctx.functionCall());
        }
        return null;
    }

    @Override
    public AstNode visitFunctionCall(typescriptparser.FunctionCallContext ctx) {
        String name = ctx.ID().getText();
        List<AstNode> args = new ArrayList<>();
        for (var argCtx : ctx.argument()) {
            AstNode arg = visit(argCtx);
            if (arg != null) {
                args.add(arg);
            }
        }
        return new FunctionCallNode(name, args);
    }

    @Override
    public AstNode visitComponentDeclaration(typescriptparser.ComponentDeclarationContext ctx) {
        String selector = "";
        boolean standalone = false;
        TemplateNode template = null;
        List<StyleNode> styles = new ArrayList<>();

        for (var elemCtx : ctx.componentDeclarationBody().componentBodyElement()) {
            if (elemCtx.selector() != null) {
                selector = elemCtx.selector().STRING_LIT().getText().replace("\"", "");
            } else if (elemCtx.standalone() != null) {
                standalone = elemCtx.standalone().isboolean().TRUE() != null;
            } else if (elemCtx.template() != null) {
                AstNode tempNode = visit(elemCtx.template());
                if (tempNode instanceof TemplateNode) {
                    template = (TemplateNode) tempNode;
                }
            } else if (elemCtx.styles() != null) {
                AstNode styleNode = visit(elemCtx.styles());
                if (styleNode instanceof StyleNode) {
                    styles.add((StyleNode) styleNode);
                }
            }
        }

        return new ComponentDeclarationNode(selector, standalone, template, styles);
    }



    @Override
    public AstNode visitTemplate(typescriptparser.TemplateContext ctx) {
        List<HtmlElementNode> children = new ArrayList<>();
        for (var element : ctx.element()) {
            AstNode child = visit(element);
            if (child instanceof HtmlElementNode) {
                children.add((HtmlElementNode) child);
            }
        }
        return new TemplateNode(children);
    }


    @Override
    public AstNode visitTag(typescriptparser.TagContext ctx) {
        if (ctx.selfClosingTag()!=null && ctx.selfClosingTag().getText() != null) {
            return visit(ctx.selfClosingTag()); // يُفترض أن يرجع SelfClosingTagNode ويرث من HtmlElementNode
        } else {
            String tagName = ctx.openingTag().TAG_OPEN_START_HTML().getText();
            Map<String, String> attrs = new HashMap<>();
            for (var attr : ctx.openingTag().attributes()) {
                attrs.put(attr.NAME_HTML().getText(), attr.STRING_HTML().getText());
            }

            List<HtmlElementNode> children = new ArrayList<>();
            for (var elem : ctx.element()) {
                AstNode child = visit(elem);
                if (child instanceof HtmlElementNode) {
                    children.add((HtmlElementNode) child);
                }
            }

            return new TagNode(tagName, attrs, children);
        }
    }

    @Override
    public AstNode visitSelfClosingTag(typescriptparser.SelfClosingTagContext ctx) {
        String tagName = ctx.TAG_OPEN_START_HTML().getText();
        Map<String, String> attrs = new HashMap<>();
        for (var attr : ctx.attributes()) {
            attrs.put(attr.NAME_HTML().getText(), attr.STRING_HTML().getText());
        }
        return new SelfClosingTagNode(tagName, attrs);
    }

    @Override
    public AstNode visitInterpolation(typescriptparser.InterpolationContext ctx) {
        return new InterpolationNode(ctx.NAME_HTML().getText());
    }

    @Override
    public AstNode visitCssBody(typescriptparser.CssBodyContext ctx) {
        List<CssRuleNode> rules = new ArrayList<>();
        for (var ruleCtx : ctx.cssObjects().csselement()) {
            rules.add((CssRuleNode) visit(ruleCtx));
        }
        return new StyleNode(rules);
    }

    @Override
    public AstNode visitCsselement(typescriptparser.CsselementContext ctx) {
        String selector = ctx.DOT_CSS().getText();
        List<CssPropertyNode> props = new ArrayList<>();
        for (var body : ctx.bodyelement()) {
            props.add((CssPropertyNode) visit(body));
        }
        return new CssRuleNode(selector, props);
    }

    @Override
    public AstNode visitBodyelement(typescriptparser.BodyelementContext ctx) {
        String name = ctx.ID_CSS().getText(); // ✔️ هذا عنصر واحد، لا داعي لـ get(0)
        String value = ctx.cssValue().getText();
        return new CssPropertyNode(name, value);
    }
}

