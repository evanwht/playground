package com.evanwht.structures.tree;

/**
 * @author evanwht1@gmail.com
 */
class Node {

	private final int[] array;

	private int index;
	private int startingIndex;
	private Node left;
	private Node right;
	private Node parent;

	/**
	 * Recursively builds a Heap from the given backing array starting at the provided index.
	 *
	 * @param array         array of values to populate nodes of the heap
	 * @param startingIndex where the root of the tree should be located. Anything to the left of this index
	 *                      will not be used in the heap
	 */
	Node(final int[] array, int startingIndex) {
		this(array, startingIndex, 0, null);
	}

	private Node(final int[] array, int startingIndex, final int index, final Node parent) {
		this.index = index;
		this.startingIndex = startingIndex;
		this.array = array;
		this.parent = parent;
		if (array.length > ((2 * index) + 1 + startingIndex)) {
			// have space for left child
			this.left = new Node(array, startingIndex, ((2 * index) + 1), this);
		}
		if (array.length > ((2 * index) + 2 + startingIndex)) {
			// have space for right child
			this.right = new Node(array, startingIndex, ((2 * index) + 2), this);
		}
	}

	/**
	 * Algorithm:
	 * 1. Recurse to leaf, then sort on the way back up.
	 * 2. swap children so smallest is left
	 * 2. Swap with left is left is smaller
	 * 3. maxSort on this node again
	 */
	void minSort() {
		if (right != null) {
			// recurse as this is possibly an internal node
			left.minSort();
			right.minSort();
			compareAndSwap();
		} else if (left != null) {
			if (left.value() < value()) {
				swap(left);
			}
		}
	}

	private void compareAndSwap() {
		if (right.value() < left.value() && right.value() < value()) {
			// right < left < this
			swap(right);
			minSort();
		} else if (left.value() < value()) {
			// left < right < this
			swap(left);
			minSort();
		}
	}

	private int arrayIndex() {
		return index + startingIndex;
	}

	private int value() {
		return array[arrayIndex()];
	}

	private void swap(Node node) {
		swapBackingArray(node);
		swapIndex(node);
		swapChildren(node);
		swapParent(node);
	}

	private void swapIndex(final Node node) {
		final int oIndex = node.index;
		node.index = index;
		index = oIndex;
	}

	private void swapParent(final Node node) {
		if (parent != null) {
			if (parent.left == this) {
				parent.left = node;
				node.parent = parent;
				parent = node;
			} else {
				parent.right = node;
				node.parent = parent;
				parent = node;
			}
		}
	}

	private void swapChildren(final Node node) {
		Node oLeft = node.left;
		Node oRight = node.right;
		if (node == left) {
			node.left = this;
			node.right = right;
		} else if (node == right) {
			node.left = left;
			node.right = this;
		} else {
			node.left = left;
			node.right = right;
		}
		left = oLeft;
		right = oRight;
	}

	private void swapBackingArray(final Node node) {
		final int value = array[arrayIndex()];
		array[arrayIndex()] = array[node.arrayIndex()];
		array[node.arrayIndex()] = value;
	}
}
