package cart;

import java.util.List;

public interface Promotion {
	public String getMinimumPrice(List<Product> productList);

	public void setMinimumPrice(List<Product> productList);

	public String getFixedDiscount(List<Product> productList);

	public void setFixedDiscount(List<Product> productList);

	public boolean isPromotionApplicable(String promo, Product product);
}
