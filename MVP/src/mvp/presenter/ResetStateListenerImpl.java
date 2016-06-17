package mvp.presenter;

import mvp.model.interfaces.Resettable;

public class ResetStateListenerImpl implements ResetStateListener {
	
	private Resettable[] resettables;
	
	public ResetStateListenerImpl(Resettable ... dependantComponents) {
		this.resettables = dependantComponents;
	}

	@Override
	public void viewResetDesired(ResetStateEvent e) {
		for (Resettable dependantComponent : resettables) {
			dependantComponent.reset();
		}
	}
}
