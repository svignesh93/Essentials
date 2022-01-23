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
 * Sums all the digits of a given number and if the result sum is not single digit, repeat summing
 * the result.
 *
 * <p>if the given number is 49, the resulting sum is 4 + 9 = 13. The result sum 13 has 2 digits,
 * further it needs to break down and summed up again until it reaches a single digit.
 *
 * <p>summing up the previous result, 1 + 3 = 4 gives a final single digit number.
 */
class SumDigits {

    public static void main(String[] args) {
        System.out.println(sumDigits(49)); // prints 4
    }

    private static int sumDigits(int num) {
        int sum = 0;
        String[] digits = String.valueOf(num).split("");
        for (String digit : digits) {
            sum += Integer.parseInt(digit);
        }
        if (String.valueOf(sum).split("").length > 1) {
            return sumDigits(sum);
        }
        return sum;
    }
}
