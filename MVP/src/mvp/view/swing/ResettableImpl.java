package mvp.view.swing;

import javax.swing.text.JTextComponent;

import mvp.model.interfaces.Resettable;

public class ResettableImpl implements Resettable {
	
	private JTextComponent component;
	
	public ResettableImpl(JTextComponent component) {
		this.component = component;
	}

	@Override
	public void reset() {
		component.setText("");
	}
}
