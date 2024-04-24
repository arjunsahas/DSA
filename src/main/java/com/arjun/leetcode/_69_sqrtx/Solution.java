package com.arjun.leetcode._69_sqrtx;

class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        long prevSquare, square = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            prevSquare = square;
            square = (long)i * (long)i;
            if (square == x) {
                return i;
            } else if (prevSquare < x && square > x) {
                return i - 1;
            }
        }
        return (int)square;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(4));
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(15));
        System.out.println(solution.mySqrt(16));
        System.out.println(solution.mySqrt(11212121));
        System.out.println(solution.mySqrt(2147483647));

    }
}