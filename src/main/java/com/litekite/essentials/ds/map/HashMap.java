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
package com.litekite.essentials.ds.map;

/**
 * Simple HashMap implementation without collision handling mechanism.
 *
 * @param <K> can be any object key type which get <V> in O(1) time.
 * @param <V> value stored in an array with the hash index calculated by the <K> key.
 * @author Vignesh S
 * @version 1.0, 16/01/2022
 * @since 1.0
 */
class HashMap<K, V> {

    private final Object[] arr;
    private final int capacity = 16;

    public HashMap() {
        arr = new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        int hashIndex = hashIndex(key);
        return (V) arr[hashIndex];
    }

    private int hashIndex(Object key) {
        if (key == null) {
            return 0;
        }
        return key.hashCode() % capacity;
    }

    public void put(K key, V value) {
        int hashIndex = hashIndex(key);
        arr[hashIndex] = value;
    }
}
