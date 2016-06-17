package a01_threadSafe;

//NotThreadSave
public class MittelwertA {
	private double summe;

	public double mittel(double x, double y) {
		summe = x + y;
		summe = summe / 2;
		return summe;
	}
}