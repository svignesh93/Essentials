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
package com.litekite.essentials.problems.str;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores the given string characters in a zigzag pattern and reads line by line in O(n) time.
 *
 * <p>The given string -> P A Y P A L I S H I R I N G
 *
 * <p>String in zigzag pattern in 3 rows -> P A H N A P L S I I G Y I R
 *
 * <p>String in zigzag pattern in 4 rows -> P I N A L S I G Y A H R P I
 */
class ZigZagStr {

    public static void main(String[] args) {
        System.out.println("zigzag str: " + convert("PAYPALISHIRING", 3));
        System.out.println("zigzag str: " + convert("PAYPALISHIRING", 4));
        System.out.println("zigzag str: " + convert("A", 2));
        System.out.println("zigzag str: " + convert("AB", 1));
    }

    private static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        numRows = Math.min(s.length(), numRows);
        List<StringBuilder> strBuilderRows = new ArrayList<>();
        for (int index = 0; index < numRows; index++) {
            strBuilderRows.add(new StringBuilder());
        }

        int strIndex = 0;
        int row = 0;
        boolean isGoingDown = false;

        while (strIndex < s.length()) {
            strBuilderRows.get(row).append(s.charAt(strIndex));
            strIndex++;

            if (row == 0 || row == numRows - 1) {
                isGoingDown = !isGoingDown;
            }

            row += isGoingDown ? 1 : -1;
        }

        StringBuilder resultStrBuilder = new StringBuilder();
        for (row = 0; row < numRows; row++) {
            resultStrBuilder.append(strBuilderRows.get(row));
        }

        return resultStrBuilder.toString();
    }
}
