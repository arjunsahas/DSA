package com.arjun.leetcode._1071_gcd;

import java.math.BigInteger;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) return str1;
        int str1Length = str1.length();
        int str2Length = str2.length();

        int lengthDiff = lengthDiff(str1, str2);
        if (lengthDiff != 0) {
            int gcd = getGCD(str1Length, str2Length);
            String basicString = getBasicString(str2, gcd);
            int str1X = str1Length / gcd;
            int str2X = str2Length / gcd;
            if (str1.equals(concatenate(basicString, str1X)) &&
                    str2.equals(concatenate(basicString, str2X))) {
                return basicString;
            } else return "";
        } else return "";
    }

    private int getGCD(int len1, int len2) {
        BigInteger big1 = new BigInteger(String.valueOf(len1));
        BigInteger big2 = new BigInteger(String.valueOf(len2));
        return big1.gcd(big2).intValue();
    }

    private int lengthDiff(String str1, String str2) {
        return str1.length() - str2.length();
    }

    private String getBasicString(String str, int len) {
        return str.substring(0, len);
    }

    private String concatenate(String str, int x) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < x; i++) {
            s.append(str);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(new Solution().gcdOfStrings("ABCABC", "ABC"));
        System.out.println(new Solution().gcdOfStrings("ARJUN", "SAHAS"));
    }
}