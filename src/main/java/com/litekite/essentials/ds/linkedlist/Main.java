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
package com.litekite.essentials.ds.linkedlist;

/**
 * Experimenting with {@link SinglyLinkedList}
 *
 * @author Vignesh S
 * @version 1.0, 28/08/2021
 * @since 1.0
 */
class Main {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        for (int index = 0; index < list.size(); index++) {
            System.out.println(list.get(index));
        }

        System.out.println();

        list.remove(7);

        for (int index = 0; index < list.size(); index++) {
            System.out.println(list.get(index));
        }

        list.reverse();

        for (int index = 0; index < list.size(); index++) {
            System.out.println(list.get(index));
        }
    }
}
