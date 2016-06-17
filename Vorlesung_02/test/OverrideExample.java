

public class OverrideExample {
	public static class ExampleSuperClass {
		public void method() {

		}
	}

	public static final class ExampleClass extends ExampleSuperClass {
		@Override
		public void method() {
			super.method();
		}

	}
}
