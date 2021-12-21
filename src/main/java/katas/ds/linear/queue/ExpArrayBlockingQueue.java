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
package katas.ds.linear.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class ExpArrayBlockingQueue {

    public static void main(String[] args) {
        // Blocks the thread if capacity is full while inserting and retrieving it while its empty.
        // A bounded array, the capacity is fixed...
        ArrayBlockingQueue<Integer> BlockingQueue = new ArrayBlockingQueue<>(11);

        // Adds the element at the last position. equivalent to offerLast.
        BlockingQueue.offer(2);
        BlockingQueue.poll();
        BlockingQueue.offer(3);
        BlockingQueue.poll();

        BlockingQueue.offer(3);

        System.out.println("ExpArrayBlockingQueue: " + BlockingQueue);
    }
}
