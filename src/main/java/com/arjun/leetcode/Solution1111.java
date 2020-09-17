package com.arjun.leetcode;

public class Solution1111 {

    static int log(int x, int base)
    {
        return (int) (Math.log(x) / Math.log(base));
    }

    public static void main(String[] args) {
        System.out.println(log(8, 2));

        System.out.println(Math.pow(2,3) == 8);
    }
}
