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
package com.litekite.essentials.problems.num;

import java.util.Arrays;

/**
 * Finds the smallest number that is not in a given A[]
 *
 * <p>[1,2,3] = 4 [-1, -3] = 1 [1, 3, 2, 5] = 4
 */
class SmallestNumber {

    private static int findSmallestNum(int[] numbers) {
        int smallestNum = 1;
        Arrays.sort(numbers);
        for (int num : numbers) {
            if (smallestNum == num) {
                ++smallestNum;
            }
        }
        return smallestNum;
    }

    public static void main(String[] args) {
        int[] numbers = new int[] {1, 2, 3};
        System.out.println(findSmallestNum(numbers)); // prints 4
    }
}
