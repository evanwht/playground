package com.evanwht.sorting;

import java.util.Arrays;

/**
 * Utility class of Searching algorithms.
 *
 * @author evanwht1@gmail.com
 */
public class Sorting {

	// utility class
	private Sorting() {}

	/**
	 * Performs a selection sort on the given array modifying it.
	 * </p>
	 * Algorithm: Traverses the array to find the smallest value to the right of the current index then swaps that
	 * value with the one at the current index. This is done for each index of the array.
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

	/**
	 * Performs a bubble sort on the given array modifying it.
	 * </p>
	 * Algorithm: starting at the second index, traverse the array swapping the previous value with the current one if
	 * the previous one is bigger than the current value. Repeat, starting at the same index but traversing until one
	 * less than the previous ending index. Effectively "bubbles" the next maximum value to the end of the array.
	 * </p>
	 * Not as bad as selection but still very slow algorithm
	 *
	 * @param array array to sort (will modify the given array)
	 */
	public static void bubbleSort(final int[] array) {
		if (array != null) {
			for (int i = array.length; i > 0; i--) {
				// start at index 1 so we can compare the first
				for (int j = 1; j < i; j++) {
					if (array[j-1] > array[j]) {
						int swap = array[j];
						array[j] = array[j-1];
						array[j-1] = swap;
					}
				}
			}
		}
	}
}
