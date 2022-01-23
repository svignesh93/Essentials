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

class RabinKarpAl {

    private static final int prime = 101;

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

    private static int detectSubStr(String str, String pattern) {
        int strLength = str.length();
        int patternLength = pattern.length();
        int patternHash = calculateHash(pattern, pattern.length());
        int subStrHash = calculateHash(str, patternLength);

        for (int index = 0; index < strLength - patternLength; index++) {
            if (patternHash != subStrHash) {
                subStrHash = recalculateHash(str, index, subStrHash, patternLength);
                continue;
            }

            if (matchPattern(str, pattern, index)) {
                return index;
            }
        }

        return -1;
    }

    private static boolean matchPattern(String s, String p, int strIndex) {
        for (int patternIndex = 0;
                patternIndex < p.length() && strIndex < s.length();
                strIndex++, patternIndex++) {
            if (s.charAt(strIndex) != p.charAt(patternIndex)) {
                return false;
            }
            if (patternIndex == p.length() - 1) {
                return true;
            }
        }
        return false;
    }

    private static int recalculateHash(String s, int index, int oldSubStrHash, int patternLength) {
        int hash = (oldSubStrHash - s.charAt(index) / prime);
        hash += s.charAt(index + patternLength) * Math.pow(prime, index);
        return hash;
    }

    private static int calculateHash(String s, int len) {
        int hash = 1;
        for (int index = 0; index < len; index++) {
            hash += s.charAt(index) * Math.pow(prime, index);
        }
        return hash;
    }
}
