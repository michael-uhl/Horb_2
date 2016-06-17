package a01_threadSafe;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterThreadSafeAtomicInteger {
	private AtomicInteger counter = new AtomicInteger(0);
	
	public int inc() {
		return counter.incrementAndGet();
	}
}