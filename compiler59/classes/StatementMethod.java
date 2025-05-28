package classes;

import java.util.ArrayList;
import java.util.List;

public class StatementMethod {
    String This ;
    List<String> variable =new ArrayList<>();
    Expression expression ;

    boolean isreturn ;
    ReturnN returnN ;

    public boolean isIsreturn() {
        return isreturn;
    }

    public void setIsreturn(boolean isreturn) {
        this.isreturn = isreturn;
    }

    public ReturnN getReturnN() {
        return returnN;
    }

    public void setReturnN(ReturnN returnN) {
        this.returnN = returnN;
    }

    public String getThis() {
        return This;
    }

    public void setThis(String aThis) {
        This = aThis;
    }

    public List<String> getVariable() {
        return variable;
    }

    public void setVariable(List<String> variable) {
        this.variable = variable;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {

        if(variable!=null) {
            return "\nStatementMethod{" +
                    "\n variable =" + variable +
                    "\n}";
        }
        if(expression!=null){

            return
                   "\nStatementMethod{" +
                   ",\n" + expression +
                   "\n}";
        }
        if(returnN!=null){
            return
                    "\nStatementMethod{" +
                    "\n" + returnN +
                    "\n}";
        }

        return
             "\nStatementMethod{" +
             ",\n" + This +
             "\n}";

    }
}
