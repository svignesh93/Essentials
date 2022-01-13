/*
 * Copyright 2021-2022 LiteKite Startup. All rights reserved.
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
 * Reverses a string with O(n) time complexity and O(1) space complexity.
 *
 * <p>StringBuilder is not thread safe while StringBuffer is thread safe. String s = "a" creates an
 * immutable string in string pool. String s = new String("a") creates string in a java heap.
 * Strings are immutable while StringBuilder and StringBuffer are mutable.
 */
class ReverseStr {

    private static String reverse(String str) {
        StringBuilder builder = new StringBuilder();
        for (int index = str.length() - 1; index >= 0; index--) {
            builder.append(str.charAt(index));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String str = "eminem";
        System.out.println("reversed str: " + reverse(str)); // prints > menime
    }
}
