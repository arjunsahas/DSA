package com.arjun.interviewbit.math.bishop_moves;

/**
 * | * * * * * * * * | | * * * * * * * * | | * * * * * * * * | | * * * * * * * * | | * * * * * * * *
 * | | * * * * * * * * | | * * * * * * * * | | * * * * * * * * |
 */
public class Solution {
  public int solve(int A, int B) {
    int b1 = B <= 4 ? 8 - B : B - 1;
    int a1 = 3 * (A <= 4 ? (A - 1) : 8 - A);
    return a1 + b1;
  }

  public static void main(String[] args) {
    int moves = new Solution().solve(4, 5);
    System.out.println(moves);

    moves = new Solution().solve(4, 4);
    System.out.println(moves);

    moves = new Solution().solve(2, 2);
    System.out.println(moves);

    moves = new Solution().solve(6, 4);
    System.out.println(moves);

    moves = new Solution().solve(6, 1);
    System.out.println(moves);

    moves = new Solution().solve(1, 6);
    System.out.println(moves);
  }
}
