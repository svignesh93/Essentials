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
 * Merge sort algorithm which has O(n log n) time complexity in all scenarios that uses divide and
 * conquer algorithm.
 *
 * <p>Space complexity takes up O(n)
 */
class MergeSort {

    public static void main(String[] args) {
        int[] arr = {6, 3, 1, 2, 4, 5};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array in Ascending Order: " + Arrays.toString(arr));

        arr = new int[] {-2, 45, 0, 11, -9};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array in Ascending Order: " + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            // Left subset of array
            mergeSort(arr, start, mid);
            // Right subset of array
            mergeSort(arr, mid + 1, end);
            // Merge left and right sub arrays
            merge(arr, start, mid, end);
        }
    }

    @SuppressWarnings("ManualArrayCopy")
    private static void merge(int[] arr, int start, int mid, int end) {
        int leftArrSize = mid - start + 1;
        int rightArrSize = end - mid;

        // Left and right sub-arrays.
        int[] leftArr = new int[leftArrSize];
        int[] rightArr = new int[rightArrSize];

        // Manually copying elements from base array to left sub-array
        for (int index = 0; index < leftArrSize; index++) {
            leftArr[index] = arr[start + index];
        }

        // Manually copying elements from base array to right sub-array
        for (int index = 0; index < rightArrSize; index++) {
            rightArr[index] = arr[mid + 1 + index];
        }

        // Pointers for left/right/base arrays
        int leftArrIndex = 0;
        int rightArrIndex = 0;
        int arrIndex = start;

        // Loop through left and right sub-arrays until it reaches any of the left or right array
        // size limits.
        while (leftArrIndex < leftArrSize && rightArrIndex < rightArrSize) {

            // if left array has smaller element, replace the element of base array
            // then increment the pointer of left array
            if (leftArr[leftArrIndex] < rightArr[rightArrIndex]) {
                arr[arrIndex] = leftArr[leftArrIndex];
                leftArrIndex++;
            } else {
                // if right array has smaller element, replace the element of base array
                // then increment the pointer of right array
                arr[arrIndex] = rightArr[rightArrIndex];
                rightArrIndex++;
            }
            // Incrementing the base array pointer
            arrIndex++;
        }

        // If any leftover element in the left array copy them to base array
        while (leftArrIndex < leftArrSize) {
            arr[arrIndex] = leftArr[leftArrIndex];
            leftArrIndex++;
            arrIndex++;
        }

        // If any leftover element in the right array copy them to base array
        while (rightArrIndex < rightArrSize) {
            arr[arrIndex] = rightArr[rightArrIndex];
            rightArrIndex++;
            arrIndex++;
        }
    }
}
