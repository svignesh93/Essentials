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
package com.litekite.essentials.katas.functions

/**
 * Scope functions that executes block of code inside the lambda.
 * Only difference is that it depends on the function return type and the object it receives.
 */
fun main() {
    val name = "eminem"

    // Let - Executes the expression and returns the lambda result.
    var result = name.let {
        println("let block")
        it.reversed().uppercase() // lambda result
    }
    println("let result: $result")

    // Run - Executes the expression and returns the lambda result
    result = name.run {
        uppercase() // lambda result
    }
    println("run result: $result")

    // Run without receiver object - Executes the expression and returns the lambda result
    result = run {
        name.plus(" rapper") // lambda result
    }
    println("run without receiver object result: $result")

    // Takes first object and block, executes and returns the lambda result
    result = with(name) {
        println("with block")
        name.plus(" singer") // lambda result
    }
    println("with result: $result")

    // Performs expression on the object, and it returns the context object.
    var adam = Person("Adam").apply {
        age = 32
        city = "London"
    }
    println("apply result: $adam")

    // Performs expression on the object, and it returns the context object.
    adam = Person("Adam 2").also {
        it.age = 28
        it.city = "Paris"
    }
    println("also result: $adam")
}

data class Person(var name: String, var age: Int = 0, var city: String = "")
