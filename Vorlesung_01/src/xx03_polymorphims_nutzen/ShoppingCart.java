package xx03_polymorphims_nutzen;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<Item> cart = new ArrayList<Item>();
	
	public void add(Item item) {
		cart.add(item);
	}
	
	public Item takeNext() {
		return cart.remove(0);
	}
	
	public boolean isEmpty() {
		return cart.isEmpty();
	}
}
