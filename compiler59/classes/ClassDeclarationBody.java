package classes;

import java.util.ArrayList;
import java.util.List;

public class ClassDeclarationBody {
    List<ClassMember> classMembers =new ArrayList<>();

    public List<ClassMember> getClassMembers() {
        return classMembers;
    }

    public void setClassMembers(List<ClassMember> classMembers) {
        this.classMembers = classMembers;
    }

    @Override
    public String toString() {
        return "\nClassDeclarationBody{" +
                "\n" + classMembers +
                "\n}";
    }
}
