package com.arjun.algorithms.problems;

import java.util.Scanner;

public class UtopianTree {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = 0;
		int input = 0;
		t = s.nextInt();
		for (int i = 0; i < t; i++) {
			input = s.nextInt();
			int initTreeHeight = 1;
			int count = 0;
			for (int j = 0; j < input; j++) {
				count = j + 1;
				if (count % 2 == 0) {
					initTreeHeight = initTreeHeight + 1;
				} else {
					initTreeHeight = initTreeHeight + initTreeHeight;
				}
			}
			System.out.println(initTreeHeight);
		}
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
	}
}