package com.arjun.interviewbit.math.verify_prime;

public class Solution {
  public int isPrime(int A) {
    if (A == 0 || A == 1) return 0;
    if (A % 2 == 0) return 0;
    double sqrt = Math.ceil(Math.sqrt(A));
    for (int i = 2; i <= sqrt; i++) {
      if (A % i == 0) return 0;
    }
    return 1;
  }

  public static void main(String[] args) {
    int isPrime = new Solution().isPrime(7);
    System.out.println(isPrime);

    isPrime = new Solution().isPrime(10);
    System.out.println(isPrime);

    isPrime = new Solution().isPrime(15);
    System.out.println(isPrime);

    isPrime = new Solution().isPrime(2223);
    System.out.println(isPrime);
  }
}
