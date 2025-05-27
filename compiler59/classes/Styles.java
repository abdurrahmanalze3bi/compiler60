package classes;

public class Styles {
CssBody cssBody ;

    public CssBody getCssBody() {
        return cssBody;
    }

    public void setCssBody(CssBody cssBody) {
        this.cssBody = cssBody;
    }

    @Override
    public String toString() {
        return "\nStyles{" +
                "\n" + cssBody +
                "\n}";
    }
}
