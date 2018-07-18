package cart;

import java.util.Iterator;
import java.util.List;

public class FixedProductPromotion implements Promotion {
	// private int minimumPrice;

	/**
	 * for printing the minimum price for availing the product discount
	 */
	public String getMinimumPrice(List<Product> productList) {
		Iterator<Product> iter = productList.iterator();
		StringBuffer getPrice = new StringBuffer();
		getPrice.append("******Minimum price of the Items*********\n");

		while (iter.hasNext()) {
			Product product = iter.next();
			getPrice.append(product.productName + ": " + product.fixOrder
					+ "\n");
		}
		return getPrice.toString();
	}

	/**
	 * for setting the minimum price for availing the product discount
	 * 
	 * @param productList
	 *            i the list of the product
	 */

	public void setMinimumPrice(List<Product> productList) {
		productList.get(0).fixOrder = 300;
		productList.get(1).fixOrder = 400;
		productList.get(2).fixOrder = 500;
		productList.get(3).fixOrder = 600;
		productList.get(4).fixOrder = 700;
	}

	/**
	 * for getting the discount
	 */
	public String getFixedDiscount(List<Product> productList) {
		Iterator<Product> iter = productList.iterator();
		StringBuffer getDiscount = new StringBuffer();
		getDiscount
				.append("******discount available on minimum purchase price*********\n");

		while (iter.hasNext()) {
			Product product = iter.next();
			getDiscount.append(product.productName + ": " + product.fixDiscount
					+ "\n");
		}
		return getDiscount.toString();

	}

	/**
	 * for setting fixed product discount
	 * 
	 * @param productList
	 *            is the list of the product
	 */
	public void setFixedDiscount(List<Product> productList) {
		productList.get(0).fixDiscount = 100;
		productList.get(1).fixDiscount = 200;
		productList.get(2).fixDiscount = 300;
		productList.get(3).fixDiscount = 400;
		productList.get(4).fixDiscount = 500;
	}

	/**
	 * for checking that promocode code can be availed by user or not
	 * 
	 * @param promo
	 *            is a promo code
	 * @param product
	 *            is the name of product on which promo is applicable
	 */
	public boolean isPromotionApplicable(String promo, Product product) {

		PromotionEnum promotion = new PromotionEnum();
		String promoCode = promotion.FixedProductPromoCode;

		if (promotion.inBetween()) {

			int price = product.productPrice * product.productQuantity;

			if (price > product.fixOrder) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

}
