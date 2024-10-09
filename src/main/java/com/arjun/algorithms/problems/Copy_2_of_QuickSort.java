package com.arjun.algorithms.problems;

import java.util.Scanner;

public class Copy_2_of_QuickSort {

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
    for (int i = 0; i < ar.length; i++) {
      if (ar[i] > pivot) {
        for (int j = ar.length - 2; j > i; j--) {
          if (ar[j] < pivot) {
            int temp = ar[i];
            ar[i] = ar[j];
            ar[j] = temp;
          }
        }
      }
    }
    printArray(ar);
  }
}
