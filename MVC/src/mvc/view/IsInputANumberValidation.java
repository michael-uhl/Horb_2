package mvc.view;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import org.apache.commons.lang3.StringUtils;

public class IsInputANumberValidation implements DocumentListener {
	
	private JComponent source;
	
	public IsInputANumberValidation(JComponent source) {
		this.source = source;
	}

	@Override
	public void removeUpdate(DocumentEvent event) {
		resetAppearance();
	}

	@Override
	public void insertUpdate(DocumentEvent event) {
		resetAppearance();
		validateInput(event.getDocument());
	}


	@Override
	public void changedUpdate(DocumentEvent event) {
		resetAppearance();
		validateInput(event.getDocument());
	}
	
	private void validateInput(Document doc) {
		try {
			String input = doc.getText(0, doc.getLength());
			if (!StringUtils.isNumeric(input)) {
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
