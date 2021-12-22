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
package com.litekite.essentials.ds.linear.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test cases for {@link DynamicArrayList}
 *
 * @author Vignesh S
 * @version 1.0, 28/08/2021
 * @since 1.0
 */
class DynamicArrayListTest {

    private DynamicArrayList<Integer> arrayList;

    /** Sets up the environment for testing. */
    @BeforeEach
    public void setUp() {
        arrayList = new DynamicArrayList<>();
    }

    @Test
    public void emptyArray() {
        String expectedElements = "[]";
        int expectedSize = 0;

        assertEquals(expectedSize, arrayList.size());
        assertEquals(expectedElements, arrayList.toString());
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void addElementsToArray() {
        String expectedElements = "[1, 2, 3]";
        int expectedSize = 3;

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        assertEquals(expectedSize, arrayList.size());
        assertEquals(expectedElements, arrayList.toString());
        assertTrue(arrayList.contains(1));
        assertTrue(arrayList.contains(2));
        assertTrue(arrayList.contains(3));
        assertEquals(0, arrayList.indexOf(1));
        assertEquals(1, arrayList.indexOf(2));
        assertEquals(2, arrayList.indexOf(3));
    }

    @Test
    public void addElementAtFirstOfArray() {
        String expectedElements = "[0, 1, 2, 3]";
        int expectedSize = 4;

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(0, 0);

        assertEquals(expectedSize, arrayList.size());
        assertEquals(expectedElements, arrayList.toString());
        assertTrue(arrayList.contains(0));
        assertTrue(arrayList.contains(1));
        assertTrue(arrayList.contains(2));
        assertTrue(arrayList.contains(3));
        assertEquals(0, arrayList.indexOf(0));
        assertEquals(1, arrayList.indexOf(1));
        assertEquals(2, arrayList.indexOf(2));
        assertEquals(3, arrayList.indexOf(3));
    }

    @Test
    public void addElementAtLastOfArray() {
        String expectedElements = "[0, 1, 2, 3]";
        int expectedSize = 4;

        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2, 2);

        assertEquals(expectedSize, arrayList.size());
        assertEquals(expectedElements, arrayList.toString());
        assertTrue(arrayList.contains(0));
        assertTrue(arrayList.contains(1));
        assertTrue(arrayList.contains(2));
        assertTrue(arrayList.contains(3));
        assertEquals(0, arrayList.indexOf(0));
        assertEquals(1, arrayList.indexOf(1));
        assertEquals(2, arrayList.indexOf(2));
        assertEquals(3, arrayList.indexOf(3));
    }

    @Test
    public void setElementOfArray() {
        String expectedElements = "[0, 1, 2, 3]";
        int expectedSize = 4;

        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(1);
        arrayList.set(3, 3);

        assertEquals(expectedSize, arrayList.size());
        assertEquals(expectedElements, arrayList.toString());
        assertTrue(arrayList.contains(0));
        assertTrue(arrayList.contains(1));
        assertTrue(arrayList.contains(2));
        assertTrue(arrayList.contains(3));
        assertEquals(0, arrayList.indexOf(0));
        assertEquals(1, arrayList.indexOf(1));
        assertEquals(2, arrayList.indexOf(2));
        assertEquals(3, arrayList.indexOf(3));
    }

    @Test
    public void getElementFromArray() {
        String expectedElements = "[0, 1, 2, 3]";
        int expectedSize = 4;

        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        assertEquals(expectedSize, arrayList.size());
        assertEquals(expectedElements, arrayList.toString());
        assertTrue(arrayList.contains(0));
        assertTrue(arrayList.contains(1));
        assertTrue(arrayList.contains(2));
        assertTrue(arrayList.contains(3));
        assertEquals(0, arrayList.get(0));
        assertEquals(1, arrayList.get(1));
        assertEquals(2, arrayList.get(2));
        assertEquals(3, arrayList.get(3));
    }

    @Test
    public void removeElementsFromArray() {
        String expectedElements = "[]";
        int expectedSize = 0;

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        assertTrue(arrayList.remove((Integer) 1));
        assertTrue(arrayList.remove((Integer) 2));
        assertTrue(arrayList.remove((Integer) 3));
        assertEquals(expectedSize, arrayList.size());
        assertEquals(expectedElements, arrayList.toString());
    }

    @Test
    public void removeElementAtFirstOfArray() {
        String expectedElements = "[1, 2, 3]";
        int expectedSize = 3;

        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        assertTrue(arrayList.remove(0));
        assertEquals(expectedSize, arrayList.size());
        assertEquals(expectedElements, arrayList.toString());
    }

    @Test
    public void removeElementAtLastOfArray() {
        String expectedElements = "[0, 1, 2]";
        int expectedSize = 3;

        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        assertTrue(arrayList.remove(3));
        assertEquals(expectedSize, arrayList.size());
        assertEquals(expectedElements, arrayList.toString());
    }

    @Test
    public void clearElementsFromArray() {
        String expectedElements = "[]";
        int expectedSize = 0;

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.clear();

        assertEquals(expectedSize, arrayList.size());
        assertEquals(expectedElements, arrayList.toString());
        assertTrue(arrayList.isEmpty());
    }
}
