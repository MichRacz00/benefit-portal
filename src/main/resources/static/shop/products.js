/* ──────  Product data (replace with real API data if needed) ────── */
const products = [
  { id: 1, title: "Basic Plan", price: "$19.99", img: "https://picsum.photos/300/200?random=1" },
  { id: 2, title: "Standard Plan", price: "$29.99", img: "https://picsum.photos/300/200?random=2" },
  { id: 3, title: "Premium Plan", price: "$49.99", img: "https://picsum.photos/300/200?random=3" },
  { id: 4, title: "Enterprise Plan", price: "$99.99", img: "https://picsum.photos/300/200?random=4" }
];

/* ──────  Render products  ────── */
const container = document.querySelector('.products');
products.forEach(p => {
  const card = document.createElement('div');
  card.className = 'product-card';
  card.dataset.id = p.id;

  card.innerHTML = `
    <img src="${p.img}" alt="${p.title}">
    <div class="info">
      <h3 class="title">${p.title}</h3>
      <p class="price">${p.price}</p>
      <button class="choose-btn btn btn-outline">Choose</button>
    </div>
  `;

  // Click anywhere on the card to select
  card.addEventListener('click', () => selectProduct(p.id));

  container.appendChild(card);
});

/* ──────  Selection logic  ────── */
let selectedId = null;

function selectProduct(id) {
  selectedId = id;
  localStorage.setItem('selectedProduct', id);

  // Highlight the selected card
  document.querySelectorAll('.product-card').forEach(card => {
    card.classList.toggle('selected', Number(card.dataset.id) === id);
  });

  // Show the “Proceed” button
  document.getElementById('proceedBtn').style.display = 'block';
}

/* ──────  On page load, restore selection if already stored  ────── */
document.addEventListener('DOMContentLoaded', () => {
  const stored = localStorage.getItem('selectedProduct');
  if (stored) {
    selectProduct(Number(stored));
  }
});