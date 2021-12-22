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
package com.litekite.essentials.problems.str;

import java.util.HashMap;

/** Counts all the character occurrence in a string and prints its count. */
class CharCounter {

    private static void countChars(String str) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (int index = 0; index < str.length(); index++) {
            Integer count = charCountMap.getOrDefault(str.charAt(index), 0);
            charCountMap.put(str.charAt(index), ++count);
        }
        System.out.println("CharCount: " + charCountMap);
    }

    public static void main(String[] args) {
        String str = "eminem";
        countChars(str); // prints > CharCount: {a=4, b=3, c=2}
    }
}
