package a01_longBlocked;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class LongRunningActonInvokeLater extends JFrame {
	private static final long serialVersionUID = 1L;

	public LongRunningActonInvokeLater(String title) {
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
	}

	private static class PrintMessageButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			// Ausgabe des zum ActionEvent gehšrenden ActionEvent
			System.out.println("Geklickt: " + ae.getActionCommand());

			new Thread(new Runnable() {

				@Override
				public void run() {
					// eintausend Wiederholungen
					for (int i = 0; i < 1000; i++) {
						if (SwingUtilities.isEventDispatchThread()) {
							// AusfŸhrung im EventDispatchThread?
							System.out.println("Running on EDT! var i=" + i);
						} else {
							System.out.println("NOT Running in EDT! var i=" + i);
						}
							
						try {// FŸr 100 Millisekunden schlafen
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
	}

	public static void main(String... args) {
		LongRunningActonInvokeLater theWindow = new LongRunningActonInvokeLater(
				"My first GUI");
		theWindow.setSize(400, 300);
		theWindow.setVisible(true);
		theWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);

		System.out.println("Exiting main ...");
	}
}
