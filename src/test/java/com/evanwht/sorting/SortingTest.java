package com.evanwht.sorting;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortingTest {

	@Test
	public void selectionSort() {
		final int[] array = new int[] {4, 1, 8, 3, 2};
		Sorting.selectionSort(array);
		assertArrayEquals(new int[] {1, 2, 3, 4, 8}, array);
	}

	@Test
	public void bubbleSort() {
		final int[] array = new int[] {4, 1, 8, 3, 2};
		Sorting.bubbleSort(array);
		assertArrayEquals(new int[] {1, 2, 3, 4, 8}, array);
	}

	@Test
	public void insertionSort() {
		final int[] array = new int[] {4, 1, 8, 3, 2};
		Sorting.insertionSort(array);
		assertArrayEquals(new int[] {1, 2, 3, 4, 8}, array);
	}

	@Test
	public void merge() {
		final int[] left = new int[] {4, 7, 9};
		final int[] right = new int[] {1, 5, 8};
		int[] merged = Sorting.merge(left, right);
		assertArrayEquals(new int[] {1, 4, 5, 7, 8, 9}, merged);

		merged = Sorting.merge(left, new int[] {});
		assertArrayEquals(left, merged);

		merged = Sorting.merge(new int[] {}, right);
		assertArrayEquals(right, merged);

		merged = Sorting.merge(left, new int[] {14});
		assertArrayEquals(new int[] {4, 7, 9, 14}, merged);
	}

	@Test
	public void mergeSort() {
		int[] sorted = Sorting.mergeSort(new int[] {4, 1, 8, 3, 2});
		assertArrayEquals(new int[] {1, 2, 3, 4, 8}, sorted);

		sorted = Sorting.mergeSort(new int[] {4});
		assertArrayEquals(new int[] {4}, sorted);
	}

	@Test
	public void quickSortEnd() {
		final int[] end = new int[] {4, 1, 8, 3, 2};
		Sorting.quickSort(end, Sorting.PivotStrategy.END);
		assertArrayEquals(new int[] {1, 2, 3, 4, 8}, end);
	}

	@Test
	public void quickSortStart() {
		final int[] start = new int[] {4, 1, 8, 3, 2};
		Sorting.quickSort(start, Sorting.PivotStrategy.START);
		assertArrayEquals(new int[] {1, 2, 3, 4, 8}, start);
	}

	@Test
	public void quickSortMid() {
		final int[] mid = new int[] {4, 1, 8, 3, 2};
		Sorting.quickSort(mid, Sorting.PivotStrategy.MID);
		assertArrayEquals(new int[] {1, 2, 3, 4, 8}, mid);
	}

	@Test
	public void quickSortRand() {
		final int[] rand = new int[] {4, 1, 8, 3, 2};
		Sorting.quickSort(rand, Sorting.PivotStrategy.RANDOM);
		assertArrayEquals(new int[] {1, 2, 3, 4, 8}, rand);
	}

	@Test
	public void minHeapSort() {
		final int[] array = new int[] {4, 7, 8, 3, 2, 14, 9, 1, 12};
		Sorting.minHeapSort(array);
		assertArrayEquals(new int[] {1, 2, 3, 4, 7, 8, 9, 12, 14}, array);
	}
}