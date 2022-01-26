/*
 * Copyright 2021-2022 LiteKite Startup. All rights reserved.
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

/** Calculates sum of prime number in a given number range. */
class SumOfPrimes {

    public static void main(String[] args) {
        // Prints 5
        System.out.println(sumOfPrimes(4));
        // Prints 129
        System.out.println(sumOfPrimes(30));
    }

    private static int sumOfPrimes(int n) {
        int sum = 0;
        for (int index = 2; index <= n; index++) {
            sum += isPrime(index) ? index : 0;
        }
        return sum;
    }

    private static boolean isPrime(int n) {
        for (int index = 2; index <= n / 2; index++) {
            if (n % index == 0) {
                // Divisible, not a prime number.
                return false;
            }
        }
        // Not divisible by any number except 1 and the number itself
        return true;
    }
}
