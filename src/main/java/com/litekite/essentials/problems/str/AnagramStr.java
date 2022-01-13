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
package com.litekite.essentials.problems.str;

import java.util.Arrays;

/**
 * Check whether the given two strings are Anagrams.
 *
 * <p>Anagrams are re-arranged letters that provides different meanings, but contains the same
 * letters. Due to sorting op, it takes O(nlogn) logarithmic time and O(n) space complexity.
 */
class AnagramStr {

    public static void main(String[] args) {
        String strOne = "cinema";
        String strTwo = "iceman";
        // Prints true
        System.out.println("isAnagram: " + isAnagram(strOne, strTwo));
    }

    private static boolean isAnagram(String strOne, String strTwo) {
        String[] strArrOne = strOne.toLowerCase().split("");
        String[] strArrTwo = strTwo.toLowerCase().split("");

        Arrays.sort(strArrOne);
        Arrays.sort(strArrTwo);

        return Arrays.equals(strArrOne, strArrTwo);
    }
}
