package xx03_polymorphims_nutzen;

public class Main {

	public static void main(String ...strings)
	{
		Shipping shipping = new Shipping();
		
		Customer customer = new Customer();
		
		ShoppingCart cart = new ShoppingCart();
		cart.add(new Item());
		cart.add(new Item());
		
		while(!cart.isEmpty()) {
			Item currentItem= cart.takeNext();
			if (currentItem.isEbook()) {
				shipping.ship(currentItem, customer.getEmailAdress());
			} else {
				shipping.ship(currentItem, customer.getPostAdress());
			}
		}
		
		while(!cart.isEmpty()) {
			cart.takeNext().ship(shipping, customer);
		}
	}
}
