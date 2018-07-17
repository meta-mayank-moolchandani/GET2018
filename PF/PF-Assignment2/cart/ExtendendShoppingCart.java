package cart;

import java.util.Iterator;
import java.util.Scanner;

public class ExtendendShoppingCart extends ShoppingCart{
	
	public int checkout(){
		try{
			
			Iterator<Product> iter = shoppingCart.iterator();
			int sum = 0;
			FixedProductPromotion promotion = new FixedProductPromotion();
			
		    while(iter.hasNext()){
				Product currentItem = iter.next();
				int effectivePrice = currentItem.productPrice * currentItem.productQuantity ;
				
				if(promotion.isPromotionApplicable("ABCDE", currentItem)){
				   effectivePrice = effectivePrice  - currentItem.fixDiscount;
				}
				
				sum = sum + effectivePrice; 

			} 
		    
		    FixedOrderPromotion orderPromotion = new FixedOrderPromotion();
		    System.out.println("sum: " + sum);
		    if(sum>4000){
		    	if(orderPromotion.isPromotionApplicable("xyz", null)){
		    		sum = sum - 1000;
		    	}
		    }
		    
			return sum;	
		}catch(Exception e){
			System.out.println("message: " + e.getMessage());
			return 0;
		}
	}
	
	
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	ExtendendShoppingCart cart = new ExtendendShoppingCart();
    	
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
        
        FixedProductPromotion fixProduct = new FixedProductPromotion();
    	
        fixProduct.setMinimumPrice(productList);
        fixProduct.getMinimumPrice(productList);
    	
        fixProduct.setFixedDiscount(productList);
        fixProduct.getFixedDiscount(productList);
        
        FixedOrderPromotion fixOrder = new FixedOrderPromotion();
        
        fixOrder.setMinimumPrice(productList);
        fixOrder.getMinimumPrice(productList);
    	
        fixOrder.setFixedDiscount(productList);
        fixOrder.getFixedDiscount(productList);
        
        
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
