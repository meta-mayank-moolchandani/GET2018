package cart;
import java.util.*;

import java.util.Iterator;
import java.util.List;

public class FixedOrderPromotion implements Promotion{
	private int minimumPrice;
	private int fixedDiscount;
	
	public void getMinimumPrice(List<Product> productList){
		System.out.println("Minimum Shopppingg To Avail This Offer: "+ minimumPrice);
	}
	
	public void setMinimumPrice(List<Product> productList) {
		  minimumPrice=4000;
	}
	public void getFixedDiscount(List<Product> productList){
		System.out.println("TOTAL ORDER DISCONT ON SHOPPING OF: "+fixedDiscount);
	}
	
	public void setFixedDiscount(List<Product> productList){
		fixedDiscount = 1000;
	}
	
	public boolean isPromotionApplicable(String promo,Product product){
		Scanner sc = new Scanner(System.in);
		PromotionEnum promotionEnum = new PromotionEnum();
		
		System.out.println("\n\nENTER PROMO CODE: ");
		String inputPromo = sc.next();
		
		String promoCode = promotionEnum.FixedOrderPromoCode;
		if( (promoCode.equals(inputPromo)) && (promotionEnum.inBetween())){
			return true;
		}else{
			return false;
		}
	}

}
