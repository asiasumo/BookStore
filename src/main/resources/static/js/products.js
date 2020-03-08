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