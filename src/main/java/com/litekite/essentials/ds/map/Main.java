/*
 * Copyright 2021-2022 LiteKite Startup. All rights reserved.
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
package com.litekite.essentials.ds.map;

/**
 * Experimenting with {@link HashMap}
 *
 * @author Vignesh S
 * @version 1.0, 16/01/2022
 * @since 1.0
 */
class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("john", 963021054);
        map.put("mark", 892754694);

        System.out.println(map.get("john")); // prints 963021054
        System.out.println(map.get("mark")); // prints 892754694
    }
}
