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
@file:JvmName("SAM")

package com.litekite.essentials.katas.classes

/**
 * Functional Interfaces (SAM - Single Abstract Method) that has only one abstract method and can have several
 * non-abstract methods that will provide us the lambda functional representation.
 */
fun interface Notification {
    fun post(): Boolean

    fun get() {
        // this is just a non-abstract method.
    }
}

val notification = Notification { return@Notification true }

fun main() {
    println("Is notification posted: ${notification.post()}")
}
