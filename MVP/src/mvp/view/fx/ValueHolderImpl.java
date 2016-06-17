package mvp.view.fx;

import javafx.scene.control.TextField;
import mvp.view.interfaces.ValueHolder;

public class ValueHolderImpl implements ValueHolder {
	
	private TextField textField;
	
	public ValueHolderImpl(TextField textField) {
		super();
		this.textField = textField;
	}

	@Override
	public String getValue() {
		return textField.getText();
	}
}
