package xx03_polymorphims_nutzen;

public class PostalDeliveryItem extends Item {
	@Override
	public void ship(Shipping shipper, Customer customer) {
		shipper.ship(this, customer.getPostAdress());
	}
}
