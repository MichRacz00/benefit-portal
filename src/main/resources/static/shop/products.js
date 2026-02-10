
function attachAddToCartListeners() {
    const buttons = document.querySelectorAll('.btn-add-to-cart');
    buttons.forEach(button => {
        button.addEventListener('click', event => {
            const itemId = event.target.dataset.itemId;
            addItemToCart(itemId, event.target);
        });
    });
}

/**
 * Sends a request to the backend to add an item to the cart.
 * @param {string} itemId - The ID of the item to add.
 * @param {HTMLElement} buttonElement - The button that was clicked.
 */
function addItemToCart(itemId, buttonElement) {
    // Provide visual feedback that something is happening.
    buttonElement.textContent = 'Adding...';
    buttonElement.disabled = true;

    Console.log("test");

    // The endpoint expects the itemId as a request parameter.
    const url = `/shop/cart/add?itemId=${encodeURIComponent(itemId)}`;

    fetch(url, {
        method: 'POST',
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to add item to cart.');
        }
        // Success! Provide feedback to the user.
        buttonElement.textContent = 'Added!';
        setTimeout(() => {
            buttonElement.textContent = 'Add to Cart';
            buttonElement.disabled = false;
        }, 1500); // Reset button after 1.5 seconds
    })
    .catch(error => {
        console.error('Add to cart error:', error);
        buttonElement.textContent = 'Error!';
        // Optionally, reset the button so the user can try again.
        setTimeout(() => {
            buttonElement.textContent = 'Add to Cart';
            buttonElement.disabled = false;
        }, 2000);
    });
}

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

                card.innerHTML = `
                    <img src="${product.image}" alt="${product.title}" class="product-image">
                    <div class="product-info">
                        <h3 class="product-title">${product.title}</h3>
                        <p class="product-content">${product.content}</p>
                        <div class="product-footer">
                            <span class="product-price">${formattedPrice}</span>
                            <button class="choose-btn btn btn-outline">Choose</button>
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

        attachAddToCartListeners();
});