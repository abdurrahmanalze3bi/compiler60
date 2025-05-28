package classes;

public class AssignmentStatement {
    String variable ;
    Expression expression ;



    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }



    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }



    @Override
    public String toString() {
     if(variable != null){
         return  "AssignmentStatement {" +
                 "variable = "+variable+
                 "}";
     } else if (expression != null) {
         return  "AssignmentStatement {" +
                 "expression = "+expression+
                 "}";
     }
return  "";
    }
}
