package classes;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Data-Driven Vanilla Web Code Generator
 * Extracts actual component data from Symbol Table and AST
 * Generates functional UI based on discovered properties and templates
 */
public class VanillaWebCodeGenerator {
    private SymbolTable symbolTable;
    private EnhancedSemanticErrorManager errorManager;
    private ComponentAnalysis componentAnalysis;
    private TemplateAnalysis templateAnalysis;

    public VanillaWebCodeGenerator(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        this.errorManager = new EnhancedSemanticErrorManager(symbolTable);
        this.componentAnalysis = new ComponentAnalysis();
        this.templateAnalysis = new TemplateAnalysis();
    }

    public void generateFromAST(Program program, String outputDir) throws IOException {
        File dir = new File(outputDir);
        dir.mkdirs();

        // Extract ALL component data from AST and symbol table
        analyzeProgram(program);

        // Generate based on actual discovered components
        for (ComponentDeclaration comp : findComponents(program)) {
            String componentName = extractComponentName(comp);
            System.out.println(">>> Generating component: " + componentName);

            // Extract ALL component data before generation
            ComponentInfo componentInfo = extractCompleteComponentInfo(comp, program);
            componentAnalysis.addComponent(componentInfo);

            generateComponent(comp, outputDir, componentName, componentInfo);
        }

        // If no components found, check for standalone class with properties
        if (componentAnalysis.getComponents().isEmpty()) {
            generateFromClassAnalysis(program, outputDir);
        }
    }

    /**
     * Extract complete component information from AST
     */
    private ComponentInfo extractCompleteComponentInfo(ComponentDeclaration comp, Program program) {
        String componentName = extractComponentName(comp);
        ComponentInfo info = new ComponentInfo(componentName);

        // Extract selector
        String selector = extractActualSelector(comp);
        if (selector != null) {
            info.setSelector(selector);
        }

        // Extract template with actual HTML structure
        String templateContent = extractActualTemplate(comp);
        if (templateContent != null) {
            info.setTemplateContent(templateContent);
            // Parse template for variables and bindings
            parseTemplateForVariables(templateContent, info);
        }

        // Extract styles
        extractActualStyles(comp, info);

        // Find associated class and extract properties
        ClassDeclaration associatedClass = findAssociatedClass(comp, program);
        if (associatedClass != null) {
            extractClassProperties(associatedClass, info);
        }

        return info;
    }

    /**
     * Extract actual selector from component AST
     */
    private String extractActualSelector(ComponentDeclaration comp) {
        if (comp.getComponentDeclarationBody() == null) return null;

        for (ComponentBodyElement element : comp.getComponentDeclarationBody().getComponentBodyElements()) {
            if (element.getSelector() != null) {
                return element.getSelector().getSTRING_LIT()
                        .replaceAll("[\"']", "");
            }
        }
        return null;
    }

    /**
     * Extract actual template content from component AST
     */
    private String extractActualTemplate(ComponentDeclaration comp) {
        if (comp.getComponentDeclarationBody() == null) return null;

        for (ComponentBodyElement element : comp.getComponentDeclarationBody().getComponentBodyElements()) {
            if (element.getTemplate() != null) {
                return buildTemplateFromElements(element.getTemplate());
            }
        }
        return null;
    }

    /**
     * Build HTML template from Template AST elements
     */
    private String buildTemplateFromElements(Template template) {
        StringBuilder html = new StringBuilder();

        for (Element element : template.getElement()) {
            html.append(buildElementHTML(element));
        }

        return html.toString();
    }

    /**
     * Build HTML for individual elements
     */
    private String buildElementHTML(Element element) {
        StringBuilder html = new StringBuilder();

        if (element.getHtmlName() != null) {
            // Simple HTML element
            html.append("<").append(element.getHtmlName()).append(">");
            html.append("</").append(element.getHtmlName()).append(">");
        }

        if (element.getTag() != null) {
            html.append(buildTagHTML(element.getTag()));
        }

        if (element.getInterpolation() != null) {
            // Angular interpolation - convert to template placeholder
            String varName = element.getInterpolation().getNAME_HTML();
            html.append("<span class=\"").append(varName).append("-display\">")
                    .append("{{").append(varName).append("}}")
                    .append("</span>");
        }

        return html.toString();
    }

