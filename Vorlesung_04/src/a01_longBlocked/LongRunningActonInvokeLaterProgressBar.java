package a01_longBlocked;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class LongRunningActonInvokeLaterProgressBar extends JFrame {
	private static final long serialVersionUID = 1L;

	public LongRunningActonInvokeLaterProgressBar(String title) {
		super(title);
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(0, 1));
		JLabel label = new JLabel("Press 'X' to exit.");
		pane.add(label);
		JButton button = new JButton("Exit");
		pane.add(button);
	    JProgressBar exampleBar = new JProgressBar( 0, 1000 );
	    exampleBar.setVisible(false);
	    pane.add(exampleBar);
		JButton sysOutButton = new JButton("Print Message");
		sysOutButton.addActionListener(new PrintMessageButtonListener(exampleBar));
		pane.add(sysOutButton);
	}

	private static class PrintMessageButtonListener implements ActionListener {
		
		private JProgressBar exampleBar;

		public PrintMessageButtonListener(JProgressBar exampleBar) {
			this.exampleBar = exampleBar;
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			// Ausgabe des zum ActionEvent geh�renden ActionEvent
			System.out.println("Geklickt: " + ae.getActionCommand());
			
			exampleBar.setVisible(true);

			new Thread(new Runnable() {

				@Override
				public void run() {
					// eintausend Wiederholungen
					for (int i = 0; i < 1000; i++) {
						if (SwingUtilities.isEventDispatchThread()) {
							// Ausf�hrung im EventDispatchThread?
							System.out.println("Running on EDT! var i=" + i);
						} else {
							System.out.println("NOT Running in EDT! var i=" + i);
							final int j = i;
							SwingUtilities.invokeLater(new Runnable() {
								
								@Override
								public void run() {
									exampleBar.setValue(j);
								}
							});
							
						}
							
						try {// F�r 100 Millisekunden schlafen
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
		LongRunningActonInvokeLaterProgressBar theWindow = new LongRunningActonInvokeLaterProgressBar(
				"My first GUI");
		theWindow.setSize(400, 300);
		theWindow.setVisible(true);
		theWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);

		System.out.println("Exiting main ...");
	}
}
