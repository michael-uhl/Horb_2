package decorator.beilagen;

import decorator.Beilage;
import decorator.Gericht;

public class Nudeln extends Beilage {
	public Nudeln(Gericht pIGericht) {
		super(pIGericht);
	}

	public void druckeBeschreibung() {
		gericht.druckeBeschreibung();
		System.out.print(", Nudeln");
	}

	public double getPreis() {
		return gericht.getPreis() + 4.50;
	}
}
