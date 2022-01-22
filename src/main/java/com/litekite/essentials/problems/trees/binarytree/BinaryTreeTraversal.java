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
package com.litekite.essentials.problems.trees.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * There are three types of traversals that can be performed in a binary tree.
 *
 * <p>Inorder - recursively looks for left node, visits the left node, and then parent node, then
 * travers to right node if present and repeats looking for left node, and so on.
 *
 * <p>Preorder - visits the parent node, recursively look for left node if present and visits left
 * node, and travers to the right node and repeats the same. (same as Depth First Algorithm - DFS)
 *
 * <p>Postorder - recursively looks for left node, recursively looks for right node, finally visits
 * the node.
 *
 * @param <T> any valid java object type.
 * @author Vignesh S
 * @version 1.0, 22/01/2022
 * @since 1.0
 */
class BinaryTreeTraversal<T> {

    public List<T> inorderTraversalDelegate(Node<T> node) {
        List<T> result = new ArrayList<>();
        inorderTraversalDelegate(node, result);
        return result;
    }

    private void inorderTraversalDelegate(Node<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inorderTraversalDelegate(node.left, result);
        }
        result.add(node.data);
        if (node.right != null) {
            inorderTraversalDelegate(node.right, result);
        }
    }

    @SuppressWarnings("unused")
    public List<T> preorderTraversalDelegate(Node<T> node) {
        List<T> result = new ArrayList<>();
        preorderTraversalDelegate(node, result);
        return result;
    }

    private void preorderTraversalDelegate(Node<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        result.add(node.data);
        if (node.left != null) {
            preorderTraversalDelegate(node.left, result);
        }
        if (node.right != null) {
            preorderTraversalDelegate(node.right, result);
        }
    }

    @SuppressWarnings("unused")
    public List<T> postorderTraversalDelegate(Node<T> node) {
        List<T> result = new ArrayList<>();
        postorderTraversalDelegate(node, result);
        return result;
    }

    private void postorderTraversalDelegate(Node<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            postorderTraversalDelegate(node.left, result);
        }
        if (node.right != null) {
            postorderTraversalDelegate(node.right, result);
        }
        result.add(node.data);
    }

    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
        }
    }
}
