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
 * Value Class (or) Inline Class that can only hold single property and act as a wrapper class
 *
 * The wrapper gets replaced with original value without any additional memory or overhead at runtime.
 *
 * It is used to provide meaning to the value to understand it better.
 *
 * This won't be creating an instance, does not call constructor, it will be replaced by the original value.
 *
 * Type alias does not create new type whereas value class represent new type as a wrapper.
 */
@JvmInline
value class Name(val s: String) : Greet {
    // It can inherit from interfaces.
    // This is class is final, other classes cannot inherit from it.
    init {
        require(s.isNotEmpty())
    }

    val length: Int get() = s.length

    override fun greet() {
        println("Hello, $s")
    }
}

interface Greet {
    fun greet()
}

@JvmInline
value class UInt(val x: Int)

// Represented as 'public final void compute(int x)' on the JVM
fun compute(x: Int) {
    println(x)
}

// Also represented as 'public final void compute(int x)' on the JVM
// with mangling function name with hashcode if it is not disabled by using @JvmName annotation
// To call this method from Java, and it avoids kotlin mangling, use @JvmName annotation
@JvmName("computeUInt")
fun compute(x: UInt) {
    println(x.x)
}

typealias NameTypeAlias = String

@JvmInline
value class NameValueClass(val s: String)

fun acceptString(s: String) { println(s) }
fun acceptNameTypeAlias(n: NameTypeAlias) { println(n) }
fun acceptNameInlineClass(p: NameValueClass) { println(p) }

fun main() {
    // In the next line no constructor call happens, and
    // at the runtime 'name' contains just string "Kotlin"
    val name = Name("Kotlin")
    println("Name: ${name.s}, length: ${name.length}")
    name.greet()

    val uInt = UInt(42)
    compute(uInt)
    compute(43)

    val nameAlias: NameTypeAlias = "I'm TypeAlias"
    val nameValueClass = NameValueClass("I'm a Wrapper Value Class")
    val string = "I'm a String"

    acceptString(nameAlias) // OK: pass alias instead of underlying type
    // acceptString(nameValueClass) Not OK: can't pass inline class instead of underlying type
    acceptString(nameValueClass.s)

    // And vice versa:
    acceptNameTypeAlias(string) // OK: pass underlying type instead of alias
    // acceptNameInlineClass(nameValueClass) Not OK: can't pass underlying type instead of inline class
    acceptNameInlineClass(nameValueClass)
}
