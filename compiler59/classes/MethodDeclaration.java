package classes;

import java.util.ArrayList;
import java.util.List;

public class MethodDeclaration {
    String name ;
    ParameterList parameterLists ;
    TypeV typeReturn ;
    MethodBody methodBody;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParameterList getParameterLists() {
        return parameterLists;
    }

    public void setParameterLists(ParameterList parameterLists) {
        this.parameterLists = parameterLists;
    }

    public TypeV getTypeReturn() {
        return typeReturn;
    }

    public void setTypeReturn(TypeV typeReturn) {
        this.typeReturn = typeReturn;
    }

    public MethodBody getMethodBody() {
        return methodBody;
    }

    public void setMethodBody(MethodBody methodBody) {
        this.methodBody = methodBody;
    }

    @Override
    public String toString() {
        if(typeReturn==null && parameterLists!=null ) {
            return "\nMethodDeclaration {" +
                    "\nname ="+name +
                     ",\n" + parameterLists +
                     "\n{"+methodBody +
                     "\n}";
        }
        if(parameterLists==null && typeReturn!=null) {
            return "\nMethodDeclaration {" +
                    "\nname ="+name +
                    ",=" + typeReturn +
                    "\n {"+methodBody +

                    "\n}";
        }

        return "\nMethodDeclaration{" +
                "\nname='" + name + '\'' +
                ", \n=" + parameterLists +
                ", " + typeReturn +
                ", {" + methodBody +

                "\n}" ;
    }
}
