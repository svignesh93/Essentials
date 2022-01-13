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
package com.litekite.essentials.problems.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Finds the elements that are common and unique in both arrays.
 *
 * <p>Brute force algorithms take linear time to search something. If you try to find some common 4
 * digit keys in two containers, it would take O(n * m) time in the worst case scenario.
 *
 * <p>But in this case, if we use set which eliminates traversal by O(1) lookout, and it would end
 * up O(n + m) time.
 */
class ArrayIntersection {

    public static void main(String[] args) {
        int[] arrOne = new int[] {1, 5, 2, 12, 6};
        int[] arrTwo = new int[] {13, 5, 9, 5, 8};
        Integer[] intersection = arrayIntersection(arrOne, arrTwo);
        System.out.println("intersection: " + Arrays.toString(intersection)); // prints > [5]
    }

    /**
     * Return the elements that are common and unique in both arrays.
     *
     * @param arrOne element container one
     * @param arrTwo element container two
     * @return container with common elements.
     */
    public static Integer[] arrayIntersection(int[] arrOne, int[] arrTwo) {
        // O(n * m) takes 25 times traversal that is reduced to 5 + 5 = 10 times
        Set<Integer> setOne = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        // Takes O(n) times
        for (int element : arrOne) {
            setOne.add(element);
        }
        // Traversal 0(1) lookout with O(n) times traversal takes O(m) times
        for (int element : arrTwo) {
            if (setOne.contains(element)) {
                resultSet.add(element);
            }
        }
        // Total time O(n + m)
        return resultSet.toArray(new Integer[0]);
    }
}
