package a01_firstWindow;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFirstWindowWithLayout extends JFrame {
	private static final long serialVersionUID = 1L;

	public MyFirstWindowWithLayout(String title) {
		super(title);
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(2, 3)); //Reihen 2, Spalten 3
//		JLabel label = new JLabel("Press 'X' to exit.");
//		pane.add(label);
//		JButton button = new JButton("Exit");
//		pane.add(button);
		pane.add(new JLabel("1"));
		pane.add(new JLabel("2"));
		pane.add(new JLabel("3"));
		pane.add(new JLabel("4"));
		pane.add(new JLabel("5"));
		pane.add(new JLabel("6"));
		pane.add(new JLabel("7"));
		pane.add(new JLabel("8"));
		pane.add(new JLabel("9"));
	}

	public static void main(String... args) {
		MyFirstWindowWithLayout theWindow = 
			new MyFirstWindowWithLayout("My first GUI");
		theWindow.setSize(400, 300);
		theWindow.setVisible(true);

		System.out.println("Exiting main ...");
	}
}
