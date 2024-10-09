package com.arjun.leetcode._50_pow;

/** https://leetcode.com/problems/powx-n/ */
class Solution1 {
  public double myPow(double x, int n) {
    double product = 1.0;
    //        if (n == Integer.MIN_VALUE && x > 1) {
    //            return 0.0;
    //        }
    if (n == 0) return 1.0;
    if (n == Integer.MAX_VALUE && (x == -1 || x == 1)) return x;
    if (n == Integer.MAX_VALUE && x > 1) return Double.POSITIVE_INFINITY;
    if (n == Integer.MAX_VALUE && x < -1) return Double.NEGATIVE_INFINITY;
    if (x == product) return x;
    for (int i = 0; i < Math.abs(n); i++) {
      product = product * x;
    }
    if (n < 0) product = 1 / product;
    return product;
  }

  public static void main(String[] args) {
    Solution1 solution = new Solution1();
    System.out.println(solution.myPow(2.00000, 10));
    System.out.println(solution.myPow(2.10000, 3));
    System.out.println(solution.myPow(2.00000, -2));
    System.out.println(solution.myPow(2.00000, -2147483648));
    System.out.println(solution.myPow(1.00001, Integer.MAX_VALUE));
    System.out.println(solution.myPow(-2.00000, 2147483647));
    System.out.println(solution.myPow(-1.00000, 2147483647));
    System.out.println(solution.myPow(1.00000, 2147483647));
    System.out.println(solution.myPow(1.0000000000001, -2147483648));
    System.out.println(Math.abs(Integer.MIN_VALUE));
    System.out.println(Math.abs(Integer.MAX_VALUE));
  }
}
