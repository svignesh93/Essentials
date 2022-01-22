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
package com.litekite.essentials.problems.trees.binarytree;

/**
 * Experimenting with {@link BinaryTreeTraversal}
 *
 * @author Vignesh S
 * @version 1.0, 22/02/2022
 * @since 1.0
 */
class Main {

    public static void main(String[] args) {
        BinaryTreeTraversal<Integer> traversal = new BinaryTreeTraversal<>();

        BinaryTreeTraversal.Node<Integer> node1 = new BinaryTreeTraversal.Node<>(4);
        node1.right = new BinaryTreeTraversal.Node<>(5);
        node1.right.left = new BinaryTreeTraversal.Node<>(6);

        // Prints [4, 6, 5]
        System.out.println(
                "inorder traversal result1: " + traversal.inorderTraversalDelegate(node1));

        BinaryTreeTraversal.Node<Integer> node2 = new BinaryTreeTraversal.Node<>(5);
        node2.left = new BinaryTreeTraversal.Node<>(10);
        node2.left.left = new BinaryTreeTraversal.Node<>(17);
        node2.left.right = new BinaryTreeTraversal.Node<>(3);
        node2.right = new BinaryTreeTraversal.Node<>(8);

        // Prints [17, 10, 3, 5, 8]
        System.out.println(
                "inorder traversal result2: " + traversal.inorderTraversalDelegate(node2));

        BinaryTreeTraversal.Node<Integer> node3 = new BinaryTreeTraversal.Node<>(6);
        node3.left = new BinaryTreeTraversal.Node<>(3);

        // Prints [3, 6]
        System.out.println(
                "inorder traversal result3: " + traversal.inorderTraversalDelegate(node3));

        BinaryTreeTraversal.Node<Integer> node4 = new BinaryTreeTraversal.Node<>(5);
        node4.left = new BinaryTreeTraversal.Node<>(3);
        node4.left.left = new BinaryTreeTraversal.Node<>(2);
        node4.left.left.left = new BinaryTreeTraversal.Node<>(1);

        // Prints [1, 2, 3, 5]
        System.out.println(
                "inorder traversal result4: " + traversal.inorderTraversalDelegate(node4));

        BinaryTreeTraversal.Node<Integer> node5 = new BinaryTreeTraversal.Node<>(8);
        node5.left = new BinaryTreeTraversal.Node<>(6);
        node5.right = new BinaryTreeTraversal.Node<>(9);
        node5.left.left = new BinaryTreeTraversal.Node<>(5);
        node5.left.right = new BinaryTreeTraversal.Node<>(7);
        node5.right.right = new BinaryTreeTraversal.Node<>(10);

        // Prints [5, 6, 7, 8, 9, 10]
        System.out.println(
                "inorder traversal result5: " + traversal.inorderTraversalDelegate(node5));
    }
}
