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
package ds.linear.linkedlist;

/**
 * Singly Linked List.
 *
 * @param <T> Any Object.
 */
public class SinglyLinkedList<T> {

    private Node<T> head;
    private Node<T> first;
    private int size;

    public void add(T data) {
        if (head == null) {
            head = new Node<>(data, null);
            first = head;
        } else {
            head.nextNode = new Node<>(data, null);
            head = head.nextNode;
        }
        size++;
    }

    public void remove(T data) {
        for (Node<T> current = first, prev = first;
                current != null;
                prev = current, current = current.nextNode) {
            if (current.data == data) {
                prev.nextNode = current.nextNode;
                break;
            }
        }
    }

    public T get(int index) {
        T data = null;
        int currentIndex = 0;
        for (Node<T> current = first; current != null; current = current.nextNode) {
            if (currentIndex == index) {
                data = current.data;
                break;
            }
            currentIndex++;
        }
        return data;
    }

    public int size() {
        return size;
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> current = first;
        Node<T> next;
        while (current != null) {
            next = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = next;
        }
        head = first;
        first = prev;
    }

    static class Node<T> {

        T data;
        Node<T> nextNode;

        Node(T data, Node<T> nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }
    }
}
