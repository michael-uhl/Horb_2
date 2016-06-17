package a05_cC;

public class Bezeichner {
	private int l = 0;
	
	public void print () {
		if (l == 0) {
			System.out.println("drin.");
		}
	}
	
	public static void main (String ... args) { 
		Bezeichner bez = new Bezeichner();
		bez.print();
	}
}
