package com.arjun.algorithms.tree.binarysearch.problem;

import java.util.Scanner;
import java.util.Stack;

import com.arjun.algorithms.linkedlist.doubly.DoublyLinkedList.LLNode;
import com.arjun.algorithms.tree.binarysearch.BinarySearchTreeOperations;

import static com.arjun.algorithms.tree.binarysearch.BinarySearchTree.Node;


/**
 *
 * Converts BST to sorted DLL by traversing inorder.
 *
 * Created by arjuns on 23/4/17.
 */
public class BSTToDLL_Stack {

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
        Node root = new Node();
        for (int i : ar) {
            BinarySearchTreeOperations.insert(root, i);
        }

        Stack<Integer> stack = new Stack();
        inorderSearch(root, stack);

        for (Integer i : stack) {
            System.out.println(i);
        }

        LLNode previous = null;
        LLNode first = null;
        for (Integer i : stack) {
            if (first == null) {
                first = createLLNode(i);
                previous = first;
            } else
                previous = createLLNode(previous, i);
        }

        while (first != null) {
            System.out.println(first);
            first = first.getNext();
        }
    }

    private static void inorderSearch(final Node root, final Stack stack) {
        if (root != null) {
            inorderSearch(root.getLeft(), stack);
            stack.push(root.getKey());
            inorderSearch(root.getRight(), stack);
        }
    }

    private static LLNode<Integer> createLLNode(int n) {
        LLNode<Integer> llNode = new LLNode();
        llNode.setData(n);
        return llNode;
    }

    private static LLNode<Integer> createLLNode(LLNode<Integer> previous, int n) {
        LLNode<Integer> llNode = new LLNode();
        llNode.setData(n);
        previous.setNext(llNode);
        llNode.setPrevious(previous);
        return llNode;
    }

}
