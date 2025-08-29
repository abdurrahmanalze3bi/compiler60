// Generated from Angular Component

class AppComponent {
    constructor() {
        this.price = null;
        this.imageUrl = null;
        this.name = null;
        this.id = null;
        this.type = null;
        this.selectedProduct = null;
        this.products = [
            {
                id: 1,
                name: "Apple iPhone 15 Pro",
                price: 999,
                imageUrl: "https://imgs.search.brave.com/PWkrla43U79BF3A9MlclhMG0NuVB5iEYTGJNqXaHz9I/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9mZG4y/LmdzbWFyZW5hLmNv/bS92di9iaWdwaWMv/YXBwbGUtaXBob25l/LTE0LmpwZw",
                type: "Smartphone"
            },
            {
                id: 2,
                name: "Samsung Galaxy S23 Ultra",
                price: 1199,
                imageUrl: "https://imgs.search.brave.com/DVt6aqYu0XAjGA_8yhOUffCvJIJ6vsNI5m2KYQ_sM9g/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly93d3cu/OTEtaW1nLmNvbS9n/YWxsZXJ5X2ltYWdl/c191cGxvYWRzL2Yv/Ny9mNzM4YzNjYzlj/ZTJhNGVmNzM2NDc4/OWZmMzFiNDhkNjM3/N2U0ZTE5LmpwZz90/cj1oLTU1MCx3LTAs/Yy1hdF9tYXg",
                type: "Smartphone"
            },
            {
                id: 3,
                name: "Google Pixel 8 Pro",
                price: 899,
                imageUrl: "https://imgs.search.brave.com/nCVKfU2zCx-30-2nCk76lwOuNirJhKlfZeTPalioM0g/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9zczcu/dnp3LmNvbS9pcy9p/bWFnZS9WZXJpem9u/V2lyZWxlc3MvZ29v/Z2xlLXRrNC1vYnNp/ZGlhbi1oZXJvP2hl/aT0yNTAmYmdjPWY2/ZjZmNg.jpeg",
                type: "Smartphone"
            },
            {
                id: 4,
                name: "OnePlus 11",
                price: 699,
                imageUrl: "https://imgs.search.brave.com/ssaPEcbKQeg2AIbelN6Mhbqzj4lt9RSsfxtnvCUdBRM/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9mZG4y/LmdzbWFyZW5hLmNv/bS92di9iaWdwaWMv/b25lcGx1cy0xMS5q/cGc",
                type: "Smartphone"
            },
            {
                id: 5,
                name: "Xiaomi 13 Pro",
                price: 799,
                imageUrl: "https://imgs.search.brave.com/n1-3EV-_yqT1ePIBqMUdbrLh6SCO6Hj3_Bdn580hZLI/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9mZG4y/LmdzbWFyZW5hLmNv/bS92di9iaWdwaWMv/eGlhb21pLTEzLXBy/by1ibGFjay5qcGc",
                type: "Smartphone"
            },
            {
                id: 6,
                name: "Sony Xperia 1 V",
                price: 1299,
                imageUrl: "https://imgs.search.brave.com/QQAPjO66v_3qVNgshnE9q7WLbeXgad9fvduKQ6j1zoM/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9tb2Jp/bGVpbnRvLmNvbS9p/bWFnZXMvU29ueS1Y/cGVyaWEtMS1WLmpw/Zw",
                type: "Smartphone"
            }
        ];
        this.init();
    }

    init() {
        this.renderProducts();
    }

    selectProduct(product) {
        this.selectedProduct = product;
        this.showProductDetails();
    }

    renderProducts() {
        const productListUl = document.getElementById('productListUl');
        if (!productListUl || !this.products) return;

        this.products.forEach(product => {
            const li = document.createElement('li');
            li.innerHTML = `<img src="${product.imageUrl}" alt="${product.name}" /><p>${product.name}</p>`;
            li.addEventListener('click', () => this.selectProduct(product));
            productListUl.appendChild(li);
        });
    }

    showProductDetails() {
        const detailsDiv = document.getElementById('productDetailsDetails');
        if (!detailsDiv || !this.selectedProduct) return;

        detailsDiv.style.display = 'block';

        const productImage = document.getElementById('selectedProductImage');
        if (productImage && this.selectedProduct.imageUrl) {
            productImage.src = this.selectedProduct.imageUrl;
            productImage.alt = this.selectedProduct.name;
        }

        const nameElement = document.getElementById('selectedproductname');
        if (nameElement && this.selectedProduct.name !== undefined) {
            nameElement.textContent = this.selectedProduct.name;
        }

        const priceElement = document.getElementById('selectedproductprice');
        if (priceElement && this.selectedProduct.price !== undefined) {
            priceElement.textContent = this.selectedProduct.price;
        }

        const typeElement = document.getElementById('selectedproducttype');
        if (typeElement && this.selectedProduct.type !== undefined) {
            typeElement.textContent = this.selectedProduct.type;
        }

    }

}

document.addEventListener('DOMContentLoaded', function() {
    const app = new AppComponent();
});
