package com.arjun.interviewbit.duplicate_in_array;

import java.util.List;

/**
 * https://www.interviewbit.com/problems/find-duplicate-in-array/
 *
 * <p>Given a read-only array of n + 1 integers between 1 and n, find one number that repeats in
 * linear time using less than O(n) space and traversing the stream sequentially O(1) times.
 *
 * <p>If there are multiple possible answers ( like in the sample case ), output any one, if there
 * is no duplicate, output -1
 */
public class Solution {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public int repeatedNumber(final List<Integer> A) {
    int slow = A.get(0);
    int fast = A.get(A.get(0));
    while (slow != fast) {
      slow = A.get(slow);
      fast = A.get(A.get(fast));
    }

    fast = 0;
    while (slow != fast) {
      slow = A.get(slow);
      fast = A.get(fast);
    }
    if (slow == 0) return -1;
    return slow;
  }

  public static void main(String[] args) {
    int duplicate = new Solution().repeatedNumber(List.of(3, 5, 3, 3, 2, 1));
    System.out.println(duplicate);
  }
}
