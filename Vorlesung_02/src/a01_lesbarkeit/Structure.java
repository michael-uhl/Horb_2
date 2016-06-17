package a01_lesbarkeit;

/**
 * Diese Klasse ist ein Beispiel.
 * 
 * @author Michael Uhl
 */
public class Structure {
	public static final String CONST = "hallo";
	protected String welt;
	int studCounter = 0;
	
	private String mySecret;
	
	/**
	 * Insert text here.
	 */
	public Structure() {
		/*
		 * This is only an example
		 */
		studCounter++; //Counts today's students.
	}
	
	public void doSomething() {
		mySecret = CONST + "welt";
		System.out.println(mySecret);
	}
}
