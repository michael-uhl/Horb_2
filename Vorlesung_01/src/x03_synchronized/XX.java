package x03_synchronized;

public class XX extends Thread {
	private String id;
	private Object monitor;

	public XX(String id, Object monitor) {
		this.id = id;
		this.monitor = monitor;
	}

	public void run() {
		while (true)
			m();
	}

	public synchronized void m() {
		System.out.println("EINtritt " + id);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("AUStritt " + id);
	}

	public static void main(String args[]) {
		Object o = new Object();
		XX x1 = new XX("1", o);
		XX x2 = new XX("2", o);
		x1.start();
		x2.start();
	}
}