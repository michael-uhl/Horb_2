package decorator.beilagen;

import decorator.Beilage;
import decorator.Gericht;

public class Bratkartoffeln extends Beilage {
	public Bratkartoffeln(Gericht pIGericht) {
		super(pIGericht);
	}

	public void druckeBeschreibung() {
		gericht.druckeBeschreibung();
		System.out.print(", Bratkartoffeln");
	}

	public double getPreis() {
		return gericht.getPreis() + 1.50;
	}
}