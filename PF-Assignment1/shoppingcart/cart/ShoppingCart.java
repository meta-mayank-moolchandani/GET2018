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
	
	
	
	
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	ShoppingCart cart = new ShoppingCart();
    	
    	Product item1 = new Product("Item1",100,10);
    	Product item2 = new Product("Item2",200,20);
    	Product item3 = new Product("Item3",300,30);
    	Product item4 = new Product("Item4",400,40);
    	Product item5 = new Product("Item5",500,50);
        productList.add(item1);
        productList.add(item2);
        productList.add(item3);
        productList.add(item4);
        productList.add(item5);
        
        System.out.println("****************PRODUCT LIST****************");
        Iterator iter = productList.iterator();
        while(iter.hasNext()){
        	System.out.println(iter.next());
        }
        
        
        
        while(true){
        	int choice;
        	System.out.println("1: Add product to cart");
        	System.out.println("2: Remove product from cart");
        	System.out.println("3: Update product in cart");
        	System.out.println("4: show all products of cart");
        	System.out.println("5: checkout cart");
        	
        	choice = sc.nextInt();
        	try{
        	
	        	switch(choice){
	        		case 1: 
		        			System.out.println("Enter the item which you want to add in your cart: ");
		        			String productToAdd = sc.next();
		        			
		        			System.out.print("Enter Quantity: ");
		        			int quantity = sc.nextInt();
		        			
		        			if(cart.addProductToCart(productToAdd,quantity))
	        			        System.out.print("product added successfully \n");
	        			    else
	        			    	System.out.print("this product can not be added \n");    
	        			    break;
	        		
	        		case 2: 
	        			    System.out.println("Enter the product name: ");
	        			    String productToRemove = sc.next();
	        			    if(cart.removeProductFromCart(productToRemove))
	        			       System.out.println("product removed successfully \n");
	        			    else
	        			    	System.out.println("product is not removed, Incorrect Product: \n");   
	        			    break;
	        		
	        		case 3: 
	        			    System.out.println("Enter the product name: ");
	        			    String productToUpdate = sc.next();
	        			    System.out.println("Enter the new quantity: ");
	        			    int updatedQuantity = sc.nextInt();
	        			    if(cart.updateProductInCart(productToUpdate, updatedQuantity))
	        			    	System.out.println("product updated successfully:\n");
	        			    else
	        			    	System.out.println("NOT UPDATED\n");	
	        			    break;
	        			    	    
	        		
	        		case 4: 
	        			    if(!cart.shoppingCartIsEmpty()){
	        			    
		        			    System.out.println("****************CART PRODUCT LIST****************");
						        iter = cart.shoppingCart.iterator();
						        while(iter.hasNext()){
						        	System.out.println(iter.next());
						        }
	        			    }else{
	        			    	System.out.println("cart is empty ");
	        			    }
	        			    break;
	          		case 5: 
	        			    System.out.println("checkout: ");
	        			    int totalPayableAmount;
	        			    totalPayableAmount = cart.checkout();
	        			    System.out.println("TOTAL AMOUNT: " + totalPayableAmount);
	        			    System.exit(0);
	        			    break;
	        			    
	        		default: 
	        			    System.out.println("Invalid Input: ");	    
	        	}
        	}catch(Exception e){
        		System.out.println("Exception Message : " + e.getMessage());
        	}	
        }
        
        
        
  }
}
