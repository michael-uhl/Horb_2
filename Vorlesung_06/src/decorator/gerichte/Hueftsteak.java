package decorator.gerichte;

import decorator.Gericht;

public class Hueftsteak implements Gericht {
	public void druckeBeschreibung() {
		System.out.print("H�ftsteak");
	}

	public double getPreis() {
		return 13.0;
	}
}
