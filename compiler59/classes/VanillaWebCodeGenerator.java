package classes;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class VanillaWebCodeGenerator {
    private SymbolTable symbolTable;

    public VanillaWebCodeGenerator(SymbolTable symbolTable) {
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
                generateVanillaComponent(stmt.getComponentDeclaration(), outputDir, program);
            }
        }

        if (!found) {
            System.out.println(">>> No ComponentDeclaration found in AST!");
        }
    }

    private void generateVanillaComponent(ComponentDeclaration comp, String outputDir, Program program) throws IOException {
        String componentName = extractComponentName(comp);
        String base = outputDir + "/" + componentName.toLowerCase();

        // Extract class data from the program
        Map<String, Object> componentData = extractComponentData(program);

        generateJS(comp, base + ".js", componentData);
        generateHTML(comp, base + ".html", componentData);
        generateCSS(comp, base + ".css");
    }

    private Map<String, Object> extractComponentData(Program program) {
        Map<String, Object> componentData = new HashMap<>();

        System.out.println(">>> Starting component data extraction...");

        // Look for class declarations in the program
        for (Statment stmt : program.getStatments()) {
            if (stmt.getClassDeclaration() != null) {
                ClassDeclaration classDecl = stmt.getClassDeclaration();
                System.out.println(">>> Found class: " + classDecl.getNameClass());

                if (classDecl.getClassDeclarationBody() != null) {
                    for (ClassMember member : classDecl.getClassDeclarationBody().getClassMembers()) {
                        if (member.getPropertyDeclaration() != null) {
                            PropertyDeclaration prop = member.getPropertyDeclaration();
                            if (!prop.getID().isEmpty()) {
                                String propName = prop.getID().get(0);
                                System.out.println(">>> Processing property: " + propName);

                                Object propValue = extractPropertyValue(prop);
                                componentData.put(propName, propValue);

                                System.out.println(">>> Extracted property: " + propName + " = " + formatDebugValue(propValue));
                            }
                        }
                    }
                }
            }
        }

        System.out.println(">>> Component data extraction completed. Found " + componentData.size() + " properties.");
        return componentData;
    }

    private String formatDebugValue(Object value) {
        if (value == null) return "null";
        if (value instanceof List) {
            List<?> list = (List<?>) value;
            return "[" + list.size() + " items: " + list.stream()
                    .map(item -> item instanceof Map ? "{" + ((Map<?,?>) item).size() + " props}" : String.valueOf(item))
                    .collect(Collectors.joining(", ")) + "]";
        }
        if (value instanceof Map) {
            Map<?,?> map = (Map<?,?>) value;
            return "{" + map.entrySet().stream()
                    .map(entry -> entry.getKey() + "=" + entry.getValue())
                    .collect(Collectors.joining(", ")) + "}";
        }
        return String.valueOf(value);
    }

    private Object extractPropertyValue(PropertyDeclaration prop) {
        if (prop.getInitvalue() != null) {
            System.out.println(">>> Property has initial value, extracting...");
            Object result = extractInitValue(prop.getInitvalue());
            System.out.println(">>> Extraction result: " + formatDebugValue(result));
            return result;
        }
        System.out.println(">>> Property has no initial value");
        return null;
    }

    private Object extractInitValue(Initvalue initValue) {
        System.out.println(">>> Extracting InitValue...");

        if (initValue.getString() != null) {
            String value = initValue.getString().replace("\"", "").replace("'", "");
            System.out.println(">>> Found string value: " + value);
            return value;
        }

        if (initValue.getNumber() != null) {
            System.out.println(">>> Found number value: " + initValue.getNumber());
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
            IsBoolean bool = initValue.getIsBoolean();
            boolean result = bool.getTruev() != null;
            System.out.println(">>> Found boolean value: " + result);
            return result;
        }

        if (initValue.getBodyList() != null) {
            System.out.println(">>> Found BodyList, extracting array...");
            List<Object> result = extractArrayData(initValue.getBodyList());
            System.out.println(">>> Array extraction completed with " + result.size() + " items");
            return result;
        }

        if (initValue.getObjectV() != null) {
            System.out.println(">>> Found ObjectV, extracting object...");
            Map<String, Object> result = extractObjectData(initValue.getObjectV());
            System.out.println(">>> Object extraction completed with " + result.size() + " properties");
            return result;
        }

        // CRITICAL FIX: Check for object key at InitValue level
        if (initValue.getObjectKey() != null) {
            System.out.println(">>> Found ObjectKey at InitValue level: " + initValue.getObjectKey());
            Map<String, Object> obj = new HashMap<>();
            obj.put("key", initValue.getObjectKey());
            return obj;
        }

        System.out.println(">>> WARNING: Could not extract value from InitValue, returning null");
        return null;
    }

    private List<Object> extractArrayData(BodyList bodyList) {
        List<Object> array = new ArrayList<>();
        System.out.println(">>> Processing BodyList...");

        if (bodyList.getInitvalues() != null) {
            System.out.println(">>> BodyList has " + bodyList.getInitvalues().size() + " items");

            for (int i = 0; i < bodyList.getInitvalues().size(); i++) {
                Initvalue item = bodyList.getInitvalues().get(i);
                System.out.println(">>> Processing array item " + i + "...");

                Object extracted = extractInitValue(item);
                array.add(extracted);

                System.out.println(">>> Array item " + i + " extracted: " + formatDebugValue(extracted));
            }
        } else {
            System.out.println(">>> BodyList has no initvalues");
        }

        return array;
    }

    private Map<String, Object> extractObjectData(ObjectV objectV) {
        Map<String, Object> obj = new LinkedHashMap<>();
        System.out.println(">>> Processing ObjectV...");

        if (objectV.getBodyObject() == null) {
            System.out.println(">>> ObjectV has no BodyObject");
            return obj;
        }

        BodyObject bodyObject = objectV.getBodyObject();

        // ENHANCED: Process each Initvalue which contains both key and value
        if (bodyObject.getInitvalues() != null) {
            System.out.println(">>> BodyObject has " + bodyObject.getInitvalues().size() + " initvalues");

            for (Initvalue initValue : bodyObject.getInitvalues()) {
                String key = initValue.getObjectKey();
                if (key != null) {
                    System.out.println(">>> Processing object property: " + key);

                    // FIXED: Recursively extract the value, handling nested objects and arrays
                    Object value = extractObjectPropertyValue(initValue);
                    obj.put(key, value);
                    System.out.println(">>> Extracted property: " + key + " = " + formatDebugValue(value));
                } else {
                    System.out.println(">>> InitValue has no ObjectKey, skipping...");
                }
            }
        }

        System.out.println(">>> Object extraction completed with " + obj.size() + " properties");
        return obj;
    }

    // NEW METHOD: Extract object property values properly
    private Object extractObjectPropertyValue(Initvalue initValue) {
        // Check for string value
        if (initValue.getString() != null) {
            String value = initValue.getString().replace("\"", "").replace("'", "");
            System.out.println(">>> Found string property value: " + value);
            return value;
        }

        // Check for number value
        if (initValue.getNumber() != null) {
            System.out.println(">>> Found number property value: " + initValue.getNumber());
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

        // Check for boolean value
        if (initValue.getIsBoolean() != null) {
            IsBoolean bool = initValue.getIsBoolean();
            boolean result = bool.getTruev() != null;
            System.out.println(">>> Found boolean property value: " + result);
            return result;
        }

        // Check for nested object
        if (initValue.getObjectV() != null) {
            System.out.println(">>> Found nested object property");
            return extractObjectData(initValue.getObjectV());
        }

        // Check for array
        if (initValue.getBodyList() != null) {
            System.out.println(">>> Found array property");
            return extractArrayData(initValue.getBodyList());
        }

        System.out.println(">>> No recognizable property value found, returning null");
        return null;
    }

    private String extractComponentName(ComponentDeclaration comp) {
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

    private void generateJS(ComponentDeclaration comp, String file, Map<String, Object> componentData) throws IOException {
        try (PrintWriter out = new PrintWriter(file)) {
            String componentName = extractComponentName(comp);
            String componentBaseName = componentName.replace("Component", "");

            out.println("// Generated Vanilla JavaScript Component");
            out.println();

            // Generate object template with actual data
            generateObjectTemplateFromData(out, componentBaseName, componentData);

            out.println("class " + componentName + " {");
            out.println("    constructor() {");

            // Generate properties with actual data
            generateJSPropertiesFromData(out, componentData);

            out.println("        this.init();");
            out.println("    }");
            out.println();

            out.println("    init() {");
            out.println("        this.bindEvents();");
            out.println("        this.render();");
            out.println("    }");
            out.println();

            out.println("    bindEvents() {");
            generateEventBindings(out);
            out.println("    }");
            out.println();

            // Generate methods from component data
            generateJSMethods(out, componentData);

            out.println("    render() {");
            generateRenderLogic(out, comp, componentData);
            out.println("    }");
            out.println("}");
            out.println();

            out.println("// Initialize component when DOM is loaded");
            out.println("document.addEventListener('DOMContentLoaded', function() {");
            out.println("    new " + componentName + "();");
            out.println("});");
        }
    }

    private void generateObjectTemplateFromData(PrintWriter out, String baseName, Map<String, Object> componentData) {
        if (!componentData.isEmpty()) {
            out.println("// " + baseName + " object template");
            out.println("const " + baseName + "Template = {");
            for (Map.Entry<String, Object> entry : componentData.entrySet()) {
                String propName = entry.getKey();
                Object propValue = entry.getValue();
                out.println("    " + propName + ": " + formatValueForJS(propValue) + ",");
            }
            out.println("};");
            out.println();
        }
    }

    private void generateJSPropertiesFromData(PrintWriter out, Map<String, Object> componentData) {
        for (Map.Entry<String, Object> entry : componentData.entrySet()) {
            String propName = entry.getKey();
            Object propValue = entry.getValue();
            out.println("        this." + propName + " = " + formatValueForJS(propValue) + ";");
        }
        if (componentData.isEmpty()) {
            out.println("        // No properties found");
        }
    }

    // ENHANCED: Better formatting for JavaScript values
    private String formatValueForJS(Object value) {
        if (value == null) return "null";
        if (value instanceof String) return "'" + value;
        if (value instanceof Number) return value.toString();
        if (value instanceof Boolean) return value.toString();

        if (value instanceof List) {
            @SuppressWarnings("unchecked")
            List<Object> list = (List<Object>) value;
            if (list.isEmpty()) return "[]";

            StringBuilder sb = new StringBuilder("[\n");
            for (int i = 0; i < list.size(); i++) {
                sb.append("        ").append(formatValueForJS(list.get(i)));
                if (i < list.size() - 1) sb.append(",");
                sb.append("\n");
            }
            sb.append("    ]");
            return sb.toString();
        }

        if (value instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> map = (Map<String, Object>) value;
            if (map.isEmpty()) return "{}";

            StringBuilder sb = new StringBuilder("{\n");
            int i = 0;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                // FIXED: Properly quote object keys
                sb.append("            ").append(entry.getKey()).append(": ").append(formatValueForJS(entry.getValue()));
                if (i < map.size() - 1) sb.append(",");
                sb.append("\n");
                i++;
            }
            sb.append("        }");
            return sb.toString();
        }

        return "'" + value.toString() + "'";
    }

    private void generateEventBindings(PrintWriter out) {
        out.println("        // Event bindings");
        out.println("        const productItems = document.querySelectorAll('[data-product]');");
        out.println("        productItems.forEach(item => {");
        out.println("            item.addEventListener('click', (e) => {");
        out.println("                const productId = parseInt(e.target.closest('[data-product]').dataset.product);");
        out.println("                this.selectProduct(this.products.find(p => p.id === productId));");
        out.println("            });");
        out.println("        });");
    }

    private void generateJSMethods(PrintWriter out, Map<String, Object> componentData) {
        // Generate selectProduct method if products exist
        if (componentData.containsKey("products")) {
            out.println("    selectProduct(product) {");
            out.println("        this.selectedProduct = product;");
            out.println("        this.render();");
            out.println("    }");
            out.println();
        }
    }

    private void generateRenderLogic(PrintWriter out, ComponentDeclaration comp, Map<String, Object> componentData) {
        out.println("        // Render products list");
        out.println("        const productList = document.querySelector('.products-container');");
        out.println("        if (productList && this.products) {");
        out.println("            productList.innerHTML = this.products.map(product => `");
        out.println("                <li data-product=\"${product.id}\" class=\"product-item\">");
        out.println("                    <img src=\"${product.imageUrl}\" alt=\"${product.name}\" />");
        out.println("                    <p>${product.name}</p>");
        out.println("                </li>");
        out.println("            `).join('');");
        out.println("        }");
        out.println();

        out.println("        // Render selected product details");
        out.println("        const productDetails = document.querySelector('.product-details');");
        out.println("        if (productDetails) {");
        out.println("            if (this.selectedProduct) {");
        out.println("                productDetails.style.display = 'block';");
        out.println("                productDetails.innerHTML = `");
        out.println("                    <h3>Product Details</h3>");
        out.println("                    <img src=\"${this.selectedProduct.imageUrl}\" alt=\"${this.selectedProduct.name}\" />");
        out.println("                    <h4>${this.selectedProduct.name}</h4>");
        out.println("                    <p><strong>Price:</strong> $${this.selectedProduct.price}</p>");
        out.println("                    <p><strong>Type:</strong> ${this.selectedProduct.type}</p>");
        out.println("                `;");
        out.println("            } else {");
        out.println("                productDetails.style.display = 'none';");
        out.println("            }");
        out.println("        }");
    }

    private void generateHTML(ComponentDeclaration comp, String file, Map<String, Object> componentData) throws IOException {
        try (PrintWriter out = new PrintWriter(file)) {
            String componentName = extractComponentName(comp);

            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("    <meta charset=\"UTF-8\">");
            out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("    <title>" + componentName + "</title>");
            out.println("    <link rel=\"stylesheet\" href=\"" + componentName.toLowerCase().replace("component", "") + "component.css\">");
            out.println("</head>");
            out.println("<body>");

            // Generate proper HTML structure
            out.println("    <div class=\"container\">");
            out.println("        <div class=\"product-list\">");
            out.println("            <h3>Products</h3>");
            out.println("            <ul class=\"products-container\">");
            out.println("                <!-- Products will be dynamically generated -->");
            out.println("            </ul>");
            out.println("        </div>");
            out.println("        <div class=\"product-details\" style=\"display: none;\">");
            out.println("            <!-- Product details will be dynamically generated -->");
            out.println("        </div>");
            out.println("    </div>");

            out.println("    <script src=\"" + componentName.toLowerCase().replace("component", "") + "component.js\"></script>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void generateCSS(ComponentDeclaration comp, String file) throws IOException {
        try (PrintWriter out = new PrintWriter(file)) {
            out.println("/* Generated Vanilla CSS Component Styles */");

            // Extract styles from component
            Styles styles = comp.getComponentDeclarationBody().getComponentBodyElements().stream()
                    .map(ComponentBodyElement::getStyles)
                    .filter(Objects::nonNull)
                    .findFirst()
                    .orElse(null);

            if (styles != null && styles.getCssBody() != null) {
                CssObjects cssObjects = styles.getCssBody().getCssObjects();
                if (cssObjects != null && cssObjects.getCssElementlist() != null) {
                    for (CssElement rule : cssObjects.getCssElementlist()) {
                        out.println(processVanillaCssRule(rule));
                    }
                }
            } else {
                // Generate enhanced default styles
                generateEnhancedCSS(out);
            }
        }
    }

    private void generateEnhancedCSS(PrintWriter out) {
        out.println(".container {");
        out.println("    display: flex;");
        out.println("    gap: 20px;");
        out.println("    padding: 20px;");
        out.println("}");
        out.println();

        out.println(".product-list {");
        out.println("    width: 30%;");
        out.println("    border-right: 1px solid #ddd;");
        out.println("}");
        out.println();

        out.println(".products-container {");
        out.println("    list-style-type: none;");
        out.println("    padding: 0;");
        out.println("}");
        out.println();

        out.println(".product-item {");
        out.println("    display: flex;");
        out.println("    align-items: center;");
        out.println("    gap: 10px;");
        out.println("    padding: 10px;");
        out.println("    cursor: pointer;");
        out.println("    border-bottom: 1px solid #ddd;");
        out.println("    transition: background-color 0.2s;");
        out.println("}");
        out.println();

        out.println(".product-item:hover {");
        out.println("    background-color: #f5f5f5;");
        out.println("}");
        out.println();

        out.println(".product-item img {");
        out.println("    width: 50px;");
        out.println("    height: 50px;");
        out.println("    object-fit: cover;");
        out.println("    border-radius: 4px;");
        out.println("}");
        out.println();

        out.println(".product-details {");
        out.println("    width: 70%;");
        out.println("    padding: 10px;");
        out.println("}");
        out.println();

        out.println(".product-details img {");
        out.println("    width: 200px;");
        out.println("    height: 200px;");
        out.println("    object-fit: cover;");
        out.println("    margin-bottom: 20px;");
        out.println("    border-radius: 8px;");
        out.println("}");
    }

    private String processVanillaCssRule(CssElement rule) {
        StringBuilder sb = new StringBuilder();

        if (rule.getSelectors() != null && !rule.getSelectors().isEmpty()) {
            sb.append(rule.getSelectors().stream()
                    .map(selector -> selector.startsWith(".") ? selector : "." + selector)
                    .collect(Collectors.joining(", ")));
        } else {
            sb.append(".component-element");
        }

        sb.append(" {\n");

        if (rule.getBodyCssElements() != null) {
            for (Bodyelement decl : rule.getBodyCssElements()) {
                sb.append("    ").append(decl.getId_css()).append(": ");
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
}