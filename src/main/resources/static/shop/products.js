document.addEventListener('DOMContentLoaded', () => {

    const productsContainer = document.querySelector('.products');

    fetch('/shop/allProducts')
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(products => {
            if (products.length === 0) {
                productsContainer.innerHTML = '<p>No products available at the moment.</p>';
                return;
            }

            products.forEach(product => {
                const card = document.createElement('div');
                card.className = 'product-card';

                const formattedPrice = (product.price / 100).toLocaleString('en-US', {
                    style: 'currency',
                    currency: 'USD',
                });

                card.innerHTML =
                `
                    <img src="${product.image}" alt="${product.title}" class="product-image">
                    <div class="product-info">
                        <h3 class="product-title">${product.title}</h3>
                        <p class="product-content">${product.content}</p>
                        <div class="product-footer">
                            <span class="product-price">${formattedPrice}</span>
                            <button class="btn-add-to-cart" data-item-id="${product.id}">Add to Cart</button>
                        </div>
                    </div>
                `;

                productsContainer.appendChild(card);
            });
        })
        .catch(error => {
            console.error('Failed to fetch products:', error);
            productsContainer.innerHTML = '<p class="error-message">Could not load products. Please try again later.</p>';
        });
});
