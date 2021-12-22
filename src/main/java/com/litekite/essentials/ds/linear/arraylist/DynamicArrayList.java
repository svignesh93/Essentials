/*
 * Copyright 2021 LiteKite Startup. All rights reserved.
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
package com.litekite.essentials.ds.linear.arraylist;

import java.util.Arrays;
import java.util.Objects;

/**
 * A dynamic array that doubles the capacity if it reaches full capacity.
 *
 * @param <T> can be any object type that the container holds.
 * @author Vignesh S
 * @version 1.0, 28/08/2021
 * @since 1.0
 */
public class DynamicArrayList<T> {

    private int capacity = 2;
    private int length = 0;
    private Object[] elements = new Object[capacity];

    @SuppressWarnings("unchecked")
    public T get(int index) {
        Objects.checkIndex(index, size());
        return (T) elements[index];
    }

    public void set(int index, int element) {
        Objects.checkIndex(index, size());
        elements[index] = element;
    }

    public void add(int index, T element) {
        Objects.checkIndex(index, size());
        if (length == capacity) {
            growCapacity();
        }
        int copyLength = size() - index;
        System.arraycopy(elements, index, elements, index + 1, copyLength);
        elements[index] = element;
        length++;
    }

    public void add(T element) {
        if (length == capacity) {
            growCapacity();
        }
        elements[length++] = element;
    }

    private void growCapacity() {
        capacity = capacity * 2;
        elements = Arrays.copyOf(elements, capacity);
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public boolean remove(T element) {
        int index = indexOf(element);
        if (index != -1) {
            return remove(index);
        }
        return false;
    }

    public int indexOf(T element) {
        for (int index = 0; index < size(); index++) {
            if (elements[index].equals(element)) {
                return index;
            }
        }
        return -1;
    }

    public boolean remove(int index) {
        Objects.checkIndex(index, size());
        int copyLength = (size() - 1) - index;
        System.arraycopy(elements, index + 1, elements, index, copyLength);
        elements[--length] = null;
        return true;
    }

    public void clear() {
        for (int i = 0; i < size(); i++) {
            elements[i] = null;
        }
        length = 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return length;
    }

    @Override
    public String toString() {
        if (size() == 0) {
            return "[]";
        }
        StringBuilder str = new StringBuilder("[");
        for (int index = 0; index < size() - 1; index++) {
            str.append(elements[index]).append(", ");
        }
        str.append(elements[size() - 1]).append("]");
        return str.toString();
    }
}
