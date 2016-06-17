package mvp.presenter;

import org.apache.commons.lang3.StringUtils;

public abstract class IsInputNumberEvenValidator extends Validatable {

	@Override
	public boolean isValueOk() {
		if (!StringUtils.isNumeric(getValue())) {
			return false;
		}
		int toTest = Integer.valueOf(getValue());
		return toTest % 2 == 0;
	}

	@Override
	public String getValidationMessage() {
		return "Bitte geben Sie eine grade Zahl ein.";
	}

	
	
}
