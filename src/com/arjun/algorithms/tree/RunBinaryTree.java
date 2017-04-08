package com.arjun.algorithms.tree;

import java.util.Scanner;

import com.arjun.algorithms.tree.BinarySearchTree.Node;

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
		BinarySearchTree tree = new BinarySearchTree();
		for (int i : ar) {
			Node z = new Node();
			z.setKey(i);
			BinaryTreeOperations.insert(tree, z);
		}

		// inorder tree walk
		BinaryTreeOperations.inorderTreeWalk(tree.getRoot());
		int k = 99;

		// Tree search
		Node x = BinaryTreeOperations.treeSearch(tree.getRoot(), k);
		System.out.println("Node found: " + x);

		// Tree minimum
		Node min = BinaryTreeOperations.treeMinimum(tree.getRoot());
		System.out.println("Minimum node: " + min);

		// Tree maximum
		Node max = BinaryTreeOperations.treeMaximum(tree.getRoot());
		System.out.println("Maximum node : " + max);

		// Successor
		k = 9;
		x = BinaryTreeOperations.treeSearch(tree.getRoot(), k);
		Node successor = BinaryTreeOperations.successor(x);
		System.out.println("Successor is : " + successor);

		// Predecessor
		k = 17;
		x = BinaryTreeOperations.treeSearch(tree.getRoot(), k);
		Node predecessor = BinaryTreeOperations.predecessor(x);
		System.out.println("Predecessor is: " + predecessor);

	}
}
