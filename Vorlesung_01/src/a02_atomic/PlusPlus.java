package a02_atomic;

public class PlusPlus {

	private int i = 0;
	private int j = 0;
	
	public int evaluateIPlusPlus() {
		return i++;
	}
	
	public int evaluatePlusPlusJ() {
		return ++j;
	}
	
	public static void main(String[] args) {
		PlusPlus pp = new PlusPlus();
		
		System.out.println(pp.evaluateIPlusPlus());
		System.out.println(pp.evaluatePlusPlusJ());
	}
}
