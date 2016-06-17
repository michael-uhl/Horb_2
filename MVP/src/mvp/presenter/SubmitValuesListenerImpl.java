package mvp.presenter;

import mvp.model.interfaces.ValueModelControllerInterface;
import mvp.model.interfaces.ValueModelInterfaceFactory;
import mvp.model.interfaces.YNotEvenException;
import mvp.view.interfaces.ErrorDialogShower;
import mvp.view.interfaces.ValueHolder;

import org.apache.commons.lang3.StringUtils;

public class SubmitValuesListenerImpl implements SubmitValuesListener {

	private ValueHolder xValueHolder;
	private ValueHolder yValueHolder;
	private ValueModelControllerInterface model;
	private ErrorDialogShower errorDialogShower;

	public SubmitValuesListenerImpl(ValueHolder textFieldX, ValueHolder textFieldY, ErrorDialogShower errorDialogShower) {
		this.xValueHolder = textFieldX;
		this.yValueHolder = textFieldY;

		this.model = ValueModelInterfaceFactory.getControllerIf();
		this.errorDialogShower = errorDialogShower;
	}

	@Override
	public void submitValues(SubmitValuesEvent evt) {
		try {
			if (StringUtils.isNotBlank(xValueHolder.getValue())) {
				this.model.setX(Long.valueOf(xValueHolder.getValue()));
			} else if (StringUtils.isNotBlank(yValueHolder.getValue())) {
				this.model.setY(Long.valueOf(yValueHolder.getValue()));
			} else {
				errorDialogShower.showErrorDialogue("Bitte machen Sie eine Eingabe");
			}
		} catch (YNotEvenException e) {
			errorDialogShower.showErrorDialogue(e.getClass().getName() + ": " + e.getMessage());
		} catch (NumberFormatException e) {
			errorDialogShower.showErrorDialogue(e.getClass().getName() + ": " + e.getMessage());
		} catch (Exception e) {
			errorDialogShower.showErrorDialogue("Fehler: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
