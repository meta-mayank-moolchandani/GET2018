package cart;
import java.util.*;


public class ShoppingCart {
    
    List<Product> shoppingCart;
    static List<Product> productList;
    
    ShoppingCart(){
    	shoppingCart = new LinkedList<Product>();
    	productList = new LinkedList<Product>();
    	
    }
	
	/**
	 * this function returns the reference of the product from product list which have the product named as thisProduct
	 * function for getting the reference of the Product by using it's name
	 * @param thisProduct is the name of product
	 * @return product reference containing the product Name thisProduct 
    */
	Product productReferenceOfProductList(String thisProduct){
		try{
			Iterator<Product> iter = productList.iterator();

			while(iter.hasNext()){
				Product currentProduct = iter.next();
				if(currentProduct.productName.equals(thisProduct)){
					return currentProduct;
				}
			}
			return iter.next();
		}catch(Exception e){
			System.out.println("Error Message: " + e.getMessage() + "\n");
			return null;
		}
	}
	
	
	/**
	 * this function returns the reference of the product from Shopping Cart list which have the product named as thisProduct
	 * function for getting the reference of the Product by using it's name
	 * @param thisProduct is the name of product
	 * @return product reference containing the product Name thisProduct 
    */
	Product productReferenceOfShoppingCart(String thisProduct){
		try{
			Iterator<Product> iter = shoppingCart.iterator();

			while(iter.hasNext()){
				Product currentProduct = iter.next();
				if(currentProduct.productName.equals(thisProduct)){
					return currentProduct;
				}
			}
			return iter.next();
		}catch(Exception e){
			System.out.println("Error Message: " + e.getMessage() + "\n");
			return null;
		}
	}
	
	/**
	 * add product to the cart
	 * @param product is the name of the product, quantity is for storing the product quantity in the cart
	 * @return returns true is successfully added else false
	*/
	
	public boolean addProductToCart(String product, int quantity){
		if(isExistInProductList(product)){
			if(isExistInCart(product)){
				return false;
			}else{
				int price = productReferenceOfProductList(product).productPrice;
			
				Product newItem = new Product(product,price,quantity);
				 newItem.fixDiscount = productReferenceOfProductList(product).fixDiscount;
				  newItem.fixOrder =productReferenceOfProductList(product).fixOrder;
				if(shoppingCart.contains(productReferenceOfProductList(product))){
					updateProductInCart(product,1);
					return true;
				}else{
				shoppingCart.add(newItem);
				return true;
			    }
			}
		}else{
			return false;
		}
	}
	
	/**
	 * remove product from the cart
	 * @param product is the name of the product
	 * @return returns true is successfully removed else false
	*/
	
	public boolean removeProductFromCart(String product){
		if(isExistInCart(product)){
			shoppingCart.remove(productReferenceOfShoppingCart(product));
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * update product to the cart
	 * @param product is the name of the product, quantity is for storing the product quantity in the cart
	 * @return returns true is successfully updated else false
	*/
	
	public boolean updateProductInCart(String product, int quantity){
		if(isExistInCart(product)){
			
			productReferenceOfShoppingCart(product).productQuantity = quantity;
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * calculating the total price of all items
	 * @return returns the total amount of all the products in the cart
	*/
	int checkout(){
		try{
			Iterator<Product> iter = shoppingCart.iterator();
			int sum = 0;

			while(iter.hasNext()){
				Product currentItem = iter.next();
				sum = sum + currentItem.productPrice * currentItem.productQuantity; 

			} 
			return sum;	
		}catch(Exception e){
			System.out.println("message: " + e.getMessage());
			return 0;
		}
	}
	/**
	 * check whether the product is existing in the ProductList or Not
	 * @param thisProduct is the name of the product
	 * @return returns true if thisProduct Exists in ProductList
	*/

	public boolean isExistInProductList(String thisProduct){
		
		try{
			Iterator<Product> iter = productList.iterator();
			while(iter.hasNext()){
				Product currentProduct = iter.next();
				if(currentProduct.productName.equals(thisProduct)){
					return true;
				}
			}
			return false;
		}catch(Exception e){
			System.out.println("Error Message: " + e.getMessage() + "\n");
			return false;
		}
	}
	
	/**
	 * check whether the product is existing in the shopping cart or Not
	 * @param thisProduct is the name of the product
	 * @return returns true if thisProduct Exists in shopping cart
	*/
	
	public boolean isExistInCart(String thisProduct){
		try{
			Iterator<Product> iter = shoppingCart.iterator();
			while(iter.hasNext()){
				Product currentProduct = iter.next();
				if(currentProduct.productName.equals(thisProduct)){
					return true;
				}
			}
			return false;
		}catch(Exception e){
			System.out.println("Error Message: " + e.getMessage() + "\n");
			return false;
		}
	}
	
	/**
	 * check whether the product is existing in the ProductList or Not
	 * @param thisProduct is the name of the product
	 * @return returns true if shoppingCart is Empty
	*/
	public boolean shoppingCartIsEmpty(){
		if(shoppingCart.size()==0)
			return true;
		else
			return false;
		
	}
}