    /**
     * Build HTML for tag elements
     */
    private String buildTagHTML(Tag tag) {
        StringBuilder html = new StringBuilder();

        if (tag.getOpeningTag() != null && tag.getClosingTag() != null) {
            // Regular tag with opening/closing
            String tagName = extractTagName(tag.getOpeningTag());
            Map<String, String> attributes = extractAttributes(tag.getOpeningTag());

            html.append("<").append(tagName);

            // Add attributes
            for (Map.Entry<String, String> attr : attributes.entrySet()) {
                html.append(" ").append(attr.getKey()).append("=\"").append(attr.getValue()).append("\"");
            }

            html.append(">");

            // Add nested elements
            for (Element nested : tag.getElements()) {
                html.append(buildElementHTML(nested));
            }

            html.append("</").append(tagName).append(">");
        }

        if (tag.getSelfClosingTag() != null) {
            // Self-closing tag
            html.append("<").append("input"); // Default for self-closing

            for (Attributes attr : tag.getSelfClosingTag().getAttributes()) {
                String attrHTML = buildAttributeHTML(attr);
                if (!attrHTML.isEmpty()) {
                    html.append(" ").append(attrHTML);
                }
            }

            html.append(" />");
        }

        return html.toString();
    }

    /**
     * Extract tag name from opening tag
     */
    private String extractTagName(OpeningTag openingTag) {
        if (openingTag.getName() != null) {
            return openingTag.getName();
        }
        return "div"; // Only as discovered from actual parsing
    }

    /**
     * Extract attributes from opening tag
     */
    private Map<String, String> extractAttributes(OpeningTag openingTag) {
        Map<String, String> attributes = new HashMap<>();

        for (Attributes attr : openingTag.getAttributes()) {
            String[] attrPair = buildAttributeHTML(attr).split("=");
            if (attrPair.length == 2) {
                attributes.put(attrPair[0], attrPair[1].replaceAll("\"", ""));
            }
        }

        return attributes;
    }

    /**
     * Build attribute HTML from Attributes object
     */
    private String buildAttributeHTML(Attributes attr) {
        if (attr.getHtmlName() != null && attr.getHtmlString() != null) {
            return attr.getHtmlName() + "=" + attr.getHtmlString();
        }

        if (attr.getBinding() != null && attr.getHtmlString() != null) {
            // Property binding - convert to data attribute
            String propName = attr.getBinding().replaceAll("[\\[\\]]", "");
            String value = attr.getHtmlString().replaceAll("[\"']", "");
            return "data-" + propName + "=\"" + value + "\"";
        }

        if (attr.getEvent() != null && attr.getHtmlString() != null) {
            // Event binding - convert to data attribute for JS handling
            String eventName = attr.getEvent().replaceAll("[\\(\\)]", "");
            String handler = attr.getHtmlString().replaceAll("[\"']", "");
            return "data-event-" + eventName + "=\"" + handler + "\"";
        }

        if (attr.getStructuralDir() != null && attr.getHtmlString() != null) {
            // Structural directive - convert to template
            String directive = attr.getStructuralDir();
            String value = attr.getHtmlString().replaceAll("[\"']", "");

            if (directive.contains("ngFor")) {
                return "data-ng-for=\"" + value + "\"";
            }
            if (directive.contains("ngIf")) {
                return "data-ng-if=\"" + value + "\"";
            }
        }

        return "";
    }

