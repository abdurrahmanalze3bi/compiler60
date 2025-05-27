package classes;

public class CssBody {
    CssObjects cssObjects ;

    public CssObjects getCssObjects() {
        return cssObjects;
    }

    public void setCssObjects(CssObjects cssObjects) {
        this.cssObjects = cssObjects;
    }

    @Override
    public String toString() {
        return "\nCssBody{" +
                "\n=" + cssObjects +
                "\n}";
    }
}
