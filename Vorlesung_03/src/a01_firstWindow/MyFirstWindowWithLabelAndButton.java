package a01_firstWindow;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFirstWindowWithLabelAndButton extends JFrame {
	private static final long serialVersionUID = 1L;

	public MyFirstWindowWithLabelAndButton(String title) {
		super(title);
		Container pane = getContentPane();
		JLabel label = new JLabel("Press 'X' to exit.");
		pane.add(label);
		JButton button = new JButton("Exit");
		pane.add(button);
	}

	public static void main(String... args) {
		MyFirstWindowWithLabelAndButton theWindow = 
			new MyFirstWindowWithLabelAndButton("My first GUI");
		theWindow.setSize(400, 300);
		theWindow.setVisible(true);

		System.out.println("Exiting main ...");
	}
}
