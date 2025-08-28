// Generated from discovered component data
class RootComponent {
    constructor() {
        this.src = null;
        this.init();
    }

    init() {
        this.bindEvents();
        this.render();
    }

    bindEvents() {
        document.addEventListener('click', (e) => {
            if (e.target.hasAttribute('data-event-click')) {
                this.selectProduct(product)(e);
            }
        });
        // Click handlers for products
        document.addEventListener('click', (e) => {
            const productElement = e.target.closest('[data-product]');
            if (productElement) {
                const productId = productElement.dataset.product;
                const product = this.products.find(item => item.id == productId);
                if (product) this.selectProduct(product);
            }
        });
    }

    render() {
        // Render products
        const productsContainer = document.querySelector('[data-ng-for*="products"]');
        if (productsContainer && this.products) {
            productsContainer.innerHTML = this.products.map(product => {
                return `<div data-product="${product.id || product.name}">${JSON.stringify(product)}</div>`;
            }).join('');
        }
    }
}

document.addEventListener('DOMContentLoaded', function() {
    new RootComponent();
});
