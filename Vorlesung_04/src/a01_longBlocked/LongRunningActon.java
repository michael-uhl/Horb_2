package a01_longBlocked;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LongRunningActon extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private String value;

	public LongRunningActon(String title) {
		super(title);
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(0, 1));
		JLabel label = new JLabel("Press 'X' to exit.");
		pane.add(label);
		JButton button = new JButton("Exit");
		pane.add(button);
		JButton sysOutButton = new JButton("Print Message");
		sysOutButton.addActionListener(new PrintMessageButtonListener());
		pane.add(sysOutButton);
		
		final JDialog dialog = new JDialog(this);
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				value = ((JTextField)dialog.getComponents()[0]).getText();
				dialog.dispose();
			}
		});
	}

	private static class PrintMessageButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			// Ausgabe des zum ActionEvent gehörenden ActionEvent
			System.out.println("Geklickt: " + ae.getActionCommand());
			// eintausend Wiederholungen
			for (int i = 0; i < 1000; i++) {
					
				if (SwingUtilities.isEventDispatchThread()) {
					// Ausführung im EventDispatchThread?
					System.out.println("Running on EDT! var i=" + i);
				} else {
					System.out.println("NOT Running in EDT! var i=" + i);
				}
				
				try {// Für 100 Millisekunden schlafen
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String... args) {
		LongRunningActon theWindow = new LongRunningActon(
				"My first GUI");
		theWindow.setSize(400, 300);
		theWindow.setVisible(true);
		theWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);

		System.out.println("Exiting main ...");
	}
}
