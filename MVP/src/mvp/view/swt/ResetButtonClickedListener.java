package mvp.view.swt;

import java.util.ArrayList;
import java.util.List;

import mvp.model.interfaces.Resettable;
import mvp.presenter.ResetStateEvent;
import mvp.presenter.ResetStateListener;
import mvp.presenter.ResetStateListenerImpl;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

public class ResetButtonClickedListener extends SelectionAdapter {
	
	private Resettable resettables[];

	public ResetButtonClickedListener(Text ... resettablesComponents) {
		List<Resettable> resettables = new ArrayList<Resettable>();
		for (Text resetabbleComponent : resettablesComponents) {
			resettables.add(new ResettableImpl(resetabbleComponent));
		}
		
		this.resettables = resettables.toArray(new Resettable[0]);
	}	

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		ResetStateListener stateResetter = new ResetStateListenerImpl(resettables);
		stateResetter.viewResetDesired(new ResetStateEvent());
	}

}
