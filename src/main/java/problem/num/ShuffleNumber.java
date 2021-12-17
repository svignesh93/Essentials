/*
 * Copyright 2021 LiteKite Startup. All rights reserved.
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
package problem.num;

/**
 * Shuffles the given number by concatenating first and last number and returns the shuffled number.
 */
class ShuffleNumber {

    public static int shuffle(int value) {
        String num = String.valueOf(value);
        StringBuilder resultBuilder = new StringBuilder();
        int midLength = Math.round(num.length() / 2F);
        for (int firstIndex = 0, lastIndex = num.length() - 1;
                firstIndex < midLength;
                firstIndex++, lastIndex--) {
            resultBuilder.append(num.charAt(firstIndex));
            if (firstIndex != lastIndex) {
                resultBuilder.append(num.charAt(lastIndex));
            }
        }
        return Integer.parseInt(resultBuilder.toString());
    }

    public static void main(String[] args) {
        int num = 123456;
        System.out.println(shuffle(num)); // prints 162534
    }
}
