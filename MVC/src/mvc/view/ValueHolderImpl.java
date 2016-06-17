package mvc.view;

import javax.swing.text.JTextComponent;

import mvc.view.interfaces.ValueHolder;

public class ValueHolderImpl implements ValueHolder {

	private JTextComponent textComponent;

	public ValueHolderImpl(JTextComponent textComponent) {
		this.textComponent = textComponent;
	}

	@Override
	public String getValue() {
		return textComponent.getText();
	}

}
