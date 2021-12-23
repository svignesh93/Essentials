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

/**
 * This class inherits a functional lambda that takes Int as an argument and return an Int.
 */
class HigherOrderFunctions : (Int) -> Int {

    companion object {

        // Receiver Object format RECEIVER_TYPE.(OTHER_PARAM) -> RETURN_TYPE
        private val sum: Int.(Int) -> Int = { other: Int -> this.plus(other) }

        private val sumByRef: Int.(Int) -> Int = Int::plus

        // Takes integer value as argument and returns boolean result
        // Function is represented as a value
        private val isEven: (Int) -> Boolean = { it % 2 == 0 }

        private val isFloat: (Any) -> Boolean = { i: Any -> i is Float }

        private fun <T> isInt(): (T) -> Boolean = { x: T -> x is Int }

        // Compact function (Single expression function)
        private fun isOdd(x: Int): Boolean = x % 2 != 0

        @JvmStatic
        fun main(args: Array<String>) {
            // Lambda (or) Higher order functions - Anonymous function represented in curly braces
            // Function or lambda passed as an argument to another function.
            val result = sum(2, 2).plus(2.sum(2)).plus(sumByRef(2, 2))
            println("sum result: $result")

            val isInt = isInt<Int>().invoke(3)
            println("isInt: $isInt")

            println("isFloat: ${isFloat(3.0)}")

            val higherOrderFunction: (Int) -> Int = HigherOrderFunctions()
            println("Class level functional inheritance: ${higherOrderFunction.invoke(2)}")

            val numbers = listOf(1, 2, 3)

            // Value reference as a predicate filter.
            println("value predicate even num:")
            println(numbers.filter(isEven))

            // Function predicate filter that passed as a reference.
            println("functional predicate odd num:")
            println(numbers.filter(::isOdd))
        }
    }

    override fun invoke(x: Int): Int {
        return x.inc()
    }
}
