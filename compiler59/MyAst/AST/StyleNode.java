package MyAst.AST;

import java.util.List;

public class StyleNode extends AstNode {
    private final List<CssRuleNode> rules;

    public StyleNode(List<CssRuleNode> rules) {
        this.rules = rules;
    }

    public List<CssRuleNode> getRules() {
        return rules;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return null;
    }
}

