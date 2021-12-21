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
package problem.matrix;

/**
 * Prints all the values from a 2D Array diagonally.
 *
 * @author Vignesh S
 * @version 1.0
 * @since 1.0
 */
class DiagonalMatrix {

    static int[][] matrixArray = {
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20},
        {21, 22, 23, 24, 25},
        {26, 27, 28, 29, 30},
        {31, 32, 33, 34, 35}
    };

    public static void main(String[] args) {
        for (int index = 0; index < matrixArray.length; index++) {
            for (int rowPos = index, colmPos = 0; colmPos <= index; rowPos--, colmPos++) {
                System.out.print(matrixArray[rowPos][colmPos] + " ");
            }
            System.out.println();
        }
        for (int index = 1; index < matrixArray.length; index++) {
            for (int rowPos = matrixArray.length - 1, colmPos = index;
                    colmPos < matrixArray.length;
                    rowPos--, colmPos++) {
                System.out.print(matrixArray[rowPos][colmPos] + " ");
            }
            System.out.println();
        }
    }
}
