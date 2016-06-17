package mvp.presenter;

import mvp.model.interfaces.ValueChangedEvent;
import mvp.model.interfaces.ValueChangedListener;
import mvp.model.interfaces.ValueModelInterfaceFactory;
import mvp.view.fx.ValuesAppMainFrame;

public class ValuesChangeApplicaton implements ValueChangedListener {
	
	private ValuesAppMainFrame mainFrame;
	
	public ValuesChangeApplicaton() {
		mainFrame = new ValuesAppMainFrame();
		ValueModelInterfaceFactory.getValueChangedProvider().addValueChangedListener(this);
		mainFrame.start();
	}
	
	public static void main(String[] argv) {
		new ValuesChangeApplicaton();
	}

	@Override
	public void valueChanged(ValueChangedEvent evt) {
		mainFrame.setValues("" + evt.getX(), "" + evt.getY());
	}
}