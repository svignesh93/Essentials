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
package com.litekite.essentials.katas.nullsafety

class NullSafety {

    companion object {

        private fun printStr(s: String?) {
            // ? - null-safe call
            println("String length: ${s?.length}")

            // ?: elvis operator
            val refStr = s ?: "string was null"
            println("refStr: $refStr")

            // !! - Non-null Assertion operator that may throw NullPointerException
            try {
                val dangerousOpStr: String = s!!
                println("dangerousOpStr: $dangerousOpStr")
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
        }

        @JvmStatic
        fun main(args: Array<String>) {
            printStr(null)
            printStr("kotlin")
        }
    }
}
