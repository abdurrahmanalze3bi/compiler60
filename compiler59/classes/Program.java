package classes;

import java.util.ArrayList;
import java.util.List;

public class Program {
    List<Statment> statments = new ArrayList<>();

    public List<Statment> getStatments() {
        return statments;
    }

    public void setStatments(List<Statment> statments) {
        this.statments = statments;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(); // Use StringBuilder for efficiency
        result.append("\n Program {");

        for (int i = 0; i < statments.size(); i++) {
            if (statments.get(i).getClassDeclaration() != null) {
                result.append("\n statments =")
                        .append("\n").append(statments.get(i).getClassDeclaration());
            }
            if (statments.get(i).getComponentDeclaration() != null) {
                result.append("\n statments =")
                        .append("\n").append(statments.get(i).getComponentDeclaration());
            }
            if (statments.get(i).getImportDeclaration() != null) {
                result.append("\n statments =")
                        .append("\n").append(statments.get(i).getImportDeclaration());
            }
            if (statments.get(i).getMethodDeclaration() != null) {
                result.append("\n statments=")
                        .append("\n").append(statments.get(i).getMethodDeclaration());
            }
            if (statments.get(i).getVariableDeclaration() != null) {
                result.append("\n statments=")
                        .append("\n").append(statments.get(i).getVariableDeclaration());
            }
            if (statments.get(i).getInterfaceDeclaration() != null) {
                result.append("\n statments= ")
                        .append("\n").append(statments.get(i).getInterfaceDeclaration());
            }
        }

        result.append("\n }");
        return result.toString(); // Return the full result after the loop
    }

}
