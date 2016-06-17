package a04_forkJoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class NumberFinderRecursiveTask extends RecursiveTask<Boolean> {
	
	private static final long serialVersionUID = 1L;

	private int[] array;
	private int element;
	
	public NumberFinderRecursiveTask(int[] array, int element) {
		this.array = array;
		this.element = element;
	}

	@Override
	protected Boolean compute() {
		if (array.length >= 1) {
			if (array[0] == element) {
				return true;
			} else {
				if (array.length >= 2) {
					if ((array.length % 2) == 1) {
						array = Arrays.copyOfRange(array, 1, array.length);
					}
					int[] lowerHalf = Arrays.copyOfRange(array, 0,(array.length / 2));
					int[] upperHalf = Arrays.copyOfRange(array, array.length / 2, array.length);
					NumberFinderRecursiveTask taskA = new NumberFinderRecursiveTask(lowerHalf, element);
					taskA.fork();
					NumberFinderRecursiveTask taskB = new NumberFinderRecursiveTask(upperHalf, element);
					return  taskB.compute() || taskA.join();
				}
			}
		}
		return false;
	}
	
	public static void main(String ... args) {
		int[] param = {1,2,3,4,5,6,7};
		NumberFinderRecursiveTask action = new NumberFinderRecursiveTask(param, 7);
		ForkJoinPool fjp = new ForkJoinPool();
		System.out.println(fjp.invoke(action));
	}
}
