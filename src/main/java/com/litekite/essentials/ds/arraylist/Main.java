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
package com.litekite.essentials.ds.arraylist;

/**
 * Experimenting with {@link DynamicArrayList}
 *
 * @author Vignesh S
 * @version 1.0, 28/08/2021
 * @since 1.0
 */
class Main {

    public static void main(String[] args) {
        DynamicArrayList<Integer> elements = new DynamicArrayList<>();

        elements.add(1);
        elements.add(2);
        elements.add(3);

        System.out.println(elements.get(1)); // [2]
        System.out.println("\n");
        System.out.println(elements); // [1, 2, 3]

        elements.remove((Integer) 1); // [2, 3]
        elements.remove(1); // [2]

        System.out.println("\n");
        System.out.println(elements); // [2]

        elements.add(0, 1);

        System.out.println("\n");
        System.out.println(elements); // [1, 2]
    }
}
