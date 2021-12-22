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
package com.litekite.essentials.katas.polymorphism;

class RuntimePolymorphism {

    static class Base {

        int randomNumber = 10;

        public int getRandomNumber() {
            return randomNumber;
        }

        public void setRandomNumber(int randomNumber) {
            this.randomNumber = randomNumber;
        }
    }

    static class Child extends Base {

        int randomNumber = 30;

        @Override
        public int getRandomNumber() {
            return randomNumber;
        }
    }

    public static void main(String[] args) {
        Base base = new Base();
        System.out.println("Base randomNumber: " + base.getRandomNumber());

        Child child = new Child();
        child.setRandomNumber(20);
        System.out.println("Child randomNumber: " + child.getRandomNumber());

        Base childToBase = new Child();
        System.out.println("Child boxed with Base: randomNumber: " + childToBase.getRandomNumber());

        // Can't put a child inside parent class, 'cause it does not fit.
        // Child baseToChild = new Base();
    }
}
