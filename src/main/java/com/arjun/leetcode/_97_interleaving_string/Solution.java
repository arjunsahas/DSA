package com.arjun.leetcode._97_interleaving_string;

/**
 * https://leetcode.com/problems/interleaving-string
 * <p>
 * The base condition is that the substring of s1 and s2 needs to match with the s3 string.
 * <p>
 * The intuition is that you consider the substring of s1 or s2. The consideration is based on condition whether there is a
 * partiol match to the s3 string.
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

//        return checkInterleave(s1, s2, s3, 0, 0, "");
        return checkInterleave1(s1, s2, s3, 0, 0, 0);
    }

    private boolean checkInterleave(String s1, String s2, String s3, int i, int j, String result) {
        if (result.equals(s3)) return true;
        if (i == s1.length() && j == s2.length()) {
            return false;
        }

        char c = i < s1.length() ? s1.charAt(i) : ' ';
        char c1 = j < s2.length() ? s2.charAt(j) : ' ';
        boolean ret = false;
        if (s3.startsWith(result + c + c1) || s3.startsWith(result + c1 + c)) {
//            result = result + c + c1 + "";
//            i++;
//            j++;
            ret |= checkInterleave(s1, s2, s3, ++i, ++j, result + c + c1) || checkInterleave(s1, s2, s3, ++i, ++j, result + c1 + c);
        } else if (s3.startsWith(result + c + "")) {
//            result = result + c + "";
//            i++;
            ret |= checkInterleave(s1, s2, s3, ++i, j, result + c);
        } else if (s3.startsWith(result + c1 + "")) {
//            result = result + c1 + "";
//            j++;
            ret |= checkInterleave(s1, s2, s3, i, ++j, result + c1);
        }
        return ret;
    }

    private boolean checkInterleave1(String s1, String s2, String s3, int i, int j, int k) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        if (i >= s1.length() && j >= s2.length()) {
            return false;
        }
        if (k >= s3.length()) return false;

        char c = i < s1.length() ? s1.charAt(i) : ' ';
        char c1 = j < s2.length() ? s2.charAt(j) : ' ';
        char c2 = k < s3.length() ? s3.charAt(k) : ' ';
        boolean ret = false;
        if (c == c2 && c1 == c2) {
            System.out.print(c2);
            ret = checkInterleave1(s1, s2, s3, i + 1, j, k + 1) || checkInterleave1(s1, s2, s3, i, j + 1, k + 1);
        } else if (c2 == c1) {
            System.out.print(c2);
            ret = checkInterleave1(s1, s2, s3, i, j + 1, k + 1);
        } else if (c2 == c) {
            System.out.print(c2);
            ret = checkInterleave1(s1, s2, s3, i + 1, j, k + 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        boolean interleave = new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(interleave);
    }
}