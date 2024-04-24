package com.arjun.leetcode._66_plusone;

/**
 * https://leetcode.com/problems/plus-one
 */
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;
        int carryOver = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                int quoitient = (digits[i] + 1) / 10;
                if (quoitient > 0) {
                    digits[i] = digits[i] + 1 - 10;
                    carryOver = 1;
                } else{
                    digits[i] = digits[i] + 1;
                    carryOver = 0;
                }
            } else {
                int quoitient = (digits[i] + carryOver) / 10;
                if (quoitient > 0) {
                    digits[i] = digits[i] + carryOver - 10;
                    carryOver = 1;
                } else {
                    digits[i] = digits[i] + carryOver;
                    carryOver = 0;
                }
            }
        }
        if (carryOver == 1) {
            int[] newArray = new int[digits.length + 1];
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            newArray[0] = 1;
            return newArray;
        }
        return digits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] digits = {1, 2, 3};
        int[] result = solution.plusOne(digits);
        for (int i : result) {
            System.out.print(i + " ");
        }

        System.out.println();

        digits = new int[]{9};
        result = solution.plusOne(digits);
        for (int i : result) {
            System.out.print(i + " ");
        }

        System.out.println();

        digits = new int[]{9, 9};
        result = solution.plusOne(digits);
        for (int i : result) {
            System.out.print(i + " ");
        }

        System.out.println();

        digits = new int[]{7, 9, 9, 9, 9};
        result = solution.plusOne(digits);
        for (int i : result) {
            System.out.print(i + " ");
        }

        System.out.println();

        System.out.println(9 / 10);
    }
}