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

/** Prints the fibonacci series of a given number. */
class Fibonacci {

    public static void main(String[] args) {
        printFibonacciSeries(5);
        printFibonacciSeries(10);
    }

    private static void printFibonacciSeries(int n) {
        int first = 0;
        int second = 1;
        int index = 1;

        System.out.println("fibonacci Series of " + n + ": ");

        while (index <= n) {
            System.out.print(first);

            int next = first + second;
            first = second;
            second = next;

            if (index < n) {
                System.out.print(", ");
            }

            index++;
        }
        System.out.println();
    }
}
