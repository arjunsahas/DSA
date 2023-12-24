package com.arjun.leetcode.wordbreak139;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break/
 * <p>
 * To speed up this we can do memoisation. Here the memoisation can be of the particular string and the list of tokens
 * map<String,List<String>>
 */
class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        List<String> results = new ArrayList<>();
        StringBuilder resultString = new StringBuilder();
        Map<String, String> memoise = new HashMap<>();
        wordBreak(s, new HashSet<>(wordDict), resultString, results, memoise);
        resultString.delete(0, resultString.length());
        return results.size() > 0;
    }

    private void wordBreak(String inputString, Set<String> wordDict, StringBuilder resultString, List<String> results, Map<String, String> memoise) {
        if (resultString.toString().length() > 0) {
            resultString.deleteCharAt(resultString.length() - 1);
            results.add(resultString.toString());
            return;
        }
        for (int i = 0; i <= inputString.length(); i++) {
            String makeWord = inputString.substring(0, i);
            if (!memoise.containsKey(makeWord)) {
                for (String word : wordDict) {
                    if (makeWord.equals(word)) {
                        memoise.putIfAbsent(makeWord, word);
                        processWord(inputString, wordDict, resultString, results, memoise, i, makeWord);
                        break;
                    }
                }
            } else {
                String token = memoise.get(makeWord);
                processWord(inputString, wordDict, resultString, results, memoise, i, token);
                break;

            }
        }
    }

    private void processWord(String inputString, Set<String> wordDict, StringBuilder resultString, List<String> results, Map<String, String> memoise, int i, String token) {
        resultString.append(token).append(" ");
        wordBreak(inputString.substring(i), wordDict, resultString, results, memoise);
        int start = resultString.lastIndexOf(token);
        resultString.delete(start, start + token.length() + 1);
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = List.of("apple", "pen", "applepen", "pine", "pineapple");
        boolean strings = new Solution1().wordBreak(s, wordDict);
        System.out.println(strings);

        s = "a";
        wordDict = List.of("a");
        strings = new Solution1().wordBreak(s, wordDict);
        System.out.println(strings);

        s = "acaaaaabbbdbcccdcdaadcdccacbcccabbbbcdaaaaaadb";
        wordDict = List.of("abbcbda", "cbdaaa", "b", "dadaaad", "dccbbbc", "dccadd", "ccbdbc", "bbca", "bacbcdd", "a", "bacb", "cbc", "adc", "c", "cbdbcad", "cdbab", "db", "abbcdbd", "bcb", "bbdab", "aa", "bcadb", "bacbcb", "ca", "dbdabdb", "ccd", "acbb", "bdc", "acbccd", "d", "cccdcda", "dcbd", "cbccacd", "ac", "cca", "aaddc", "dccac", "ccdc", "bbbbcda", "ba", "adbcadb", "dca", "abd", "bdbb", "ddadbad", "badb", "ab", "aaaaa", "acba", "abbb");
        strings = new Solution1().wordBreak(s, wordDict);
        System.out.println(strings);

        s = "catskicatcats";
        wordDict = List.of("cats", "cat", "dog", "ski");
        strings = new Solution1().wordBreak(s, wordDict);
        System.out.println(strings);

        s = "catsandog";
        wordDict = List.of("cats","dog","sand","and","cat");
        strings = new Solution1().wordBreak(s, wordDict);
        System.out.println(strings);
    }
}