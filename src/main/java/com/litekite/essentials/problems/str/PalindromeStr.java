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

/**
 * Checks whether the given string is a Palindrome or not.
 *
 * <p>Palindrome is a word that reads the same backward as forward. eg, tenet in forward means tenet
 * in backwards.
 *
 * <p>Takes O(n) time complexity for iterating first with last pointer, and O(1) space complexity.
 */
class PalindromeStr {

    private static boolean isPalindrome(String str) {
        for (int first = 0, last = str.length() - 1; first < last; ) {
            if (str.charAt(first) == str.charAt(last)) {
                first++;
                last--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "tenet";
        // prints > true
        System.out.println("isPalindrome: " + isPalindrome(str));
    }
}
