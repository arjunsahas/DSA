package com.arjun.leetcode._50_pow;

class Solution {
    public double myPow(double x, int n) {
        double product = 1.0;
        // System.out.println(Math.abs(n));
        if (x == product) return x;
        if (Math.abs(n) < 0) return 0.0;
        for (int i = 0; i < Math.abs(n); i++) {
            product = product * x;
            // System.out.println(product);
        }
        if (n < 0) product = 1 / product;
        return product;
    }
}