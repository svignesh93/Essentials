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
package com.litekite.essentials.katas.ds.linear

fun main() {
    val map = hashMapOf("1" to "One")
    println(map["1"])
    println(map.getOrDefault("2", "Not Found"))
    println(map.getOrElse("2") { "Not Found" })

    val mutableMap = mutableMapOf("1" to "One")
    mutableMap["3"] = "three"
    mutableMap.remove("1")
    println(mutableMap)
}
