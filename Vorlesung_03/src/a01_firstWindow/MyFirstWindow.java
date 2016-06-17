package a01_firstWindow;

import javax.swing.JFrame;

public class MyFirstWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public MyFirstWindow(String title) {
		super(title);
	}

	public static void main(String ... args) {
		MyFirstWindow theWindow = new MyFirstWindow("My first GUI");
		theWindow.setSize(400, 300);
		theWindow.setVisible(true);
		theWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		System.out.println("Exiting main ...");
	}
}
