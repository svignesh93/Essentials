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

/** Reverses only alphabets and preserve the position of other symbols and characters. */
class ReverseAlphabets {

    private static String reverseAlphabets(String str) {
        StringBuilder builder = new StringBuilder(str);
        for (int first = 0, last = str.length() - 1; first < last; ) {
            if (Character.isLetter(str.charAt(first)) && Character.isLetter(str.charAt(last))) {
                builder.setCharAt(first, str.charAt(last));
                builder.setCharAt(last, str.charAt(first));
                first++;
                last--;
            } else if (!Character.isLetter(str.charAt(first))) {
                first++;
            } else {
                last--;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String str = "B!FDCEA2";
        // prints > A!ECDFB2
        System.out.println("reversed alphabets only: " + reverseAlphabets(str));
    }
}