    /**
     * Parse template for variables and bindings
     */
    private void parseTemplateForVariables(String templateContent, ComponentInfo info) {
        // Extract interpolation variables
        java.util.regex.Pattern interpolationPattern = java.util.regex.Pattern.compile("\\{\\{\\s*(\\w+)\\s*\\}\\}");
        java.util.regex.Matcher matcher = interpolationPattern.matcher(templateContent);

        while (matcher.find()) {
            String varName = matcher.group(1);
            templateAnalysis.addTemplateVariable(varName, "string");
        }

        // Extract property bindings
        java.util.regex.Pattern bindingPattern = java.util.regex.Pattern.compile("data-(\\w+)=\"([^\"]+)\"");
        matcher = bindingPattern.matcher(templateContent);

        while (matcher.find()) {
            String propName = matcher.group(1);
            String propValue = matcher.group(2);
            templateAnalysis.addTemplateVariable(propName, "any");
        }
    }

    /**
     * Extract actual styles from component
     */
    private void extractActualStyles(ComponentDeclaration comp, ComponentInfo info) {
        if (comp.getComponentDeclarationBody() == null) return;

        for (ComponentBodyElement element : comp.getComponentDeclarationBody().getComponentBodyElements()) {
            if (element.getStyles() != null) {
                String cssContent = extractCSSFromStyles(element.getStyles());
                info.setStyleContent(cssContent);
            }
        }
    }

    /**
     * Extract CSS content from Styles object
     */
    private String extractCSSFromStyles(Styles styles) {
        StringBuilder css = new StringBuilder();

        if (styles.getCssBody() != null && styles.getCssBody().getCssObjects() != null) {
            CssObjects cssObjects = styles.getCssBody().getCssObjects();

            for (CssElement rule : cssObjects.getCssElementlist()) {
                css.append(buildCSSRule(rule));
            }
        }

        return css.toString();
    }

    /**
     * Build CSS rule from CssElement
     */
    private String buildCSSRule(CssElement rule) {
        StringBuilder css = new StringBuilder();

        // Build selector
        if (rule.getSelectors() != null && !rule.getSelectors().isEmpty()) {
            css.append(String.join(", ", rule.getSelectors()));
        } else {
            return ""; // No fallback - only use discovered selectors
        }

        css.append(" {\n");

        // Build properties
        if (rule.getBodyCssElements() != null) {
            for (Bodyelement decl : rule.getBodyCssElements()) {
                css.append("    ").append(decl.getId_css()).append(": ");

                if (decl.getCssValue() != null && decl.getCssValue().getID_CSS() != null) {
                    css.append(String.join(" ", decl.getCssValue().getID_CSS()));
                } else {
                    continue; // Skip if no value discovered
                }

                css.append(";\n");
            }
        }

        css.append("}\n\n");

        return css.toString();
    }

    /**
     * Find associated class for component
     */
    private ClassDeclaration findAssociatedClass(ComponentDeclaration comp, Program program) {
        String componentName = extractComponentName(comp);
        String expectedClassName = componentName.replace("Component", "");

        for (Statment stmt : program.getStatments()) {
            if (stmt.getClassDeclaration() != null) {
                ClassDeclaration classDecl = stmt.getClassDeclaration();
                if (classDecl.getNameClass().toLowerCase().contains(expectedClassName.toLowerCase())) {
                    return classDecl;
                }
            }
        }

        return null;
    }

    /**
     * Extract properties from class declaration
     */
    private void extractClassProperties(ClassDeclaration classDecl, ComponentInfo info) {
        if (classDecl.getClassDeclarationBody() == null) return;

        ClassInfo classInfo = new ClassInfo(classDecl.getNameClass());

        for (ClassMember member : classDecl.getClassDeclarationBody().getClassMembers()) {
            if (member.getPropertyDeclaration() != null) {
                PropertyDeclaration prop = member.getPropertyDeclaration();
                if (!prop.getID().isEmpty()) {
                    String propName = prop.getID().get(0);
                    Object propValue = extractPropertyValue(prop);
                    String propType = determinePropertyType(propValue);

                    PropertyInfo propertyInfo = new PropertyInfo(propName, propType, propValue);
                    classInfo.addProperty(propertyInfo);

                    System.out.println(">>> Extracted property: " + propName + " = " + propValue + " (" + propType + ")");
                }
            }
        }

        componentAnalysis.addClassInfo(classInfo);
        info.setAssociatedClass(classInfo);
    }

