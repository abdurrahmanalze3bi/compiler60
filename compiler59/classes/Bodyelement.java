package classes;

public class Bodyelement {
    String Id_css ;
    CssValue cssValue;

    public String getId_css() {
        return Id_css;
    }

    public void setId_css(String id_css) {
        Id_css = id_css;
    }

    public CssValue getCssValue() {
        return cssValue;
    }

    public void setCssValue(CssValue cssValue) {
        this.cssValue = cssValue;
    }

    @Override
    public String toString() {
        return "\nBodyelement{" +
                "\nId_css='" + Id_css + '\'' +
                ", \n=" + cssValue +
                "\n}";
    }
}
