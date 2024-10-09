package com.arjun.leetcode._300_longest_inc_subsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** https://leetcode.com/problems/longest-increasing-subsequence */
class Solution {

  // There needs to be two variables
  //  a. one variable to increment to the next number
  //  b. one variable to keep track of the last known big number.
  //  c. we will keep track of all the subsequence combinations and choose the longest among them.
  public int lengthOfLIS(int[] nums) {
    if (nums.length == 1) return 1;
    Map<Integer, List<Integer>> integerArray = new HashMap<>();
    lengthOfLIS1(nums, -10001, 0, integerArray);
    int longestLength = 0;
    for (List<Integer> array : integerArray.values()) {
      if (array.size() > longestLength) {
        longestLength = array.size();
      }
    }
    return longestLength;
  }

  private void lengthOfLIS1(
      int[] nums,
      int lastLargeNumber,
      int combination,
      Map<Integer, List<Integer>> combinationMap) {
    if (combination == nums.length) {
      return;
    }
    for (int i = combination; i < nums.length; i++) {
      if (nums[i] > lastLargeNumber) {
        combinationMap.computeIfAbsent(combination, k -> new ArrayList<>());
        combinationMap.get(combination).add(nums[i]);
        lastLargeNumber = nums[i];
      }
      if (i + 1 == nums.length) lastLargeNumber = -10001;
    }
    lengthOfLIS1(nums, lastLargeNumber, ++combination, combinationMap);
  }

  public static void main(String[] args) {
    int i = new Solution().lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18});
    System.out.println(i);

    i = new Solution().lengthOfLIS(new int[] {0, 1, 0, 3, 2, 3});
    System.out.println(i);

    i = new Solution().lengthOfLIS(new int[] {7, 7, 7, 7, 7, 7, 7});
    System.out.println(i);
  }
}
