package mvc.view;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import org.apache.commons.lang3.StringUtils;

public class IsInputNumberEvenValidation implements DocumentListener {
	
	private JComponent source;
	
	public IsInputNumberEvenValidation(JComponent source) {
		this.source = source;
	}	

	@Override
	public void insertUpdate(DocumentEvent event) {
		resetAppearance();
		validateInput(event.getDocument());
	}

	@Override
	public void removeUpdate(DocumentEvent event) {
		resetAppearance();
	}

	@Override
	public void changedUpdate(DocumentEvent event) {
		resetAppearance();
		validateInput(event.getDocument());
	}
	
	private void validateInput(Document doc) {
		try {
			String input = doc.getText(0, doc.getLength());
			if (StringUtils.isNumeric(input)) {
				Integer inputInt = Integer.parseInt(input);
				
				if (! (inputInt % 2 == 0)) {
					JOptionPane.showMessageDialog(source.getParent(), "Bitte geben Sie eine gerade Zahl ein!");
					source.setBackground(Color.RED);
				}
			} else {
				JOptionPane.showMessageDialog(source.getParent(), "Bitte geben Sie eine Zahl ein!");
				source.setBackground(Color.RED);
			}
				
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}	
	
	private void resetAppearance() {
		source.setBackground(Color.WHITE);
	}		

}
