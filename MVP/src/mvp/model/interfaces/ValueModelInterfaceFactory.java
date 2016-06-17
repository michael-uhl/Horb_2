package mvp.model.interfaces;

import mvp.model.core.ValuesCore;

public class ValueModelInterfaceFactory {
	
	private static volatile ValuesCore core = new ValuesCore();
	
	public static ValueModelViewInterface getViewIf() {
		return core;
	}
	
	public static ValueModelControllerInterface getControllerIf() {
		return core;
	}
	
	public static ValueChangedProvider getValueChangedProvider() {
		return core;
	}

}
