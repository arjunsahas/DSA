package com.arjun.leetcode._35_search_insert;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid -1;
            } else if (target == nums[mid]) {
                return mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        new Solution().searchInsert(new int[]{1, 3, 5, 6}, 5);
    }
}
