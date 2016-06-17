package a01_firstWindow;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFirstWindowWithLabel extends JFrame {
	private static final long serialVersionUID = 1L;

	public MyFirstWindowWithLabel(String title) {
		super(title);
		Container pane = getContentPane();
		JLabel label = new JLabel("Press 'X' to exit.");
		pane.add(label);
	}

	public static void main(String... args) {
		MyFirstWindowWithLabel theWindow = 
			new MyFirstWindowWithLabel("My first GUI");
		theWindow.setSize(400, 300);
		theWindow.setVisible(true);
		theWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);

		System.out.println("Exiting main ...");
	}
}
