package com.arjun.leetcode.two_sum;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] nums1 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums1);
        int[] result = new int[2];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1 ; j < nums1.length; j++) {
                if (nums1[i] < target && nums1[j] <= target) {
                    int sum = nums1[i] + nums1[j];
                    if (sum == target) {
                        result[0] = search(nums, nums1[i]);
                        result[1] = search(nums, nums1[j]);
                        return result;
                    }
                } else break;
            }
        }
        return result;
    }

    private int search(int[] ar, int key) {
        for(int i = 0; i < ar.length; i++) {
            if(key == ar[i]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = new Solution().twoSum(new int[]{11, 15, 0, 5, 10, 40}, 50);
        for (int i: ints) {
            System.out.print(i);
        }
    }
}