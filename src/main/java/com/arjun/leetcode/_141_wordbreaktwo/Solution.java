package com.arjun.leetcode._141_wordbreaktwo;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break-ii/
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> results = new ArrayList<>();
        StringBuilder resultString = new StringBuilder();
        wordBreak(s, wordDict, resultString, results);
        resultString.delete(0, resultString.length());
        return results;
    }

    private void wordBreak(String inputString, List<String> wordDict, StringBuilder resultString, List<String> results) {
        if (inputString.length() == 0) {
            resultString.deleteCharAt(resultString.length() - 1);
            results.add(resultString.toString());
            return;
        }
        for (int i = 0; i <= inputString.length(); i++) {
            String makeWord = inputString.substring(0, i);
            for (String word : wordDict) {
                if (makeWord.equals(word)) {
                    resultString.append(makeWord).append(" ");
                    wordBreak(inputString.substring(i), wordDict, resultString, results);
                    int start = resultString.lastIndexOf(makeWord);
                    resultString.delete(start, start + makeWord.length() + 1);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = List.of("apple", "pen", "applepen", "pine", "pineapple");
        List<String> strings = new Solution().wordBreak(s, wordDict);
        System.out.println(strings);

        s = "a";
        wordDict = List.of("a");
        strings = new Solution().wordBreak(s, wordDict);
        System.out.println(strings);

        s = "catskicatcats";
        wordDict = List.of("cats", "cat", "dog", "ski");
        strings = new Solution().wordBreak(s, wordDict);
        System.out.println(strings);

        s = "catsandog";
        wordDict = List.of("cats","dog","sand","and","cat");
        strings = new Solution().wordBreak(s, wordDict);
        System.out.println(strings);
    }
}