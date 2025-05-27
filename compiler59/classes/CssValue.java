package classes;

import java.util.ArrayList;
import java.util.List;

public class CssValue {
  List <String> ID_CSS  =new ArrayList<>();

    public List<String> getID_CSS() {
        return ID_CSS;
    }

    public void setID_CSS(List<String> ID_CSS) {
        this.ID_CSS = ID_CSS;
    }

    @Override
    public String toString() {
        return "\nCssValue{" +
                "\nID_CSS='" + ID_CSS + '\'' +
                "\n}";
    }
}
