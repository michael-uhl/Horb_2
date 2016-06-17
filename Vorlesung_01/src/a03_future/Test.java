package a03_future;

public class Test<V> {

	private V v;
	
	public void setValue(V value) {
		this.v = value;
	}
	
	public V getValue() {
		return v;
	}
	
	public <T> int name(T ... a) {
		return a.length;
	}
	
	public static void main(String ... args) {
		Test<String> testString = new Test<String>();
		testString.<String>name("a", "b", "c");
	}
}
