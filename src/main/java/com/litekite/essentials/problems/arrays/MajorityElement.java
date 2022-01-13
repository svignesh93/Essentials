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

import java.util.HashMap;

/**
 * Finds the majority element in a given array.
 *
 * <p>Takes O(n) times and O(n) space for storing it in a HashMap.
 */
class MajorityElement {

    public static void main(String[] args) {
        int[] inputArr = new int[] {1, 1, 1, 4, 2, 4, 4, 3, 1, 1, 1};
        // Prints 1 found 6 times greater than other elements in the array.
        System.out.println("majorityElement: " + majorityElement(inputArr));
    }

    private static int majorityElement(int[] inputArr) {
        int majorityElementKey = 0;
        HashMap<Integer, Integer> numCountMap = new HashMap<>();
        for (int key : inputArr) {
            Integer count = numCountMap.getOrDefault(key, 0);
            numCountMap.put(key, ++count);

            int majorityCount = numCountMap.getOrDefault(majorityElementKey, 0);

            if (majorityCount < count) {
                majorityElementKey = key;
            }
        }
        return majorityElementKey;
    }
}
