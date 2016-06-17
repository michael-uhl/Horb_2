package boundary;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class ShippingTest extends Shipping{

	@Test
	public void testFreeShippingForOrderAboveMinPrice() {
		assertTrue(super.isFreeShipping(MIN_FREE_SHIPPING_PRICE + 1));
	}
	
	@Test
	public void testFreeShippingForOrderBelowMinPrice() {
		assertFalse(super.isFreeShipping(MIN_FREE_SHIPPING_PRICE - 1));
	}	
	
//	@Test
//	public void testFreeShippingForOrderEqualMinPrice() {
//		assertTrue(super.isFreeShipping(MIN_FREE_SHIPPING_PRICE));
//	}		
}
