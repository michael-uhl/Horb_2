package mvc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.JTextComponent;

public class ResetInputListener implements ActionListener {
	
	private JTextComponent[] dependantComponents;
	
	public ResetInputListener(JTextComponent ... dependantComponents) {
		this.dependantComponents = dependantComponents;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (JTextComponent dependantComponent : dependantComponents) {
			dependantComponent.setText("");
			dependantComponent.setEnabled(true);
		}
	}
}
