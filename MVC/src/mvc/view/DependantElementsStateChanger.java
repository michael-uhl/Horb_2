package mvc.view;

import javax.swing.JComponent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DependantElementsStateChanger implements DocumentListener {
	
	private JComponent[] dependantSources;
	
	public DependantElementsStateChanger(JComponent ... dependentSources) {
		this.dependantSources = dependentSources;
	}	

	@Override
	public void insertUpdate(DocumentEvent e) {
		disableDependantSources();
	}

	@Override
	public void removeUpdate(DocumentEvent event) {
		if (isTextfieldEmpty(event)) {
			enableDependantSources();
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		disableDependantSources();
	}
	
	private void disableDependantSources() {
		for (JComponent dependantSource : dependantSources) {
			dependantSource.setEnabled(false);
		}
	}
	
	private void enableDependantSources() {
		for (JComponent dependantSource : dependantSources) {
			dependantSource.setEnabled(true);
		}
	}	
	
	private boolean isTextfieldEmpty(DocumentEvent event) {
		return event.getDocument().getLength() == 0;
	}	
}
