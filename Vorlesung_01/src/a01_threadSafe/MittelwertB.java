package a01_threadSafe;

//ThreadSave
public class MittelwertB {
	public double mittel(double x, double y) {
		double summe;
		summe = x + y;
		summe = summe / 2;
		return summe;
	}
}