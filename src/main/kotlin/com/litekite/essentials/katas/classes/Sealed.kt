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

import java.io.File

/**
 * Sealed classes and interfaces provides restricted hierarchy of subclasses known at compile time.
 * No other classes can extend this type of class outside its origin like a library that cannot be extended by outer
 * world.
 *
 * Same like enum classes whereas enums create single instance for each of its constants. But sealed subclass can
 * have multi instances. Enums can extend sealed interfaces, but not sealed classes
 *
 * Sealed classes are abstract by itself and cannot be instantiated. It can have abstract members.
 *
 * Subclasses must be declared within the same package and should have qualified name unlike anonymous
 */
class Sealed {

    sealed interface Error

    /**
     * Constructors are protected by default, and can be private.
     */
    sealed class IOError : Error

    class FileReadError(val file: File) : IOError()

    class DatabaseError(val source: DataSource) : IOError()

    /**
     * Singleton classes in kotlin are objects, it can be anonymous too.
     */
    object RuntimeError : Error

    /**
     * Data classes hold data like java pojo classes
     *
     * At-least one param needed, it cannot be sealed, abstract, inner, open.
     * Param should be val or var
     *
     * equals() / hashCode() / copy() / toString() / componentN() - order of properties => can be added by the compiler
     */
    data class DataSource(val src: String)

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            @Suppress("MoveVariableDeclarationIntoWhen")
            val error: Error = RuntimeError

            // when expression is exhaustive.
            when (error) {
                is FileReadError -> {
                    println("Error while reading file ${error.file}")
                }
                is RuntimeError -> {
                    println("Runtime error")
                }
                is DatabaseError -> {
                    println("Error while reading from database ${error.source}")
                }
            }
        }
    }
}
