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

class HigherOrderFunctions {

    companion object {

        private fun isOdd(x: Int) = x % 2 != 0

        @JvmStatic
        fun main(args: Array<String>) {
            // Receiver Parameter format RECEIVER_TYPE.(OTHER_PARAM) -> RETURN_TYPE
            val sum: Int.(Int) -> Int = { other -> this.plus(other) }
            val result = 2.sum(2)
            println("result: $result")

            val numbers = listOf(1, 2, 3)
            println(numbers.filter(::isOdd))
        }
    }
}
