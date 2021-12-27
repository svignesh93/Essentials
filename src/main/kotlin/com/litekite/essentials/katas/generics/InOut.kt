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
package com.litekite.essentials.katas.generics

/**
 * Invariant - does not accept subtypes of supertype
 *
 * Covariant - collection<? extends T> (or) Out, accepts any subtypes of supertype T. This is a producer that you can
 * read from it, but cannot add any value to it. It is immutable, and you can only clear() from it.
 *
 * Contravariant - Collection<? super T> (or) In, accepts any supertypes of T. This is a consumer that you can add
 * value to it, and you can read [Object] or [Any] from it.
 *
 * PECS stands for Producer-Extends (Out), Consumer-Super (In)
 *
 * Variance annotation - In, Out
 */
interface Source<out T> {
    // out - covariant - declaration-site variance
    fun next(): T
}

@Suppress("unused")
fun demo(source: Source<String>) {
    // In Java:

    // List<String> strList = new ArrayList<>();

    // Object supertype accepts subtype String
    // List<? extends Object> objList = strList;

    val objects: Source<Any> = source

    println("Objects: $objects")
}

interface Comparable<in T> {
    // in - contravariant
    operator fun compareTo(other: T): Int
}

@Suppress("unused")
fun demo(x: Comparable<Number>) {
    // In Java:

    // List<Number> numList = new ArrayList<>();

    // Double subtype accepts supertype Number
    // List<? super Double> doubleList = numList;

    // 1.0 has type Double, which is a subtype of Number
    var result = x.compareTo(1.0)

    println("result: $result")

    // Thus, you can assign x to a variable of type Comparable<Double>
    val y: Comparable<Double> = x
    result = y.compareTo(1.2)

    println("result: $result")
}

// Star Projections in Kotlin

// interface Function<in T, out U>

// Function<*, String> means Function<in Nothing, String>
// Function<Int, *> means Function<Int, out Any?>.
// Function<*, *> means Function<in Nothing, out Any?>

fun <T> copy(from: Array<out T>, to: Array<in T>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
    println("copy result: ${to.joinToString(", ", "[", "]") { it.toString() }}")
}

fun main() {
    // In and out in Generics
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }
    copy(ints, any)
}
