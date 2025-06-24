package classes;

import java.util.ArrayList;
import java.util.List;
public class CssElement {
    // Existing fields
    private List<Bodyelement> bodyCssElements = new ArrayList<>();

    // New field for CSS selectors
    private List<String> selectors = new ArrayList<>();

    // Existing methods
    public List<Bodyelement> getBodyCssElements() {
        return bodyCssElements;
    }

    public void addBodyCssElement(Bodyelement element) {
        bodyCssElements.add(element);
    }

    // New methods for selectors
    public List<String> getSelectors() {
        return selectors;
    }

    public void addSelector(String selector) {
        selectors.add(selector);
    }
}