package classes;

public class ReturnN {
    private String valueReturn;
    private IsBoolean  boolReturn;  // Wrapper Boolean so it can be null
Expression expressionReturn;

    public Expression getExpressionReturn() {
        return expressionReturn;
    }

    public void setExpressionReturn(Expression expressionReturn) {
        this.expressionReturn = expressionReturn;
    }

    public String getValueReturn() {
        return valueReturn;
    }

    public void setValueReturn(String valueReturn) {
        this.valueReturn = valueReturn;
    }

    public IsBoolean getBoolReturn() {
        return boolReturn;
    }

    public void setBoolReturn(IsBoolean boolReturn) {
        this.boolReturn = boolReturn;
    }

    @Override
    public String toString() {
        if (valueReturn != null) {
            return "return { " +
                    "\n" +
                    " valueReturn = " + valueReturn + "\n" +
                    "}\n";
        } else if (boolReturn != null) {
            return "return {\n" +
                    "  boolReturn = " + boolReturn + "\n" +
                    "}\n";
        }
        else if (expressionReturn != null) {
            return "return {\n" +
                    "  expressionReturn = " + expressionReturn + "\n" +
                    "}\n";
        }

        return "";
    }
}