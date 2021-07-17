package com.arjun.leetcode.climbstairs;

import java.util.Arrays;

class Solution {
    public int climbStairs(int n) {
        int[] result = new int[n + 1];
        Arrays.fill(result, -1);
        climbStairs1(n, result);
        return result[n];
    }

    private int climbStairs1(int n, int[] result) {
        if (n == 1 || n == 0 || n == 2) {
            result[n] = n;
            return result[n];
        }
        if (result[n] != -1)
            return result[n];
        result[n] = climbStairs1(n - 1, result) + climbStairs1(n - 2, result);
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(45));
    }
}