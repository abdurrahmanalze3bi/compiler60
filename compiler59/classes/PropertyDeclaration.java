package classes;

import java.util.ArrayList;
import java.util.List;

public class PropertyDeclaration {
    private List<String> ID = new ArrayList<>();
    private TypeV typeV;
    private Initvalue initvalue;
    private String unionType;  // New field for union types

    // ================= GETTERS & SETTERS =================
    public List<String> getID() {
        return ID;
    }

    public void setID(List<String> ID) {
        this.ID = ID;
    }

    // FIXED: Added setInitValue method that was missing
    public void setInitValue(Initvalue initvalue) {
        this.initvalue = initvalue;
    }

    public TypeV getTypeV() {
        return typeV;
    }

    public void setTypeV(TypeV typeV) {
        this.typeV = typeV;
    }

    public Initvalue getInitvalue() {
        return initvalue;
    }

    public void setInitvalue(Initvalue initvalue) {
        this.initvalue = initvalue;
    }

    // New getter and setter for unionType
    public String getUnionType() {
        return unionType;
    }

    public void setUnionType(String unionType) {
        this.unionType = unionType;
    }

    // ================= TOSTRING =================
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nPropertyDeclaration{");

        if (!ID.isEmpty()) {
            sb.append("\n  ID=").append(ID);
        }
        if (typeV != null) {
            sb.append("\n  typeV=").append(typeV);
        }
        if (initvalue != null) {
            sb.append("\n  initvalue=").append(initvalue);
        }
        if (unionType != null) {
            sb.append("\n  unionType='").append(unionType).append('\'');
        }

        sb.append("\n}");
        return sb.toString();
    }
}