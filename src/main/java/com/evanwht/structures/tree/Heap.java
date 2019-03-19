package com.evanwht.structures.tree;

/**
 * Complete binary tree that each parent is either greater or lesser than its children
 * depending on what type of sorting you choose.
 * TODO do max sorting
 *
 * -----------------------------------------
 * | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
 * -----------------------------------------
 *
 * 				 0
 * 			  /	   \
 * 			1       2
 * 		  /   \    /  \
 *       3    4   5   6
 *     /  \  /
 *    7   8 9
 *
 * Left child 	= 2n + 1
 * Right child 	= 2n + 2
 *
 * @author evanwht1@gmail.com
 */
public class Heap {

	private final Node root;

	public Heap(final int[] arr, int startingIndex) {
		root = new Node(arr, startingIndex);
	}

	public Node getRoot() {
		return root;
	}

	public void minSort() {
		root.minSort();
	}
}
