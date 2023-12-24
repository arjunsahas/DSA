package com.arjun.leetcode.wordbreak139;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break/
 * <p>
 * To speed up this we can do memoisation. Here the memoisation can be of the particular string and the list of tokens
 * map<String,List<String>>
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> memo = new HashMap<>();
        return wordBreak(s, new HashSet<>(wordDict), memo);
    }

    private boolean wordBreak(String inputString, Set<String> wordDict, Map<String, Boolean> memo) {
        if (memo.containsKey(inputString)) {
            return memo.get(inputString);
        }
        if (inputString.length() == 0) {
            return true;
        }
        for (int i = 1; i <= inputString.length(); i++) {
            String makeWord = inputString.substring(0, i);
            if (wordDict.contains(makeWord) && wordBreak(inputString.substring(i), wordDict, memo)) {
                memo.put(makeWord, true);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = List.of("apple", "pen", "applepen", "pine", "pineapple");
        boolean strings = new Solution().wordBreak(s, wordDict);
        System.out.println(strings);

        s = "a";
        wordDict = List.of("a");
        strings = new Solution().wordBreak(s, wordDict);
        System.out.println(strings);

        s = "acaaaaabbbdbcccdcdaadcdccacbcccabbbbcdaaaaaadb";
        wordDict = List.of("abbcbda", "cbdaaa", "b", "dadaaad", "dccbbbc", "dccadd", "ccbdbc", "bbca", "bacbcdd", "a", "bacb", "cbc", "adc", "c", "cbdbcad", "cdbab", "db", "abbcdbd", "bcb", "bbdab", "aa", "bcadb", "bacbcb", "ca", "dbdabdb", "ccd", "acbb", "bdc", "acbccd", "d", "cccdcda", "dcbd", "cbccacd", "ac", "cca", "aaddc", "dccac", "ccdc", "bbbbcda", "ba", "adbcadb", "dca", "abd", "bdbb", "ddadbad", "badb", "ab", "aaaaa", "acba", "abbb");
        strings = new Solution().wordBreak(s, wordDict);
        System.out.println(strings);

        s = "catskicatcats";
        wordDict = List.of("cats", "cat", "dog", "ski");
        strings = new Solution().wordBreak(s, wordDict);
        System.out.println(strings);

        s = "catsandog";
        wordDict = List.of("cats", "dog", "sand", "and", "cat");
        strings = new Solution().wordBreak(s, wordDict);
        System.out.println(strings);

        s = "aaaaaaa";
        wordDict = List.of("aaaa", "aaa");
        strings = new Solution().wordBreak(s, wordDict);
        System.out.println(strings);
    }
}