/*
 * Copyright 2022 LiteKite Startup. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.litekite.essentials.ds.Heap;

import java.util.ArrayList;
import java.util.List;

class MaxHeap {

    private final List<Integer> list = new ArrayList<>();

    public void insert(int element) {
        list.add(element);

        int rootElementIndex = size() / 2 - 1;

        while (rootElementIndex >= 0) {
            heapify(rootElementIndex);
            rootElementIndex = rootElementIndex / 2 - 1;
        }
    }

    @SuppressWarnings("UnusedReturnValue")
    public int delete(int element) {
        int index = 0;

        for (; index < size(); index++) {
            if (element == list.get(index)) {
                break;
            }
        }

        if (index > size() - 1) {
            return -1;
        }

        if (index == size() - 1) {
            list.remove(size() - 1);
            return index;
        }

        int temp = list.get(index);
        list.set(index, list.get(size() - 1));
        list.set(size() - 1, temp);

        list.remove(size() - 1);

        int rootElementIndex = index;
        while (rootElementIndex >= 0) {
            heapify(rootElementIndex);
            rootElementIndex = rootElementIndex / 2 - 1;
        }

        return index;
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
