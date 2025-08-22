// Generated Vanilla JavaScript Component

// Root object template
const RootTemplate = {
    selectedProduct: null,
    products: [
        {},
        {},
        {},
        {},
        {},
        {}
    ],
};

class RootComponent {
    constructor() {
        this.selectedProduct = null;
        this.products = [
        {},
        {},
        {},
        {},
        {},
        {}
    ];
        this.init();
    }

    init() {
        this.bindEvents();
        this.render();
    }

    bindEvents() {
        // Event bindings
        const productItems = document.querySelectorAll('[data-product]');
        productItems.forEach(item => {
            item.addEventListener('click', (e) => {
                const productId = parseInt(e.target.closest('[data-product]').dataset.product);
                this.selectProduct(this.products.find(p => p.id === productId));
            });
        });
    }

    selectProduct(product) {
        this.selectedProduct = product;
        this.render();
    }

    render() {
        // Render products list
        const productList = document.querySelector('.products-container');
        if (productList && this.products) {
            productList.innerHTML = this.products.map(product => `
                <li data-product="${product.id}" class="product-item">
                    <img src="${product.imageUrl}" alt="${product.name}" />
                    <p>${product.name}</p>
                </li>
            `).join('');
        }

        // Render selected product details
        const productDetails = document.querySelector('.product-details');
        if (productDetails) {
            if (this.selectedProduct) {
                productDetails.style.display = 'block';
                productDetails.innerHTML = `
                    <h3>Product Details</h3>
                    <img src="${this.selectedProduct.imageUrl}" alt="${this.selectedProduct.name}" />
                    <h4>${this.selectedProduct.name}</h4>
                    <p><strong>Price:</strong> $${this.selectedProduct.price}</p>
                    <p><strong>Type:</strong> ${this.selectedProduct.type}</p>
                `;
            } else {
                productDetails.style.display = 'none';
            }
        }
    }
}

// Initialize component when DOM is loaded
document.addEventListener('DOMContentLoaded', function() {
    new RootComponent();
});
