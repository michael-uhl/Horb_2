package xx01_versionStrings;

public class Main {
	
	public static void main(String[] args) {
		
		double versionOld = 1.2;
		double versionNew = 1.11;
		
		if (versionNew > versionOld) {
			System.out.println("Update");
		} else {
			System.out.println("Kein Update");
		}
	}

}
