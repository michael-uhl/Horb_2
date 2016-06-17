package mvp.view.swt;

import mvp.view.interfaces.ValueHolder;

import org.eclipse.swt.widgets.Text;

public class ValueHolderImpl implements ValueHolder {
	private Text textComponent;

	public ValueHolderImpl(Text textComponent) {
		this.textComponent = textComponent;
	}

	@Override
	public String getValue() {
		return textComponent.getText();
	}
}
