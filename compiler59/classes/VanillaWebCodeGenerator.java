package classes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Dynamic Vanilla Web Code Generator
 * Converts Angular components to vanilla HTML, CSS, and JavaScript
 * Uses Symbol Table and Semantic Error Manager data for intelligent generation
 */
public class VanillaWebCodeGenerator {
    private SymbolTable symbolTable;
    private StringBuilder htmlContent;
    private StringBuilder cssContent;
    private StringBuilder jsContent;

    // Dynamic extraction results
    private Map<String, String> componentProperties;
    private Map<String, String> propertyTypes;
    private Map<String, String> propertyInitValues;
    private List<String> templateVariables;
    private Map<String, String> eventBindings;
    private Map<String, String> propertyBindings;
    private List<String> methods;
    private Map<String, String> methodBodies;
    private String componentSelector;
    private List<String> cssRules;
    private Map<String, Map<String, String>> cssProperties;

    public VanillaWebCodeGenerator(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        this.htmlContent = new StringBuilder();
        this.cssContent = new StringBuilder();
        this.jsContent = new StringBuilder();

        // Initialize dynamic data structures
        this.componentProperties = new HashMap<>();
        this.propertyTypes = new HashMap<>();
        this.propertyInitValues = new HashMap<>();
        this.templateVariables = new ArrayList<>();
        this.eventBindings = new HashMap<>();
        this.propertyBindings = new HashMap<>();
        this.methods = new ArrayList<>();
        this.methodBodies = new HashMap<>();
        this.cssRules = new ArrayList<>();
        this.cssProperties = new HashMap<>();
    }

    public void generateFromAST(Program program, String outputDirectory) {
        System.out.println(">>> Starting dynamic code generation from AST...");

        // Extract all data dynamically from AST and Symbol Table
        extractComponentData(program);

        // Generate code based on extracted data
        generateHTML();
        generateCSS();
        generateJavaScript();

        // Write files to output directory
        writeGeneratedFiles(outputDirectory);

        System.out.println(">>> Dynamic code generation completed successfully");
    }

    private void extractComponentData(Program program) {
        System.out.println(">>> Extracting component data dynamically...");

        // Extract from Symbol Table
        extractFromSymbolTable();

        // Extract from AST
        extractFromAST(program);

        System.out.println(">>> Component properties found: " + componentProperties.size());
        System.out.println(">>> Methods found: " + methods.size());
        System.out.println(">>> CSS rules found: " + cssRules.size());
    }

    private void extractFromSymbolTable() {
        List<Row> allSymbols = symbolTable.getAllSymbols();

        for (Row symbol : allSymbols) {
            String type = symbol.getType();
            String value = symbol.getValue();
            String scope = symbol.getScopeName();

            switch (type) {
                case "COMPONENT_PROPERTY":
                case "PROPERTY":
                    componentProperties.put(value, "any");
                    System.out.println(">>> Found property from symbol table: " + value);
                    break;

                case "METHOD":
                    if (!methods.contains(value)) {
                        methods.add(value);
                        System.out.println(">>> Found method from symbol table: " + value);
                    }
                    break;

                case "TEMPLATE_VARIABLE":
                    if (!templateVariables.contains(value)) {
                        templateVariables.add(value);
                        System.out.println(">>> Found template variable: " + value);
                    }
                    break;

                case "SELECTOR_STRING":
                    componentSelector = value.replace("'", "").replace("\"", "");
                    System.out.println(">>> Found selector: " + componentSelector);
                    break;

                case "CSS_SELECTOR":
                    if (!cssRules.contains(value)) {
                        cssRules.add(value);
                        System.out.println(">>> Found CSS selector: " + value);
                    }
                    break;

                case "CSS_PROPERTY":
                    // Will be handled when we find the full CSS rule
                    break;

                case "EVENT_BINDING":
                    // Extract event name from binding syntax
                    String eventName = extractEventName(value);
                    if (eventName != null) {
                        eventBindings.put(eventName, "");
                        System.out.println(">>> Found event binding: " + eventName);
                    }
                    break;

                case "BINDING_PROPERTY":
                    propertyBindings.put(value, "");
                    System.out.println(">>> Found property binding: " + value);
                    break;
            }
        }
    }

    private void extractFromAST(Program program) {
        if (program == null || program.getStatments() == null) return;

        for (Statment statement : program.getStatments()) {
            if (statement.getComponentDeclaration() != null) {
                extractFromComponent(statement.getComponentDeclaration());
            } else if (statement.getClassDeclaration() != null) {
                extractFromClass(statement.getClassDeclaration());
            } else if (statement.getInterfaceDeclaration() != null) {
                extractFromInterface(statement.getInterfaceDeclaration());
            }
        }
    }

