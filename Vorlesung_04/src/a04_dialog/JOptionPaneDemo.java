package a04_dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JOptionPaneDemo extends JFrame {

	private static final long serialVersionUID = -4477106604121029192L;

	public JOptionPaneDemo() {
		super("JOptionPaneDemo");  
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		JOptionPane.showMessageDialog(this, "Dies ist eine Nachricht.");

		if (JOptionPane.showConfirmDialog(this, "Sind Sie sicher?", "Sicher?",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(this, "Ja, Sie sind sicher.");
		}

		System.out.println(JOptionPane.showInputDialog(this,
				"Geben Sie Ihren Namen an"));

		// Custom button text
		Object[] options = { "Yes, please", "No, thanks", "No eggs, no ham!" };
		int n = JOptionPane.showOptionDialog(this,
				"Would you like some green eggs to go " + "with that ham?",
				"A Silly Question", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
		System.out.println(n);
		
        Object[] options2 = {"OK", "Cancel", "Ja", "Nein", "Egal"};
        
		int selected = JOptionPane.showOptionDialog(null,
		                                            "Treffen Sie eine Auswahl",
		                                            "Alternativen",
		                                            JOptionPane.DEFAULT_OPTION, 
		                                            JOptionPane.INFORMATION_MESSAGE, 
		                                            null, options2, options2[0]);
        System.out.println(selected);	
	}

	public static void main(String[] args) {
		new JOptionPaneDemo();
	}

}
