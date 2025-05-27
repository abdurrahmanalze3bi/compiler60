package classes;

import java.util.ArrayList;
import java.util.List;

public class CssObjects {
    List<CssElement> cssElementlist =new ArrayList<CssElement>();

    public List<CssElement> getCssElementlist() {
        return cssElementlist;
    }

    public void setCssElementlist(List<CssElement> cssElementlist) {
        this.cssElementlist = cssElementlist;
    }

    @Override
    public String toString() {
        return "\nCssObjects{" +
                "\n" + cssElementlist +
                "\n}";
    }
}
