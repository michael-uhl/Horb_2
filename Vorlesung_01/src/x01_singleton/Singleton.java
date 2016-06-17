package x01_singleton;

public class Singleton {

	private static volatile Singleton instance; // !
	
	// ... andere Objektvariablen ...
	private Singleton() {
		// ... diverse Aktionen ...
	}

	public static Singleton getInstance() {
		if (instance == null)
			synchronized (Singleton.class) {
				if (instance == null)
					instance = new Singleton();
			}
		return instance;
	}
}