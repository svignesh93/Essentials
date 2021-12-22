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
package com.litekite.essentials.katas.functions

class FunFeatures {

    companion object {

        private fun defaultArgs(argOne: Int = 0, argTwo: Int = 0) {
            println("argOne: $argOne argTwo: $argTwo")
        }

        // Single-expression functions / Compact function
        private fun someCal(num: Int): Int = num * num / 2 + num

        @JvmStatic
        fun main(args: Array<String>) {
            // Operator Overloading function used with "operator" keyword in functions.

            val plus = 1.plus(2)
            println("plus: $plus")

            val minus = 1.minus(2)
            println("minus: $minus")

            // multiply function
            val times = 3.times(2)
            println("times: $times")

            // Remainder after division
            val rem = 1.rem(2)
            println("rem: $rem")

            val div = 1.div(2)
            println("div: $div")

            // Inverts bits
            val inv = 1.inv()
            println("inv: $inv")

            // Infix function that uses "infix" keyword in function

            val and = 1 and 2
            println("and: $and")

            val or = 1 or 2
            println("or: $or")

            val xor = 1 xor 2
            println("xor: $xor")

            // Default Args
            defaultArgs(argOne = 2, argTwo = 3)
            defaultArgs(argTwo = 3)

            // Single-expression function
            var result = someCal(2)
            result = someCal(result)
            println("result: $result")
        }
    }
}
