package decorator;

public abstract class Beilage implements Gericht {
	protected Gericht gericht;

	public Beilage(Gericht pIGericht) {
		gericht = pIGericht;
	}
}