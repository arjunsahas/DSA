package com.arjun.leetcode._53_maxsubarray;

/** Given an integer array nums, find the subarray with the largest sum, and return its sum. */
class Solution {
  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      max = Math.max(sum, max);
      if (sum < 0) {
        sum = 0;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int maxSubArray = new Solution().maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4});
    System.out.println(maxSubArray);

    maxSubArray = new Solution().maxSubArray(new int[] {-1, -1, -2, -3});
    System.out.println(maxSubArray);
  }
}
