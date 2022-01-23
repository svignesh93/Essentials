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
package com.litekite.essentials.problems.str.pattern;

/** Detects a substring from a given string in O(nm) time complexity. */
class SubStr {

    public static void main(String[] args) {
        // Prints Index 19
        System.out.println(detectSubStr("home is where your cat is", "cat"));
        // Prints Index 1
        System.out.println(detectSubStr("ggraph", "graph"));
        // Prints Index 6
        System.out.println(detectSubStr("thepigflewwow", "flew"));
        // Prints Index 0
        System.out.println(detectSubStr("twocanplay", "two"));
        // Prints Index -1
        System.out.println(detectSubStr("wherearemyshorts", "pork"));
    }

    private static int detectSubStr(String str, String subStr) {
        for (int strIndex = 0; strIndex < str.length(); strIndex++) {
            if (strIndex + (subStr.length() - 1) > (str.length() - 1)) {
                return -1;
            }
            for (int subStrIndex = 0; subStrIndex < subStr.length(); subStrIndex++) {
                if (str.charAt(strIndex + subStrIndex) != subStr.charAt(subStrIndex)) {
                    break;
                }
                if (subStrIndex == subStr.length() - 1) {
                    return strIndex;
                }
            }
        }
        return -1;
    }
}
