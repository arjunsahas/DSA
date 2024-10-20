package com.arjun.interviewbit.perfect_peak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/perfect-peak-of-array/
 *
 * <p>This is a slight improvement over version 2 where one array is replaced with a pointer. This
 * calculates max for every iteration making the complexity O(n2)
 */
public class Solution2 {
  public int perfectPeak(ArrayList<Integer> A) {
    int isPerfectPeak = 0;

    List<Integer> maxGroup = new ArrayList<>();

    for (int i = 1; i < A.size(); i++) {
      maxGroup.add(A.get(i));
    }

    int maxFromMinGroup = A.get(0);
    int minFromMaxGroup;
    for (int i = 1; i < A.size() - 1; i++) {

      Integer num = maxGroup.get(0);
      if (0 < maxGroup.size()) maxGroup.remove(0);
      minFromMaxGroup = Collections.min(A.subList(i + 1, A.size()));

      if (maxFromMinGroup < num && minFromMaxGroup > num) {
        isPerfectPeak = 1;
        break;
      } else {
        if (num > maxFromMinGroup) maxFromMinGroup = num;
      }
    }

    return isPerfectPeak;
  }

  public static void main(String[] args) {
    int isPerfectPeak =
        new Solution2().perfectPeak(new ArrayList<>(Arrays.asList(5, 1, 4, 3, 6, 8, 10, 7, 9)));
    System.out.println(isPerfectPeak);

    isPerfectPeak = new Solution2().perfectPeak(new ArrayList<>(Arrays.asList(5, 1, 4, 4)));
    System.out.println(isPerfectPeak);

    isPerfectPeak =
        new Solution2()
            .perfectPeak(
                new ArrayList<>(
                    Arrays.asList(
                        5706, 26963, 24465, 29359, 16828, 26501, 28146, 18468, 9962, 2996, 492,
                        11479, 23282, 19170, 15725, 6335)));
    System.out.println(isPerfectPeak);

    isPerfectPeak =
        new Solution2()
            .perfectPeak(
                new ArrayList<>(
                    Arrays.asList(
                        9895, 30334, 17674, 23812, 20038, 25668, 6869, 1870, 4665, 27645, 7712,
                        17036, 31323, 8724, 28254, 28704, 26300, 25548, 15142, 12860, 19913, 32663,
                        32758)));
    System.out.println(isPerfectPeak);
  }
}
