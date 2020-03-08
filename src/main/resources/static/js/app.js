//variables

const cartBtn = document.querySelector('.cart-btn');
const closeCartBtn = document.querySelector('.close-cart');
const clearCartBtn = document.querySelector('.clear-cart');
const cartDOM = document.querySelector(".cart");
const cartOverlay = document.querySelector(".cart-overlay");
const cartItems = document.querySelector(".cart-items");
const cartTotal = document.querySelector(".cart-total");
const cartContent = document.querySelector(".cart-content");
const productsDOM = document.querySelector(".products-center");
// cart
let cart = [];
//buttons
let buttonsDOM=[];

//getting the products
class Products{
    async getProducts(){
    try{
        let result = await fetch("books/all", {
              method: 'GET',
              mode: 'cors'
          });
        let data = await result.json();
        let products = data;
        return products;
        }catch (error){
            console.log(error);
        }
    }
}
//display products
class UI{
    displayProducts(products){
        let result = '';
        products.forEach(product => {
            result+=`
            <article class="product">
                <div class="img-container">
                    <img
                        src=${product.cover}
                        alt="product"
                        class="product-img"
                    />
                    <button class="bag-btn" data-id=${product.id}>
                        <i class="fas fa-cart-plus"></i>
                        dodaj do koszyka
                    </button>
                </div>
                <h3>${product.title}</h3>
                <h4>${product.price}PLN</h4>
            </article>
            `;
        });
        productsDOM.innerHTML = result;
    }
    getBagButtons(){
        const buttons = [...document.querySelectorAll(".bag-btn")];
        buttonsDOM = buttons;
        buttons.forEach(button =>{
            let id = button.dataset.id;
            console.log(id);
            let inCart = cart.find(item => String(item.id) === id);
            if(inCart){
                button.innerText = "W Koszyku";
                button.disabled = true;
            }
            button.addEventListener('click',(event)=>{
               event.target.innerText = "W Koszyku";
               event.target.disabled = true;
               let cartItem = {...Storage.getProduct(id), amount: 1 };
               cart = [...cart, cartItem];
               Storage.saveCart(cart);
               this.setCartValues(cart);
               this.addCartItem(cartItem);
               this.showCart();
            });
        });
    }
    setCartValues(cart){
        let tempTotal = 0;
        let itemsTotal = 0;
        cart.map(item =>{
            tempTotal += item.price * item.amount;
            itemsTotal += item.amount;
        })
        cartTotal.innerText = parseFloat(tempTotal.toFixed(2));
        cartItems.innerText = itemsTotal;
    }
    addCartItem(item){
        const div = document.createElement('div');
        div.classList.add('cart-item');
        div.innerHTML = `<img src=${item.cover} alt="product">
        <div>
            <h4>${item.title}</h4>
            <h5>${item.price}PLN</h5>
            <span class="remove-item" data-id=${item.id}>usuń</span>
        </div>
        <div>
            <i class="fas fa-chevron-up" data-id=${item.id}></i>
            <p class="item-amount">${item.amount}</p>
            <i class="fas fa-chevron-down" data-id=${item.id}></i>
        </div>`;
        cartContent.appendChild(div);
        console.log(cartContent);
    }
    showCart(){
        cartOverlay.classList.add('transparentBcg');
        cartDOM.classList.add('showCart');
    }
    setupAPP(){
        cart = Storage.getCart();
        this.setCartValues(cart);
        this.populateCart(cart);
        cartBtn.addEventListener('click',this.showCart);
        closeCartBtn.addEventListener('click',this.hideCart);
    }
    populateCart(cart){
        cart.forEach(item => this.addCartItem(item));
    }
    hideCart(){
        cartOverlay.classList.remove('transparentBcg');
        cartDOM.classList.remove('showCart');
    }
    cartLogic(){
        clearCartBtn.addEventListener("click",()=>{this.clearCart();});
        cartContent.addEventListener('click', event=>{
            if(event.target.classList.contains('remove-item')){
                let removeItem = event.target;
                let id = removeItem.dataset.id;
                cartContent.removeChild(removeItem.parentElement.parentElement);
                this.removeItem(id);
            }else if(event.target.classList.contains('fa-chevron-up')){
                let addAmount = event.target;
                let id = addAmount.dataset.id;
                let tempItem = cart.find(item => String(item.id) === id);
                tempItem.amount = tempItem.amount + 1;
                Storage.saveCart(cart);
                this.setCartValues(cart);
                addAmount.nextElementSibling.innerText = tempItem.amount;
            }else if(event.target.classList.contains('fa-chevron-down')){
                let lowerAmount = event.target;
                let id  = lowerAmount.dataset.id;
                let tempItem = cart.find(item => String(item.id) === id);
                tempItem.amount = tempItem.amount - 1;
                if (tempItem.amount > 0){
                    Storage.saveCart(cart);
                    this.setCartValues(cart);
                    lowerAmount.previousElementSibling.innerText = tempItem.amount;
                }else{
                    cartContent.removeChild(lowerAmount.parentElement.parentElement);
                    this.removeItem(id);
                }

            }
        })
    }
    clearCart(){
        let cartItems = cart.map(item => String(item.id));
        cartItems.forEach(id => this.removeItem(id));
        while(cartContent.children.length>0){
            cartContent.removeChild(cartContent.children[0])
        }
        this.hideCart();
    }
    removeItem(id){
        cart = cart.filter(item => String(item.id) !== id);
        this.setCartValues(cart);
        Storage.saveCart(cart);
        let button = this.getSingleButton(id);
        button.disabled = false;
        button.innerHTML = `<i class="fas fa-cart-plus"></i>Dodaj do Koszyka`;
    }
    getSingleButton(id){
        return buttonsDOM.find(button => button.dataset.id === id);
    }
}


document.addEventListener("DOMContentLoaded", ()=>{
const ui = new UI();
const products = new Products();
ui.setupAPP();

//get all products
products.getProducts().then(products => {
    ui.displayProducts(products)
    Storage.saveProducts(products);
    }).then(()=>{
        ui.getBagButtons();
        ui.cartLogic()
    });
});