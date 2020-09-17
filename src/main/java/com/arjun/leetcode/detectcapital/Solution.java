package com.arjun.leetcode.detectcapital;

class Solution {
    public boolean detectCapitalUse(String word) {
        boolean isTitleCase = isTitleCase(word);
        if (isTitleCase) return isTitleCase;
        boolean isSmallLetters = isSmallLetters(word);
        if (isSmallLetters) return isSmallLetters;
        boolean isAllCapital = isAllCapital(word);
        if (isAllCapital) return isAllCapital;
        return false;
    }

    private boolean isTitleCase(String word) {
        boolean isTitleCase = true;
        isTitleCase = isTitleCase && Character.isUpperCase(word.charAt(0));
        isTitleCase = isTitleCase && isSmallLetters(word.substring(1));
        return isTitleCase;
    }

    private boolean isSmallLetters(String word) {
        boolean isLowerCase = true;
        for (char c : word.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return isLowerCase;
    }

    private boolean isAllCapital(String word) {
        boolean isUpperCase = true;
        for (char c : word.toCharArray()) {
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        return isUpperCase;
    }

    public static void main(String[] args) {
        new Solution().detectCapitalUse("ArjunA");
    }
}