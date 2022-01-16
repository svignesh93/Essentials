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
import java.util.HashMap;

/**
 * In a given array of numbers, one element will show up once and the others will each show up
 * twice.
 *
 * <p>Finds the number that only appears once in O(nlogn) linear time and O(1) space as well.
 */
class LonelyElement {

    public static void main(String[] args) {
        int[] inputArr = new int[] {1, 4, 7, 9, 4, 7, 1};
        // Prints 9 found only onetime.
        System.out.println("LonelyElement: " + lonelyElement(inputArr));
    }

    private static int lonelyElement(int[] inputArr) {
        HashMap<Integer, Integer> numCountMap = new HashMap<>();

        Arrays.sort(inputArr);

        int lonelyElement = 0;
        for (int key : inputArr) {
            Integer count = numCountMap.getOrDefault(key, 0);
            numCountMap.put(key, ++count);

            if (count == 1) {
                lonelyElement = key;
            } else if (count > 1) {
                numCountMap.remove(key);
            }
        }
        return lonelyElement;
    }
}
