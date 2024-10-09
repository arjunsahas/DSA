package com.arjun.leetcode._300_longest_inc_subsequence;

import java.util.Arrays;

/** https://leetcode.com/problems/longest-increasing-subsequence */
class Solution1 {

  // There needs to be two variables
  //  a. one variable to increment to the next number
  //  b. one variable to keep track of the last known big number.
  //  c. we will keep track of all the subsequence combinations and choose the longest among them.
  public int lengthOfLIS(int[] nums) {
    if (nums.length == 1) return 1;
    int[][] memo = new int[nums.length][nums.length];
    for (int i = 0; i < memo.length; i++) Arrays.fill(memo[i], -1);
    return lengthOfLIS1(nums, -1, 0, memo);
  }

  private int lengthOfLIS1(int[] nums, int prev, int index, int[][] memo) {
    if (index == nums.length) {
      return 0;
    }

    if (prev != -1 && memo[prev][index] != -1) {
      return memo[prev][index];
    }
    int takeOption = 0;

    if (prev == -1 || nums[index] > nums[prev]) {
      takeOption = 1 + lengthOfLIS1(nums, index, index + 1, memo);
    }

    int skipOption = lengthOfLIS1(nums, prev, index + 1, memo);

    return prev != -1
        ? memo[prev][index] = Math.max(takeOption, skipOption)
        : Math.max(takeOption, skipOption);
  }

  public static void main(String[] args) {
    int i = new Solution1().lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18});
    System.out.println(i);

    i = new Solution1().lengthOfLIS(new int[] {0, 1, 0, 3, 2, 3});
    System.out.println(i);

    i = new Solution1().lengthOfLIS(new int[] {7, 7, 7, 7, 7, 7, 7});
    System.out.println(i);
  }
}
