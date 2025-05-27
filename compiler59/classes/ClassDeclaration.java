package classes;

public class ClassDeclaration {
    String id;
    ClassDeclarationBody classDeclarationBody ;

    public ClassDeclarationBody getClassDeclarationBody() {
        return classDeclarationBody;
    }

    public void setClassDeclarationBody(ClassDeclarationBody classDeclarationBody) {
        this.classDeclarationBody = classDeclarationBody;
    }

    public String getNameClass() {
        return id;
    }

    public void setNameClass(String nameClass) {
        this.id = nameClass;
    }


    @Override
    public String toString() {
        return "\nClassDeclaration{" +
                "\nnameClass='" + id + '\'' +
                ",\n" + classDeclarationBody +
                "\n}";
    }
}
