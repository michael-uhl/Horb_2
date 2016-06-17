package mvp.view.swt;

import mvp.presenter.SubmitValuesEvent;
import mvp.presenter.SubmitValuesListenerImpl;
import mvp.view.interfaces.ErrorDialogShower;
import mvp.view.interfaces.ValueHolder;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

public class OkButtonClickedListener extends SelectionAdapter {
	
	private ValueHolder xValueHolder;
	private ValueHolder yValueHolder;
	
	private SubmitValuesListenerImpl submitValuesListener;
	
	public OkButtonClickedListener(Text xValueComp, Text yValueComp, ErrorDialogShower errShower) {
		this.xValueHolder = new ValueHolderImpl(xValueComp);
		this.yValueHolder = new ValueHolderImpl(yValueComp);
		submitValuesListener = new SubmitValuesListenerImpl(xValueHolder, yValueHolder, errShower);
	}	

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		submitValuesListener.submitValues(new SubmitValuesEvent());
	}
}