package classes;

import java.util.ArrayList;
import java.util.List;

public class MethodBody {
  List<StatementMethod>statementMethods =new ArrayList<>();

    public List<StatementMethod> getStatementMethods() {
        return statementMethods;
    }

    public void setStatementMethods(List<StatementMethod> statementMethods) {
        this.statementMethods = statementMethods;
    }

    @Override
    public String toString() {
        return "\nMethodBody{" +
                "\n" + statementMethods +
                "\n}";
    }
}
