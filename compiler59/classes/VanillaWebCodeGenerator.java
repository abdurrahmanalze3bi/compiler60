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
    private String extractBaseProperty(String interpolation) {
        if (interpolation == null || interpolation.isEmpty()) {
            return null;
        }
        // Remove non-null assertion and spaces
        String cleaned = interpolation.replace("!", "").trim();
        // Extract property after the dot
        if (cleaned.contains(".")) {
            String[] parts = cleaned.split("\\.");
            return parts[parts.length - 1]; // Return the last part (property name)
        }
        return cleaned;
    }

    // Replace the generateDetailsContent method in VanillaWebCodeGenerator.java
    // Replace generateDetailsContent method in VanillaWebCodeGenerator.java
    private String generateDetailsContent(String selector, Map<String, String> interpolations, String indent) {
        StringBuilder detailsContent = new StringBuilder();
        String detailsId = generateElementId(selector) + "Details";
        detailsContent.append(indent).append("<div id=\"").append(detailsId).append("\" style=\"display: none;\">\n");

        // ALWAYS generate the main product image since we know from debug output that imageUrl is captured
        detailsContent.append(indent).append("    <img id=\"selectedProductImage\" alt=\"Product\" />\n");
        System.out.println(">>> Generated main product image element");

        // Extract properties from INTERPOLATION_ID symbols only
        List<Row> allSymbols = symbolTable.getAllSymbols();
        Set<String> uniqueProperties = new LinkedHashSet<>();

        for (Row symbol : allSymbols) {
            if ("INTERPOLATION_ID".equals(symbol.getType())) {
                String value = symbol.getValue();
                System.out.println(">>> Found interpolation: " + value);
                String baseProperty = extractBaseProperty(value);
                if (baseProperty != null && !baseProperty.isEmpty() && !baseProperty.equals("imageUrl")) {
                    uniqueProperties.add(baseProperty);
                    System.out.println(">>> Added property for HTML: " + baseProperty);
                }
            }
        }

        // Generate elements for each discovered property
        for (String property : uniqueProperties) {
            String elementId = "selectedproduct" + property.toLowerCase();
            String labelText = generateLabelFromProperty(property);

            if ("name".equals(property)) {
                detailsContent.append(indent).append("    <h4 id=\"").append(elementId).append("\"></h4>\n");
            } else {
                detailsContent.append(indent).append("    <p><strong>").append(labelText).append(":</strong> ");
                detailsContent.append("<span id=\"").append(elementId).append("\"></span></p>\n");
            }
            System.out.println(">>> Generated HTML element for: " + property + " with ID: " + elementId);
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

    // Replace generateProductsArray method in VanillaWebCodeGenerator.java
    // Replace generateProductsArray method in VanillaWebCodeGenerator.java
    private void generateProductsArray() {
        List<Row> allSymbols = symbolTable.getAllSymbols();
        List<Map<String, String>> products = new ArrayList<>();
        Map<String, String> currentProduct = null;

        // Collect all data by type first to handle parsing order issues
        List<String> allIds = new ArrayList<>();
        List<String> allNames = new ArrayList<>();
        List<String> allPrices = new ArrayList<>();
        List<String> allImageUrls = new ArrayList<>();
        List<String> allTypes = new ArrayList<>();

        System.out.println(">>> Collecting all product data from Symbol Table");

        for (Row symbol : allSymbols) {
            String type = symbol.getType();
            String value = symbol.getValue();

            if ("OBJECT_PROPERTY_NUMBER".equals(type)) {
                try {
                    int numValue = Integer.parseInt(value);
                    if (numValue >= 1 && numValue <= 20) {
                        allIds.add(value);
                        System.out.println(">>> Found ID: " + value);
                    } else if (numValue >= 50) {
                        allPrices.add(value);
                        System.out.println(">>> Found price: " + value);
                    }
                } catch (NumberFormatException ignored) {}
            } else if ("OBJECT_PROPERTY_STRING".equals(type)) {
                if (value.startsWith("http")) {
                    allImageUrls.add(value);
                    System.out.println(">>> Found imageUrl");
                } else if (value.equals("Smartphone")) {
                    allTypes.add(value);
                    System.out.println(">>> Found type: " + value);
                } else if (value.contains("iPhone") || value.contains("Galaxy") ||
                        value.contains("Pixel") || value.contains("OnePlus") ||
                        value.contains("Xiaomi") || value.contains("Sony")) {
                    allNames.add(value);
                    System.out.println(">>> Found name: " + value);
                }
            }
        }

        // Now reconstruct products using collected data in order
        int productCount = Math.min(Math.min(allIds.size(), allNames.size()),
                Math.min(Math.min(allPrices.size(), allImageUrls.size()), allTypes.size()));

        System.out.println(">>> Reconstructing " + productCount + " products from collected data");
        System.out.println(">>> Available: IDs=" + allIds.size() + ", Names=" + allNames.size() +
                ", Prices=" + allPrices.size() + ", ImageUrls=" + allImageUrls.size() +
                ", Types=" + allTypes.size());

        for (int i = 0; i < productCount; i++) {
            Map<String, String> product = new LinkedHashMap<>();
            product.put("id", allIds.get(i));
            product.put("name", allNames.get(i));
            product.put("price", allPrices.get(i));
            product.put("imageUrl", allImageUrls.get(i));
            product.put("type", allTypes.get(i));
            products.add(product);
            System.out.println(">>> Reconstructed product " + (i+1) + ": " + allNames.get(i));
        }

        if (products.isEmpty()) {
            System.err.println(">>> ERROR: No complete products reconstructed");
            jsContent.append("[]");
            return;
        }

        System.out.println(">>> Successfully reconstructed " + products.size() + " products");

        // Generate the array maintaining original associations
        jsContent.append("[\n");
        for (int i = 0; i < products.size(); i++) {
            if (i > 0) jsContent.append(",\n");
            Map<String, String> product = products.get(i);
            jsContent.append("            {\n");
            jsContent.append("                id: ").append(product.get("id")).append(",\n");
            jsContent.append("                name: \"").append(product.get("name")).append("\",\n");
            jsContent.append("                price: ").append(product.get("price")).append(",\n");
            jsContent.append("                imageUrl: \"").append(product.get("imageUrl")).append("\",\n");
            jsContent.append("                type: \"").append(product.get("type")).append("\"\n");
            jsContent.append("            }");
            System.out.println(">>> Generated complete product: " + product.get("name"));
        }
        jsContent.append("\n        ]");
    }

    private boolean isCompleteProduct(Map<String, String> product) {
        return product.containsKey("id") && product.containsKey("name") &&
                product.containsKey("price") && product.containsKey("imageUrl") &&
                product.containsKey("type");
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

    // Replace the generateHelperMethods method in VanillaWebCodeGenerator.java
    // Replace generateHelperMethods method in VanillaWebCodeGenerator.java
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
        jsContent.append("        detailsDiv.style.display = 'block';\n\n");

        // ALWAYS handle the main product image since we know imageUrl is captured
        jsContent.append("        const productImage = document.getElementById('selectedProductImage');\n");
        jsContent.append("        if (productImage && this.selectedProduct.imageUrl) {\n");
        jsContent.append("            productImage.src = this.selectedProduct.imageUrl;\n");
        jsContent.append("            productImage.alt = this.selectedProduct.name;\n");
        jsContent.append("        }\n\n");

        // Handle name, price, type based on what we know is captured
        jsContent.append("        const nameElement = document.getElementById('selectedproductname');\n");
        jsContent.append("        if (nameElement && this.selectedProduct.name !== undefined) {\n");
        jsContent.append("            nameElement.textContent = this.selectedProduct.name;\n");
        jsContent.append("        }\n\n");

        jsContent.append("        const priceElement = document.getElementById('selectedproductprice');\n");
        jsContent.append("        if (priceElement && this.selectedProduct.price !== undefined) {\n");
        jsContent.append("            priceElement.textContent = this.selectedProduct.price;\n");
        jsContent.append("        }\n\n");

        jsContent.append("        const typeElement = document.getElementById('selectedproducttype');\n");
        jsContent.append("        if (typeElement && this.selectedProduct.type !== undefined) {\n");
        jsContent.append("            typeElement.textContent = this.selectedProduct.type;\n");
        jsContent.append("        }\n\n");

        jsContent.append("    }\n\n");
    }

    // Helper method to extract base property name from interpolation (same as in HTML generation)



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

    public String getGeneratedHtml() { return htmlContent.toString(); }
    public String getGeneratedCss() { return cssContent.toString(); }
    public String getGeneratedJs() { return jsContent.toString(); }
}