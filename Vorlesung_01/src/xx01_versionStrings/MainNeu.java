package xx01_versionStrings;

public class MainNeu {

	public static void main(String[] args) {
		
		String versionOld = "1.2";
		String versionNew = "1.11";
		
		if (new VersionStringComparation().compare(versionNew, versionOld) > 0) {
			System.out.println("Update");
		} else {
			System.out.println("Kein Update");
		}
	}

	
}
