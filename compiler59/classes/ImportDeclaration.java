package classes;

public class ImportDeclaration {
    String id ;
    String string_lit ;

    public String getString_lit() {
        return string_lit;
    }

    public void setString_lit(String string_lit) {
        this.string_lit = string_lit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\nImportDeclaration{" +
                "\nid='" + id + '\'' +
                ",\nstring='" + string_lit + '\'' +
                "\n}";
    }
}
