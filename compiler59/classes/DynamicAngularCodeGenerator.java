package classes;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DynamicAngularCodeGenerator {
    private SymbolTable symbolTable;

    public DynamicAngularCodeGenerator(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public void generateFromAST(Program program, String outputDir) throws IOException {
        File dir = new File(outputDir);
        dir.mkdirs();

        boolean found = false;
        for (Statment stmt : program.getStatments()) {
            if (stmt.getComponentDeclaration() != null) {
                found = true;
                String componentName = extractComponentName(stmt.getComponentDeclaration());
                System.out.println(">>> Found component: " + componentName);
                generateComponent(stmt.getComponentDeclaration(), outputDir);
            }
        }

        if (!found) {
            System.out.println(">>> No ComponentDeclaration found in AST!");
        }
    }

    private void generateComponent(ComponentDeclaration comp, String outputDir) throws IOException {
        String componentName = extractComponentName(comp);
        String base = outputDir + "/" + componentName.toLowerCase();

        generateTS(comp, base + ".component.ts");
        generateHTML(comp, base + ".component.html");
        generateCSS(comp, base + ".component.css");
    }

    private String extractComponentName(ComponentDeclaration comp) {
        // Look for selector to determine component name
        for (ComponentBodyElement element : comp.getComponentDeclarationBody().getComponentBodyElements()) {
            if (element.getSelector() != null) {
                String raw = element.getSelector().getSTRING_LIT();
                // Clean selector and create component name
                String cleaned = raw.replaceAll("[^a-zA-Z0-9-]", "");
                if (cleaned.startsWith("app-")) {
                    cleaned = cleaned.substring(4);
                }
                return toPascalCase(cleaned) + "Component";
            }
        }
        return "AppComponent";
    }

    private String toPascalCase(String input) {
        if (input == null || input.isEmpty()) return "App";

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

    private void generateTS(ComponentDeclaration comp, String file) throws IOException {
        try (PrintWriter out = new PrintWriter(file)) {
            String componentName = extractComponentName(comp);
            String componentBaseName = componentName.replace("Component", "");

            out.println("import { Component } from '@angular/core';");
            out.println("import { CommonModule } from '@angular/common';");
            out.println();

            // Extract and generate interface if properties suggest it
            generateInterface(out, componentBaseName);

            out.println("@Component({");
            out.println("  selector: 'app-" + componentBaseName.toLowerCase() + "',");
            out.println("  standalone: true,");
            out.println("  imports: [CommonModule],");
            out.println("  templateUrl: './" + componentName.toLowerCase() + ".component.html',");
            out.println("  styleUrls: ['./" + componentName.toLowerCase() + ".component.css']");
            out.println("})");
            out.println("export class " + componentName + " {");

            // Generate properties from symbol table
            generateProperties(out);

            // Generate methods from symbol table
            generateMethods(out);

            out.println("}");
        }
    }

    private void generateInterface(PrintWriter out, String baseName) {
        // Check if we have structured data that suggests an interface
        List<Row> allSymbols = symbolTable.getAllSymbols();
        Set<String> interfaceProperties = new HashSet<>();

        for (Row row : allSymbols) {
            if ("PROPERTY".equals(row.getType()) || "COMPONENT_PROPERTY".equals(row.getType())) {
                String value = row.getValue();
                // Look for property patterns that suggest interface properties
                if (value.contains("id") || value.contains("name") || value.contains("price") ||
                        value.contains("type") || value.contains("imageUrl") || value.contains("url")) {
                    interfaceProperties.add(value);
                }
            }
        }

        if (!interfaceProperties.isEmpty()) {
            out.println("interface " + baseName + " {");

            // Generate common interface properties based on patterns
            if (interfaceProperties.stream().anyMatch(p -> p.contains("id"))) {
                out.println("  id: number;");
            }
            if (interfaceProperties.stream().anyMatch(p -> p.contains("name"))) {
                out.println("  name: string;");
            }
            if (interfaceProperties.stream().anyMatch(p -> p.contains("price"))) {
                out.println("  price: number;");
            }
            if (interfaceProperties.stream().anyMatch(p -> p.contains("type"))) {
                out.println("  type: string;");
            }
            if (interfaceProperties.stream().anyMatch(p -> p.toLowerCase().contains("url"))) {
                out.println("  imageUrl: string;");
            }

            out.println("}");
            out.println();
        }
    }

    private void generateProperties(PrintWriter out) {
        List<Row> allSymbols = symbolTable.getAllSymbols();
        Set<String> addedProperties = new HashSet<>();

        for (Row row : allSymbols) {
            if (("PROPERTY".equals(row.getType()) || "COMPONENT_PROPERTY".equals(row.getType()))
                    && !addedProperties.contains(row.getValue())) {

                String propName = row.getValue();
                addedProperties.add(propName);

                // Generate property with appropriate type and initial value
                if (propName.toLowerCase().contains("product") && propName.toLowerCase().contains("s")) {
                    // Array property
                    String singularName = propName.replace("s", "");
                    out.println("  " + propName + ": " + toPascalCase(singularName) + "[] = [];");
                } else if (propName.toLowerCase().contains("selected")) {
                    // Selected item property
                    String typeName = extractTypeFromPropertyName(propName);
                    out.println("  " + propName + ": " + typeName + " | null = null;");
                } else {
                    // Generic property
                    out.println("  " + propName + ": any = null;");
                }
            }
        }

        // Add default properties if none found
        if (addedProperties.isEmpty()) {
            out.println("  // Generated default properties");
            out.println("  data: any[] = [];");
            out.println("  selectedItem: any = null;");
        }
    }

    private void generateMethods(PrintWriter out) {
        List<Row> allSymbols = symbolTable.getAllSymbols();
        Set<String> addedMethods = new HashSet<>();

        out.println();
        for (Row row : allSymbols) {
            if ("METHOD".equals(row.getType()) && !addedMethods.contains(row.getValue())) {
                String methodName = row.getValue();
                addedMethods.add(methodName);

                // Generate method based on name pattern
                if (methodName.toLowerCase().contains("select")) {
                    String paramType = extractTypeFromMethodName(methodName);
                    out.println("  " + methodName + "(" + paramType.toLowerCase() + ": " + paramType + "): void {");
                    out.println("    this.selected" + paramType + " = " + paramType.toLowerCase() + ";");
                    out.println("  }");
                } else {
                    out.println("  " + methodName + "(): void {");
                    out.println("    // TODO: Implement " + methodName);
                    out.println("  }");
                }
            }
        }

        // Add default method if none found
        if (addedMethods.isEmpty()) {
            out.println("  // Generated default method");
            out.println("  onClick(): void {");
            out.println("    console.log('Button clicked');");
            out.println("  }");
        }
    }

    private void generateHTML(ComponentDeclaration comp, String file) throws IOException {
        Template template = comp.getComponentDeclarationBody().getComponentBodyElements()
                .stream()
                .map(ComponentBodyElement::getTemplate)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);

        try (PrintWriter out = new PrintWriter(file)) {
            out.println("<!-- Generated Angular Template -->");

            if (template != null) {
                for (Element element : template.getElement()) {
                    String htmlContent = elementToHTML(element);
                    // Fix common Angular directive issues
                    htmlContent = fixAngularDirectives(htmlContent);
                    out.println(htmlContent);
                }
            } else {
                // Generate default template
                generateDefaultTemplate(out);
            }
        }
    }

    private String fixAngularDirectives(String html) {
        // Fix ngFor - ensure it has *
        html = html.replaceAll("ngFor=", "*ngFor=");
        // Fix duplicate asterisks
        html = html.replaceAll("\\*\\*ngFor", "*ngFor");

        // Fix ngIf - ensure it has *
        html = html.replaceAll("(?<!\\*)ngIf=", "*ngIf=");
        html = html.replaceAll("\\*\\*ngIf", "*ngIf");

        return html;
    }

    private void generateDefaultTemplate(PrintWriter out) {
        out.println("<div class=\"container\">");
        out.println("  <div class=\"content\">");
        out.println("    <h1>Component Title</h1>");
        out.println("    <div *ngIf=\"data.length > 0\">");
        out.println("      <ul>");
        out.println("        <li *ngFor=\"let item of data\">");
        out.println("          <span>{{ item.name }}</span>");
        out.println("        </li>");
        out.println("      </ul>");
        out.println("    </div>");
        out.println("  </div>");
        out.println("</div>");
    }

    private String elementToHTML(Element element) {
        if (element == null) return "<!-- null element -->";

        if (element.getHtmlName() != null) {
            return "<" + element.getHtmlName() + "></" + element.getHtmlName() + ">";
        }

        if (element.getInterpolation() != null) {
            return "{{ " + element.getInterpolation().getNAME_HTML() + " }}";
        }

        if (element.getTag() != null) {
            return processTag(element.getTag());
        }

        return "<div>Unsupported element</div>";
    }

    private String processTag(Tag tag) {
        StringBuilder sb = new StringBuilder();

        OpeningTag opening = tag.getOpeningTag();
        if (opening != null) {
            String tagName = opening.getName();
            sb.append("<").append(tagName != null ? tagName : "div");

            if (opening.getAttributes() != null) {
                for (Attributes attr : opening.getAttributes()) {
                    String attrName = attr.getHtmlName();
                    String attrValue = attr.getHtmlString();

                    if ("ngFor".equals(attrName)) {
                        attrName = "*ngFor";
                    } else if ("ngIf".equals(attrName)) {
                        attrName = "*ngIf";
                    }
                    sb.append(" ").append(attrName).append("=\"").append(attrValue).append("\"");
                }
            }
            sb.append(">");
        }

        // Process child elements
        if (tag.getElements() != null) {
            for (Element child : tag.getElements()) {
                sb.append(elementToHTML(child));
            }
        }

        // Process closing tag
        ClosingTag closing = tag.getClosingTag();
        if (closing != null && closing.getNAME_HTML() != null) {
            sb.append("</").append(closing.getNAME_HTML()).append(">");
        }

        return sb.toString();
    }

    private void generateCSS(ComponentDeclaration comp, String file) throws IOException {
        try (PrintWriter out = new PrintWriter(file)) {
            out.println("/* Generated Angular Component Styles */");

            Styles styles = comp.getComponentDeclarationBody().getComponentBodyElements().stream()
                    .map(ComponentBodyElement::getStyles)
                    .filter(Objects::nonNull)
                    .findFirst()
                    .orElse(null);

            if (styles != null && styles.getCssBody() != null) {
                CssObjects cssObjects = styles.getCssBody().getCssObjects();
                if (cssObjects != null && cssObjects.getCssElementlist() != null) {
                    for (CssElement rule : cssObjects.getCssElementlist()) {
                        out.println(processCssRule(rule));
                    }
                }
            } else {
                // Generate default styles
                generateDefaultStyles(out);
            }
        }
    }

    private void generateDefaultStyles(PrintWriter out) {
        out.println(".container {");
        out.println("  padding: 20px;");
        out.println("  max-width: 1200px;");
        out.println("  margin: 0 auto;");
        out.println("}");
        out.println();
        out.println(".content {");
        out.println("  background: #f5f5f5;");
        out.println("  padding: 15px;");
        out.println("  border-radius: 8px;");
        out.println("}");
        out.println();
        out.println("h1 {");
        out.println("  color: #333;");
        out.println("  margin-bottom: 20px;");
        out.println("}");
        out.println();
        out.println("ul {");
        out.println("  list-style: none;");
        out.println("  padding: 0;");
        out.println("}");
        out.println();
        out.println("li {");
        out.println("  padding: 10px;");
        out.println("  border-bottom: 1px solid #ddd;");
        out.println("}");
    }

    private String processCssRule(CssElement rule) {
        StringBuilder sb = new StringBuilder();

        // Process selectors
        if (rule.getSelectors() != null && !rule.getSelectors().isEmpty()) {
            sb.append(".").append(String.join(".", rule.getSelectors()));
        } else {
            sb.append(".default-class");
        }

        sb.append(" {\n");

        // Process CSS properties
        if (rule.getBodyCssElements() != null) {
            for (Bodyelement decl : rule.getBodyCssElements()) {
                sb.append("  ").append(decl.getId_css()).append(": ");

                if (decl.getCssValue() != null && decl.getCssValue().getID_CSS() != null) {
                    sb.append(decl.getCssValue().getID_CSS().stream()
                            .collect(Collectors.joining(" ")));
                } else {
                    sb.append("auto");
                }

                sb.append(";\n");
            }
        }

        sb.append("}\n\n");
        return sb.toString();
    }

    // Helper methods
    private String extractTypeFromPropertyName(String propName) {
        if (propName.toLowerCase().contains("product")) {
            return "Product";
        }
        if (propName.toLowerCase().contains("user")) {
            return "User";
        }
        return "Item";
    }

    private String extractTypeFromMethodName(String methodName) {
        if (methodName.toLowerCase().contains("product")) {
            return "Product";
        }
        if (methodName.toLowerCase().contains("user")) {
            return "User";
        }
        if (methodName.toLowerCase().contains("item")) {
            return "Item";
        }
        return "Object";
    }
}