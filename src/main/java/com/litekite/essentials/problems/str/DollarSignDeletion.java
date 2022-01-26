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
 * Deletes all chars before the dollar sign in the given two strings and compares them for equality
 * in O(n) time.
 */
class DollarSignDeletion {

    public static void main(String[] args) {
        System.out.println(isDollarDeleteEqual(new String[] {"f$st", "st"}));
        System.out.println(isDollarDeleteEqual(new String[] {"a90$n$c$se", "a90n$cse"}));
        System.out.println(isDollarDeleteEqual(new String[] {"ab$$", "c$d$"}));
        System.out.println(isDollarDeleteEqual(new String[] {"b$$p", "$b$p"}));
    }

    private static boolean isDollarDeleteEqual(String[] arr) {
        String firstStr = arr[0];
        String secondStr = arr[1];

        return performDollarDeletion(firstStr).equals(performDollarDeletion(secondStr));
    }

    private static String performDollarDeletion(String str) {
        StringBuilder builder = new StringBuilder();
        for (char s : str.toCharArray()) {
            if (s == '$') {
                builder.setLength(0);
            } else {
                builder.append(s);
            }
        }
        return builder.toString();
    }
}
