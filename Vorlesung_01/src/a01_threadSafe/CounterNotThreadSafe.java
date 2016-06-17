package a01_threadSafe;

public class CounterNotThreadSafe {
	private int counter = 0;

	public int inc() {
		return ++counter;
	}
}
