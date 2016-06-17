package a01_lesbarkeit;

/**
 * Hier steht der Text.
 * 
 * @author Michael Uhl
 */
public class AnweidungenBuendig {
	
	double potential;
	double depth;
	double curious;
	double flameValue;
	int intValue;
	int x,y,z;
	
	public void main() {
		double value;
		
		value = (potential    + curious) /
				(flameValue   + depth);
		
		double minPosition;
		double maxPosition;
		
		minPosition = computeDistance(flameValue, x, y, z);
		maxPosition = computeDistance(potential,  x, y, z);
		
		double doubleValue = (double) intValue;
		double doubleValue2 = intValue;
	}
	
	public double computeDistance(double a, double b, double c, double d) {
		return 0.0;
	}
	
	

}
