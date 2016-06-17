package x03_synchronized;

class SecondSync implements Runnable {
	public void run() {
		synchronized (this) {
			try {
				System.out.print("I am a ");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Second sync interrupted.");
			}
			System.out.println("sync method");
		}
	}
	
	public static void main(String args[]){
		Thread x1 = new Thread(new SecondSync());
		Thread x2 = new Thread(new SecondSync());
		x1.start();
		x2.start();
		}
}