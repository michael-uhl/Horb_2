package mvp.view.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.JTextComponent;

import mvp.presenter.SubmitValuesEvent;
import mvp.presenter.SubmitValuesListenerImpl;
import mvp.view.interfaces.ErrorDialogShower;
import mvp.view.interfaces.ValueHolder;

public class OkButtonClickedListener implements ActionListener {
	
	private ValueHolder xValueHolder;
	private ValueHolder yValueHolder;
	
	private SubmitValuesListenerImpl submitValuesListener;
	
	public OkButtonClickedListener(JTextComponent xValueComp, JTextComponent yValueComp, ErrorDialogShower errShower) {
		this.xValueHolder = new ValueHolderImpl(xValueComp);
		this.yValueHolder = new ValueHolderImpl(yValueComp);
		submitValuesListener = new SubmitValuesListenerImpl(xValueHolder, yValueHolder, errShower);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		submitValuesListener.submitValues(new SubmitValuesEvent());
	}
}
