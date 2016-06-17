package a04_forkJoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


public class NumberFinderRecursiveAction extends RecursiveAction {
	
	private static final long serialVersionUID = 1L;

	private int[] array;
	private int element;
	public volatile boolean result = false;
	
	public NumberFinderRecursiveAction(int[] array, int element) {
		this.array = array;
		this.element = element;
	}

	@Override
	protected void compute() {
		if (array.length >= 1) {
			if (array[0] == element) {
				result = true;
			} else {
				if (array.length >= 2) {
					if ((array.length % 2) == 1) {
						array = Arrays.copyOfRange(array, 1, array.length);
					}
					int[] lowerHalf = Arrays.copyOfRange(array, 0,(array.length / 2));
					int[] upperHalf = Arrays.copyOfRange(array, array.length / 2, array.length);
					NumberFinderRecursiveAction taskA = new NumberFinderRecursiveAction(lowerHalf, element);
					NumberFinderRecursiveAction taskB = new NumberFinderRecursiveAction(upperHalf, element);
					invokeAll(taskA, taskB);
					result =  taskA.result || taskB.result;
				}
			}
		}
	}
	
	public static void main(String ... args) {
		int[] param = {1,2,3,4,5,6,7};
		NumberFinderRecursiveAction action = 
				new NumberFinderRecursiveAction(param, 5);
		ForkJoinPool fjp = new ForkJoinPool();
		fjp.invoke(action);
		System.out.println(action.result);
	}
}
