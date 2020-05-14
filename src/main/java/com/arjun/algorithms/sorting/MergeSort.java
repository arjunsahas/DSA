package com.arjun.algorithms.sorting;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        mergesort(array, 0, array.length - 1);
        printArray(array);
    }

    private static void mergesort(int[] array, int l, int r) {
        if (l < r) {
            int middle = (l + r) / 2;
            mergesort(array, l, middle);
            mergesort(array, middle + 1, r);
            merge(array, l, middle, r);
        }
    }

    private static void merge(int[] array, int l, int middle, int r) {
        int n1 = middle - l + 1;
        int[] subArray1 = new int[n1];
        System.arraycopy(array, l, subArray1, 0, n1);

        int n2 = r - middle;
        int[] subArray2 = new int[n2];
        System.arraycopy(array, middle + 1, subArray2, 0, n2);

        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (subArray1[i] <= subArray2[j]) {
                array[k] = subArray1[i];
                i++;
            } else {
                array[k] = subArray2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = subArray1[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = subArray2[j];
            j++;
            k++;
        }

    }

    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
