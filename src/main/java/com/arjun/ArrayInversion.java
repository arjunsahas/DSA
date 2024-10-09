package com.arjun;

import java.util.HashSet;
import java.util.Set;

/** Created by arjuns on 22/1/17. */
public class ArrayInversion {

  private static final int[] a = {5, 15, 10, 1, 7, 8};

  public static void main(String[] args) {
    arrayinversion(a, a.length);
  }

  private static void arrayinversion(final int[] a, int n) {
    Set<Integer> stack = new HashSet<>();
    int count = 0;
    int i = 0;
    while (i < n) {
      for (int j = i + 1; j < n - 1; j++) {
        if (a[i] > a[j]) {
          System.out.println(a[i] + "," + a[j]);
          boolean b1 = stack.add(a[i]);
          boolean b2 = stack.add(a[j]);
          if (!b2) {
            count++;
          }
        }
      }
      i++;
    }
    System.out.println(count);
  }
}
