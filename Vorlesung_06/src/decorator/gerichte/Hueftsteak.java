package decorator.gerichte;

import decorator.Gericht;

public class Hueftsteak implements Gericht {
	public void druckeBeschreibung() {
		System.out.print("HŸftsteak");
	}

	public double getPreis() {
		return 13.0;
	}
}
