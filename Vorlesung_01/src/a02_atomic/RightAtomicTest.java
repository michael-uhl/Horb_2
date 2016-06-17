package a02_atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class RightAtomicTest {
	private int notAtomic = 0;
	private AtomicInteger atomic = new AtomicInteger(0);
	private static final long NUM = 1000000000;
	
	public synchronized int incrementNotAtomic() {
	    return notAtomic++;
	}

	public void performTestNotAtomic() {
	    final long start = System.currentTimeMillis();

	    for (int i = 0; i < 5; i++) {
	    	new Thread(new IncementorNotAtomic()).start();
	    }
	    
	    System.out.println("Not atomic: "+(System.currentTimeMillis() - start));
	}

	public void performTestAtomic() {
	    final long start = System.currentTimeMillis();
	
	    for (int i = 0; i < 5; i++) {
	    	new Thread(new IncementorAtomic()).start();
	    }
	    
	    System.out.println("Atomic: "+(System.currentTimeMillis() - start));
	}
	
	public static void main(String ... args) {
		SimpleAtomicTest test = new SimpleAtomicTest();
		test.performTestNotAtomic();
		test.performTestAtomic();
	}
	
	private final class IncementorNotAtomic implements Runnable {

		@Override
		public void run() {
		    for (int i = 0 ; i < NUM ; i++) {
		        incrementNotAtomic();
		    }	
		}
		
	}
	
	private final class IncementorAtomic implements Runnable {

		@Override
		public void run() {
		    for (int i = 0 ; i < NUM ; i++) {
		    	atomic.incrementAndGet();
		    }	
		}
		
	}	
}
