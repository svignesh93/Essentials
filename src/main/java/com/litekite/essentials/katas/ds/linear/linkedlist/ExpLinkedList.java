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
package com.litekite.essentials.katas.ds.linear.linkedlist;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ExpLinkedList {

    private static <T> void reverseList(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            T lastVal = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.add(i, lastVal);
        }
    }

    private static <T> void printList(List<T> list) {
        for (T t : list) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.addLast(3);
        list.addFirst(1);

        System.out.println("LinkedList: ");
        printList(list);

        System.out.println("Reversed LinkedList using Collections: ");
        Collections.reverse(list);
        printList(list);

        Collections.reverse(list);

        System.out.println("Reversed LinkedList: ");
        reverseList(list);
        printList(list);
    }
}
