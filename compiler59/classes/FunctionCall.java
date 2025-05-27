package classes;

import java.util.ArrayList;
import java.util.List;

public class FunctionCall {
    String nameFun;
    List<Argument> arguments =new ArrayList<>();

    public List<Argument> getArguments() {
        return arguments;
    }

    public String getNameFun() {
        return nameFun;
    }

    public void setNameFun(String nameFun) {
        this.nameFun = nameFun;
    }

    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        if(arguments==null)
            return "\nFunctionCall{" +
                    "\n name"+nameFun+

                    "\n}";


        return "\nFunctionCall{" +
                "\n name"+nameFun+
                "\n" + arguments +
                "\n}";
    }
}
