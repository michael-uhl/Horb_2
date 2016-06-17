package decorator.gerichte;

import decorator.Gericht;

public class Tofu implements Gericht {
	public void druckeBeschreibung() {
		System.out.print("Tofu");
	}

	public double getPreis() {
		return 8.50;
	}
}