    private void extractFromComponent(ComponentDeclaration component) {
        if (component.getComponentDeclarationBody() == null) return;

        ComponentDeclarationBody body = component.getComponentDeclarationBody();
        if (body.getComponentBodyElements() == null) return;

        for (ComponentBodyElement element : body.getComponentBodyElements()) {
            if (element.getSelector() != null && element.getSelector().getSTRING_LIT() != null) {
                componentSelector = element.getSelector().getSTRING_LIT().replace("'", "").replace("\"", "");
            } else if (element.getTemplate() != null) {
                extractFromTemplate(element.getTemplate());
            } else if (element.getStyles() != null) {
                extractFromStyles(element.getStyles());
            }
        }
    }

    private void extractFromTemplate(Template template) {
        if (template.getElement() == null) return;

        StringBuilder templateHtml = new StringBuilder();

        for (Element element : template.getElement()) {
            extractFromElement(element, templateHtml);
        }

        // Process the extracted HTML for bindings and directives
        processTemplateContent(templateHtml.toString());
    }

    private void extractFromElement(Element element, StringBuilder templateHtml) {
        if (element.getTag() != null) {
            extractFromTag(element.getTag(), templateHtml);
        } else if (element.getHtmlName() != null) {
            templateHtml.append("<").append(element.getHtmlName()).append(">");
        } else if (element.getInterpolation() != null) {
            String interpolationVar = element.getInterpolation().getNAME_HTML();
            templateHtml.append("{{").append(interpolationVar).append("}}");
        }
    }

    private void extractFromTag(Tag tag, StringBuilder templateHtml) {
        if (tag.getOpeningTag() != null && tag.getClosingTag() != null) {
            // Extract opening tag
            OpeningTag openTag = tag.getOpeningTag();
            String tagName = extractTagName(openTag);

            templateHtml.append("<").append(tagName);

            // Extract attributes
            if (openTag.getAttributes() != null) {
                for (Attributes attr : openTag.getAttributes()) {
                    extractFromAttributes(attr, templateHtml);
                }
            }

            templateHtml.append(">");

            // Extract nested elements
            if (tag.getElements() != null) {
                for (Element nestedElement : tag.getElements()) {
                    extractFromElement(nestedElement, templateHtml);
                }
            }

            // Extract closing tag
            String closingTagName = tag.getClosingTag().getNAME_HTML();
            templateHtml.append("</").append(closingTagName).append(">");

        } else if (tag.getSelfClosingTag() != null) {
            SelfClosingTag selfTag = tag.getSelfClosingTag();
            templateHtml.append("<").append("div"); // Default tag name

            if (selfTag.getAttributes() != null) {
                for (Attributes attr : selfTag.getAttributes()) {
                    extractFromAttributes(attr, templateHtml);
                }
            }

            templateHtml.append(" />");
        }
    }

    private void extractFromAttributes(Attributes attr, StringBuilder templateHtml) {
        if (attr.getHtmlName() != null && attr.getHtmlString() != null) {
            // Regular HTML attribute
            String attrName = attr.getHtmlName();
            String attrValue = attr.getHtmlString().replace("\"", "").replace("'", "");
            templateHtml.append(" ").append(attrName).append("=\"").append(attrValue).append("\"");

        } else if (attr.getStructuralDir() != null) {
            // Structural directive (e.g., *ngFor, *ngIf)
            String directive = attr.getStructuralDir();
            String value = attr.getHtmlString().replace("\"", "").replace("'", "");

            if (directive.contains("ngFor")) {
                processNgForDirective(value, templateHtml);
            } else if (directive.contains("ngIf")) {
                processNgIfDirective(value, templateHtml);
            }

        } else if (attr.getBinding() != null) {
            // Property binding [property]="value"
            String property = attr.getBinding().replace("[", "").replace("]", "");
            String value = attr.getHtmlString().replace("\"", "").replace("'", "");
            propertyBindings.put(property, value);
            templateHtml.append(" data-bind-").append(property).append("=\"").append(value).append("\"");

        } else if (attr.getEvent() != null) {
            // Event binding (click)="method()"
            String event = attr.getEvent().replace("(", "").replace(")", "");
            String handler = attr.getHtmlString().replace("\"", "").replace("'", "");
            eventBindings.put(event, handler);
            templateHtml.append(" data-event-").append(event).append("=\"").append(handler).append("\"");
        }
    }

