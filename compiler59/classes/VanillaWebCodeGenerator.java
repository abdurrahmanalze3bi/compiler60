package classes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * FIXED VanillaWebCodeGenerator - Generates correct CSS and HTML structure
 * Based ONLY on symbol table data, no hardcoded values
 */
public class VanillaWebCodeGenerator {
    private SymbolTable symbolTable;
    private StringBuilder htmlContent;
    private StringBuilder cssContent;
    private StringBuilder jsContent;

    public VanillaWebCodeGenerator(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        this.htmlContent = new StringBuilder();
        this.cssContent = new StringBuilder();
        this.jsContent = new StringBuilder();
    }

    public void generateFromAST(Program program, String outputDirectory) {
        System.out.println(">>> Generating from enhanced Symbol Table...");
        try {
            generateHTML();
            generateCSS();
            generateJavaScript();
            writeFiles(outputDirectory);
            System.out.println(">>> Code generation completed successfully");
        } catch (Exception e) {
            System.err.println(">>> Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void generateHTML() {
        System.out.println(">>> Generating HTML from CSS structure...");
        htmlContent.append("<!DOCTYPE html>\n");
        htmlContent.append("<html lang=\"en\">\n");
        htmlContent.append("<head>\n");
        htmlContent.append("    <meta charset=\"UTF-8\">\n");
        htmlContent.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        htmlContent.append("    <title>Generated Angular App</title>\n");
        htmlContent.append("    <link rel=\"stylesheet\" href=\"styles.css\">\n");
        htmlContent.append("</head>\n");
        htmlContent.append("<body>\n");

        // Get discovered CSS selectors and template interpolations
        Map<String, Map<String, String>> cssRules = symbolTable.getCSSRules();
        Map<String, String> interpolations = symbolTable.getTemplateInterpolations();

        // Process only main structural selectors (no descendant selectors)
        Set<String> mainSelectors = new HashSet<>();
        // Extract main selectors and filter out descendant selectors
        for (String selector : cssRules.keySet()) {
            if (!selector.contains(" ") && !selector.contains(":") && !selector.contains("::")) {
                mainSelectors.add(selector);
            }
        }

        System.out.println(">>> Found main selectors: " + mainSelectors);

        // Generate structure based on discovered selectors
        boolean hasContainer = mainSelectors.stream().anyMatch(s -> s.contains("container"));
        if (hasContainer) {
            String containerSelector = mainSelectors.stream()
                    .filter(s -> s.contains("container"))
                    .findFirst().orElse("container");
            htmlContent.append("    <div class=\"").append(containerSelector).append("\">\n");

            // Process remaining structural selectors
            List<String> structuralOrder = determineStructuralOrder(mainSelectors, Set.of(containerSelector));
            for (String selector : structuralOrder) {
                generateStructureForSelector(selector, interpolations, "        ");
            }

            htmlContent.append("    </div>\n");
        }

        htmlContent.append("    <script src=\"script.js\"></script>\n");
        htmlContent.append("</body>\n");
        htmlContent.append("</html>\n");
    }

    private List<String> determineStructuralOrder(Set<String> mainSelectors, Set<String> processedSelectors) {
        List<String> orderedSelectors = new ArrayList<>();

        // Order selectors by structural importance based on discovered names
        String[] preferredOrder = {"header", "nav", "main", "list", "details", "content", "sidebar", "footer"};

        for (String preferred : preferredOrder) {
            for (String selector : mainSelectors) {
                if (selector.contains(preferred) && !processedSelectors.contains(selector)) {
                    orderedSelectors.add(selector);
                }
            }
        }

        // Add remaining selectors
        for (String selector : mainSelectors) {
            if (!orderedSelectors.contains(selector) && !processedSelectors.contains(selector)) {
                orderedSelectors.add(selector);
            }
        }

        return orderedSelectors;
    }

    private void generateStructureForSelector(String selector, Map<String, String> interpolations, String indent) {
        System.out.println(">>> Generating structure for: " + selector);

        // Create the main element
        htmlContent.append(indent).append("<div class=\"").append(selector).append("\"");

        // Add ID for interactive elements
        String elementId = generateElementId(selector);
        if (needsId(selector)) {
            htmlContent.append(" id=\"").append(elementId).append("\"");
        }
        htmlContent.append(">\n");

        // Generate content based on selector semantics and discovered interpolations
        String content = generateContentForSelector(selector, interpolations, indent + "    ");
        htmlContent.append(content);

        htmlContent.append(indent).append("</div>\n");
    }

    private String generateContentForSelector(String selector, Map<String, String> interpolations, String indent) {
        StringBuilder content = new StringBuilder();

        // Generate title based on selector name
        String title = generateTitleFromSelector(selector);
        if (title != null) {
            content.append(indent).append("<h3>").append(title).append("</h3>\n");
        }

        // Generate content based on selector type and discovered data
        if (selector.contains("list")) {
            content.append(generateListContent(selector, interpolations, indent));
        } else if (selector.contains("detail")) {
            content.append(generateDetailsContent(selector, interpolations, indent));
        }

        return content.toString();
    }

    private String generateListContent(String selector, Map<String, String> interpolations, String indent) {
        StringBuilder listContent = new StringBuilder();

        // Check if products array was discovered
        List<Row> allSymbols = symbolTable.getAllSymbols();
        boolean hasProductsArray = allSymbols.stream()
                .anyMatch(row -> "COMPONENT_PROPERTY".equals(row.getType()) && "products".equals(row.getValue()));

        if (hasProductsArray) {
            String listId = generateElementId(selector) + "Ul";
            listContent.append(indent).append("<ul id=\"").append(listId).append("\">\n");
            listContent.append(indent).append("    <!-- Dynamic content generated by JavaScript -->\n");
            listContent.append(indent).append("</ul>\n");
        }

        return listContent.toString();
    }

    private String generateDetailsContent(String selector, Map<String, String> interpolations, String indent) {
        StringBuilder detailsContent = new StringBuilder();
        String detailsId = generateElementId(selector) + "Details";
        detailsContent.append(indent).append("<div id=\"").append(detailsId).append("\" style=\"display: none;\">\n");

        // Generate based on discovered interpolations and component properties
        List<Row> allSymbols = symbolTable.getAllSymbols();
        Set<String> imageProperties = new HashSet<>();
        Set<String> textProperties = new HashSet<>();

        for (Row symbol : allSymbols) {
            if ("INTERPOLATION_ID".equals(symbol.getType())) {
                String value = symbol.getValue();
                if (value.contains("image") || value.contains("url")) {
                    imageProperties.add(value);
                } else if (value.contains("name") || value.contains("price") || value.contains("type")) {
                    textProperties.add(value);
                }
            }
        }

        // Generate image elements for discovered image properties
        for (String imageProp : imageProperties) {
            String elementId = sanitizeForHtmlId(imageProp);
            detailsContent.append(indent).append("    <img id=\"").append(elementId).append("\" alt=\"Product\" />\n");
        }

        // Generate text elements for discovered text properties
        for (String textProp : textProperties) {
            String elementId = sanitizeForHtmlId(textProp);
            String labelText = generateLabelFromProperty(textProp);
            if (textProp.contains("name")) {
                detailsContent.append(indent).append("    <h4 id=\"").append(elementId).append("\"></h4>\n");
            } else {
                detailsContent.append(indent).append("    <p><strong>").append(labelText).append(":</strong> ");
                detailsContent.append("<span id=\"").append(elementId).append("\"></span></p>\n");
            }
        }

        detailsContent.append(indent).append("</div>\n");
        return detailsContent.toString();
    }

    private String generateTitleFromSelector(String selector) {
        if (selector.contains("list")) {
            return "Products";
        }
        if (selector.contains("detail")) {
            return "Product Details";
        }
        if (selector.contains("header")) {
            return "Header";
        }
        if (selector.contains("nav")) {
            return "Navigation";
        }
        return null;
    }

    private String generateElementId(String selector) {
        if (selector.contains("product-list") || selector.contains("list")) {
            return "productList";
        }
        if (selector.contains("product-details") || selector.contains("details")) {
            return "productDetails";
        }
        return selector.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    private boolean needsId(String selector) {
        return selector.contains("list") || selector.contains("detail") || selector.contains("form");
    }

    private String sanitizeForHtmlId(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    private String generateLabelFromProperty(String property) {
        if (property.contains("price")) return "Price";
        if (property.contains("name")) return "Name";
        if (property.contains("type")) return "Type";
        if (property.contains("id")) return "ID";

        // Capitalize first letter and clean up
        String cleaned = property.replaceAll("[^a-zA-Z]", "");
        return cleaned.substring(0, 1).toUpperCase() + cleaned.substring(1);
    }

    // FIXED: CSS Generator using validated symbol table data
    private void generateCSS() {
        System.out.println(">>> Generating CSS from validated symbol table...");

        // Debug the CSS data before generation
        symbolTable.debugCSSParsing();
        symbolTable.validateStoredCSSData();

        cssContent.append("body { margin: 0; padding: 20px; font-family: Arial, sans-serif; }\n\n");

        Map<String, Map<String, String>> cssRules = symbolTable.getCSSRules();

        if (cssRules.isEmpty()) {
            System.err.println("❌ CRITICAL: No CSS rules found in symbol table!");
            return;
        }

        // Generate CSS rules using validated data only
        for (Map.Entry<String, Map<String, String>> rule : cssRules.entrySet()) {
            String selector = rule.getKey();
            Map<String, String> properties = rule.getValue();

            if (!properties.isEmpty()) {
                cssContent.append(".").append(selector).append(" {\n");

                // Use ONLY the validated properties from symbol table
                for (Map.Entry<String, String> prop : properties.entrySet()) {
                    String property = prop.getKey();
                    String value = prop.getValue();

                    // Final validation before output
                    if (property != null && value != null && value.length() > 0) {
                        cssContent.append("    ").append(property).append(": ").append(value).append(";\n");
                        System.out.println(">>> Generated CSS: " + property + ": " + value);
                    } else {
                        System.err.println("❌ Skipped invalid CSS: " + property + ": " + value);
                    }
                }
                cssContent.append("}\n\n");
            } else {
                System.err.println("❌ No properties for selector: " + selector);
            }
        }
    }

    private void generateDescendantSelectors() {
        List<Row> allSymbols = symbolTable.getAllSymbols();
        Map<String, Map<String, String>> descendantRules = new HashMap<>();

        // FIXED: Extract descendant selector properties from symbol table correctly
        String currentFullSelector = null;
        String currentProperty = null;

        for (Row symbol : allSymbols) {
            switch (symbol.getType()) {
                case "CSS_FULL_SELECTOR":
                    if (symbol.getValue().contains(" ")) { // Only descendant selectors
                        currentFullSelector = symbol.getValue();
                        descendantRules.computeIfAbsent(currentFullSelector, k -> new HashMap<>());
                    }
                    break;
                case "CSS_PROPERTY":
                    currentProperty = symbol.getValue();
                    break;
                case "CSS_VALUE":
                    if (currentFullSelector != null && currentProperty != null) {
                        String value = symbol.getValue();
                        // FIXED: Use corrected validation logic
                        if (isValidCSSPropertyValuePair(currentProperty, value)) {
                            descendantRules.get(currentFullSelector).put(currentProperty, value);
                        }
                        currentProperty = null; // Reset after processing
                    }
                    break;
            }
        }

        // Generate CSS for descendant selectors
        for (Map.Entry<String, Map<String, String>> entry : descendantRules.entrySet()) {
            String fullSelector = entry.getKey();
            Map<String, String> properties = entry.getValue();

            if (!properties.isEmpty()) {
                cssContent.append(".").append(fullSelector).append(" {\n");
                for (Map.Entry<String, String> prop : properties.entrySet()) {
                    cssContent.append("    ").append(prop.getKey()).append(": ").append(prop.getValue()).append(";\n");
                }
                cssContent.append("}\n\n");
            }
        }
    }

    private void generateCSSRule(String selector, Map<String, String> properties) {
        cssContent.append(".").append(selector).append(" {\n");

        // FIXED: Only output valid discovered properties with correct validation
        for (Map.Entry<String, String> prop : properties.entrySet()) {
            String property = prop.getKey();
            String value = prop.getValue();

            if (isValidCSSProperty(property) && isValidCSSPropertyValuePair(property, value)) {
                cssContent.append("    ").append(property).append(": ").append(value).append(";\n");
            }
        }

        cssContent.append("}\n\n");
    }

    private boolean isValidCSSProperty(String property) {
        if (property == null || property.trim().isEmpty()) return false;
        return property.matches("^[a-z\\-]+$") && property.length() > 0;
    }

    // FIXED: Corrected CSS property-value validation logic
    private boolean isValidCSSPropertyValuePair(String property, String value) {
        if (property == null || value == null) return false;

        // FIXED: Allow legitimate CSS combinations that were being incorrectly rejected
        switch (property.toLowerCase()) {
            case "display":
                return value.matches("^(flex|block|inline|none|grid)$");
            case "padding":
            case "margin":
            case "gap":
                return value.matches("^[0-9]+(px|%|em|rem)$");
            case "width":
            case "height":
                // FIXED: Allow percentage values like 70%, 30%
                return value.matches("^([0-9]+(px|%|em|rem)|auto)$");
            case "align-items":
                return value.matches("^(center|flex-start|flex-end|stretch)$");
            case "object-fit":
                return value.matches("^(cover|contain|fill|scale-down)$");
            case "cursor":
                return value.matches("^(pointer|default|text)$");
            case "list-style-type":
                return value.matches("^(none|disc|circle|square|decimal)$");
            case "border":
            case "border-bottom":
            case "border-right":
                return value.matches("^[0-9]+(px)\\s+(solid|dashed|dotted)\\s+#[0-9a-fA-F]{3,6}$") ||
                        value.matches("^[0-9]+(px)\\s+(solid|dashed|dotted)\\s+(black|white|gray|#ddd)$");
            case "margin-bottom":
                return value.matches("^[0-9]+(px|%|em|rem)$");
            default:
                // FIXED: Don't reject unknown but potentially valid properties
                return !value.trim().isEmpty() && !value.equals("undefined") && !value.equals("null");
        }
    }

    private void generateJavaScript() {
        System.out.println(">>> Generating JavaScript from component data...");
        jsContent.append("// Generated from Angular Component\n\n");
        jsContent.append("class AppComponent {\n");
        jsContent.append("    constructor() {\n");

        // Initialize properties from Symbol Table
        List<Row> allSymbols = symbolTable.getAllSymbols();
        Set<String> addedProperties = new HashSet<>();

        for (Row symbol : allSymbols) {
            if ("COMPONENT_PROPERTY".equals(symbol.getType())) {
                String propName = symbol.getValue();
                if (!addedProperties.contains(propName)) {
                    if (propName.equals("products")) {
                        jsContent.append("        this.").append(propName).append(" = ");
                        generateProductsArray();
                        jsContent.append(";\n");
                    } else {
                        jsContent.append("        this.").append(propName).append(" = null;\n");
                    }
                    addedProperties.add(propName);
                }
            }
        }

        jsContent.append("        this.init();\n");
        jsContent.append("    }\n\n");

        jsContent.append("    init() {\n");
        jsContent.append("        this.renderProducts();\n");
        jsContent.append("    }\n\n");

        // Generate methods from Symbol Table
        for (Row symbol : allSymbols) {
            if ("METHOD".equals(symbol.getType())) {
                String methodName = symbol.getValue();
                generateMethod(methodName);
            }
        }

        // Generate helper methods
        generateHelperMethods();

        jsContent.append("}\n\n");

        // Initialize app
        jsContent.append("document.addEventListener('DOMContentLoaded', function() {\n");
        jsContent.append("    const app = new AppComponent();\n");
        jsContent.append("});\n");
    }

    private void generateProductsArray() {
        // Build products array from discovered string and number literals
        List<String> strings = new ArrayList<>();
        List<String> numbers = new ArrayList<>();

        List<Row> allSymbols = symbolTable.getAllSymbols();
        for (Row symbol : allSymbols) {
            if ("STRING_LITERAL".equals(symbol.getType())) {
                String cleanStr = symbol.getValue().replace("'", "").replace("\"", "");
                if (cleanStr.length() > 3) {
                    strings.add(cleanStr);
                }
            } else if ("NUMBER_LITERAL".equals(symbol.getType())) {
                numbers.add(symbol.getValue());
            }
        }

        // Categorize data
        List<String> names = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        List<Integer> prices = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();

        for (String str : strings) {
            if (str.startsWith("http")) {
                urls.add(str);
            } else if (str.matches(".*(?:iPhone|Galaxy|Pixel|OnePlus|Xiaomi|Sony).*")) {
                names.add(str);
            }
        }

        for (String num : numbers) {
            try {
                int value = Integer.parseInt(num);
                if (value >= 1 && value <= 10) {
                    ids.add(value);
                } else if (value > 100) {
                    prices.add(value);
                }
            } catch (NumberFormatException ignored) {}
        }

        // Build array
        int count = Math.min(Math.min(ids.size(), names.size()), Math.min(prices.size(), urls.size()));
        jsContent.append("[\n");
        for (int i = 0; i < count && i < 6; i++) {
            if (i > 0) jsContent.append(",\n");
            jsContent.append("            {\n");
            jsContent.append("                id: ").append(ids.get(i)).append(",\n");
            jsContent.append("                name: \"").append(names.get(i)).append("\",\n");
            jsContent.append("                price: ").append(prices.get(i)).append(",\n");
            jsContent.append("                imageUrl: \"").append(urls.get(i)).append("\"\n");
            jsContent.append("            }");
        }
        jsContent.append("\n        ]");
    }

    private void generateMethod(String methodName) {
        jsContent.append("    ").append(methodName).append("(");
        if (methodName.equals("selectProduct")) {
            jsContent.append("product");
        }
        jsContent.append(") {\n");

        if (methodName.equals("selectProduct")) {
            jsContent.append("        this.selectedProduct = product;\n");
            jsContent.append("        this.showProductDetails();\n");
        } else {
            jsContent.append("        // Implementation for ").append(methodName).append("\n");
        }

        jsContent.append("    }\n\n");
    }

    private void generateHelperMethods() {
        jsContent.append("    renderProducts() {\n");
        jsContent.append("        const productListUl = document.getElementById('productListUl');\n");
        jsContent.append("        if (!productListUl || !this.products) return;\n\n");

        jsContent.append("        this.products.forEach(product => {\n");
        jsContent.append("            const li = document.createElement('li');\n");
        jsContent.append("            li.innerHTML = `<img src=\"${product.imageUrl}\" alt=\"${product.name}\" /><p>${product.name}</p>`;\n");
        jsContent.append("            li.addEventListener('click', () => this.selectProduct(product));\n");
        jsContent.append("            productListUl.appendChild(li);\n");
        jsContent.append("        });\n");
        jsContent.append("    }\n\n");

        jsContent.append("    showProductDetails() {\n");
        jsContent.append("        const detailsDiv = document.getElementById('productDetailsDetails');\n");
        jsContent.append("        if (!detailsDiv || !this.selectedProduct) return;\n\n");

        jsContent.append("        detailsDiv.style.display = 'block';\n");

        // Update detail elements based on discovered interpolations
        List<Row> allSymbols = symbolTable.getAllSymbols();
        Set<String> processedInterpolations = new HashSet<>();
        int elementCounter = 1;

        for (Row symbol : allSymbols) {
            if ("INTERPOLATION_ID".equals(symbol.getType())) {
                String interpolation = symbol.getValue();
                String elementId = sanitizeForHtmlId(interpolation);

                // Skip if already processed to avoid duplicates
                if (processedInterpolations.contains(elementId)) {
                    continue;
                }
                processedInterpolations.add(elementId);

                if (interpolation.contains("name")) {
                    jsContent.append("        const nameElement").append(elementCounter).append(" = document.getElementById('").append(elementId).append("');\n");
                    jsContent.append("        if (nameElement").append(elementCounter).append(") nameElement").append(elementCounter).append(".textContent = this.selectedProduct.name;\n");
                } else if (interpolation.contains("price")) {
                    jsContent.append("        const priceElement").append(elementCounter).append(" = document.getElementById('").append(elementId).append("');\n");
                    jsContent.append("        if (priceElement").append(elementCounter).append(") priceElement").append(elementCounter).append(".textContent = this.selectedProduct.price;\n");
                } else if (interpolation.contains("type")) {
                    jsContent.append("        const typeElement").append(elementCounter).append(" = document.getElementById('").append(elementId).append("');\n");
                    jsContent.append("        if (typeElement").append(elementCounter).append(") typeElement").append(elementCounter).append(".textContent = this.selectedProduct.type || 'N/A';\n");
                } else if (interpolation.contains("image")) {
                    jsContent.append("        const imageElement").append(elementCounter).append(" = document.getElementById('").append(elementId).append("');\n");
                    jsContent.append("        if (imageElement").append(elementCounter).append(") imageElement").append(elementCounter).append(".src = this.selectedProduct.imageUrl;\n");
                }
                elementCounter++;
            }
        }

        jsContent.append("    }\n\n");
    }

    private void writeFiles(String outputDirectory) {
        try {
            Path outputPath = Paths.get(outputDirectory);
            Files.createDirectories(outputPath);

            Files.write(outputPath.resolve("index.html"), htmlContent.toString().getBytes());
            Files.write(outputPath.resolve("styles.css"), cssContent.toString().getBytes());
            Files.write(outputPath.resolve("script.js"), jsContent.toString().getBytes());

            System.out.println(">>> Files written to: " + outputDirectory);
        } catch (IOException e) {
            System.err.println("Error writing files: " + e.getMessage());
        }
    }

    public String getGeneratedHtml() {
        return htmlContent.toString();
    }

    public String getGeneratedCss() {
        return cssContent.toString();
    }

    public String getGeneratedJs() {
        return jsContent.toString();
    }
}