    /**
     * Determine property type from value
     */
    private String determinePropertyType(Object value) {
        if (value == null) return "any";
        if (value instanceof String) return "string";
        if (value instanceof Number) return "number";
        if (value instanceof Boolean) return "boolean";
        if (value instanceof List) return "array";
        if (value instanceof Map) return "object";
        return "any";
    }

    /**
     * Generate component files using discovered data
     */
    private void generateComponent(ComponentDeclaration comp, String outputDir, String componentName, ComponentInfo componentInfo) throws IOException {
        String baseName = componentName.toLowerCase().replace("component", "");
        String base = outputDir + "/" + baseName;

        generateJSFromDiscoveredData(base + ".js", componentInfo);
        generateHTMLFromDiscoveredData(base + ".html", componentInfo);
        generateCSSFromDiscoveredData(base + ".css", componentInfo);
    }

    /**
     * Generate JavaScript from discovered component data
     */
    private void generateJSFromDiscoveredData(String filename, ComponentInfo componentInfo) throws IOException {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println("// Generated from discovered component data");
            out.println("class " + componentInfo.getComponentName() + " {");
            out.println("    constructor() {");

            // Initialize discovered properties
            ClassInfo classInfo = componentInfo.getAssociatedClass();
            if (classInfo != null) {
                for (PropertyInfo prop : classInfo.getProperties()) {
                    out.println("        this." + prop.getName() + " = " + formatValueForJS(prop.getValue()) + ";");
                }
            }

            // Add template variables as properties
            for (String templateVar : templateAnalysis.getTemplateVariables().keySet()) {
                if (classInfo == null || !hasProperty(classInfo, templateVar)) {
                    out.println("        this." + templateVar + " = null;");
                }
            }

            out.println("        this.init();");
            out.println("    }");
            out.println();

            // Generate methods based on discovered properties
            if (classInfo != null) {
                generateMethodsFromProperties(out, classInfo);
            }

            out.println("    init() {");
            out.println("        this.bindEvents();");
            out.println("        this.render();");
            out.println("    }");
            out.println();

            out.println("    bindEvents() {");
            generateEventBindingsFromTemplate(out, componentInfo);
            out.println("    }");
            out.println();

            out.println("    render() {");
            generateRenderFromTemplate(out, componentInfo);
            out.println("    }");
            out.println("}");
            out.println();

            out.println("document.addEventListener('DOMContentLoaded', function() {");
            out.println("    new " + componentInfo.getComponentName() + "();");
            out.println("});");
        }
    }

    /**
     * Generate methods from discovered properties
     */
    private void generateMethodsFromProperties(PrintWriter out, ClassInfo classInfo) {
        for (PropertyInfo prop : classInfo.getProperties()) {
            if (prop.getValue() instanceof List) {
                String propName = prop.getName();
                String itemName = propName.endsWith("s") ? propName.substring(0, propName.length() - 1) : "item";

                out.println("    select" + capitalize(itemName) + "(" + itemName + ") {");
                out.println("        this.selected" + capitalize(itemName) + " = " + itemName + ";");
                out.println("        this.render();");
                out.println("    }");
                out.println();
            }
        }
    }

    /**
     * Generate event bindings from template
     */
    private void generateEventBindingsFromTemplate(PrintWriter out, ComponentInfo componentInfo) {
        if (componentInfo.getTemplateContent() == null) {
            return;
        }

        String template = componentInfo.getTemplateContent();

        // Find data-event attributes
        java.util.regex.Pattern eventPattern = java.util.regex.Pattern.compile("data-event-(\\w+)=\"([^\"]+)\"");
        java.util.regex.Matcher matcher = eventPattern.matcher(template);

        while (matcher.find()) {
            String eventType = matcher.group(1);
            String handler = matcher.group(2);

            out.println("        document.addEventListener('" + eventType + "', (e) => {");
            out.println("            if (e.target.hasAttribute('data-event-" + eventType + "')) {");
            out.println("                this." + handler + "(e);");
            out.println("            }");
            out.println("        });");
        }

        // Find ngFor patterns
        java.util.regex.Pattern ngForPattern = java.util.regex.Pattern.compile("data-ng-for=\"([^\"]+)\"");
        matcher = ngForPattern.matcher(template);

        while (matcher.find()) {
            String ngForValue = matcher.group(1);
            String[] parts = ngForValue.split("\\s+of\\s+");
            if (parts.length == 2) {
                String itemVar = parts[0].replace("let ", "").trim();
                String collectionVar = parts[1].trim();

                out.println("        // Click handlers for " + collectionVar);
                out.println("        document.addEventListener('click', (e) => {");
                out.println("            const " + itemVar + "Element = e.target.closest('[data-" + itemVar + "]');");
                out.println("            if (" + itemVar + "Element) {");
                out.println("                const " + itemVar + "Id = " + itemVar + "Element.dataset." + itemVar + ";");
                out.println("                const " + itemVar + " = this." + collectionVar + ".find(item => item.id == " + itemVar + "Id);");
                out.println("                if (" + itemVar + ") this.select" + capitalize(itemVar) + "(" + itemVar + ");");
                out.println("            }");
                out.println("        });");
            }
        }
    }

    /**
     * Generate render method from template
     */
    private void generateRenderFromTemplate(PrintWriter out, ComponentInfo componentInfo) {
        if (componentInfo.getTemplateContent() == null) {
            return;
        }

        String template = componentInfo.getTemplateContent();
        ClassInfo classInfo = componentInfo.getAssociatedClass();

        // Handle interpolation
        java.util.regex.Pattern interpolationPattern = java.util.regex.Pattern.compile("\\{\\{\\s*(\\w+)\\s*\\}\\}");
        java.util.regex.Matcher matcher = interpolationPattern.matcher(template);

        Set<String> foundVariables = new HashSet<>();
        while (matcher.find()) {
            foundVariables.add(matcher.group(1));
        }

        for (String varName : foundVariables) {
            out.println("        const " + varName + "Elements = document.querySelectorAll('." + varName + "-display');");
            out.println("        " + varName + "Elements.forEach(el => {");
            out.println("            el.textContent = this." + varName + " || '';");
            out.println("        });");
        }

        // Handle ngFor rendering
        java.util.regex.Pattern ngForPattern = java.util.regex.Pattern.compile("data-ng-for=\"([^\"]+)\"");
        matcher = ngForPattern.matcher(template);

        while (matcher.find()) {
            String ngForValue = matcher.group(1);
            String[] parts = ngForValue.split("\\s+of\\s+");
            if (parts.length == 2) {
                String itemVar = parts[0].replace("let ", "").trim();
                String collectionVar = parts[1].trim();

                out.println("        // Render " + collectionVar);
                out.println("        const " + collectionVar + "Container = document.querySelector('[data-ng-for*=\"" + collectionVar + "\"]');");
                out.println("        if (" + collectionVar + "Container && this." + collectionVar + ") {");
                out.println("            " + collectionVar + "Container.innerHTML = this." + collectionVar + ".map(" + itemVar + " => {");
                out.println("                return `<div data-" + itemVar + "=\"${" + itemVar + ".id || " + itemVar + ".name}\">${JSON.stringify(" + itemVar + ")}</div>`;");
                out.println("            }).join('');");
                out.println("        }");
            }
        }
    }

    /**
     * Generate HTML from discovered template
     */
    private void generateHTMLFromDiscoveredData(String filename, ComponentInfo componentInfo) throws IOException {
        try (PrintWriter out = new PrintWriter(filename)) {
            String componentName = componentInfo.getComponentName();
            String baseName = componentName.toLowerCase().replace("component", "");

            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("    <meta charset=\"UTF-8\">");
            out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("    <title>" + componentName + "</title>");
            out.println("    <link rel=\"stylesheet\" href=\"" + baseName + ".css\">");
            out.println("</head>");
            out.println("<body>");

            if (componentInfo.getTemplateContent() != null) {
                // Use discovered template
                out.println(componentInfo.getTemplateContent());
            } else {
                // Generate from component properties if no template
                generateHTMLFromProperties(out, componentInfo);
            }

            out.println("    <script src=\"" + baseName + ".js\"></script>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Generate HTML structure from component properties
     */
    private void generateHTMLFromProperties(PrintWriter out, ComponentInfo componentInfo) {
        ClassInfo classInfo = componentInfo.getAssociatedClass();
        if (classInfo == null) return;

        out.println("    <div class=\"container\">");

        for (PropertyInfo prop : classInfo.getProperties()) {
            if (prop.getValue() instanceof List) {
                out.println("        <div class=\"" + prop.getName() + "-container\" data-ng-for=\"let item of " + prop.getName() + "\">");
                out.println("        </div>");
            } else {
                out.println("        <div class=\"" + prop.getName() + "-display\">{{" + prop.getName() + "}}</div>");
            }
        }

        out.println("    </div>");
    }

    /**
     * Generate CSS from discovered styles
     */
    private void generateCSSFromDiscoveredData(String filename, ComponentInfo componentInfo) throws IOException {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println("/* Generated from discovered component styles */");

            if (componentInfo.getStyleContent() != null && !componentInfo.getStyleContent().isEmpty()) {
                out.println(componentInfo.getStyleContent());
            }

            // Generate CSS for discovered properties
            ClassInfo classInfo = componentInfo.getAssociatedClass();
            if (classInfo != null) {
                generateCSSForProperties(out, classInfo);
            }
        }
    }

    /**
     * Generate CSS for component properties
     */
    private void generateCSSForProperties(PrintWriter out, ClassInfo classInfo) {
        for (PropertyInfo prop : classInfo.getProperties()) {
            String propName = prop.getName();

            if (prop.getValue() instanceof List) {
                out.println("." + propName + "-container {");
                out.println("    margin: 10px 0;");
                out.println("}");
                out.println();
            } else {
                out.println("." + propName + "-display {");
                out.println("    margin: 5px 0;");
                out.println("}");
                out.println();
            }
        }
    }

    /**
     * Generate from standalone class analysis if no components found
     */
    private void generateFromClassAnalysis(Program program, String outputDir) throws IOException {
        for (Statment stmt : program.getStatments()) {
            if (stmt.getClassDeclaration() != null) {
                ClassDeclaration classDecl = stmt.getClassDeclaration();
                ComponentInfo componentInfo = new ComponentInfo(classDecl.getNameClass() + "Component");

                extractClassProperties(classDecl, componentInfo);

                if (componentInfo.getAssociatedClass() != null &&
                        !componentInfo.getAssociatedClass().getProperties().isEmpty()) {

                    String baseName = classDecl.getNameClass().toLowerCase();
                    generateJSFromDiscoveredData(outputDir + "/" + baseName + ".js", componentInfo);
                    generateHTMLFromDiscoveredData(outputDir + "/" + baseName + ".html", componentInfo);
                    generateCSSFromDiscoveredData(outputDir + "/" + baseName + ".css", componentInfo);

                    System.out.println(">>> Generated from class: " + classDecl.getNameClass());
                }
            }
        }
    }

    // Helper methods
    private Object extractPropertyValue(PropertyDeclaration prop) {
        if (prop.getInitvalue() == null) return null;
        return extractInitValue(prop.getInitvalue());
    }

    private Object extractInitValue(Initvalue initValue) {
        if (initValue.getString() != null) {
            return initValue.getString().replace("\"", "").replace("'", "");
        }
        if (initValue.getNumber() != null) {
            try {
                return Integer.parseInt(initValue.getNumber());
            } catch (NumberFormatException e) {
                try {
                    return Double.parseDouble(initValue.getNumber());
                } catch (NumberFormatException e2) {
                    return initValue.getNumber();
                }
            }
        }
        if (initValue.getIsBoolean() != null) {
            return initValue.getIsBoolean().getTruev() != null;
        }
        if (initValue.getBodyList() != null) {
            return extractArrayData(initValue.getBodyList());
        }
        if (initValue.getObjectV() != null) {
            return extractObjectData(initValue.getObjectV());
        }
        return null;
    }

    private List<Object> extractArrayData(BodyList bodyList) {
        List<Object> array = new ArrayList<>();
        if (bodyList.getInitvalues() != null) {
            for (Initvalue item : bodyList.getInitvalues()) {
                array.add(extractInitValue(item));
            }
        }
        return array;
    }

    private Map<String, Object> extractObjectData(ObjectV objectV) {
        Map<String, Object> obj = new LinkedHashMap<>();
        if (objectV.getBodyObject() != null && objectV.getBodyObject().getProperties() != null) {
            for (Map.Entry<String, Initvalue> entry : objectV.getBodyObject().getProperties().entrySet()) {
                obj.put(entry.getKey(), extractInitValue(entry.getValue()));
            }
        }
        return obj;
    }

    private String formatValueForJS(Object value) {
        if (value == null) return "null";
        if (value instanceof String) return "'" + value + "'";
        if (value instanceof Number || value instanceof Boolean) return value.toString();
        if (value instanceof List) {
            @SuppressWarnings("unchecked")
            List<Object> list = (List<Object>) value;
            return "[" + list.stream()
                    .map(this::formatValueForJS)
                    .collect(Collectors.joining(", ")) + "]";
        }
        if (value instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> map = (Map<String, Object>) value;
            return "{" + map.entrySet().stream()
                    .map(entry -> "'" + entry.getKey() + "': " + formatValueForJS(entry.getValue()))
                    .collect(Collectors.joining(", ")) + "}";
        }
        return "'" + value.toString() + "'";
    }

    private String extractComponentName(ComponentDeclaration comp) {
        if (comp.getComponentDeclarationBody() == null) return "UnknownComponent";

        for (ComponentBodyElement element : comp.getComponentDeclarationBody().getComponentBodyElements()) {
            if (element.getSelector() != null) {
                String raw = element.getSelector().getSTRING_LIT();
                String cleaned = raw.replaceAll("[^a-zA-Z0-9-]", "");
                if (cleaned.startsWith("app-")) {
                    cleaned = cleaned.substring(4);
                }
                return toPascalCase(cleaned) + "Component";
            }
        }
        return "UnknownComponent";
    }

    private List<ComponentDeclaration> findComponents(Program program) {
        return program.getStatments().stream()
                .filter(stmt -> stmt.getComponentDeclaration() != null)
                .map(stmt -> stmt.getComponentDeclaration())
                .collect(Collectors.toList());
    }

    private String toPascalCase(String input) {
        if (input == null || input.isEmpty()) return "Unknown";
        String[] parts = input.split("-");
        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                result.append(Character.toUpperCase(part.charAt(0)));
                if (part.length() > 1) {
                    result.append(part.substring(1).toLowerCase());
                }
            }
        }
        return result.toString();
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    private boolean hasProperty(ClassInfo classInfo, String propertyName) {
        return classInfo.getProperties().stream()
                .anyMatch(prop -> prop.getName().equals(propertyName));
    }

    private void analyzeProgram(Program program) {
        System.out.println(">>> Starting comprehensive program analysis...");

        for (Statment stmt : program.getStatments()) {
            if (stmt.getComponentDeclaration() != null) {
                analyzeComponentDeclaration(stmt.getComponentDeclaration(), program);
            }
            if (stmt.getClassDeclaration() != null) {
                analyzeClassDeclaration(stmt.getClassDeclaration());
            }
        }

        System.out.println(">>> Analysis completed:");
        System.out.println("    - Components: " + componentAnalysis.getComponents().size());
        System.out.println("    - Template variables: " + templateAnalysis.getTemplateVariables().size());
    }

    private void analyzeComponentDeclaration(ComponentDeclaration comp, Program program) {
        String componentName = extractComponentName(comp);
        System.out.println(">>> Analyzing component: " + componentName);

        ComponentInfo info = extractCompleteComponentInfo(comp, program);
        componentAnalysis.addComponent(info);
    }

    private void analyzeClassDeclaration(ClassDeclaration classDecl) {
        String className = classDecl.getNameClass();
        System.out.println(">>> Analyzing class: " + className);

        if (classDecl.getClassDeclarationBody() != null) {
            ClassInfo classInfo = new ClassInfo(className);

            for (ClassMember member : classDecl.getClassDeclarationBody().getClassMembers()) {
                if (member.getPropertyDeclaration() != null) {
                    PropertyDeclaration prop = member.getPropertyDeclaration();
                    if (!prop.getID().isEmpty()) {
                        String propName = prop.getID().get(0);
                        Object propValue = extractPropertyValue(prop);
                        String propType = determinePropertyType(propValue);

                        PropertyInfo propertyInfo = new PropertyInfo(propName, propType, propValue);
                        classInfo.addProperty(propertyInfo);
                    }
                }
            }

            componentAnalysis.addClassInfo(classInfo);
        }
    }

    // Data classes
    private static class ComponentAnalysis {
        private List<ComponentInfo> components = new ArrayList<>();
        private Map<String, ClassInfo> classInfoMap = new HashMap<>();

        public void addComponent(ComponentInfo info) {
            components.add(info);
        }

        public void addClassInfo(ClassInfo info) {
            classInfoMap.put(info.getClassName(), info);
        }

        public List<ComponentInfo> getComponents() {
            return components;
        }

        public ComponentInfo getComponentByName(String name) {
            return components.stream()
                    .filter(comp -> comp.getComponentName().equals(name))
                    .findFirst()
                    .orElse(null);
        }

        public ClassInfo getClassInfoForComponent(String componentName) {
            String className = componentName.replace("Component", "");
            return classInfoMap.values().stream()
                    .filter(classInfo -> classInfo.getClassName().contains(className))
                    .findFirst()
                    .orElse(null);
        }
    }

    private static class TemplateAnalysis {
        private Map<String, String> templateVariables = new HashMap<>();

        public void addTemplateVariable(String varName, String type) {
            templateVariables.put(varName, type);
        }

        public Map<String, String> getTemplateVariables() {
            return templateVariables;
        }
    }

    private static class ComponentInfo {
        private String componentName;
        private String selector;
        private String templateContent;
        private String styleContent;
        private ClassInfo associatedClass;

        public ComponentInfo(String componentName) {
            this.componentName = componentName;
        }

        public String getComponentName() { return componentName; }
        public String getSelector() { return selector; }
        public void setSelector(String selector) { this.selector = selector; }
        public String getTemplateContent() { return templateContent; }
        public void setTemplateContent(String templateContent) { this.templateContent = templateContent; }
        public String getStyleContent() { return styleContent; }
        public void setStyleContent(String styleContent) { this.styleContent = styleContent; }
        public ClassInfo getAssociatedClass() { return associatedClass; }
        public void setAssociatedClass(ClassInfo associatedClass) { this.associatedClass = associatedClass; }
    }

    private static class ClassInfo {
        private String className;
        private List<PropertyInfo> properties = new ArrayList<>();

        public ClassInfo(String className) {
            this.className = className;
        }

        public String getClassName() { return className; }
        public List<PropertyInfo> getProperties() { return properties; }
        public void addProperty(PropertyInfo property) { properties.add(property); }
    }

    private static class PropertyInfo {
        private String name;
        private String type;
        private Object value;

        public PropertyInfo(String name, String type, Object value) {
            this.name = name;
            this.type = type;
            this.value = value;
        }

        public String getName() { return name; }
        public String getType() { return type; }
        public Object getValue() { return value; }
    }
}