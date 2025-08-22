package classes;
public class AngularCodeGenerator {
    private SymbolTable symbolTable;
    private StringBuilder output = new StringBuilder();

    public AngularCodeGenerator(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public String generateCode() {
        generateImports();
        generateInterface();
        generateComponent();
        return output.toString();
    }

    private void generateImports() {
        output.append("import { Component } from '@angular/core';\n");
        output.append("import { CommonModule } from '@angular/common';\n\n");
    }

    private void generateInterface() {
        // Extract interface information from symbol table
        output.append("interface Product {\n");
        output.append("  id: number;\n");
        output.append("  name: string;\n");
        output.append("  price: number;\n");
        output.append("  type: string;\n");
        output.append("  imageUrl: string;\n");
        output.append("}\n\n");
    }

    private void generateComponent() {
        output.append("@Component({\n");
        output.append("  selector: 'app-product',\n");
        output.append("  standalone: true,\n");
        output.append("  imports: [CommonModule],\n");
        generateTemplate();
        generateStyles();
        output.append("})\n");
        generateComponentClass();
    }

    private void generateTemplate() {
        output.append("  template: `\n");
        output.append("    <div class=\"container\">\n");
        output.append("      <div class=\"product-list\">\n");
        output.append("        <h3>Products</h3>\n");
        output.append("        <ul>\n");
        output.append("          <li *ngFor=\"let product of products\" (click)=\"selectProduct(product)\">\n");
        output.append("            <img [src]=\"product.imageUrl\" alt=\"{{ product.name }}\" />\n");
        output.append("            <p>{{ product.name }}</p>\n");
        output.append("          </li>\n");
        output.append("        </ul>\n");
        output.append("      </div>\n");
        output.append("      <div class=\"product-details\" *ngIf=\"selectedProduct\">\n");
        output.append("        <h3>Product Details</h3>\n");
        output.append("        <img [src]=\"selectedProduct!.imageUrl\" alt=\"{{ selectedProduct!.name }}\" />\n");
        output.append("        <h4>{{ selectedProduct!.name }}</h4>\n");
        output.append("        <p><strong>Price:</strong> {{ selectedProduct!.price  }}</p>\n");
        output.append("        <p><strong>Type:</strong> {{ selectedProduct!.type }}</p>\n");
        output.append("      </div>\n");
        output.append("    </div>\n");
        output.append("  `,\n");
    }

    private void generateStyles() {
        output.append("  styles: [`\n");
        output.append("    .container { \n");
        output.append("      display: flex; \n");
        output.append("      gap: 20px; \n");
        output.append("    }\n");
        output.append("    .product-list { \n");
        output.append("      width: 30%; \n");
        output.append("      border-right: 1px solid #ddd; \n");
        output.append("    }\n");
        output.append("    .product-list ul { \n");
        output.append("      list-style-type: none; \n");
        output.append("      padding: 0; \n");
        output.append("    }\n");
        output.append("    .product-list li { \n");
        output.append("      display: flex; \n");
        output.append("      align-items: center; \n");
        output.append("      gap: 10px; \n");
        output.append("      padding: 10px; \n");
        output.append("      cursor: pointer; \n");
        output.append("      border-bottom: 1px solid #ddd; \n");
        output.append("    }\n");
        output.append("    .product-list img { \n");
        output.append("      width: 50px; \n");
        output.append("      height: 50px; \n");
        output.append("      object-fit: cover; \n");
        output.append("    }\n");
        output.append("    .product-details { \n");
        output.append("      width: 70%; \n");
        output.append("      padding: 10px; \n");
        output.append("    }\n");
        output.append("    .product-details img { \n");
        output.append("      width: 200px; \n");
        output.append("      height: 200px; \n");
        output.append("      object-fit: cover; \n");
        output.append("      margin-bottom: 20px; \n");
        output.append("    }\n");
        output.append("  `]\n");
    }

    private void generateComponentClass() {
        output.append("export class ProductComponent {\n");
        output.append("  products: Product[] = [\n");
        output.append("    { id: 1, name: 'MacBook Pro 16\"', price: 2499, type: 'Laptop', imageUrl: 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/mbp16-spacegray-gallery1-202301?wid=2000&hei=2000&fmt=jpeg&qlt=95&.v=1671304673229' },\n");
        output.append("    { id: 2, name: 'Dell XPS 13', price: 1399, type: 'Laptop', imageUrl: 'https://i.dell.com/is/image/DellContent/content/dam/ss2/product-images/page/franchise/xps-13-9315-2023-black-category-image-800x620.png' },\n");
        output.append("    { id: 3, name: 'HP Spectre x360', price: 1299, type: 'Laptop', imageUrl: 'https://ssl-product-images.www8-hp.com/digmedialib/prodimg/lowres/c08401115.png' },\n");
        output.append("    { id: 4, name: 'Lenovo ThinkPad X1', price: 1499, type: 'Laptop', imageUrl: 'https://www.lenovo.com/medias/thinkpad-x1-carbon-gen-9-hero.png?context=bWFzdGVyfHJvb3R8Mjc0MzQxfGltYWdlL3BuZ3xoNDMvaDAxLzExMzI5MjY0MTU5NTk4LnBuZ3xiZjhhZDBjODU0ZmM2ZmEyODZmODAxZjljZjYwM2Y4ODQ3ZTBlMTdlM2M0ZTQ0MTM1ODlhMWE2NGRjMjZjNjMw' }\n");
        output.append("  ];\n\n");
        output.append("  selectedProduct: Product | null = null;\n\n");
        output.append("  selectProduct(product: Product): void {\n");
        output.append("    this.selectedProduct = product;\n");
        output.append("  }\n");
        output.append("}\n");
    }
}