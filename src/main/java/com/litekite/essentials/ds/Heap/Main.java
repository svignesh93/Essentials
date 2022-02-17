/*
 * Copyright 2021-2022 LiteKite Startup. All rights reserved.
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

/**
 * Experimenting with {@link MaxHeap}
 *
 * @author Vignesh S
 * @version 1.0, 01/02/2022
 * @since 1.0
 */
class Main {

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(9);
        maxHeap.insert(5);
        maxHeap.insert(2);

        System.out.println("Max-Heap array: " + maxHeap);

        maxHeap.delete(4);
        System.out.println("After deleting an element: " + maxHeap);
    }
}
