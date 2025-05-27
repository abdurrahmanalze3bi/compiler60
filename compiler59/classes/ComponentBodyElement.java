package classes;

public class ComponentBodyElement {
    Selector selector  ;
    Standalone standalone ;
    ImportDeclaration importDeclaration ;
    Template  template ;
    Styles styles ;

    public Selector getSelector() {

        return selector;
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    public Standalone getStandalone() {
        return standalone;
    }

    public void setStandalone(Standalone standalone) {
        this.standalone = standalone;
    }

    public ImportDeclaration getImportDeclaration() {
        return importDeclaration;
    }

    public void setImportDeclaration(ImportDeclaration importDeclaration) {
        this.importDeclaration = importDeclaration;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public Styles getStyles() {
        return styles;
    }

    public void setStyles(Styles styles) {
        this.styles = styles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nComponentBodyElement {");

        if (selector != null) {
            sb.append("\n  ").append(selector);
        }
        if (standalone != null) {
            sb.append(",\n ").append(standalone);
        }
        if (importDeclaration != null) {
            sb.append(",\n ").append(importDeclaration);
        }
        if (template != null) {
            sb.append(",\n ").append(template);
        }
        if (styles != null) {
            sb.append(",\n  ").append(styles);
        }

        sb.append("\n}");
        return sb.toString();
    }

}
