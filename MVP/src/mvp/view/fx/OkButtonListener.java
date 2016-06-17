package mvp.view.fx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import mvp.presenter.SubmitValuesEvent;
import mvp.presenter.SubmitValuesListenerImpl;
import mvp.view.interfaces.ErrorDialogShower;
import mvp.view.interfaces.ValueHolder;

public class OkButtonListener implements EventHandler<ActionEvent>{

	private ValueHolder xValueHolder;
	private ValueHolder yValueHolder;
	
	private SubmitValuesListenerImpl submitValuesListener;
	
	public OkButtonListener(TextField xValueComp, TextField yValueComp, ErrorDialogShower errShower) {
		this.xValueHolder = new ValueHolderImpl(xValueComp);
		this.yValueHolder = new ValueHolderImpl(yValueComp);
		submitValuesListener = new SubmitValuesListenerImpl(xValueHolder, yValueHolder, errShower);
	}		
	
	@Override
	public void handle(ActionEvent event) {
		submitValuesListener.submitValues(new SubmitValuesEvent());
	}

}
