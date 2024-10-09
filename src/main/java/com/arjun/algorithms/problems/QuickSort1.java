package com.arjun.algorithms.problems;

import java.util.Scanner;

public class QuickSort1 {

  static void partition(int[] ar) {
    int n = ar.length;
    int pivot = ar[0];
    int rem = n - 1;
    int subArrayLength = 0;
    int pivotPlace = 0;
    if (rem % 2 == 0) {
      subArrayLength = rem / 2;
      pivotPlace = subArrayLength;
    } else {
      subArrayLength = n / 2;
    }
    int[] subArray1 = new int[subArrayLength];
    int[] subArray2 = new int[subArrayLength];
    int subArrayCount1 = 0;
    int subArrayCount2 = 0;
    for (int i = 1; i < ar.length; i++) {
      if (ar[i] > pivot) {
        subArray2[subArrayCount2] = ar[i];
        subArrayCount2++;
      } else {
        subArray1[subArrayCount1] = ar[i];
        subArrayCount1++;
      }
    }
    if (rem % 2 == 0) {
      System.arraycopy(subArray1, 0, ar, 0, subArray1.length);
      System.arraycopy(subArray2, 0, ar, subArray1.length + 1, subArray1.length);
      ar[pivotPlace] = pivot;
    } else {
      System.arraycopy(subArray1, 0, ar, 0, subArrayCount1);
      System.arraycopy(subArray2, 0, ar, subArrayCount1 + 1, subArrayCount2);
      ar[subArrayCount1] = pivot;
    }
    printArray(ar);
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
    int[] ar = new int[n];
    for (int i = 0; i < n; i++) {
      ar[i] = in.nextInt();
    }
    partition(ar);
  }
}
