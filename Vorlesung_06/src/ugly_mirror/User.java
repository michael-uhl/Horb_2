package ugly_mirror;

public class User {
	
	protected String firstName;
	protected String lastName;
	protected String eMail;

	public User(String firstName, String lastName, String eMail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
	}
	
	public String toString() {
		return lastName + ", " + firstName + " <" + eMail + ">"; 
	}
}
