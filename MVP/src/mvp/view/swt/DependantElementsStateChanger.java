package mvp.view.swt;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

public class DependantElementsStateChanger implements ModifyListener {

	private Text[] dependantSources;

	public DependantElementsStateChanger(Text... dependantSources) {
		this.dependantSources = dependantSources;
	}

	@Override
	public void modifyText(ModifyEvent event) {
		if (StringUtils.isEmpty(((Text) event.getSource()).getText())) {
			enableDependantSources();
		} else {
			disableDependantSources();
		}

	}

	private void disableDependantSources() {
		for (Text dependantSource : dependantSources) {
			dependantSource.setEnabled(false);
		}
	}

	private void enableDependantSources() {
		for (Text dependantSource : dependantSources) {
			dependantSource.setEnabled(true);
		}
	}

	private void recursiveSetEnabled(Control ctrl, boolean enabled) {
		if (ctrl instanceof Composite) {
			Composite comp = (Composite) ctrl;
			for (Control c : comp.getChildren())
				recursiveSetEnabled(c, enabled);
		} else {
			ctrl.setEnabled(enabled);
		}
	}

}
