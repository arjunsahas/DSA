package com.arjun.algorithms.sorting;

import java.util.Scanner;

public class InsertionSort {

  public static void insertionSortPart2(int[] ar) {
    for (int i = 1; i < ar.length; i++) {
      int key = ar[i];
      for (int j = i - 1; j >= 0; j--) {
        if (ar[j] > key) {
          ar[j + 1] = ar[j];
          ar[j] = key;
        } else {
          break;
        }
      }
      printArray(ar);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int[] ar = new int[s];
    for (int i = 0; i < s; i++) {
      ar[i] = in.nextInt();
    }
    insertionSortPart2(ar);
  }

  private static void printArray(int[] ar) {
    for (int n : ar) {
      System.out.print(n + " ");
    }
    System.out.println("");
  }
}
