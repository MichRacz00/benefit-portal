/**
 * Handles clicks on "Add to Cart" buttons using event delegation.
 */
document.addEventListener('DOMContentLoaded', () => {
    const productsContainer = document.querySelector('.products');

    if (!productsContainer) {
        console.error('Products container not found');
        return;
    }

    // ✅ Event delegation: one listener for all current & future buttons
    productsContainer.addEventListener('click', event => {
        const button = event.target.closest('.btn-add-to-cart');
        if (!button) return;

        const itemId = button.dataset.itemId;
        if (!itemId) {
            console.error('Missing itemId on button');
            return;
        }

        addItemToCart(itemId, button);
    });

    // Fetch and render products
    fetch('/shop/allProducts')
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(products => {
            if (!products.length) {
                productsContainer.innerHTML =
                    '<p>No products available at the moment.</p>';
                return;
            }

            products.forEach(product => {
                const card = document.createElement('div');
                card.className = 'product-card';

                const formattedPrice = (product.price / 100).toLocaleString(
                    'en-US',
                    {
                        style: 'currency',
                        currency: 'USD',
                    }
                );

                card.innerHTML = `
                    <img src="${product.image}" alt="${product.title}" class="product-image">
                    <div class="product-info">
                        <h3 class="product-title">${product.title}</h3>
                        <p class="product-content">${product.content}</p>
                        <div class="product-footer">
                            <span class="product-price">${formattedPrice}</span>
                            <button
                                class="choose-btn btn btn-outline btn-add-to-cart"
                                data-item-id="${product.id}">
                                Choose
                            </button>
                        </div>
                    </div>
                `;

                productsContainer.appendChild(card);
            });
        })
        .catch(error => {
            console.error('Failed to fetch products:', error);
            productsContainer.innerHTML =
                '<p class="error-message">Could not load products.</p>';
        });
});

/**
 * Sends a request to the backend to add an item to the cart.
 */
function addItemToCart(itemId, button) {
    console.log('Adding item:', itemId);

    button.textContent = 'Adding...';
    button.disabled = true;

    fetch(`/shop/cart/add?itemId=${encodeURIComponent(itemId)}`, {
        method: 'POST',
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to add item to cart');
            }

            button.textContent = 'Added!';
            setTimeout(() => {
                button.textContent = 'Add to Cart';
                button.disabled = false;
            }, 1500);
        })
        .catch(error => {
            console.error('Add to cart error:', error);
            button.textContent = 'Error!';
            setTimeout(() => {
                button.textContent = 'Add to Cart';
                button.disabled = false;
            }, 2000);
        });
}