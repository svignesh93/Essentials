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
import java.util.HashSet;
import java.util.Scanner;

/**
 * Alice and Bob are playing the game called Centauri Prime. Centauri Prime represents a planet
 * which is split into several independent kingdoms. Before they start playing the game, they have
 * to choose rulers for each kingdom. Alice and Bob mutually decided to distribute kingdoms based on
 * the letter the kingdom's name ended with. Alice loves vowels and decided to rule kingdoms whose
 * names ended in a vowel. Bob loves consonants and decided to rule kingdoms whose names ended in a
 * consonant. Both of them do not like the letter 'y'(case-insensitive) and thus, all kingdoms whose
 * names ended in the letter 'y' are left without a ruler. Can you write a program that will
 * determine the rulers of several kingdoms, given the kingdoms' names?
 *
 * <p>Sample input:
 *
 * <p>3
 *
 * <p>Mollaristan
 *
 * <p>Auritania
 *
 * <p>Zizily
 *
 * <p>Sample Output:
 *
 * <p>Case #1: Mollaristan is ruled by Bob.
 *
 * <p>Case #2: Auritania is ruled by Alice.
 *
 * <p>Case #3: Zizily is ruled by nobody.
 */
public class CentauriPrime {

    private static final HashSet<Character> vowels =
            new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    private static final char unlikeableChar = 'y';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        sc.nextLine();

        for (int testIndex = 1; testIndex <= testCases; testIndex++) {
            String kingdom = sc.nextLine();
            System.out.println(
                    "Case #"
                            + testIndex
                            + ": "
                            + kingdom
                            + " is ruled by "
                            + getRuler(kingdom)
                            + ".");
        }
    }

    private static String getRuler(String kingdom) {
        char kingdomLastChar = Character.toLowerCase(kingdom.charAt(kingdom.length() - 1));

        if (kingdomLastChar == unlikeableChar) return "nobody";

        if (vowels.contains(kingdomLastChar)) return "Alice";

        return "Bob";
    }
}
