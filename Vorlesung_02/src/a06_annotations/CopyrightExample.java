package a06_annotations;

@Copyright("Max")
public class CopyrightExample {
	
	@Copyright(value="Michael Müller")
	public void method() {
	}
	
	public static void main(String[] args) {
		System.out.println(
				CopyrightExample.class.getAnnotation(Copyright.class).value());
	}

}
