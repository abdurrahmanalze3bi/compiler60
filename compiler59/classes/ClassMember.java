package classes;

public class ClassMember {
    PropertyDeclaration propertyDeclaration;
    MethodDeclaration methodDeclaration ;
    ClassDeclaration classDeclaration;

    public ClassDeclaration getClassDeclaration() {
        return classDeclaration;
    }

    public void setClassDeclaration(ClassDeclaration classDeclaration) {
        this.classDeclaration = classDeclaration;
    }

    public PropertyDeclaration getPropertyDeclaration() {
        return propertyDeclaration;
    }

    public void setPropertyDeclaration(PropertyDeclaration propertyDeclaration) {
        this.propertyDeclaration = propertyDeclaration;
    }

    public MethodDeclaration getMethodDeclaration() {
        return methodDeclaration;
    }

    public void setMethodDeclaration(MethodDeclaration methodDeclaration) {
        this.methodDeclaration = methodDeclaration;
    }

    @Override
    public String toString() {
        // Case 1: Only propertyDeclaration is not null
        if (propertyDeclaration != null && methodDeclaration == null && classDeclaration == null) {
            return "\nClassMember{" +
                    "\n " + propertyDeclaration +
                    "\n}";
        }
        // Case 2: Only methodDeclaration is not null
        else if (methodDeclaration != null && propertyDeclaration == null && classDeclaration == null) {
            return "\nClassMember{" +
                    "\n " + methodDeclaration +
                    "\n}";
        }
        // Case 3: Only classDeclaration is not null
        else if (classDeclaration != null && propertyDeclaration == null && methodDeclaration == null) {
            return "\nClassMember{" +
                    "\n " + classDeclaration +
                    "\n}";
        }
        // Case 4: Multiple or all fields are not null - show all non-null fields
        else {
            StringBuilder sb = new StringBuilder("\nClassMember{");
            if (propertyDeclaration != null) {
                sb.append("\n ").append(propertyDeclaration);
            }
            if (methodDeclaration != null) {
                sb.append("\n ").append(methodDeclaration);
            }
            if (classDeclaration != null) {
                sb.append("\n ").append(classDeclaration);
            }
            sb.append("\n}");
            return sb.toString();
        }
    }
}
