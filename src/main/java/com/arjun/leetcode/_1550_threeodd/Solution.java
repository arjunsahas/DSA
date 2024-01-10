package com.arjun.leetcode._1550_threeodd;

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length < 3) return false;
        boolean isOdd = false;
        for (int i = 0; i < arr.length; i++) {
            int jLength = i + 3 < arr.length ? i + 3 : arr.length;
            isOdd = false;
            for (int j = i; j < jLength; j++) {
                if(arr[j] % 2 > 0) {
                    isOdd = true;
                } else{
                    isOdd = false;
                    break;
                }
            }
            if(isOdd) break;
        }
        return isOdd;
    }

    public static void main(String[] args) {
        boolean b = new Solution().threeConsecutiveOdds(new int[]{2, 3, 4, 5, 7, 9, 11, 15});
        System.out.println(b);
    }
}