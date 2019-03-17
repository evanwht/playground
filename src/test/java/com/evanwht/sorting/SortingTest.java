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
}