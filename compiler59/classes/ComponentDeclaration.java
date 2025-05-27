package classes;

public class ComponentDeclaration {
    String decorato ;
    ComponentDeclarationBody componentDeclarationBody ;

    public String getDecorato() {
        return decorato;
    }

    public void setDecorato(String decorato) {
        this.decorato = decorato;
    }

    public ComponentDeclarationBody getComponentDeclarationBody() {
        return componentDeclarationBody;
    }

    public void setComponentDeclarationBody(ComponentDeclarationBody componentDeclarationBody) {
        this.componentDeclarationBody = componentDeclarationBody;
    }

    @Override
    public String toString() {

        return "\nComponentDeclaration{" +
                "\ndecorato='" + decorato + '\'' +
                ",\n =" + componentDeclarationBody +
                "\n}";
    }
}
