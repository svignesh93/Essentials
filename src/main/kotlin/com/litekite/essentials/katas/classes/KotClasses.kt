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
 * have multi instances. Enums can extend sealed interfaces, but not sealed classes.
 *
 * Sealed classes are abstract by itself and cannot be instantiated. It can have abstract members.
 *
 * Subclasses must be declared within the same package and should have qualified name unlike anonymous.
 */
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
 * Data classes hold data like java pojo classes.
 *
 * At-least one param needed, it cannot be sealed, abstract, inner, open.
 * Param should be val or var.
 *
 * equals() / hashCode() / copy() / toString() / componentN() - order of properties => can be added by the compiler.
 */
data class DataSource(val src: String)

/**
 * All Enum constants are objects.
 * Enums can implement interfaces, but cannot extend classes.
 *
 * [Color.valueOf] Returns the enum object for the given enum name.
 * @throws IllegalArgumentException if the constant was not there.
 *
 * [Color.values] Return an [Array<Color>] of Color Enum Objects.
 *
 * [enumValues] Returns all enum object of the specified type.
 * [enumValueOf] Returns the enum object of the given enum object name.
 *
 * [ordinal] Refers the index of the enum object constant.
 * [name] The name of the enum object constant.
 */
enum class Color(val rgb: Int) {

    RED(0xFF0000) {
        override fun printValue() {
            println(rgb)
        }
    },
    GREEN(0x00FF00) {
        override fun printValue() {
            println(rgb)
        }
    },
    BLUE(0x0000FF) {
        override fun printValue() {
            println(rgb)
        }
    };

    abstract fun printValue()

    // Static methods and properties in Kotlin
    companion object {

        fun valueOf(rgb: Int) = enumValues<Color>().firstOrNull { it.rgb == rgb }
    }
}

/**
 * Type erasure in generics that replaces T with the identified object type at Runtime, and it cannot be known at
 * compile time.
 *
 * Reified with inline fun in kotlin, compiles copies and replaces the caller method block and reveals its object type.
 *
 * <reified T : Enum<T>> restricts the inflow to object type of Enum<T>
 *     known as Generic constraint or Generic Restriction
 */
inline fun <reified T : Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}

fun main() {
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

    println("Enum Color:")
    printAllValues<Color>()
}
