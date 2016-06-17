package a03_event;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFirstWindowWithViewUpdateNestedInnerClass extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel label;
	
	public MyFirstWindowWithViewUpdateNestedInnerClass(String title) {
		super(title);
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(0, 1));
		label = new JLabel("Press 'X' to exit.");
		pane.add(label);
		JButton button = new JButton("Exit");
		pane.add(button);
		JButton changeMessageButton = new JButton("Change Text");
		changeMessageButton.addActionListener(new PrintMessageButtonListener());
		pane.add(changeMessageButton);
	}
	
	private class PrintMessageButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText("Change Text Button was clicked.");
		}
	}

	public static void main(String... args) {
		MyFirstWindowWithViewUpdateNestedInnerClass theWindow = new MyFirstWindowWithViewUpdateNestedInnerClass("My first GUI");
		theWindow.setSize(400, 300);
		theWindow.setVisible(true);

		System.out.println("Exiting main ...");
	}
}
