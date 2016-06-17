package a03_event;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MyFirstWindowWithViewUpdate extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public MyFirstWindowWithViewUpdate(String title) {
		super(title);
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(0, 1));
		JLabel label = new JLabel("Press 'X' to exit.");
		pane.add(label);
		JButton button = new JButton("Exit");
		pane.add(button);
		JButton changeMessageButton = new JButton("Change Text");
		changeMessageButton.addActionListener(new PrintMessageButtonListener(label));
		pane.add(changeMessageButton);
	}
	
	private static class PrintMessageButtonListener implements ActionListener {
		private JLabel label2ChangeTxt;
		
		public PrintMessageButtonListener(JLabel label2ChangeTxt) {
			this.label2ChangeTxt = label2ChangeTxt;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			label2ChangeTxt.setText("Change Text Button was clicked. " + SwingUtilities.isEventDispatchThread());
		}
	}

	public static void main(String... args) {
		MyFirstWindowWithViewUpdate theWindow = new MyFirstWindowWithViewUpdate("My first GUI");
		theWindow.setSize(400, 300);
		theWindow.setVisible(true);

		System.out.println("Exiting main ...");
	}
}
