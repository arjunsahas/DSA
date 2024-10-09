package com.arjun.algorithms.problems;

import java.util.Scanner;

public class ServiceLane {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int t = s.nextInt();
    int width[] = new int[n];
    for (int i = 0; i < width.length; i++) {
      width[i] = s.nextInt();
    }

    for (int c = 0; c < t; c++) {
      int i = s.nextInt();
      int j = s.nextInt();
      int smallestWidth = 0;
      for (int c1 = i; c1 <= j; c1++) {
        if (c1 == i) {
          smallestWidth = width[c1];
        }
        if (width[c1] < smallestWidth) {
          smallestWidth = width[c1];
        }
      }
      System.out.println(smallestWidth);
    }
  }
}
