package a01_lesbarkeit;

public class ArraySum {
	
	public long sumElements(long[] input) {
		long sum = 0;
		for (long element : input) {
			sum += element;
		}
		long[] newArr = new long[input.length];
		return sum;
	}

}
