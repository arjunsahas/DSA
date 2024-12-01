package com.arjun.interviewbit.perfect_peak;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://www.interviewbit.com/problems/perfect-peak-of-array/ The solution is a O(n2) solution.
 *
 * <p>The solution simply iterates over the array and compares whether the integers before it is
 * lesser than "i" and the integers after it is greater than "i".
 */
public class Solution {
  public int perfectPeak(ArrayList<Integer> A) {
    int isPerfectPeak = 0;
    for (int i = 0; i < A.size(); i++) {
      int num = A.get(i);
      isPerfectPeak = 0;
      for (int j = 0; j < A.size(); j++) {
        if (i == j) continue;
        if ((num > A.get(j) && i > j) || (num < A.get(j) && i < j)) {
          isPerfectPeak = 1;
        } else {
          isPerfectPeak = 0;
          break;
        }
      }
      if (isPerfectPeak == 1) {
        System.out.println(num);
        break;
      }
    }

    return isPerfectPeak;
  }

  public static void main(String[] args) {
    int isPerfectPeak =
        new Solution().perfectPeak(new ArrayList<>(Arrays.asList(5, 1, 4, 3, 6, 8, 10, 7, 9)));
    System.out.println(isPerfectPeak);

    isPerfectPeak = new Solution().perfectPeak(new ArrayList<>(Arrays.asList(5, 1, 4, 4)));
    System.out.println(isPerfectPeak);

    isPerfectPeak =
        new Solution()
            .perfectPeak(
                new ArrayList<>(
                    Arrays.asList(
                        5706, 26963, 24465, 29359, 16828, 26501, 28146, 18468, 9962, 2996, 492,
                        11479, 23282, 19170, 15725, 6335)));
    System.out.println(isPerfectPeak);

    isPerfectPeak =
        new Solution()
            .perfectPeak(
                new ArrayList<>(
                    Arrays.asList(
                        9895, 30334, 17674, 23812, 20038, 25668, 6869, 1870, 4665, 27645, 7712,
                        17036, 31323, 8724, 28254, 28704, 26300, 25548, 15142, 12860, 19913, 32663,
                        32758)));
    System.out.println(isPerfectPeak);
  }
}
