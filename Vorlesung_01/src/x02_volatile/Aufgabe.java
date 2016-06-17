package x02_volatile;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import a03_future.CallableException;

public class Aufgabe {
	public static interface Version {
		Integer work();

		void stop();
	}

	
	public static class Version1 implements Version {
		private boolean ok = true;

		public Integer work() {
			int i = 0;
			while (ok) {
				i++;
			}
			return i;
		}

		public void stop() {
			ok = false;
		}
	}

	public static class Version2 implements Version {
		private volatile boolean ok = true;

		public Integer work() {
			int i = 0;
			while (ok) {
				i++;
			}
			return i;
		}

		public void stop() {
			ok = false;
		}
	}

	public static class Version3 implements Version {
		private boolean ok = true;

		public Integer work() {
			int i = 0;
			while (true) {
				synchronized (this) {
					if (!ok)
						break;
				}
				i++;
			}
			return i;
		}

		public synchronized void stop() {
			ok = false;
		}
	}
	
	public static class Stopper implements Runnable {
		private Version v;
		
		public Stopper(Version v) {
			this.v = v;
		}

		public void run() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			v.stop();
		}
		
	}
	
	public static class Worker implements Callable<Integer> {
		private Version v;

		public Worker(Version v) {
			this.v = v;
		}

		public Integer call() {
			return v.work();
		}
	}

	/**
	 * Dies ist der Einsprungpunkt. 
	 * 
	 * @param argumente Werden hier nicht verwendet.
	 * @throws ExecutionException Exceptions in Multithreading ({@link Callable}) werden hier verpackt.
	 * @throws InterruptedException
	 * @see {@link CallableException}
	 */
	public static void main(String... argumente) throws ExecutionException, InterruptedException, NullPointerException {
		Version v = new Version2();
		Stopper stopper = new Stopper(v);
		Worker worker = new Worker(v); 
		Executors.newSingleThreadExecutor().execute(stopper);
		Future<Integer> result = Executors.newSingleThreadExecutor().submit(worker);
		System.out.println(result.get());
	}
}
