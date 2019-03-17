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
	 * Performs a selection sort on the given array, modifying it.
	 * </p>
	 * Algorithm: Traverses the array to find the smallest value to the right of the current index then swaps that
	 * value with the one at the current index. This is done for each index of the array.
	 * </p>
	 * Notes:
	 * 	- Best:		O(n^2)
	 * 	- Avg:		O(n^2)
	 * 	- Worst:	O(n^2)
	 * </p>
	 * Possibly the slowest sorting algorithm.
	 *
	 * TODO short circuit if array is in order
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
	 * Performs a bubble sort on the given array, modifying it.
	 * </p>
	 * Algorithm: starting at the second index, traverse the array swapping the previous value with the current one if
	 * the previous one is bigger than the current value. Repeat, starting at the same index but traversing until one
	 * less than the previous ending index.
	 * </p>
	 * Notes:
	 * 	- "bubbles" up the largest value to the end of the array
	 * 	- Best:		O(n)
	 * 	- Avg:		O(n^2)
	 * 	- Worst:	O(n^2)
	 * </p>
	 * Not as bad as selection but still very slow algorithm
	 *
	 * TODO short circuit if array is in order
	 * @param array array to sort (will modify the given array)
	 */
	public static void bubbleSort(final int[] array) {
		if (array != null) {
			// only bubble up to the next ending space
			for (int i = array.length; i > 0; i--) {
				// start at index 1 so we can compare the first
				for (int j = 1; j < i; j++) {
					if (array[j-1] > array[j]) {
						final int swap = array[j];
						array[j] = array[j-1];
						array[j-1] = swap;
					}
				}
			}
		}
	}

	/**
	 * Performs an insertion sort on the given array, modifying it.
	 * </p>
	 * Algorithm: starting at the second index, walk backwards, shifting all larger values than the current value to the
	 * right, until you find a value smaller than the current value. Repeat starting at the next index.
	 * </p>
	 * Notes:
	 * 	- Basically builds a sorted array in place while traversing the array.
	 * 	- Best:		O(n)
	 * 	- Avg:		O(n^2)
	 * 	- Worst:	O(n^2)
	 * 	</p>
	 * Comparable performance to bubble
	 *
	 * @param array array to sort (will modify the given array)
	 */
	public static void insertionSort(final int[] array) {
		if (array != null) {
			for (int i = 1; i < array.length; i++) {
				for (int j = i-1; j >= 0; j--) {
					if (array[j] > array[j+1]) {
						final int swap = array[j+1];
						array[j+1] = array[j];
						array[j] = swap;
					}
				}
			}
		}
	}

	/**
	 * Performs a merge sort on the given array.
	 * </p>
	 * Algorithm: Recursively break apart current working array into 2 sub arrays until you get an array of size 1.
	 * While returning through the recursion tree, merge 2 broken up arrays into one sorted array.
	 * </p>
	 * Notes:
	 * 	- Divide and Conquer
	 * 	- Best algorithm for time complexity
	 * 	- Creates garbage when working with arrays, LinkedLists can be modified in place eliminating the need for
	 * 		creating garbage.
	 * 	- Best:		O(n log(n))
	 * 	- Avg:		O(n log(n))
	 * 	- Worst:	O(n log(n))
	 * 	</p>
	 * Best performance for LinkedLists
	 *
	 * TODO this creates lots of garbage. Clean up to reduce copying
	 * @param array array to sort
	 * @return sorted array
	 */
	public static int[] mergeSort(final int[] array) {
		return mergeSort(array, 0, array.length);
	}

	private static int[] mergeSort(final int[] array, int start, int end) {
		// if we are still working on a section of array larger than 2, break apart and recurse
		final int size = end - start;
		if (size > 1) {
			final int[] left = mergeSort(array, start, start + (size/2));
			final int[] right = mergeSort(array, start + (size/2), end);
			return merge(left, right);
		}
		// create copy of smallest length array to pass back up
		final int[] ret = new int[size];
		System.arraycopy(array, start, ret, 0, size);
		return ret;
	}

	// visible for testing
	static int[] merge(final int[] left, final int[] right) {
		final int[] merged = new int[left.length + right.length];
		int l = 0, r = 0;
		for (int i = 0; i < merged.length; i++) {
			if (l > left.length - 1) {
				merged[i] = right[r++];
			} else if (r > right.length - 1) {
				merged[i] = left[l++];
			} else if (left[l] <= right[r]) {
				merged[i] = left[l++];
			} else {
				merged[i] = right[r++];
			}
		}
		return merged;
	}
}
