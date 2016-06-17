package mvc.model.core;

import mvc.model.interfaces.ValueChangedEvent;

public class ValueChangedEventImpl implements ValueChangedEvent {
	
	private long x; 
	private long y;
	
	public ValueChangedEventImpl(long x, long y) {
		this.x = x;
		this.y = y;
	}

	public long getX() {
		return x;
	}
	
	public long getY() {
		return y;
	}
}
