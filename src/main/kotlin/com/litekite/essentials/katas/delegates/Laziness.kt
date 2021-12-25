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
package com.litekite.essentials.katas.delegates

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Laziness {

    companion object {

        // Gets initialized when required and returns the same for future use.
        private val lazyStr: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            "what a day"
        }

        // Providing custom delegation
        private var delegateStr: String by DelegateStr()

        // Delegate observable that gives us callback after the value is changed.
        private var name: String by Delegates.observable("no_name") { prop, old, new ->
            println("$prop: $old -> $new")
        }

        // Reference property delegation: even oldName gets assigned it will be assigned to name.
        @Deprecated("Use 'name' instead", ReplaceWith("name"))
        private var oldName: String by this::name

        // Delegate veto: gives us the callback before the value change
        // if we return true, the value will be changed, ignored otherwise.
        private var max: Int by Delegates.vetoable(0) { prop, old, new ->
            println("$prop: $old -> $new")
            new > old
        }

        // set will not be available for outer scope
        @Suppress("MemberVisibilityCanBePrivate")
        var privateSetStr: String = "init"
            private set

        @JvmStatic
        fun main(args: Array<String>) {
            println("lazyStr: $lazyStr")

            println("delegateStr during init: $delegateStr")
            delegateStr = "new value"
            println("delegateStr after set: $delegateStr")

            println("Delegate observable before change: $name")
            name = "eminem"
            println("Delegate observable after change: $name")

            println("Delegate veto: before change: $max")
            max = 10
            println("Delegate veto: after change: $max")
            max = 5 // will fail, because 5 < 10
            println("Delegate veto: failure after change: $max")

            privateSetStr = "private set string"
            println("privateSetStr: $privateSetStr")

            oldName = "chris"
            println("deprecated property with delegation: $name")
        }
    }

    /**
     * Property initialization with get and set methods by delegation.
     *
     * @property Any - The object owner of this property.
     * @property String - Property Value
     */
    class DelegateStr : ReadWriteProperty<Any, String> {

        private var value: String? = null

        override fun getValue(thisRef: Any, property: KProperty<*>): String {
            println("$thisRef, thank you for delegating ${property.name} to me!")
            var value = this.value
            if (value == null) {
                value = "initialized"
                this.value = value
            }
            return value
        }

        override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
            println("$value has been assigned to '${property.name}' in $thisRef.")
            this.value = value
        }
    }
}
