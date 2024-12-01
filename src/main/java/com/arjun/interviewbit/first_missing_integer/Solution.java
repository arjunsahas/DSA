package com.arjun.interviewbit.first_missing_integer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/first-missing-integer/
 *
 * <p>Intuition: sort the array first as the array is unsorted. ignore numbers till zero and start
 * counting from the positive numbers. the first positive number in the count which is missing in
 * the input is the answer or if no numbers are missing, then the latest count value is the answer.
 */
public class Solution {

  public int firstMissingPositive(ArrayList<Integer> A) {
    Collections.sort(A);
    int positiveCount = 1;
    for (int i = 0; i < A.size(); i++) {
      int val = A.get(i);
      if (val > 0) {
        if (positiveCount != A.get(i)) {
          return positiveCount;
        }
        positiveCount++;
      }
    }
    return positiveCount;
  }

  public static void main(String[] args) {
    int missingFirstNumber = new Solution().firstMissingPositive(new ArrayList<>(List.of(1, 2, 0)));
    System.out.println(missingFirstNumber);

    missingFirstNumber = new Solution().firstMissingPositive(new ArrayList<>(List.of(3, 4, -1, 1)));
    System.out.println(missingFirstNumber);

    missingFirstNumber = new Solution().firstMissingPositive(new ArrayList<>(List.of(-8, -7, -6)));
    System.out.println(missingFirstNumber);
  }
}
