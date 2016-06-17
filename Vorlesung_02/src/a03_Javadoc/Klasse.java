package a03_Javadoc;

import a02_helloWorld.HelloWorld2;

/** 
 * This is a ABC class. See {@link HelloWorld2}. Usage is:
 * <p>{@code System.out.printlin(this.getClass().getName();}</p>
 * 
 * @author Michael Uhl
 * @version 0.2
 * @since 0.1
 * 
 * @see HelloWorld2
 *
 */
public class Klasse {
	private String variable = "1"; 

	/**
	 * Beschreibung dem Methode.
	 * 
	 * @param v Wird noch nicht verwendet.
	 * @return Inhalt von variable.
	 */
	public String getVariable(String v) {
		return variable;
	}

	
}
