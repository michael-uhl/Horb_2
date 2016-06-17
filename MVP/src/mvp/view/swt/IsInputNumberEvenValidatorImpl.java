package mvp.view.swt;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;

import mvp.presenter.IsInputNumberEvenValidator;

public class IsInputNumberEvenValidatorImpl extends IsInputNumberEvenValidator implements ModifyListener {
	
	private Text source;
	
	public IsInputNumberEvenValidatorImpl(Text source) {
		super();
		this.source = source;
	}

	@Override
	public void setError(String msg) {
		if (StringUtils.isNotEmpty(source.getText())) {
			Color red = Display.getDefault().getSystemColor(SWT.COLOR_RED);
			source.setForeground(red);
			
			MessageBox messageBox = new MessageBox(Display.getCurrent()
					.getActiveShell(), SWT.ICON_WARNING | SWT.OK);
	
			messageBox.setText("Warning");
			messageBox.setMessage(getValidationMessage());
			messageBox.open();
		}
	}

	@Override
	public void setNoError() {
		Color black = Display.getDefault().getSystemColor(SWT.COLOR_BLACK);
		source.setForeground(black);
	}

	@Override
	public String getValue() {
		source.update();
		return source.getText();
	}

	@Override
	public void modifyText(ModifyEvent event) {
		validate();
	}

}
