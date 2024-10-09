package com.arjun.interviewbit.noble_integer;

import java.util.Arrays;

/**
 * Given an integer array A, find if an integer p exists in the array such that the number of
 * integers greater than p in the array equals to p.
 */
public class Solution {
  public int solve(int[] A) {
    if (A.length == 1 && A[0] > 0) return 1;
    if (A.length == 1 && A[0] < 0) return -1;
    Arrays.sort(A);
    System.out.println(Arrays.toString(A));
    for (int i = 0; i < A.length; i++) {
      if (i < A.length - 1 && A[i] == A[i + 1]) {
        continue;
      }
      if (A[i] == A.length - i - 1) {
        return 1;
      }
    }
    return -1;
  }

  public int findNobleInteger(int[] A) {
    Arrays.sort(A); // Sort the array in ascending order

    int n = A.length;

    // Iterate from the end to count elements greater than the current element
    for (int i = n - 1; i >= 0; i--) {
      if (A[i] == n - i - 1) { // Check if the count matches the element
        return 1;
      }
    }

    return -1; // If no noble integer is found
  }

  public static void main(String[] args) {
    int solve = new Solution().solve(new int[] {3, 2, 1, 3});
    System.out.println(solve);
    solve = new Solution().solve(new int[] {1, 1, 3, 3});
    System.out.println(solve);
    solve = new Solution().solve(new int[] {1, 1, 3, 5, 7, 7, 6, 4, 2, 1});
    System.out.println(solve);
    solve = new Solution().solve(new int[] {-4, -2, 0, -1, -6});
    System.out.println(solve);
    solve = new Solution().solve(new int[] {-4, -2, -1, -1, -6});
    System.out.println(solve);
    solve = new Solution().solve(new int[] {-4, -2, 1, -1, -6});
    System.out.println(solve);
    solve = new Solution().solve(new int[] {-1, -2, 0, 0, 0, -3});
    System.out.println(solve);
    solve = new Solution().findNobleInteger(new int[] {-1, -2, 0, 0, 0, -3});
    System.out.println(solve);
    solve =
        new Solution()
            .solve(
                new int[] {
                  -4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1,
                  -8, 0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8,
                  -6, 5, 0, 3, -4, 1, -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7,
                  -6, 5, -8, -5, 4, -3, 4, -6, -7, 0, -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6,
                  -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8, 7, 2, 2, 6, -9, -10, -4, -9,
                  -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4, -5, -4, -7, 9,
                  -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2,
                  -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5
                });
    System.out.println(solve);
  }
}
