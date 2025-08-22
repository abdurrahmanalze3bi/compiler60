package classes;

import java.util.ArrayList;
import java.util.List;

public class OpeningTag {
    private String name;
    List<Attributes> attributes = new ArrayList<>();
    public List<Attributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attributes> attributes) {
        this.attributes = attributes;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        if(attributes!=null){
            return "\nOpeningTag{" +
                    attributes +
                    "\n}";
        }
        return "";
        }

}
