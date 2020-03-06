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
                <h4>${product.price}zł</h4>
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
            let inCart = cart.find(item => item.id === id);
            if(inCart){
                button.innerText = "W Koszyku";
                button.disabled = true;
            }
            button.addEventListener('click',(event)=>{
               event.target.innerText = "W Koszyku";
               event.target.disabled = true;
               let cartItem = Storage.getProduct(id);
               console.log(cart);
              /* cart = [...cart, cartItem];
               Storage.saveCart(cart);
               this.setCartValues(cart);*/

            });
        });
    }
    /*setCartValues(cart){
        let tempTotal = 0;
        let itemsTotal = 0;
        cart.map(item =>{
            tempTotal += item.price * item.amount;
            itemsTotal += item.amount;
        })
        cartTotal.innerText = tempTotal;
        cartItems.innerText = itemsTotal;
        console.log(cartTotal, cartItems);
    }*/
}
//local storage
class Storage{
    static saveProducts(products){
        localStorage.setItem("products", JSON.stringify(products));
    }
    static getProduct(id){
        let products = JSON.parse(localStorage.getItem('products'));
        return products.find(product => product.id === id);
    }
    static saveCart(cart){
        localStorage.setItem('cart',JSON.stringify(cart));
    }
}

document.addEventListener("DOMContentLoaded", ()=>{
const ui = new UI();
const products = new Products();

//get all products
products.getProducts().then(products => {
    ui.displayProducts(products)
    Storage.saveProducts(products);
    }).then(()=>{
        ui.getBagButtons();
    });
});