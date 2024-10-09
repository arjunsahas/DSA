package com.arjun.algorithms.sorting;

import java.util.Scanner;

public class QuickSort {

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
    int lo = 0;
    int hi = ar.length - 1;
    sort(ar, lo, hi);
  }

  public static void sort(int ar[], int lo, int hi) {
    if (hi <= lo) return;
    int j = partition(ar, lo, hi);
    sort(ar, lo, j - 1);
    sort(ar, j + 1, hi);
  }

  private static int partition(int[] ar, int lo, int hi) {
    int pivot = ar[hi];
    int i = lo;
    int j = hi - 1;
    // left scan
    while (i < j) {
      for (; i < hi - 1; i++) {
        if (ar[i] > pivot) {
          break;
        }
      }
      for (; j > i; j--) {
        if (ar[j] < pivot) {
          break;
        }
      }
      if (i >= j) break;
      swap(ar, i, j);
    }
    if (ar[j] > ar[hi]) swap(ar, j, hi);
    printArray(ar);
    System.out.println(j);
    return j;
  }

  private static void swap(int[] ar, int i, int j) {
    int temp = ar[i];
    ar[i] = ar[j];
    ar[j] = temp;
  }
}
