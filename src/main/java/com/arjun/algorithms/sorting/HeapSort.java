package com.arjun.algorithms.sorting;

import java.util.Scanner;

public class HeapSort {
    private static void maxHeapify(int[] array, int i, int length) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int root = i;
        if (leftChild < length) {
            if (array[leftChild] > array[root]) {
                swap(array, leftChild, root);
                maxHeapify(array, leftChild, length);
            }
        }
        if (rightChild < length) {
            if (array[rightChild] > array[root]) {
                swap(array, rightChild, root);
                maxHeapify(array, rightChild, length);
            }
        }
        printArray(array);
    }

    private static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        int length = array.length;
        for (int i = (length - 1) / 2; i >= 0; i--) {
            maxHeapify(array, i, length);
        }
        int[] sortedArray = new int[array.length];
        int l = length;
        for (int i = l - 1; i >= 0; i--) {
            swap(array, 0, i);
            sortedArray[i] = array[i];
            maxHeapify(array, 0, --l);
        }
        printArray(sortedArray);
    }
}
