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
package com.litekite.essentials.problems.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Jorge has written N papers in his lifetime. The i-th paper has Ci citations. Each paper was
 * written sequentially in the order provided, and the number of citations that each paper has will
 * never change. Please help Jorge determine his H-index score after each paper he wrote.
 *
 * <p>Sample input:
 *
 * <p>2
 *
 * <p>3
 *
 * <p>5 1 2
 *
 * <p>6
 *
 * <p>1 3 3 2 2 15
 *
 * <p>Sample Output:
 *
 * <p>Case #1: 1 1 2
 *
 * <p>Case #2: 1 1 2 2 2 3
 */
public class HIndex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        for (int testIndex = 1; testIndex <= testCases; testIndex++) {
            int papers = sc.nextInt();

            int[] citations = new int[papers];

            for (int paperIndex = 0; paperIndex < papers; paperIndex++) {
                citations[paperIndex] = sc.nextInt();
            }

            int hIndex = 0;

            PriorityQueue<Integer> queue = new PriorityQueue<>();

            for (int citation : citations) {
                if (citation > hIndex) {
                    queue.offer(citation);
                }

                while (queue.peek() != null && queue.peek() <= hIndex) {
                    queue.poll();
                }

                if (queue.size() >= hIndex + 1) {
                    hIndex++;
                }

                System.out.print(hIndex + " ");
            }

            System.out.println();
        }
    }
}
