package com.arjun.interviewbit.reverse_the_string;

public class Solution {
  public String solve(String A) {
    String[] words = A.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) {
      sb.append(words[i].trim());

      if (words[i].trim().length() > 0 && sb.length() > 0) {
        sb.append(" ");
      }
    }
    return sb.toString().trim();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(
        solution.solve(
            "qxkpvo  f   w vdg t wqxy ln mbqmtwwbaegx   mskgtlenfnipsl bddjk znhksoewu zwh bd fqecoskmo"));

    solution = new Solution();
    System.out.println(solution.solve("        the sky is blue"));

    solution = new Solution();
    System.out.println(solution.solve("the wwew 32 33   "));

    solution = new Solution();
    System.out.println(solution.solve("   the sky is blue   "));
  }
}
