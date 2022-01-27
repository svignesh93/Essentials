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

/** Finds whether the given year, leap year or not. */
class LeapYear {

    public static void main(String[] args) {
        // Print true, 1996 is a leap year
        System.out.println(isLeapYear(1996));
        // Print false, 1900 is not a leap year
        System.out.println(isLeapYear(1900));
        // Print true, 2012 is a leap year
        System.out.println(isLeapYear(2012));
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                return true;
            }
            return year % 400 == 0;
        } else {
            return false;
        }
    }
}
