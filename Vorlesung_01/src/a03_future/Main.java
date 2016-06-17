package a03_future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String... args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Callable<Long> callable = new AckermannTask();
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
