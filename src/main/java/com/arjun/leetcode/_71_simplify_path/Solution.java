package com.arjun.leetcode._71_simplify_path;

public class Solution {
  public String simplifyPath(String path) {
    return null;
  }

  public static void main(String[] args) {
    String s = new Solution().simplifyPath("/home/");
    String s1 = new Solution().simplifyPath("/../");
    String s2 = new Solution().simplifyPath("/home//foo/");
  }
}
