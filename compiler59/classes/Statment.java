package classes;

public class Statment {

    ComponentDeclaration componentDeclaration ;
    ClassDeclaration classDeclaration;
    InterfaceDeclaration interfaceDeclaration ;
    MethodDeclaration methodDeclaration ;
    VariableDeclaration variableDeclaration ;
    ImportDeclaration importDeclaration ;

    public ComponentDeclaration getComponentDeclaration() {
        return componentDeclaration;
    }

    public void setComponentDeclaration(ComponentDeclaration componentDeclaration) {
        this.componentDeclaration = componentDeclaration;
    }

    public ClassDeclaration getClassDeclaration() {
        return classDeclaration;
    }

    public void setClassDeclaration(ClassDeclaration classDeclaration) {
        this.classDeclaration = classDeclaration;
    }

    public InterfaceDeclaration getInterfaceDeclaration() {
        return interfaceDeclaration;
    }

    public void setInterfaceDeclaration(InterfaceDeclaration interfaceDeclaration) {
        this.interfaceDeclaration = interfaceDeclaration;
    }

    public MethodDeclaration getMethodDeclaration() {
        return methodDeclaration;
    }

    public void setMethodDeclaration(MethodDeclaration methodDeclaration) {
        this.methodDeclaration = methodDeclaration;
    }

    public VariableDeclaration getVariableDeclaration() {
        return variableDeclaration;
    }

    public void setVariableDeclaration(VariableDeclaration variableDeclaration) {
        this.variableDeclaration = variableDeclaration;
    }

    public ImportDeclaration getImportDeclaration() {
        return importDeclaration;
    }

    public void setImportDeclaration(ImportDeclaration importDeclaration) {
        this.importDeclaration = importDeclaration;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Statment {");

        boolean hasPrevious = false;

        if (componentDeclaration != null) {
            sb.append("\n  componentDeclaration=").append(componentDeclaration);
            hasPrevious = true;
        }
        if (classDeclaration != null) {
            if (hasPrevious) sb.append(",");
            sb.append("\n  classDeclaration=").append(classDeclaration);
            hasPrevious = true;
        }
        if (interfaceDeclaration != null) {
            if (hasPrevious) sb.append(",");
            sb.append("\n  interfaceDeclaration=").append(interfaceDeclaration);
            hasPrevious = true;
        }
        if (methodDeclaration != null) {
            if (hasPrevious) sb.append(",");
            sb.append("\n  methodDeclaration=").append(methodDeclaration);
            hasPrevious = true;
        }
        if (variableDeclaration != null) {
            if (hasPrevious) sb.append(",");
            sb.append("\n  variableDeclaration=").append(variableDeclaration);
            hasPrevious = true;
        }
        if (importDeclaration != null) {
            if (hasPrevious) sb.append(",");
            sb.append("\n  importDeclaration=").append(importDeclaration);
        }

        sb.append("\n}");
        return sb.toString();
    }

}

