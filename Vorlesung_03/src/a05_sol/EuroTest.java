package a05_sol;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EuroTest {

	private Euro two;
	
	@Before
	public void setUp() {
		two = new Euro(2.00);
	}

	@Test
	public void testAmount() {
		Assert.assertTrue(2.00 == two.getAmount());
	}

	@Test
	public void testRounding() {
		two = new Euro(1.995);
		Assert.assertEquals("rounded amount", 2.00, two.getAmount(), 0.001);
	}

	@Test
	public void testAdding() {
		Euro three = two.add(new Euro(1.00)); 								
		Assert.assertEquals("two", 2.00, two.getAmount(), 0.001); 		
	}
}