package com.arjun.leetcode._198_house_robber;

public class Solution {

     public int rob(int[] nums) {
        return robFrom(nums, 0);

    }

    private int robFrom(int[] nums, int currentIndex) {
        if (currentIndex >= nums.length) {
            return 0;
        }

        // Choose to rob the current house and skip the next one
        int robCurrent = nums[currentIndex] + robFrom(nums, currentIndex + 2);
        // Choose not to rob the current house and move to the next one
        int skipCurrent = robFrom(nums, currentIndex + 1);

        // Return the maximum of the two choices
        return Math.max(robCurrent, skipCurrent);
    }

    // solve using dynamic programming
    public int robDP(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(sol.rob(nums1)); // Output: 4

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println(sol.rob(nums2)); // Output: 12

        // Additional test cases
        int[] nums3 = {2, 1, 1, 2};
        System.out.println(sol.rob(nums3)); // Output: 4

        int[] nums4 = {5, 3, 4, 11, 2};
        System.out.println(sol.rob(nums4)); // Output: 16
    }
    
}
