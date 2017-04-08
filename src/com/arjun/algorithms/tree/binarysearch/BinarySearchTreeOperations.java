package com.arjun.algorithms.tree.binarysearch;

import static com.arjun.algorithms.tree.binarysearch.BinarySearchTree.Node;

public class BinarySearchTreeOperations {

    public static void insert(Node root, int k) {
        if (root.getKey() == null) {
            root.setKey(k);
        } else {
            Node n = new Node();
            n.setKey(k);
            Node x = root;
            Node y = null;
            while (x != null) {
                y = x;
                if (n.getKey() < x.getKey()) {
                    x = x.getLeft();
                } else {
                    x = x.getRight();
                }
            }
            if (n.getKey() < y.getKey())
                y.setLeft(n);
            else
                y.setRight(n);
        }
    }

    public static void delete(BinarySearchTree t, Node z) {

    }

    /**
     * traverse left subtree
     * visit root
     * traverse right subtree
     *
     * @param root
     */
    public static void inorderTreeWalk(Node root) {
        if (root != null) {
            inorderTreeWalk(root.getLeft());
            System.out.print(root.getKey() + ",");
            inorderTreeWalk(root.getRight());
        }
    }


    /**
     * visit root
     * traverse left subtree
     * traverse right subtree
     *
     * @param root
     */
    public static void preorderTreeWalk(Node root) {
        if (root != null) {
            System.out.print(root.getKey() + ",");
            preorderTreeWalk(root.getLeft());
            preorderTreeWalk(root.getRight());
        }
    }

    /**
     * traverse left subtree
     * traverse right subtree
     * visit root
     *
     * @param root
     */
    public static void postorderTreeWalk(Node root) {
        if (root != null) {
            postorderTreeWalk(root.getLeft());
            postorderTreeWalk(root.getRight());
            System.out.print(root.getKey() + ",");
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
    public static Node successor(Node root, Node x) {
        if (x.getRight() != null) {
            return treeMinimum(x.getRight());
        }
        Node y = getParent(root, x);
        while (y != null && x.equals(y.getRight())) {
            x = y;
            y = getParent(root, y);
        }
        return y;
    }

    public static Node predecessor(Node root, Node x) {
        if (x.getLeft() != null) {
            return treeMaximum(x.getLeft());
        }
        Node y = getParent(root, x);
        while (y != null && x.equals(y.getLeft())) {
            x = y;
            y = getParent(root, y);
        }
        return y;

    }

    public static Node getParent(Node root, Node n) {
        Node x = root;
        Node parentOfX = null;
        while (x != null) {
            if (n.getKey() < x.getKey()) {
                parentOfX = x;
                x = x.getLeft();
            } else if (n.getKey() > x.getKey()) {
                parentOfX = x;
                x = x.getRight();
            } else if (n.getKey() == x.getKey()) {
                return parentOfX;
            }
        }
        return null;
    }

}
