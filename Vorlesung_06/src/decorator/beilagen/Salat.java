package decorator.beilagen;

import decorator.Beilage;
import decorator.Gericht;

public class Salat extends Beilage {
	public Salat(Gericht pIGericht) {
		super(pIGericht);
	}

	public void druckeBeschreibung() {
		gericht.druckeBeschreibung();
		System.out.print(", Salat");
	}

	public double getPreis() {
		return gericht.getPreis() + 2.25;
	}
}