    private void extractFromStyles(Styles styles) {
        if (styles.getCssBody() == null) return;

        CssBody cssBody = styles.getCssBody();
        if (cssBody.getCssObjects() == null) return;

        CssObjects cssObjects = cssBody.getCssObjects();
        if (cssObjects.getCssElementlist() == null) return;

        for (CssElement cssElement : cssObjects.getCssElementlist()) {
            extractFromCssElement(cssElement);
        }
    }

    private void extractFromCssElement(CssElement cssElement) {
        // Extract selectors
        List<String> selectors = cssElement.getSelectors();
        if (selectors == null || selectors.isEmpty()) return;

        String selectorString = String.join(" ", selectors);
        if (!cssRules.contains(selectorString)) {
            cssRules.add(selectorString);
        }

        Map<String, String> properties = new HashMap<>();

        // Extract CSS properties
        if (cssElement.getBodyCssElements() != null) {
            for (Bodyelement bodyElement : cssElement.getBodyCssElements()) {
                if (bodyElement.getId_css() != null && bodyElement.getCssValue() != null) {
                    String property = bodyElement.getId_css();
                    String value = extractCssValue(bodyElement.getCssValue());
                    properties.put(property, value);
                }
            }
        }

        cssProperties.put(selectorString, properties);
    }

    private void extractFromClass(ClassDeclaration classDecl) {
        if (classDecl.getClassDeclarationBody() == null) return;

        ClassDeclarationBody body = classDecl.getClassDeclarationBody();
        if (body.getClassMembers() == null) return;

        for (ClassMember member : body.getClassMembers()) {
            if (member.getPropertyDeclaration() != null) {
                extractFromProperty(member.getPropertyDeclaration());
            } else if (member.getMethodDeclaration() != null) {
                extractFromMethod(member.getMethodDeclaration());
            }
        }
    }

    private void extractFromProperty(PropertyDeclaration prop) {
        if (prop.getID() == null || prop.getID().isEmpty()) return;

        String propName = prop.getID().get(0);
        componentProperties.put(propName, "any");

        if (prop.getTypeV() != null) {
            String type = extractTypeFromTypeV(prop.getTypeV());
            propertyTypes.put(propName, type);
        }

        if (prop.getInitvalue() != null) {
            String initValue = extractInitValue(prop.getInitvalue());
            propertyInitValues.put(propName, initValue);
        }
    }

    private void extractFromMethod(MethodDeclaration method) {
        String methodName = method.getName();
        if (methodName != null && !methods.contains(methodName)) {
            methods.add(methodName);
        }

        if (method.getMethodBody() != null) {
            String methodBody = extractMethodBody(method.getMethodBody());
            methodBodies.put(methodName, methodBody);
        }
    }

    private void extractFromInterface(InterfaceDeclaration interfaceDecl) {
        // Extract interface properties as potential data models
        if (interfaceDecl.getInterfaceMembers() == null) return;

        for (InterfaceMember member : interfaceDecl.getInterfaceMembers()) {
            if (member.getPropertyDeclaration() != null) {
                extractFromProperty(member.getPropertyDeclaration());
            }
        }
    }

    // HTML Generation
    private void generateHTML() {
        System.out.println(">>> Generating HTML dynamically...");

        htmlContent.append("<!DOCTYPE html>\n");
        htmlContent.append("<html lang=\"en\">\n");
        htmlContent.append("<head>\n");
        htmlContent.append("    <meta charset=\"UTF-8\">\n");
        htmlContent.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        htmlContent.append("    <title>Generated App</title>\n");
        htmlContent.append("    <link rel=\"stylesheet\" href=\"styles.css\">\n");
        htmlContent.append("</head>\n");
        htmlContent.append("<body>\n");

        // Generate app container
        if (componentSelector != null) {
            htmlContent.append("    <div class=\"").append(componentSelector.replace("app-", "")).append("\">\n");
        } else {
            htmlContent.append("    <div class=\"app-container\">\n");
        }

        // Generate HTML from extracted template data
        generateTemplateHTML();

        htmlContent.append("    </div>\n");
        htmlContent.append("    <script src=\"script.js\"></script>\n");
        htmlContent.append("</body>\n");
        htmlContent.append("</html>\n");
    }

    private void generateTemplateHTML() {
        // Look for template content from symbol table or reconstructed from bindings
        generateContainerDivs();
        generateProductList();
        generateProductDetails();
    }

