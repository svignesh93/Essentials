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
package com.litekite.essentials.katas.ds.linear

fun main() {
    val strArray: Array<String> = arrayOf("One", "Two", "Three")
    println("strArray sumOf: ${strArray.sumOf { it.length }}")
    println("strArray: ${strArray.joinToString(", ", "[", "]") { it }}")

    val intArray = intArrayOf(1, 2, 3)
    println("intArray sum: ${intArray.sum()}")
    println("intArray: ${intArray.joinToString(", ", "[", "]") { it.toString() }}")

    // Mixed array
    val mixedArray = arrayOf("One", 2, "Three")
    println("mixedArray: ${mixedArray.joinToString(", ", "[", "]") { it.toString() }}")

    // List
    val list = listOf("One", 4, "Three").reversed()
    println("reversed list: $list")

    // toIndex not taken into account
    println("sublist: ${list.subList(0, 2)}")

    // Sequence with collection - recommended for longer items.
    // collection op recommended for shorter items
    // each item gets processed one by one through all intermediate ops
    // when the terminal operation request happens
    val words = listOf("The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog")

    // convert the List to a Sequence
    val wordsSequence = words.asSequence()

    val lengthsSequence = wordsSequence.filter { println("filter: $it"); it.length > 3 }
        .map { println("length: ${it.length}"); it.length }
        .take(4)

    println("Lengths of first 4 words longer than 3 chars")

    // terminal operation: obtaining the result as a List
    // count(), sum(), toList()
    // The sequence op starts only here at the time of terminal op.
    println(lengthsSequence.toList())
}
