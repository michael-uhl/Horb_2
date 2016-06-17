package x03_synchronized;

public class XXX implements Runnable {

	public void run() {
		while (true) {
			m();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void m() {
		System.out.println("EINtritt " + Thread.currentThread().getName());
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("AUStritt " + Thread.currentThread().getName());
	}

	public static void main(String args[]) {
		Runnable x = new XXX();

		new Thread(x, "1").start();
		new Thread(x, "2").start();
	}
}