package com.arjun.leetcode._125_valid_palindrome;

class Solution {
    public boolean isPalindrome(String s) {
        if(s.isBlank() || s.isEmpty()) return true;
        int front = 0;
        int back = s.length() - 1;
        while (front != back && front < s.length() && back > 0) {
            char cFront = s.charAt(front);
            char cBack = s.charAt(back);

            // skip spaces and commas
            if (Character.isLetterOrDigit(cFront) && Character.isLetterOrDigit(cBack)) {
                if (Character.toLowerCase(cFront) != Character.toLowerCase(cBack)) {             // if capital, make it small and compare
                    return false;
                }
            } else if (!Character.isLetterOrDigit(cFront)) {
                front++;
                continue;
            } else if (!Character.isLetterOrDigit(cBack)) {
                back--;
                continue;
            }

            front++;
            back--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean palindrome = new Solution().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);

        palindrome = new Solution().isPalindrome("race a car");
        System.out.println(palindrome);

        palindrome = new Solution().isPalindrome("      ");
        System.out.println(palindrome);

        palindrome = new Solution().isPalindrome("daaaaaaad      ");
        System.out.println(palindrome);

        palindrome = new Solution().isPalindrome("aa");
        System.out.println(palindrome);

        palindrome = new Solution().isPalindrome("0P");
        System.out.println(palindrome);
    }
}