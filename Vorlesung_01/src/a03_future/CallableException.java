package a03_future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableException implements Callable<Long> {

	@Override
	public Long call() throws Exception {
		throw new TestException();
	}

	public static final class TestException extends Exception {

		private static final long serialVersionUID = 1L;

		@Override
		public String getMessage() {
			return "Dies ist ein Test.";
		}
		
	}
	
	public static void main(String... args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Callable<Long> callable = new CallableException();
		Future<Long> future = executor.submit(callable);
		
		try {
			System.out.println("Future value: " + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
