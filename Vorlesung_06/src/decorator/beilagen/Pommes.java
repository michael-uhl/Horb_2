package decorator.beilagen;

import decorator.Beilage;
import decorator.Gericht;

public class Pommes extends Beilage {
	public Pommes(Gericht pIGericht) {
		super(pIGericht);
	}

	public void druckeBeschreibung() {
		gericht.druckeBeschreibung();
		System.out.print(", Pommes");
	}

	public double getPreis() {
		return gericht.getPreis() + 2.50;
	}
}