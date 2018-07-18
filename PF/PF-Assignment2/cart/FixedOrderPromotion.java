package cart;

import java.util.*;

import java.util.Iterator;
import java.util.List;

public class FixedOrderPromotion implements Promotion {
	private int minimumPrice;
	private int fixedDiscount;

	/**
	 * for printing the minimum price for availing the product discount
	 */
	public String getMinimumPrice(List<Product> productList) {
		StringBuffer getMin = new StringBuffer();
		getMin.append("Minimum Shopppingg To Avail This Offer: " + minimumPrice);
		return getMin.toString();
	}

	/**
	 * for setting the minimum price for availing the product discount
	 */
	public void setMinimumPrice(List<Product> productList) {
		minimumPrice = 4000;
	}

	/**
	 * for getting the fix discount price for availing the product discount
	 */
	public String getFixedDiscount(List<Product> productList) {
		StringBuffer getFix = new StringBuffer();
		getFix.append("TOTAL ORDER DISCONT ON SHOPPING OF: " + fixedDiscount);
		return getFix.toString();
	}

	/**
	 * for setting the fix discount price
	 */
	public void setFixedDiscount(List<Product> productList) {
		fixedDiscount = 1000;
	}

	/**
	 * check that promo is applicable or not
	 */
	public boolean isPromotionApplicable(String promo, Product product) {
		Scanner sc = new Scanner(System.in);
		PromotionEnum promotionEnum = new PromotionEnum();

		System.out.println("\n\nENTER PROMO CODE: ");
		String inputPromo = sc.next();

		String promoCode = promotionEnum.FixedOrderPromoCode;
		if ((promoCode.equals(inputPromo)) && (promotionEnum.inBetween())) {
			return true;
		} else {
			return false;
		}
	}

}
