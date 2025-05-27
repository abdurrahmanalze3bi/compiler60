package classes;

public class Parameter {
String name ;
TypeV typeV ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeV getTypeV() {
        return typeV;
    }

    public void setTypeV(TypeV typeV) {
        this.typeV = typeV;
    }

    @Override
    public String toString() {
        return "\nParameter{" +
                "\nname='" + name + '\'' +
                ", \ntypeV=" + typeV +
                "\n}";
    }
}
