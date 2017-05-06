package com.arjun.algorithms.tree.binarysearch;

import java.util.Scanner;

import com.arjun.algorithms.tree.binarysearch.BinarySearchTree.Node;


public class RunBinarySearchTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        // 5 4 3 2 7 8 99 0 3 10

        //           5
        //        /     \
        //      4        7
        //     /          \
        //     3           8
        //   /  \            \
        //  2    3            99
        // /				/
        // 0			    10

        // 15 18 6 17 20 3 2 4 7 13 9

        //            15
        //          /    \
        //         6      18
        //       /   \    /  \
        //     3     7   17   20
        //    / \     \
        //  2    4     13
        //            /
        //           9

        // Insert
//        Node root = new Node();
//        for (int i : ar) {
//            BinarySearchTreeOperations.insert(root, i);
//        }

        // comment this before running AVL Tree
        Node root = BinarySearchTreeOperations.balancedTreeInsert(null, ar[0]);
        for (int i = 1; i < ar.length; i++) {
            Node node = BinarySearchTreeOperations.balancedTreeInsert(root, ar[i]);
            root = node;

        }

        // inorder tree walk
        System.out.println("inorder tree walk");
        BinarySearchTreeOperations.inorderTreeWalk(root);

        // preorder tree walk
        System.out.println("preorder tree walk");
        BinarySearchTreeOperations.preorderTreeWalk(root);

        // postorder tree walk
        System.out.println("postorder tree walk");
        BinarySearchTreeOperations.postorderTreeWalk(root);

        // Tree search
        int k = in.nextInt();
        Node x = BinarySearchTreeOperations.treeSearch(root, k);
        System.out.println("Node found: " + x);

        // Tree minimum
        Node min = BinarySearchTreeOperations.treeMinimum(root);
        System.out.println("Minimum node: " + min);

        // Tree maximum
        Node max = BinarySearchTreeOperations.treeMaximum(root);
        System.out.println("Maximum node : " + max);

        // Successor
        k = in.nextInt();
        x = BinarySearchTreeOperations.treeSearch(root, k);
        Node successor = BinarySearchTreeOperations.successor(root, x);
        System.out.println("Successor is : " + successor);

        // Predecessor
        k = in.nextInt();
        x = BinarySearchTreeOperations.treeSearch(root, k);
        Node predecessor = BinarySearchTreeOperations.predecessor(root, x);
        System.out.println("Predecessor is: " + predecessor);

//        int x1 = in.nextInt();
//        int y1 = in.nextInt();
//        Node nx1 = BinarySearchTreeOperations.treeSearch(root, x1);
//        Node nx2 = BinarySearchTreeOperations.treeSearch(root, y1);
//        Node node = BinarySearchTreeOperations.leastCommonAncestor(root, nx1, nx2);
//        System.out.println("Least Common Ancestor is : " + node.getKey());

        boolean bst = BinarySearchTreeOperations.isBST(root);
        System.out.println(root + " is " + (bst ? "" : "not") + "a binary search tree");


        int height = BinarySearchTreeOperations.height(root);
        System.out.println("Height of the tree is " + height);


    }
}