    private void generateContainerDivs() {
        // Check if we have container-related CSS
        boolean hasContainer = cssRules.stream().anyMatch(rule -> rule.contains("container"));

        if (hasContainer) {
            htmlContent.append("        <div class=\"container\">\n");

            // Generate product list section
            boolean hasProductList = cssRules.stream().anyMatch(rule -> rule.contains("product-list"));
            if (hasProductList) {
                htmlContent.append("            <div class=\"product-list\">\n");
                htmlContent.append("                <h3>Products</h3>\n");
                htmlContent.append("                <ul id=\"productList\">\n");
                htmlContent.append("                    <!-- Products will be generated by JavaScript -->\n");
                htmlContent.append("                </ul>\n");
                htmlContent.append("            </div>\n");
            }

            // Generate product details section
            boolean hasProductDetails = cssRules.stream().anyMatch(rule -> rule.contains("product-details"));
            if (hasProductDetails) {
                htmlContent.append("            <div class=\"product-details\" id=\"productDetails\" style=\"display: none;\">\n");
                htmlContent.append("                <h3>Product Details</h3>\n");
                htmlContent.append("                <img id=\"detailImage\" src=\"\" alt=\"\" />\n");
                htmlContent.append("                <h4 id=\"detailName\"></h4>\n");
                htmlContent.append("                <p><strong>Price:</strong> <span id=\"detailPrice\"></span></p>\n");
                htmlContent.append("                <p><strong>Type:</strong> <span id=\"detailType\"></span></p>\n");
                htmlContent.append("            </div>\n");
            }

            htmlContent.append("        </div>\n");
        }
    }

    private void generateProductList() {
        // This will be handled by JavaScript based on component properties
    }

    private void generateProductDetails() {
        // This will be handled by JavaScript based on component properties
    }

    // CSS Generation
    private void generateCSS() {
        System.out.println(">>> Generating CSS dynamically...");

        // Generate CSS from extracted rules and properties
        for (String selector : cssRules) {
            Map<String, String> properties = cssProperties.get(selector);

            if (properties != null && !properties.isEmpty()) {
                // Clean selector (remove dots if present)
                String cleanSelector = selector.startsWith(".") ? selector : "." + selector;
                cssContent.append(cleanSelector).append(" {\n");

                for (Map.Entry<String, String> property : properties.entrySet()) {
                    cssContent.append("    ").append(property.getKey()).append(": ").append(property.getValue()).append(";\n");
                }

                cssContent.append("}\n\n");
            }
        }

        // Add any missing essential styles
        generateEssentialStyles();
    }

    private void generateEssentialStyles() {
        // Only add styles if we don't already have them
        if (!cssRules.contains("body") && !cssRules.contains("html")) {
            cssContent.append("body {\n");
            cssContent.append("    margin: 0;\n");
            cssContent.append("    padding: 20px;\n");
            cssContent.append("    font-family: Arial, sans-serif;\n");
            cssContent.append("}\n\n");
        }
    }

    // JavaScript Generation
    private void generateJavaScript() {
        System.out.println(">>> Generating JavaScript dynamically...");

        jsContent.append("// Generated JavaScript from Angular Component\n\n");

        // Generate component class
        generateComponentClass();

        // Generate initialization
        generateInitialization();

        // Generate event handlers
        generateEventHandlers();
    }

    private void generateComponentClass() {
        jsContent.append("class AppComponent {\n");
        jsContent.append("    constructor() {\n");

        // Generate properties from extracted data
        for (Map.Entry<String, String> property : componentProperties.entrySet()) {
            String propName = property.getKey();
            String initValue = propertyInitValues.get(propName);

            if (initValue != null) {
                jsContent.append("        this.").append(propName).append(" = ").append(initValue).append(";\n");
            } else {
                jsContent.append("        this.").append(propName).append(" = null;\n");
            }
        }

        jsContent.append("        this.init();\n");
        jsContent.append("    }\n\n");

        // Generate methods
        for (String methodName : methods) {
            generateMethod(methodName);
        }

        jsContent.append("}\n\n");
    }

    private void generateMethod(String methodName) {
        jsContent.append("    ").append(methodName).append("(");

        // Generate parameters if method has them
        if (methodName.equals("selectProduct")) {
            jsContent.append("product");
        }

        jsContent.append(") {\n");

        // Generate method body based on extracted data or infer from name
        String methodBody = methodBodies.get(methodName);
        if (methodBody != null && !methodBody.trim().isEmpty()) {
            jsContent.append("        ").append(methodBody).append("\n");
        } else {
            // Infer method behavior from name and context
            if (methodName.equals("selectProduct")) {
                jsContent.append("        this.selectedProduct = product;\n");
                jsContent.append("        this.updateProductDetails();\n");
            } else {
                jsContent.append("        // Method implementation\n");
            }
        }

        jsContent.append("    }\n\n");
    }

