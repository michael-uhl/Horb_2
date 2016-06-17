package boundary;

public class Shipping {
	
	protected static final int MIN_FREE_SHIPPING_PRICE = 2500;
	
	public boolean isFreeShipping(int priceTotalOrder) {
		return priceTotalOrder > MIN_FREE_SHIPPING_PRICE;
	}
}
