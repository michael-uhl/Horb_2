package xx03_polymorphims_nutzen;

public class DownloadableItem extends Item {
	@Override
	public void ship(Shipping shipper, Customer customer) {
		shipper.ship(this, customer.getEmailAdress());
	}
}
