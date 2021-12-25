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
package com.litekite.essentials.katas.classes

/**
 * A Primary Constructor with private visibility.
 *
 * All init blocks and property init block happen as per the order. But secondary constructor init block happen last.
 */
class Constructors private constructor() {

    private val firstProperty = "First property".also(::println)

    init {
        println("First initializer block")
    }

    private val secondProperty = "Second property".also(::println)

    init {
        println("Second initializer block")
    }

    private var name: String = ""

    /**
     * Secondary Constructor
     */
    constructor(name: String) : this() {
        this.name = name
        println("Secondary Constructor initializer block")
    }

    init {
        println("Third initializer block")
        println("name: ${this.name}, firstProperty: $firstProperty, secondProperty: $secondProperty")
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val constructors = Constructors("secondary constructor")
            println(constructors)
        }
    }
}
