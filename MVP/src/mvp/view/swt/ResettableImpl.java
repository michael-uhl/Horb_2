package mvp.view.swt;

import org.eclipse.swt.widgets.Text;

import mvp.model.interfaces.Resettable;

public class ResettableImpl implements Resettable {
	
	private Text component;	
	
	public ResettableImpl(Text component) {
		super();
		this.component = component;
	}

	@Override
	public void reset() {
		component.setText("");
	}

}
