package mvc.model.interfaces;

public interface ValueModelControllerInterface {
	
	void setX(long x);
	
	void setY(long y) throws YNotEvenException;

}
