package ugly_mirror;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class UserTest {

	@Test
	public void testToStringIncludesNameAndEmail2() {
		User user = new User("John", "Smith", "john.smith@example.com");
		assertEquals(user.lastName + ", " + user.firstName + " <" + user.eMail + ">" , user.toString());
	}
	
		@Test
		public void testToStringIncludesNameAndEmail() {
			User user = new User("John", "Smith", "john.smith@example.com");
			assertEquals("Smith, John <john.smith@example.com>" , user.toString());
		}	
}