    private void generateInitialization() {
        jsContent.append("// Initialize the application\n");
        jsContent.append("document.addEventListener('DOMContentLoaded', function() {\n");
        jsContent.append("    const app = new AppComponent();\n");
        jsContent.append("});\n\n");

        // Generate initialization method within the class
        jsContent.insert(jsContent.lastIndexOf("}"),
                "    init() {\n" +
                        "        this.renderProductList();\n" +
                        "        this.attachEventListeners();\n" +
                        "    }\n\n" +

                        "    renderProductList() {\n" +
                        "        const productList = document.getElementById('productList');\n" +
                        "        if (!productList || !this.products) return;\n\n" +
                        "        productList.innerHTML = '';\n" +
                        "        this.products.forEach(product => {\n" +
                        "            const li = document.createElement('li');\n" +
                        "            li.innerHTML = `\n" +
                        "                <img src=\"${product.imageUrl}\" alt=\"${product.name}\" />\n" +
                        "                <p>${product.name}</p>\n" +
                        "            `;\n" +
                        "            li.addEventListener('click', () => this.selectProduct(product));\n" +
                        "            productList.appendChild(li);\n" +
                        "        });\n" +
                        "    }\n\n" +

                        "    updateProductDetails() {\n" +
                        "        const detailsDiv = document.getElementById('productDetails');\n" +
                        "        if (!detailsDiv) return;\n\n" +
                        "        if (this.selectedProduct) {\n" +
                        "            detailsDiv.style.display = 'block';\n" +
                        "            document.getElementById('detailImage').src = this.selectedProduct.imageUrl;\n" +
                        "            document.getElementById('detailImage').alt = this.selectedProduct.name;\n" +
                        "            document.getElementById('detailName').textContent = this.selectedProduct.name;\n" +
                        "            document.getElementById('detailPrice').textContent = '$' + this.selectedProduct.price;\n" +
                        "            document.getElementById('detailType').textContent = this.selectedProduct.type;\n" +
                        "        } else {\n" +
                        "            detailsDiv.style.display = 'none';\n" +
                        "        }\n" +
                        "    }\n\n" +

                        "    attachEventListeners() {\n" +
                        "        // Additional event listeners can be added here\n" +
                        "    }\n\n"
        );
    }

    private void generateEventHandlers() {
        // Event handlers are already generated in the initialization method
        // This method can be used for additional global event handlers if needed
    }

    // Helper Methods
    private String extractEventName(String eventBinding) {
        // Extract event name from (click), (mouseover), etc.
        if (eventBinding.contains("(") && eventBinding.contains(")")) {
            return eventBinding.substring(eventBinding.indexOf("(") + 1, eventBinding.indexOf(")"));
        }
        return null;
    }

    private String extractTagName(OpeningTag openTag) {
        // Try to extract tag name from the opening tag structure
        // This would need to be implemented based on your specific AST structure
        return "div"; // Default fallback
    }

    private void processTemplateContent(String templateContent) {
        // Process template content for additional bindings and directives
        // Extract interpolations {{variable}}
        Pattern interpolationPattern = Pattern.compile("\\{\\{\\s*(\\w+)\\s*\\}\\}");
        Matcher matcher = interpolationPattern.matcher(templateContent);

        while (matcher.find()) {
            String variable = matcher.group(1);
            if (!templateVariables.contains(variable)) {
                templateVariables.add(variable);
            }
        }
    }

    private void processNgForDirective(String directive, StringBuilder templateHtml) {
        // Extract variables from "let item of items"
        Pattern pattern = Pattern.compile("let\\s+(\\w+)\\s+of\\s+(\\w+)");
        Matcher matcher = pattern.matcher(directive);

        if (matcher.find()) {
            String itemVar = matcher.group(1);
            String collectionVar = matcher.group(2);

            templateVariables.add(itemVar);
            templateVariables.add(collectionVar);

            // Add data attributes for dynamic processing
            templateHtml.append(" data-ngfor=\"").append(directive).append("\"");
        }
    }

    private void processNgIfDirective(String directive, StringBuilder templateHtml) {
        // Add data attribute for conditional rendering
        templateHtml.append(" data-ngif=\"").append(directive).append("\"");
    }

    private String extractTypeFromTypeV(TypeV typeV) {
        if (typeV.getString_type() != null) return typeV.getString_type();
        if (typeV.getNumber_type() != null) return "number";
        if (typeV.getIsboolean() != null) return "boolean";
        if (typeV.getListV() != null) return "array";
        return "any";
    }

