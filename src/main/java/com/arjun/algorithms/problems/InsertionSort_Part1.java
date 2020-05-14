package com.arjun.algorithms.problems;

import java.util.Scanner;

public class InsertionSort_Part1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = s.nextInt();
        }
        print(list);
        int last = list[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (list[i] > last) {
                list[i + 1] = list[i];
                print(list);
            } else {
                list[i + 1] = last;
                print(list);
                break;
            }
        }
    }

    static void print(int[] n) {
        for (int i : n) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
