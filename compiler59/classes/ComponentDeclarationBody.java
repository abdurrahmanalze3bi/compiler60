package classes;

import java.util.ArrayList;
import java.util.List;

public class ComponentDeclarationBody {
List<ComponentBodyElement> componentBodyElements =new ArrayList<ComponentBodyElement>();

    public List<ComponentBodyElement> getComponentBodyElements() {
        return componentBodyElements;
    }

    public void setComponentBodyElements(List<ComponentBodyElement> componentBodyElements) {
        this.componentBodyElements = componentBodyElements;
    }

    @Override
    public String toString() {
        return "\nComponentDeclarationBody{" +
                "\n=" + componentBodyElements +
                "\n}";
    }
}
