package decorator.beilagen;

import decorator.Beilage;
import decorator.Gericht;

public class Suppe extends Beilage {
	public Suppe(Gericht pIGericht) {
		super(pIGericht);
	}

	public void druckeBeschreibung() {
		gericht.druckeBeschreibung();
		System.out.print(", Suppe");
	}

	public double getPreis() {
		return gericht.getPreis() + 1.50;
	}
}