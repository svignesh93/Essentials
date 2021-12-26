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
package com.litekite.essentials.katas.destructure

/**
 * Destructuring Declarations
 */
fun main() {
    // Under the hood:
    // val first = triple.component1()
    // val second = triple.component2()
    // val third = triple.component3() ...componentN gets replaced by the compiler.
    val (first, second, third) = Triple(4, 6, 12) // Destructuring Triple
    println("Destructuring triples: first: $first, second: $second, third: $third")

    val (firstVal, secondVal) = "Fishnet" to "catching fish" // Destructuring Pair
    println("Destructuring Pair: firstVal: $firstVal, secondVal: $secondVal")

    val map = mapOf("A" to "B", "C" to "D")
    println("Destructuring maps:")

    map.mapValues { (key, _) -> println("mapValues: key: $key") }

    map.mapValues { entry -> println("mapValues: key: ${entry.key}, value: ${entry.value}") }

    for ((key, value) in map) {
        // do something with the key and the value
        println("key: $key, value: $value")
    }
}
