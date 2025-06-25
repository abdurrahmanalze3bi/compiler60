package classes;

public class Expression {
    String string ;
    IsBoolean isboolean;
    VariableDeclaration variableDeclaration ;
    FunctionCall functionCall ;

    private MemberAccess memberAccess;

    // ... constructors and other methods ...

    public void setMemberAccess(MemberAccess memberAccess) {
        this.memberAccess = memberAccess;
    }

    public MemberAccess getMemberAccess() {
        return memberAccess;
    }
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }


    public IsBoolean isIsboolean() {
        return isboolean;
    }

    public void setIsboolean(IsBoolean isboolean) {
        this.isboolean = isboolean;
    }

    public VariableDeclaration getVariableDeclaration() {
        return variableDeclaration;
    }

    public void setVariableDeclaration(VariableDeclaration variableDeclaration) {
        this.variableDeclaration = variableDeclaration;
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    public void setFunctionCall(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    @Override
    public String toString() {

        if(variableDeclaration!=null) {
            return "\nExpression {" +
                    "\n" +variableDeclaration +
                    "\n}";
        }
        if(functionCall!=null) {
            return "\nExpression {" +
                    "\n" +functionCall +
                    "\n}";
        }
        return "\nExpression {" +
                "\nstring" + string +
                "\n}";


    } }