package classes;

import java.util.ArrayList;
import java.util.List;

public class InterfaceDeclaration {
    private String nameInterface; // Add this field for the interface name
    private List<InterfaceMember> interfaceMembers = new ArrayList<>();

    // Getter and setter for interface name
    public String getNameInterface() {
        return nameInterface;
    }

    public void setNameInterface(String nameInterface) {
        this.nameInterface = nameInterface;
    }

    // Existing getters and setters for interface members
    public List<InterfaceMember> getInterfaceMembers() {
        return interfaceMembers;
    }

    public void setInterfaceMembers(List<InterfaceMember> interfaceMembers) {
        this.interfaceMembers = interfaceMembers;
    }

    @Override
    public String toString() {
        return "\nInterfaceDeclaration{" +
                "\nname='" + nameInterface + '\'' +
                "\n" + interfaceMembers +
                "\n}";
    }
}