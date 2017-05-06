package com.arjun.algorithms.problems;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation
 */
public class ArrayLeftRotation {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for (int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }

    public static int[] arrayLeftRotation(int a[], int n, int k) {
        int[] newArray = new int[n];
        int count = 0;
        for (int i = (n - k); i < newArray.length; i++) {
            newArray[i] = a[count];
            count++;
        }
        for (int i = 0; i < n - k; i++) {
            newArray[i] = a[k + i];
        }
        return newArray;
    }


}