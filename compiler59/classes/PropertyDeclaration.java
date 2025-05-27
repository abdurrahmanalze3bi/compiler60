package classes;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PropertyDeclaration {
    private List<String> ID = new ArrayList<>();  // Initialize the list to avoid null pointer exception
    private TypeV typeV;
    private Initvalue initvalue;

    // Getters and Setters
    public List<String> getID() {
        return ID;
    }

    public void setID(List<String> ID) {
        this.ID = ID;
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

    @Override
    public String toString() {
        if (initvalue != null) {
            return "\nPropertyDeclaration{" +
                     initvalue + '\'' +
                    "\n}";
        }

  if(ID!=null){
      return  "\nPropertyDeclaration{" +
             "\nID=" + ID + '\'' +
              "\n}";

        }
            return  "\nPropertyDeclaration{" +
                    typeV + '\'' +
                    "\n}";




    }
}
