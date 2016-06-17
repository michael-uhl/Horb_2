package a04_eventListenerFrameParam;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFirstWindowWithViewUpdate extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel label;
	private JButton button;
	private JButton changeMessageButton;
	
	public MyFirstWindowWithViewUpdate(String title) {
		super(title);
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(0, 1));
		label = new JLabel("Press 'X' to exit.");
		pane.add(label);
		button = new JButton("Exit");
		pane.add(button);
		changeMessageButton = new JButton("Change Text");
		changeMessageButton.addActionListener(new PrintMessageButtonListener(this));
		pane.add(changeMessageButton);
	}
	
	public JLabel getLabel() {
		return label;
	}

	public JButton getButton() {
		return button;
	}

	public JButton getChangeMessageButton() {
		return changeMessageButton;
	}

	public static void main(String... args) {
		MyFirstWindowWithViewUpdate theWindow = new MyFirstWindowWithViewUpdate("My first GUI");
		theWindow.setSize(400, 300);
		theWindow.setVisible(true);

		System.out.println("Exiting main ...");
	}
}
