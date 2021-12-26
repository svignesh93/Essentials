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
package com.litekite.essentials.katas.visibility

/**
 * Visibility modifiers in Kotlin
 *
 * private - visible only to the specific file or scope.
 *
 * protected - like private properties are visible for subclasses
 *
 * open - by default, everything is final, and it cannot be inherited. open enables subclasses to inherit classes and
 * its properties.
 *
 * internal - will be visible inside the package
 * public - public is used by default. It will be visible everywhere.
 */
@Suppress("unused")
class VisibilityModifiers {

    /**
     * All classes supertype is Any in Kotlin, and it defines [equals] [hashCode] and [toString] for all classes
     */
    open class A : Any() {

        // By default, it's public
        val about = "A Class"

        internal val desc = "Description of this class"

        private val age = 29

        protected open val name: String = "A"

        open fun printName() {
            println("name: $name")
        }
    }

    interface Base {
        fun printName() {}
    }

    open class B : A(), Base {
        // Overriding for subclasses is disabled here with final keyword.
        final override val name: String = "B"

        override fun printName() {
            super<A>.printName()
            super<Base>.printName()
        }
    }

    class C : B()

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val b = B()
            println("b: ${b.printName()}")
        }
    }
}
