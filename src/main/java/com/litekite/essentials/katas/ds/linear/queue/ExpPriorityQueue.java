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
package com.litekite.essentials.katas.ds.linear.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class ExpPriorityQueue {

    public static void main(String[] args) {
        // Reverse Order
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        // Adds the element at the last position. equivalent to offerLast.
        queue.offer(2);

        queue.add(3);
        queue.add(1);

        System.out.println("PriorityQueue: " + queue);

        // Natural Order
        Queue<Integer> queueTwo = new PriorityQueue<>(Comparator.naturalOrder());
        queueTwo.addAll(queue);

        System.out.println("PriorityQueue: " + queueTwo);

        // Integer::CompareTo reference.
        Queue<Integer> queueThree = new PriorityQueue<>(Integer::compareTo);
        queueThree.addAll(queue);

        System.out.println("PriorityQueue: ");
        while (queueThree.peek() != null) {
            int i = queueThree.poll();
            System.out.print(i + " ");
        }

        System.out.println();

        // Priority Blocking Queue and it's thread safe.
        PriorityBlockingQueue<Integer> blockingQueue =
                new PriorityBlockingQueue<>(11, Comparator.naturalOrder());
        blockingQueue.addAll(queue);

        System.out.println("PriorityBlockingQueue: ");
        while (blockingQueue.peek() != null) {
            int i = blockingQueue.poll();
            System.out.print(i + " ");
        }
    }
}
