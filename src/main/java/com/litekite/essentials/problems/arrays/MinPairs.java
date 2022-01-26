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

/**
 * Finds the minimum value by forming a pair in a sorted array.
 *
 * <p>If [3, 4, 2, 5] is the given array, after sorting it would become [2, 3, 4, 5]. Forming pairs
 * results in [2, 3], [4, 5]. The minimum value from these pairs are 2 and 4 and the result is 2 + 4
 * = 6 with O(nlogn) time complexity which uses sorting algorithm.
 */
class MinPairs {

    public static void main(String[] args) {
        System.out.println(maxOfMinPairs(new int[] {3, 4, 2, 5}));
    }

    public static int maxOfMinPairs(int[] nums) {
        Arrays.sort(nums);

        int total = 0;
        for (int index = 0; index < nums.length; index += 2) {
            total += nums[index];
        }
        return total;
    }
}
