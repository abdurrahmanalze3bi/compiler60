package classes;

public class VariableDeclaration {
    String name;
    String constv ;
    String let ;
    String var ;
Expression expression;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public String getConstv() {
        return constv;
    }

    public void setConstv(String constv) {
        this.constv = constv;
    }

    public String getLet() {
        return let;
    }

    public void setLet(String let) {
        this.let = let;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public String toString() {
        if(let!=null) {
            return "\nVariableDeclaration{" +
                    "\nlet =" +let +
                     "\nname=" +name +
                    "\n expression {" +expression +
                    "\n}";
        }
        if(constv!=null) {
            return "\nVariableDeclaration{" +
                    "\nconst =" +constv +
                    "\nname=" +name +
                    "\n expression {" +expression +
                    "\n}";
        }


        return "\nVariableDeclaration{" +

                "\n var=" + var + '\'' +
                "\nname=" +name +
                "\n expression {" +expression +
                "\n}";
    }
}
