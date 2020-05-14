package com.arjun.algorithms.tree.binarysearch.v1;

import com.arjun.algorithms.tree.binarysearch.v1.BinarySearchTree.Node;

public class BinaryTreeOperations {
    public static void insert(BinarySearchTree t, Node z) {
        Node x = t.getRoot();
        Node y = null;
        while (x != null) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        z.setParent(y);
        if (y == null) {
            t.setRoot(z);
        } else if (z.getKey() < y.getKey())
            y.setLeft(z);
        else
            y.setRight(z);
    }

    public static void delete(BinarySearchTree t, Node z) {

    }

    public static void inorderTreeWalk(Node root) {
        if (root != null) {
            inorderTreeWalk(root.getLeft());
            System.out.println(root.getKey());
            inorderTreeWalk(root.getRight());
        }
    }

    public static Node treeSearch(Node x, int k) {
        if (x == null || k == x.getKey())
            return x;
        if (k < x.getKey()) {
            return treeSearch(x.getLeft(), k);
        } else
            return treeSearch(x.getRight(), k);
    }

    public static Node treeMinimum(Node x) {
        Node y = null;
        while (x != null) {
            y = x;
            x = x.getLeft();
        }
        return y;
    }

    public static Node treeMaximum(Node root) {
        Node x = null;
        while (root != null) {
            x = root;
            root = root.getRight();
        }
        return x;
    }

    // if right subtree of node x is empty and x has a successor y,
    // then y is the lowest ancestor of x whose left child is also the ancestor
    // of x
    public static Node successor(Node x) {
        if (x.getRight() != null) {
            return treeMinimum(x.getRight());
        }
        Node y = x.getParent();
        while (y != null && x.equals(y.getRight())) {
            x = y;
            y = y.getParent();
        }
        return y;
    }

    public static Node predecessor(Node x) {
        if (x.getLeft() != null) {
            return treeMaximum(x.getLeft());
        }
        Node y = x.getParent();
        while (y != null && x.equals(y.getLeft())) {
            x = y;
            y = y.getParent();
        }
        return y;

    }

}
