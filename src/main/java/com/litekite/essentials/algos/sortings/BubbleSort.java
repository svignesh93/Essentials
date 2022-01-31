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
package com.litekite.essentials.algos.sortings;

import java.util.Arrays;

/**
 * Bubble sort algorithm which has O(n^2) time complexity in the worst case and avg case scenarios
 * and O(n) in the best case if the array has sorted elements before doing bubble sort.
 *
 * <p>Space complexity takes up O(2) for swapping temporary variable and boolean variable
 * [isSwapped]
 */
class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {6, 3, 1, 2, 4};
        bubbleSort(arr);
        System.out.println("Sorted Array in Ascending Order: " + Arrays.toString(arr));

        arr = new int[] {-2, 45, 0, 11, -9};
        bubbleSort(arr);
        System.out.println("Sorted Array in Ascending Order: " + Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        int size = arr.length;
        for (int step = 0; step < size - 1; step++) {

            boolean isSwapped = false;

            System.out.println("steps: " + step);

            for (int index = 0; index < size - step - 1; index++) {

                if (arr[index] > arr[index + 1]) {
                    int temp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = temp;

                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }
}
