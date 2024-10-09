package com.arjun.algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

  static class IceCream implements Comparable {
    int flavor;
    int index;

    public IceCream(int flavor, int index) {
      this.flavor = flavor;
      this.index = index;
    }

    @Override
    public int compareTo(Object o) {
      if (o instanceof IceCream) {
        IceCream other = (IceCream) o;
        if (this.flavor == other.flavor) {
          return 0;
        } else if (this.flavor > other.flavor) {
          return 1;
        } else return -1;
      }
      return -1;
    }

    @Override
    public boolean equals(Object o) {
      if (o instanceof IceCream) {
        IceCream other = (IceCream) o;
        return this.flavor == other.flavor;
      }
      return false;
    }
  }

  public static int binarySearch(int first, int last, IceCream[] arr, int search) {
    int median = (first + last) / 2;
    // System.out.println("First "+ first +" Last "+last);
    // System.out.println("Median "+median);
    if (first != last) {
      if (search == arr[median].flavor) {
        return arr[median].index;
      } else if (search < arr[median].flavor) {
        return binarySearch(first, median, arr, search);
      } else {
        return binarySearch(median + 1, last, arr, search);
      }
    } else {
      if (search == arr[median].flavor) {
        return arr[median].index;
      } else return -1;
    }
  }

  public static void main(String[] args) {

    int t;
    int n, m;

    Scanner in = new Scanner(System.in);
    // trips
    t = in.nextInt();
    for (int test = 0; test < t; test++) {
      // money
      m = in.nextInt();
      n = in.nextInt();
      IceCream[] arr = new IceCream[n];

      for (int i = 0; i < n; i++) arr[i] = new IceCream(in.nextInt(), i + 1);

      Arrays.sort(arr);
      int firstIndex = 100000, secondIndex = 100000;
      for (int i = 0; i < n - 1; i++) {
        int search = m - arr[i].flavor;
        if (search >= arr[i].flavor) {
          int index = binarySearch(i + 1, n - 1, arr, search);
          if (index != -1) {
            System.out.println(Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
            break;
          }
        }
      }
    }
  }
}
