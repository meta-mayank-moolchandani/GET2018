package cart;

import java.util.Iterator;
import java.util.List;

public class FixedProductPromotion implements Promotion {
	//private int minimumPrice;
	
	
	public void getMinimumPrice( List<Product> productList ) {
		Iterator<Product> iter = productList.iterator();
		System.out.println("******Minimum price of the Items*********");
		
		while ( iter.hasNext() ) {
			Product product = iter.next();
			System.out.println(product.productName + ": " + product.fixOrder);
		}
	}
	
	public void setMinimumPrice(List<Product> productList){
		 productList.get(0).fixOrder = 300;
		 productList.get(1).fixOrder = 400;
		 productList.get(2).fixOrder = 500;
		 productList.get(3).fixOrder = 600;
		 productList.get(4).fixOrder = 700;
	}
	
	
	public void getFixedDiscount(List<Product> productList){
		Iterator<Product> iter = productList.iterator();
		System.out.println("******discount available on minimum purchase price*********");
		
		while(iter.hasNext()){
			Product product = iter.next();
			System.out.println(product.productName + ": " + product.fixDiscount);
		}
		
	}
	
	public void setFixedDiscount(List<Product> productList){
		 productList.get(0).fixDiscount = 100;
		 productList.get(1).fixDiscount = 200;
		 productList.get(2).fixDiscount = 300;
		 productList.get(3).fixDiscount = 400;
		 productList.get(4).fixDiscount = 500;
	}
	
	public boolean isPromotionApplicable(String promo, Product product){
		
		PromotionEnum promotion = new PromotionEnum();
		String promoCode = promotion.FixedProductPromoCode;
		
		if ( promotion.inBetween() ) {
			
			
			int price = product.productPrice * product.productQuantity;
			
			if( price>product.fixOrder ) {
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}
	}



}
