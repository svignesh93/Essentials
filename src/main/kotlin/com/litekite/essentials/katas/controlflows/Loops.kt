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
package com.litekite.essentials.katas.controlflows

class Loops {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // Range in loop
            println("Range: ")
            for (i in 1..3) {
                println(i)
            }

            println("Repeat: ")
            repeat(3) {
                println("Repeat")
            }

            println("Repeat with index: ")
            repeat(3) { index ->
                println(index)
            }

            // Backward in loop with step counter
            println("Backward loop with steps: ")
            for (i in 6 downTo 0 step 2) {
                println(i)
            }

            val arr = arrayOf(1, 2, 3, 4)

            println("Array Indices: ")
            for (index in arr.indices) {
                println(index)
            }

            println("Array Indices with values: ")
            for ((index, value) in arr.withIndex()) {
                println("index: $index value: $value")
            }

            println("Array ForEach: ")
            arr.forEach {
                println(it)
            }

            println("Array ForEach: ")
            arr.forEachIndexed { index, value ->
                println("index: $index value: $value")
            }
        }
    }
}
