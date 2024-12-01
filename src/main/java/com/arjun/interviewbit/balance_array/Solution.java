package com.arjun.interviewbit.balance_array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://www.interviewbit.com/problems/balance-array/
 *
 * <p>The intuition is that as the elements are removed, the odd numbers become even and even
 * becomes odd. So, We have to balance them in imaginary buckets by adding current odd number to
 * even sum and removing the current (i) number and vice-versa. This is from a existing solution.
 */
public class Solution {
  public int solve(ArrayList<Integer> A) {

    int specialElement = 0;

    int oddSum = 0;
    int evenSum = 0;
    for (int i = 0; i < A.size(); i++) {
      if (i % 2 == 0) {
        evenSum += A.get(i);
      } else oddSum += A.get(i);
    }

    int currEvenSum = 0, currOddSum = 0; // stores sum upto curr index

    for (int i = 0; i < A.size(); i++) {

      if (i % 2 == 0) { // even element removed
        currEvenSum += A.get(i);

        // remove currElement from evenSum and add consecutive odd elements sum to buck1
        int buck1 = currEvenSum - A.get(i) + oddSum - currOddSum;

        // add consecutive even elements sum to buck2
        int buck2 = currOddSum + evenSum - currEvenSum;
        if (buck1 == buck2) {
          specialElement++;
        }

      } else { // odd element removed
        currOddSum += A.get(i);

        // add consecutive odd elements sum to buck1
        int buck1 = currEvenSum + oddSum - currOddSum;

        // remove currElement from oddSum and add consecutive even elements sum to buck2
        int buck2 = currOddSum - A.get(i) + evenSum - currEvenSum;
        if (buck1 == buck2) {
          specialElement++;
        }
      }
    }
    return specialElement;
  }

  public static void main(String[] args) {
    int solve = new Solution().solve(new ArrayList<>(Arrays.asList(2, 1, 6, 4)));
    System.out.println(solve);

    solve = new Solution().solve(new ArrayList<>(Arrays.asList(5, 5, 2, 5, 8)));
    System.out.println(solve);
  }
}
