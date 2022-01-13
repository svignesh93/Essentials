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
package com.litekite.essentials.problems.num;

/** Prints FizzBuzz for all the numbers from 1 to given number, takes O(n) times and O(1) space. */
class FizzBuzz {

    public static void main(String[] args) {
        System.out.println("fizzbuzz: " + fizzBuzz(15));
    }

    public static String fizzBuzz(Integer num) {
        StringBuilder result = new StringBuilder();
        for (int index = 1; index <= num; index++) {
            if (index % 15 == 0) {
                result.append("fizzbuzz");
            } else if (index % 5 == 0) {
                result.append("buzz");
            } else if (index % 3 == 0) {
                result.append("fizz");
            } else {
                result.append(index);
            }
        }
        return result.toString();
    }
}
