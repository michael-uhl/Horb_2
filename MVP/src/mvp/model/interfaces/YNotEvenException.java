package mvp.model.interfaces;

public class YNotEvenException  extends Exception {

	private static final long serialVersionUID = -7229699145954487279L;

	@Override
	public String getMessage() {
		return "Value of \"y\" must be even.";
	}

	@Override
	public String getLocalizedMessage() {
		return getMessage();
	}
	
	

}
