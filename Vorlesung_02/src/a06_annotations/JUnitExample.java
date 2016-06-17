package a06_annotations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JUnitExample {
	private List<String> classUnderTest; 
	
	@Before
	public void setUp() {
		classUnderTest = new ArrayList<String>();
	}

	@Test
	public void testInOut() {
		classUnderTest.add("out");
		classUnderTest.add("XXXXX");
		Assert.assertEquals("out", classUnderTest.get(0));
	}

}
