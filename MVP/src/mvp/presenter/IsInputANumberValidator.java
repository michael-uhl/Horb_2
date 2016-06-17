package mvp.presenter;

import org.apache.commons.lang3.StringUtils;

public abstract class IsInputANumberValidator extends Validatable {


	@Override
	public boolean isValueOk() {
		return StringUtils.isNumeric(getValue());
	}

	@Override
	public String getValidationMessage() {
		return "Bitte geben Sie eine Zahl ein";
	}
}
