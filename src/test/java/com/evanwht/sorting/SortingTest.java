package com.evanwht.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

	@Test
	void selectionSort() {
		final int[] array = new int[] {4, 1, 8, 3, 2};
		Sorting.selectionSort(array);
		assertArrayEquals(new int[] {1, 2, 3, 4, 8}, array);
	}
}