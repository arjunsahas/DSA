package com.arjun.algorithms.problems;

import java.util.Scanner;

public class CopyOfQuickSort {

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		partition(ar);
	}

	private static void partition(int[] ar) {
		int pivot = ar[ar.length - 1];
		// left scan
		int i = 0;
		int j = ar.length - 2;
		while (true) {
			while (ar[i] > pivot) {
				break;
			}
			while (ar[j] < pivot) {
				break;
			}
			if (i >= j)
				break;
			swap(ar, i, j);
			i++;
			j--;
		}
		swap(ar, ar.length - 1, j);
		printArray(ar);
	}

	private static void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

}
