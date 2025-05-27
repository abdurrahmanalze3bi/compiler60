package classes;

import java.util.ArrayList;
import java.util.List;

public class CssElement {
    List<Bodyelement> bodyElements =new ArrayList<>();

    public List<Bodyelement> getBodyCssElements() {
        return bodyElements;
    }

    public void setBodyCssElements(List<Bodyelement> bodyCssElements) {
        this.bodyElements = bodyCssElements;
    }

    @Override
    public String toString() {
        return "\nCssElement{" +
                "\nbodyElements=" + bodyElements +
                "\n}";
    }
}
