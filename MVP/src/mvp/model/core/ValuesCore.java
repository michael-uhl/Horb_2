package mvp.model.core;

import java.util.ArrayList;
import java.util.List;

import mvp.model.interfaces.ValueChangedListener;
import mvp.model.interfaces.ValueChangedProvider;
import mvp.model.interfaces.ValueModelControllerInterface;
import mvp.model.interfaces.ValueModelViewInterface;
import mvp.model.interfaces.YNotEvenException;

/**
 * 
 * Holds 2 long values (x and y).
 * (y == 2x) = true
 * 
 * @author Michael Uhl
 *
 */
public class ValuesCore implements ValueChangedProvider, ValueModelViewInterface, ValueModelControllerInterface {
	
	private List<ValueChangedListener> valueChangedListeners = new ArrayList<ValueChangedListener>();

	private long x;
	private long y;
	
	public long getX() {
		return x;
	}
	public void setX(long x) {
		this.y = 2 * x;
		this.x = x;
		
		//throw new RuntimeException("Datenbankfehler");
		notifyValueChanged();
	}
	public long getY() {
		return y;
	}
	public void setY(long y) throws YNotEvenException {
		if (y % 2 != 0) {
			throw new YNotEvenException();
		}
		
		this.y = y;
		this.x = y / 2;
		
		notifyValueChanged();
	}
	
	@Override
	public void addValueChangedListener(ValueChangedListener listener) {
		valueChangedListeners.add(listener);
	}
	
	private void notifyValueChanged() {
		for (ValueChangedListener listener : valueChangedListeners) {
			listener.valueChanged(new ValueChangedEventImpl(x, y));
		}
	}
	
	
}