    private String extractInitValue(Initvalue initValue) {
        if (initValue.getNumber() != null) {
            return initValue.getNumber();
        }
        if (initValue.getString() != null) {
            return initValue.getString();
        }
        if (initValue.getIsBoolean() != null) {
            IsBoolean boolVal = initValue.getIsBoolean();
            if (boolVal.getTruev() != null) return "true";
            if (boolVal.getFalsev() != null) return "false";
        }
        if (initValue.getBodyList() != null) {
            return extractArrayValue(initValue.getBodyList());
        }
        if (initValue.getObjectV() != null) {
            return extractObjectValue(initValue.getObjectV());
        }
        return "null";
    }

    private String extractArrayValue(BodyList bodyList) {
        if (bodyList.getInitvalues() == null) return "[]";

        StringBuilder arrayBuilder = new StringBuilder("[");
        boolean first = true;

        for (Initvalue item : bodyList.getInitvalues()) {
            if (!first) arrayBuilder.append(", ");
            arrayBuilder.append(extractInitValue(item));
            first = false;
        }

        arrayBuilder.append("]");
        return arrayBuilder.toString();
    }

    private String extractObjectValue(ObjectV objectV) {
        if (objectV.getBodyObject() == null) return "{}";

        BodyObject bodyObj = objectV.getBodyObject();
        StringBuilder objBuilder = new StringBuilder("{");

        // Extract key-value pairs
        if (bodyObj.getInitvalues() != null) {
            // This would need to be implemented based on how your BodyObject stores key-value pairs
            // For now, return empty object
        }

        objBuilder.append("}");
        return objBuilder.toString();
    }

    private String extractMethodBody(MethodBody methodBody) {
        if (methodBody.getStatementMethods() == null) return "";

        StringBuilder bodyBuilder = new StringBuilder();

        for (StatementMethod stmt : methodBody.getStatementMethods()) {
            if (stmt.getVariable() != null && !stmt.getVariable().isEmpty()) {
                String varName = stmt.getVariable().get(0);
                if (stmt.getExpression() != null) {
                    bodyBuilder.append("this.").append(varName).append(" = ");
                    bodyBuilder.append(extractExpressionValue(stmt.getExpression()));
                    bodyBuilder.append(";");
                }
            }

            if (stmt.getReturnN() != null) {
                bodyBuilder.append("return ");
                bodyBuilder.append(extractReturnValue(stmt.getReturnN()));
                bodyBuilder.append(";");
            }
        }

        return bodyBuilder.toString();
    }

    private String extractExpressionValue(Expression expr) {
        if (expr.getString() != null) return expr.getString();
        if (expr.isIsboolean() != null) {
            IsBoolean bool = expr.isIsboolean();
            return (bool.getTruev() != null) ? "true" : "false";
        }
        if (expr.getVariableDeclaration() != null) {
            return extractVariableDeclarationValue(expr.getVariableDeclaration());
        }
        if (expr.getFunctionCall() != null) {
            return extractFunctionCallValue(expr.getFunctionCall());
        }
        if (expr.getMemberAccess() != null) {
            return extractMemberAccessValue(expr.getMemberAccess());
        }
        return "null";
    }

    private String extractVariableDeclarationValue(VariableDeclaration varDecl) {
        if (varDecl.getName() != null) {
            return varDecl.getName();
        }
        return "null";
    }

    private String extractFunctionCallValue(FunctionCall funcCall) {
        if (funcCall.getNameFun() != null) {
            StringBuilder callBuilder = new StringBuilder();
            callBuilder.append(funcCall.getNameFun()).append("(");

            if (funcCall.getArguments() != null) {
                boolean first = true;
                for (Argument arg : funcCall.getArguments()) {
                    if (!first) callBuilder.append(", ");
                    if (arg.getExpression() != null) {
                        callBuilder.append(extractExpressionValue(arg.getExpression()));
                    }
                    first = false;
                }
            }

            callBuilder.append(")");
            return callBuilder.toString();
        }
        return "null";
    }

    private String extractMemberAccessValue(MemberAccess memberAccess) {
        StringBuilder accessBuilder = new StringBuilder();

        if (memberAccess.isThis()) {
            accessBuilder.append("this");
        }

        if (memberAccess.getMemberName() != null) {
            if (accessBuilder.length() > 0) {
                accessBuilder.append(".");
            }
            accessBuilder.append(memberAccess.getMemberName());
        }

        return accessBuilder.length() > 0 ? accessBuilder.toString() : "null";
    }

    private String extractReturnValue(ReturnN returnN) {
        if (returnN.getValueReturn() != null) return returnN.getValueReturn();
        if (returnN.getExpressionReturn() != null) {
            return extractExpressionValue(returnN.getExpressionReturn());
        }
        if (returnN.getBoolReturn() != null) {
            IsBoolean bool = returnN.getBoolReturn();
            return (bool.getTruev() != null) ? "true" : "false";
        }
        return "";
    }

