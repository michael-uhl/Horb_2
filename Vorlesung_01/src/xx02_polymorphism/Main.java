package xx02_polymorphism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	

	@SuppressWarnings("serial")
	public static void main(String ... args)
	{
		List<String> example = new ArrayList<String>() {{add("2"); add("3"); add("4");}};
		example.add("2");
		
		System.out.println(example);
	}
}
