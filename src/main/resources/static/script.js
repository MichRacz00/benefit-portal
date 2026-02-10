const products = [
  { id: 1, name: "Laptop", price: 999, img: "https://via.placeholder.com/150" },
  { id: 2, name: "Smartphone", price: 599, img: "https://via.placeholder.com/150" },
  { id: 3, name: "Headphones", price: 199, img: "https://via.placeholder.com/150" },
  { id: 4, name: "Watch", price: 299, img: "https://via.placeholder.com/150" },
];

const productsContainer = document.getElementById("products-container");
const cartBtn = document.getElementById("cart-btn");
const cartModal = document.getElementById("cart-modal");
const closeCart = document.getElementById("close-cart");
const cartItemsElem = document.getElementById("cart-items");
const cartTotalElem = document.getElementById("cart-total");
const cartCountElem = document.getElementById("cart-count");

let cart = [];

function renderProducts() {
  productsContainer.innerHTML = "";
  products.forEach(p => {
    const div = document.createElement("div");
    div.classList.add("product");
    div.innerHTML = `
      <img src="${p.img}" alt="${p.name}">
      <h3>${p.name}</h3>
      <p>$${p.price}</p>
      <button onclick="addToCart(${p.id})">Add to Cart</button>
    `;
    productsContainer.appendChild(div);
  });
}

function addToCart(id) {
  const product = products.find(p => p.id === id);
  cart.push(product);
  updateCart();
}

function updateCart() {
  cartItemsElem.innerHTML = "";
  cart.forEach((item, index) => {
    const li = document.createElement("li");
    li.textContent = `${item.name} - $${item.price}`;
    cartItemsElem.appendChild(li);
  });
  const total = cart.reduce((acc, item) => acc + item.price, 0);
  cartTotalElem.textContent = total;
  cartCountElem.textContent = cart.length;
}

cartBtn.addEventListener("click", () => cartModal.classList.remove("hidden"));
closeCart.addEventListener("click", () => cartModal.classList.add("hidden"));

renderProducts();