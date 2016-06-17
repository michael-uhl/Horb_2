package a03_threadPools;

public class Bisher {
	public static class ExampleRunnable implements Runnable {
		public void run() {
			System.out.println("Run");
		}
	}
	
	public static void main(String[] args) {
		new Thread(new ExampleRunnable()).start();
	}
}
