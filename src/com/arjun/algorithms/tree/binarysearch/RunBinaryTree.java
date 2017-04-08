package com.arjun.algorithms.tree.binarysearch;

import java.util.Scanner;

import com.arjun.algorithms.tree.binarysearch.BinarySearchTree.Node;


public class RunBinaryTree {
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

        // Insert
        Node root = new Node();
        for (int i : ar) {
            BinarySearchTreeOperations.insert(root, i);
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

    }
}