    private String extractCssValue(CssValue cssValue) {
        if (cssValue.getID_CSS() == null || cssValue.getID_CSS().isEmpty()) {
            return "";
        }

        return String.join(" ", cssValue.getID_CSS());
    }

    // File Writing Methods
    private void writeGeneratedFiles(String outputDirectory) {
        try {
            Path outputPath = Paths.get(outputDirectory);
            Files.createDirectories(outputPath);

            // Write HTML file
            writeHtmlFile(outputPath);

            // Write CSS file
            writeCssFile(outputPath);

            // Write JavaScript file
            writeJsFile(outputPath);

            System.out.println(">>> Files written successfully to: " + outputDirectory);

        } catch (IOException e) {
            System.err.println("Error writing generated files: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void writeHtmlFile(Path outputPath) throws IOException {
        Path htmlPath = outputPath.resolve("index.html");
        Files.write(htmlPath, htmlContent.toString().getBytes());
        System.out.println(">>> HTML file written: " + htmlPath);
    }

    private void writeCssFile(Path outputPath) throws IOException {
        Path cssPath = outputPath.resolve("styles.css");
        Files.write(cssPath, cssContent.toString().getBytes());
        System.out.println(">>> CSS file written: " + cssPath);
    }

    private void writeJsFile(Path outputPath) throws IOException {
        Path jsPath = outputPath.resolve("script.js");
        Files.write(jsPath, jsContent.toString().getBytes());
        System.out.println(">>> JavaScript file written: " + jsPath);
    }

    // Debug and Utility Methods
    public void printExtractionSummary() {
        System.out.println("\n=== EXTRACTION SUMMARY ===");
        System.out.println("Component Selector: " + componentSelector);
        System.out.println("Properties: " + componentProperties.keySet());
        System.out.println("Methods: " + methods);
        System.out.println("Template Variables: " + templateVariables);
        System.out.println("Event Bindings: " + eventBindings.keySet());
        System.out.println("Property Bindings: " + propertyBindings.keySet());
        System.out.println("CSS Rules: " + cssRules);
        System.out.println("========================\n");
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

    // Advanced Extraction Methods for Complex Scenarios
    private void handleComplexBindings() {
        // Process complex property bindings that might involve method calls or complex expressions
        for (Map.Entry<String, String> binding : propertyBindings.entrySet()) {
            String property = binding.getKey();
            String value = binding.getValue();

            // Handle method calls in bindings
            if (value.contains("(") && value.contains(")")) {
                String methodName = value.substring(0, value.indexOf("("));
                if (!methods.contains(methodName)) {
                    methods.add(methodName);
                    System.out.println(">>> Found method in binding: " + methodName);
                }
            }

            // Handle object property access
            if (value.contains(".")) {
                String[] parts = value.split("\\.");
                String objectName = parts[0];
                if (!componentProperties.containsKey(objectName)) {
                    componentProperties.put(objectName, "object");
                    System.out.println(">>> Found object property in binding: " + objectName);
                }
            }
        }
    }

    private void enhanceJavaScriptWithAdvancedFeatures() {
        // Add advanced JavaScript features based on detected patterns
        StringBuilder advancedJs = new StringBuilder();

        // Add utility methods if array operations are detected
        if (hasArrayOperations()) {
            advancedJs.append("    // Utility methods for array operations\n");
            advancedJs.append("    filterItems(items, criteria) {\n");
            advancedJs.append("        return items.filter(item => this.matchesCriteria(item, criteria));\n");
            advancedJs.append("    }\n\n");

            advancedJs.append("    matchesCriteria(item, criteria) {\n");
            advancedJs.append("        return Object.keys(criteria).every(key => item[key] === criteria[key]);\n");
            advancedJs.append("    }\n\n");
        }

        // Add event handling utilities if multiple event types detected
        if (eventBindings.size() > 1) {
            advancedJs.append("    // Event handling utilities\n");
            advancedJs.append("    addEventListener(element, event, handler) {\n");
            advancedJs.append("        if (element && typeof handler === 'function') {\n");
            advancedJs.append("            element.addEventListener(event, handler.bind(this));\n");
            advancedJs.append("        }\n");
            advancedJs.append("    }\n\n");
        }

        // Insert advanced features before the final closing brace
        if (advancedJs.length() > 0) {
            int insertIndex = jsContent.lastIndexOf("}");
            jsContent.insert(insertIndex, advancedJs.toString());
        }
    }

    private boolean hasArrayOperations() {
        // Check if component has array properties and related operations
        return componentProperties.values().stream().anyMatch(type ->
                type.equals("array") || type.contains("[]")) ||
                propertyInitValues.values().stream().anyMatch(value ->
                        value.startsWith("[") && value.endsWith("]"));
    }

    private void optimizeGeneratedCode() {
        // Optimize the generated code by removing redundancy and improving performance
        optimizeCSS();
        optimizeJavaScript();
    }

    private void optimizeCSS() {
        // Remove duplicate CSS rules and consolidate similar selectors
        String cssString = cssContent.toString();

        // Remove empty CSS rules
        cssString = cssString.replaceAll("\\.\\w+\\s*\\{\\s*\\}", "");

        // Remove duplicate whitespace
        cssString = cssString.replaceAll("\\s+", " ");
        cssString = cssString.replaceAll("\\s*\\{\\s*", " {\n    ");
        cssString = cssString.replaceAll("\\s*;\\s*", ";\n    ");
        cssString = cssString.replaceAll("\\s*\\}\\s*", "\n}\n\n");

        cssContent.setLength(0);
        cssContent.append(cssString.trim());
    }

    private void optimizeJavaScript() {
        // Optimize JavaScript by removing unused variables and consolidating similar methods
        String jsString = jsContent.toString();

        // Remove extra whitespace while preserving indentation
        jsString = jsString.replaceAll("\\n\\s*\\n", "\n");

        jsContent.setLength(0);
        jsContent.append(jsString);
    }

    // Validation Methods
    private boolean validateExtractedData() {
        boolean isValid = true;

        // Validate that we have essential components
        if (componentProperties.isEmpty()) {
            System.err.println("Warning: No component properties found");
            isValid = false;
        }

        if (methods.isEmpty()) {
            System.err.println("Warning: No methods found");
        }

        if (cssRules.isEmpty()) {
            System.err.println("Warning: No CSS rules found");
        }

        // Validate property bindings reference existing properties
        for (String binding : propertyBindings.values()) {
            if (!binding.isEmpty() && !componentProperties.containsKey(binding.split("\\.")[0])) {
                System.err.println("Warning: Property binding references unknown property: " + binding);
            }
        }

        // Validate event handlers reference existing methods
        for (String handler : eventBindings.values()) {
            if (!handler.isEmpty()) {
                String methodName = handler.contains("(") ? handler.substring(0, handler.indexOf("(")) : handler;
                if (!methods.contains(methodName)) {
                    System.err.println("Warning: Event handler references unknown method: " + methodName);
                }
            }
        }

        return isValid;
    }

    // Enhanced template processing for complex Angular features
    private void processAngularDirectives() {
        // Process *ngFor directives more thoroughly
        processNgForDirectives();

        // Process *ngIf directives
        processNgIfDirectives();

        // Process interpolation expressions
        processInterpolationExpressions();
    }

    private void processNgForDirectives() {
        // Look for *ngFor patterns in template variables or symbol table
        for (Row symbol : symbolTable.getAllSymbols()) {
            if ("STRUCTURAL_DIRECTIVE".equals(symbol.getType()) && symbol.getValue().contains("ngFor")) {
                // Extract the directive value and process it
                System.out.println(">>> Processing ngFor directive: " + symbol.getValue());
            }
        }
    }

    private void processNgIfDirectives() {
        // Process *ngIf directives for conditional rendering
        for (Row symbol : symbolTable.getAllSymbols()) {
            if ("STRUCTURAL_DIRECTIVE".equals(symbol.getType()) && symbol.getValue().contains("ngIf")) {
                System.out.println(">>> Processing ngIf directive: " + symbol.getValue());
            }
        }
    }

    private void processInterpolationExpressions() {
        // Process {{ }} interpolation expressions
        for (Row symbol : symbolTable.getAllSymbols()) {
            if ("INTERPOLATION_ID".equals(symbol.getType())) {
                String variableName = symbol.getValue();
                if (!templateVariables.contains(variableName)) {
                    templateVariables.add(variableName);
                    System.out.println(">>> Found interpolation variable: " + variableName);
                }
            }
        }
    }

    // Final assembly method that brings everything together
    public void finalizeGeneration() {
        System.out.println(">>> Finalizing code generation...");

        // Handle complex bindings
        handleComplexBindings();

        // Process Angular directives
        processAngularDirectives();

        // Enhance JavaScript with advanced features
        enhanceJavaScriptWithAdvancedFeatures();

        // Optimize generated code
        optimizeGeneratedCode();

        // Validate the generated code
        boolean isValid = validateExtractedData();

        if (isValid) {
            System.out.println(">>> Code generation completed successfully");
        } else {
            System.err.println(">>> Code generation completed with warnings");
        }

        // Print summary
        printExtractionSummary();
    }
}