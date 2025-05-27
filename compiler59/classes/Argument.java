package classes;

public class Argument {
    Expression expression ;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "\nArgument{" +
                "\n=" + expression +
                "\n}";
    }
}
