package com.arjun.leetcode.contest._100200_earliest_second;

class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        for (int i = 1; i < changeIndices.length; i++) {
            int modulo = i % (nums.length - 1);

            if (modulo != 0) {
                if (nums[modulo] > 0) {
                    nums[modulo] = nums[modulo] - 1;
                }
                if (nums[modulo] == 0) {
                    if (nums[changeIndices[i]] == 0) changeIndices[i] = 0;
                }
            } else continue; // skip zero
        }
        for (int i = changeIndices.length - 1; i >= 1; i--) {
            if (changeIndices[i] == 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new Solution().earliestSecondToMarkIndices(new int[]{-1, 2, 2, 0}, new int[]{-1, 2, 2, 2, 2, 3, 2, 2, 1});
        System.out.println(i);

        i = new Solution().earliestSecondToMarkIndices(new int[]{-1, 1, 3}, new int[]{1, 1, 1, 2, 1, 1, 1});
        System.out.println(i);

    }
}