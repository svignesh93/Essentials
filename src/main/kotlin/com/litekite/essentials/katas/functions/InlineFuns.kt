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
 * Inline function avoids overhead of creating functional objects and places code on the caller site.
 *
 * It must accept higher order function, and it must have reified type param.
 *
 * noinline means that it will not treat it as an inline fun and does not place code on the caller site and create
 * function object.
 */
inline fun compute(block: () -> Boolean, noinline otherBlock: () -> Boolean): Boolean {
    otherBlock.invoke()
    return block.invoke()
}

/**
 * cross inline required if the lambda block needs to be executed in other context like another thread.
 */
inline fun crossInlineFun(crossinline body: () -> Unit) {
    val runnable = Runnable { body() }
    Thread(runnable).start()
}

/**
 * Type erasure in generics that replaces T with the identified object type at Runtime, and it cannot be known at
 * compile time.
 *
 * Reified with inline fun in kotlin, compiler copies and replaces the caller method block and reveals its object type.
 */
inline fun <reified T> membersOf() = T::class.members

fun main() {
    crossInlineFun {
        println("This is cross-inlined")
    }

    println(membersOf<StringBuilder>().joinToString("\n"))

    compute(block = {
        println("inline block")
        // return works as a non-local return without label as it was inlined.
        // the result directed to fun main() which is expecting Unit as a result and exits the process.
        return
    }) {
        println("noinline block")
        // Use label to return the Boolean result as it was not inlined
        return@compute true
    }
}
