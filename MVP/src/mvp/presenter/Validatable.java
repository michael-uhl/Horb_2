package mvp.presenter;

public abstract class Validatable {
	
	public abstract void setError(String msg);
	public abstract void setNoError();
	public abstract String getValue();
	public abstract boolean isValueOk();
	public abstract String getValidationMessage();
	
	public void validate() {
		if (!isValueOk()) {
			setError(getValidationMessage());
		} else {
			setNoError();
		}
	}

}
