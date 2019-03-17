package com.evanwht.sorting;

/**
 * Utility class of Searching algorithms.
 *
 * @author evanwht1@gmail.com
 */
public class Sorting {

	// utility class
	private Sorting() {}

	/**
	 * Performs a selection sort on the given array modifying it. Algorithm consists of traversing the array to find
	 * the smallest value to the right of the current index then swapping that value with the one at the current
	 * index. This is done for each index of the array.
	 * </p>
	 * Possibly the slowest sorting algorithm.
	 *
	 * @param array array to sort (will modify the given array)
	 */
	public static void selectionSort(final int[] array) {
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				int min = array[i];
				int minIndex = i;
				for (int j = i; j < array.length; j++) {
					if (array[j] < min) {
						min = array[j];
						minIndex = j;
					}
				}
				if (min != array[i]) {
					array[minIndex] = array[i];
					array[i] = min;
				}
			}
		}
	}
}
