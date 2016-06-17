package mvp.view.swing;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

import mvp.presenter.IsInputANumberValidator;

public class IsInputANumberValidatorImpl extends IsInputANumberValidator implements DocumentListener {
	
	JTextComponent source;

	public IsInputANumberValidatorImpl(JTextComponent source) {
		this.source = source;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		validate();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		setNoError();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		validate();
	}

	@Override
	public void setError(String msg) {
		JOptionPane.showMessageDialog(source.getParent(), getValidationMessage());
		source.setBackground(Color.RED);
	}

	@Override
	public void setNoError() {
		source.setBackground(Color.WHITE);
	}

	@Override
	public String getValue() {
		try {
			return source.getDocument().getText(0, source.getDocument().getLength());
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		return "";
	}

}
