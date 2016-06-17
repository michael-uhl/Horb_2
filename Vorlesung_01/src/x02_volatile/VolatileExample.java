package x02_volatile;

public class VolatileExample {

	private static final class Looper extends Thread {
		public volatile boolean finish = false;

		@Override
		public void run() {
			while (!finish) {
				// do something (Breakpoint)
				//System.out.println("finish is '" + finish + "'");
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Looper looper = new Looper();
		looper.start();
		Thread.sleep(1000);
		looper.finish = true;
		System.out.println("Wait for looper to terminate.");
		looper.join();
		System.out.println("Done.");
	}
	
}
