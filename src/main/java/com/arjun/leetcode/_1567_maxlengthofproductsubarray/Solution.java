package com.arjun.leetcode._1567_maxlengthofproductsubarray;

class Solution {
  public int getMaxLen(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1 && nums[0] > 0) return 1;
    if (nums.length == 1 && nums[0] < 0) return 0;
    int maxLength = 0;
    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      long product = 1;
      for (int j = i; j < nums.length; j++) {
        product = product * nums[j];
        count++;
        if (product > 0) {
          if (count > maxLength) maxLength = count;
        }
        if (j == 0 && nums[j] < 0 && nums[j + 1] > 0) {
          product = 1;
          count = 0;
        }
        if (product == 0) {
          product = 1;
          count = 0;
        }
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    //        int maxLen = new Solution().getMaxLen(new int[]{1, -2, -3, 4});
    //        int maxLen = new Solution().getMaxLen(new int[]{-1,-2,-3,0,1});
    int maxLen =
        new Solution()
            .getMaxLen(
                new int[] {
                  70, -18, 75, -72, -69, -84, 64, -65, 0, -82, 62, 54, -63, -85, 53, -60, -59, 29,
                  32, 59, -54, -29, -45, 0, -10, 22, 42, -37, -16, 0, -7, -76, -34, 37, -10, 2, -59,
                  -24, 85, 45, -81, 56, 86
                });

    System.out.println(maxLen);
  }
}
