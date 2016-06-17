package a05_sol;

public class Euro {
	
	private double amount;

	public Euro(double amount) {
		super();
		this.amount = amount;
	}

	public double getAmount() {
		return Math.round(amount);
	}

	public Euro add(Euro euro) {
		return new Euro(amount + euro.amount);
	}
	
	

}
