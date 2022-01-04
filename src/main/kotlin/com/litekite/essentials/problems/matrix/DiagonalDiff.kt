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
package com.litekite.essentials.problems.matrix

import kotlin.math.abs

/**
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */
fun diagonalDiff(arr: Array<Array<Int>>): Int {
    // Write your code here
    var primaryDiagonal = 0
    var secondaryDiagonal = 0
    for (i in arr.indices) {
        println("primaryDiagonal: index: $i, val: ${arr[i][i]}")
        primaryDiagonal += arr[i][i]
    }
    val reversedArray = arr.reversed()
    for (i in reversedArray.indices) {
        println("secondaryDiagonal: index: $i, val: ${reversedArray[i][i]}")
        secondaryDiagonal += reversedArray[i][i]
    }
    return abs(primaryDiagonal - secondaryDiagonal)
}

/**
 * Calculates the diagonal differences
 *
 * Size:
 * n = 3
 *
 * 2D Array:
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * First Diagonal - 1 5 9 = 15 total
 * Second Diagonal - 7 5 3 = 15 total
 * Difference = 0
 */
fun main() {
    val n = readLine()!!.trim().toInt()

    val arr: Array<Array<Int>> = Array(n) { Array(n) { 0 } }

    for (i in 0 until n) {
        arr[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = diagonalDiff(arr)

    println("Diagonal difference: $result")
}
