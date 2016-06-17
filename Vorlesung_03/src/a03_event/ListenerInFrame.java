package a03_event;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ListenerInFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	public ListenerInFrame(String title) {
		super(title);
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(0, 1));
		JLabel label = new JLabel("Press 'X' to exit.");
		pane.add(label);
		JButton button = new JButton("Exit");
		pane.add(button);
		JButton sysOutButton = new JButton("Print Message");
		sysOutButton.addActionListener(this);
		pane.add(sysOutButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clicked button.");
	}

	public static void main(String... args) {
		ListenerInFrame theWindow = new ListenerInFrame("My first GUI");
		theWindow.setSize(400, 300);
		theWindow.setVisible(true);

		System.out.println("Exiting main ...");
	}
}
