package mvp.view.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.JTextComponent;

import mvp.model.interfaces.Resettable;
import mvp.presenter.ResetStateEvent;
import mvp.presenter.ResetStateListener;
import mvp.presenter.ResetStateListenerImpl;

public class ResetButtonClickedListener implements ActionListener {
	
	private Resettable resettables[];

	public ResetButtonClickedListener(JTextComponent ... resettablesComponents) {
		List<Resettable> resettables = new ArrayList<Resettable>();
		for (JTextComponent resetabbleComponent : resettablesComponents) {
			resettables.add(new ResettableImpl(resetabbleComponent));
		}
		
		this.resettables = resettables.toArray(new Resettable[0]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ResetStateListener stateResetter = new ResetStateListenerImpl(resettables);
		stateResetter.viewResetDesired(new ResetStateEvent());
	}

}
