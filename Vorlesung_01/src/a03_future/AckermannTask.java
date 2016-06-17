package a03_future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class AckermannTask implements Callable<Long> {

	@Override
	public Long call() {
		return ackermann(3,4);
	}

	public long ackermann(long m, long n) {
		if (m == 0)
			return n + 1;
		if (n == 0)
			return ackermann(m - 1, 1);
		return 
		ackermann(m - 1, ackermann(m, n - 1));
	}
	
	public static void main(String ... args) throws InterruptedException, ExecutionException {
		System.out.println(new AckermannTask().call());
		System.out.println(Executors.newFixedThreadPool(1).submit(new AckermannTask()).get());
	}

}
