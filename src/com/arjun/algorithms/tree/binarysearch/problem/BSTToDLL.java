package com.arjun.algorithms.tree.binarysearch.problem;

import java.util.Scanner;
import java.util.Stack;

import com.arjun.algorithms.tree.binarysearch.BinarySearchTreeOperations;

import com.arjun.algorithms.linkedlist.doubly.DoublyLinkedList.LLNode;

import static com.arjun.algorithms.tree.binarysearch.BinarySearchTree.Node;


/**
 * Created by arjuns on 23/4/17.
 */
public class BSTToDLL {

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

//        LLNode<Integer> llNode = convertBSTToDLL(root);
//        while (llNode.getNext() != null) {
//            System.out.println(llNode.getData());
//        }

        Stack<Integer> stack = new Stack();
        inorderSearch(root, stack);


        for (Integer i : stack) {
            System.out.println(i);

        }
    }

    private static void inorderSearch(final Node root, final Stack stack) {
        if (root != null) {
            inorderSearch(root.getLeft(), stack);
            stack.push(root.getKey());
            inorderSearch(root.getRight(), stack);
        }
    }

    private static LLNode<Integer> convertBSTToDLL(Node root) {
        LLNode<Integer> llNode = createLLNode(root);
        convertBSTToDLL(root.getLeft(), llNode);
        if (root.getRight() != null) {
            root = root.getRight();
            convertBSTToDLL(root, getLast(llNode));
        }
        return llNode;
    }

    private static void convertBSTToDLL(final Node root, final LLNode<Integer> llNode) {
        if (root != null) {
            LLNode<Integer> llNode1 = createLLNode(llNode, root);
            convertBSTToDLL(root.getLeft(), llNode1);
            convertBSTToDLL(root.getRight(), llNode1);
        }
    }

    private static LLNode<Integer> createLLNode(Node n) {
        LLNode<Integer> llNode = new LLNode();
        llNode.setData(n.getKey());
        return llNode;
    }

    private static LLNode<Integer> createLLNode(LLNode<Integer> previous, Node n) {
        LLNode<Integer> llNode = new LLNode();
        llNode.setData(n.getKey());
        previous.setNext(llNode);
        if (llNode.getPrevious() != null)
            llNode.setPrevious(previous);
        return llNode;
    }

    private static LLNode<Integer> getLast(final LLNode<Integer> llNode) {
        LLNode llNode1 = llNode;
        LLNode last = null;
        while (llNode1.getNext() != null) {
            llNode1 = llNode1.getNext();
            last = llNode1;
        }
        return last;
    }
}
