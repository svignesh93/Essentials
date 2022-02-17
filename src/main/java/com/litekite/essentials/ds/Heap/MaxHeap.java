package com.litekite.essentials.ds.Heap;

import java.util.ArrayList;
import java.util.List;

class MaxHeap {

	private final List<Integer> list = new ArrayList<>();

	public void insert(int element) {
		if (list.isEmpty()) {
			list.add(element);
		} else {
			list.add(element);

			int currentElementIndex = list.size() - 1;
			int rootElementIndex = (currentElementIndex - 1) / 2;

			while (rootElementIndex >= 0) {
				heapify(rootElementIndex);
				rootElementIndex = (rootElementIndex - 1) / 2;
			}
		}
	}

	public void delete(int element) {
		int index = 0;

		for (; index < size(); index++) {
			if (element == list.get(index)) {
				break;
			}
		}

		int temp = list.get(index);
		list.set(index, list.size() - 1);
		list.set(size() - 1, temp);

		list.remove(size() - 1);

		int currentElementIndex = index;
		int rootElementIndex = (currentElementIndex - 1) / 2;

		while (rootElementIndex >= 0) {
			heapify(rootElementIndex);
			rootElementIndex = (rootElementIndex - 1) / 2;
		}
	}

	private void heapify(int index) {
		int leftNodeIndex = 2 * index + 1;
		int rightNodeIndex = 2 * index + 2;
		int maxIndex = index;

		if (leftNodeIndex < size() && list.get(leftNodeIndex) > list.get(index)) {
			maxIndex = leftNodeIndex;
		}

		if (rightNodeIndex < size() && list.get(rightNodeIndex) > list.get(index)) {
			maxIndex = rightNodeIndex;
		}

		if (maxIndex != index) {
			int temp = list.get(index);
			list.set(index, list.get(maxIndex));
			list.set(maxIndex, temp);

			heapify(maxIndex);
		}
	}

	public int size() {
		return list.size();
	}

	@Override
	public String toString() {
		if (size() == 0) {
			return "[]";
		}
		StringBuilder str = new StringBuilder("[");
		for (int index = 0; index < size() - 1; index++) {
			str.append(list.get(index)).append(", ");
		}
		str.append(list.get(size() - 1)).append("]");
		return str.toString();
	}
}
