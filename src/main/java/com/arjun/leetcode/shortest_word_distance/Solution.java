package com.arjun.leetcode.shortest_word_distance;

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        
        int count = 0;
        for( int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if(word.equals(word1)) {
                int jCount = 0;
                for (int j = i + 1; j < wordsDict.length; j++) {
                     word = wordsDict[j];
                    jCount++;
                    if(word.equals(word2)){
                        if(count == 0) {
                            count = jCount;
                        } else if (jCount < count) {
                            count = jCount;
                        }                        
                        break;
                    } 
                }
            } else if(word.equals(word2)) {
                 int jCount = 0;
                 for (int j = i + 1; j < wordsDict.length; j++) {
                     word = wordsDict[j];
                     jCount++;
                    if(word.equals(word1)){
                       if(count == 0) {
                            count = jCount;
                        } else if (jCount < count) {
                            count = jCount;
                        }  
                        break;
                    } 
                }
            }
        }
        return count;
    }
}