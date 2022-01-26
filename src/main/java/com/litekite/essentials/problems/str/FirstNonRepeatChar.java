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

import java.util.LinkedHashSet;

/**
 * Finds the first non-repeating character from the given string in O(n) time.
 *
 * <p>It uses LinkedHashSet which maintains insertion order.
 */
class FirstNonRepeatChar {

    public static void main(String[] args) {
        // Prints "J" which is the first non-repeating character found.
        System.out.println(firstNonRepeat("asdfsdafdasfjdfsafnnunlfdffvxcvsfansd"));
    }

    public static char firstNonRepeat(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        for (Character c : set) {
            return c;
        }
        return '\0';
    }
}
