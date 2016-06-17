package a01_threadSafe;

public class CounterThreadSafeSynchronized {
	private int counter = 0;

	public synchronized int inc() {
		return ++counter;
	}
}
