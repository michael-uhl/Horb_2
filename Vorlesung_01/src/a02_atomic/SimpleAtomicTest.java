package a02_atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleAtomicTest {
	private int notAtomic = 0;
	private AtomicInteger atomic = new AtomicInteger(0);
	private static final int NUM = 10000000;
	
	public synchronized int incrementNotAtomic() {
	    return notAtomic++;
	}

	public void performTestNotAtomic() {
	    final long start = System.currentTimeMillis();
	    for (int i = 0 ; i < NUM ; i++) {
	        incrementNotAtomic();
	    }
	    System.out.println("Not atomic: "+(System.currentTimeMillis() - start));
	}

	public void performTestAtomic() {
	    final long start = System.currentTimeMillis();
	    for (int i = 0 ; i < NUM ; i++) {
	        atomic.getAndIncrement();
	    }
	    System.out.println("Atomic: "+(System.currentTimeMillis() - start));
	}
	
	public static void main(String ... args) {
		SimpleAtomicTest test = new SimpleAtomicTest();
		test.performTestNotAtomic();
		test.performTestAtomic();
	}
}
