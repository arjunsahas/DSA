package com.arjun.leetcode.shortest_word_distance2;

class WordDistance {

  private String[] wordsDict;

  public WordDistance(String[] wordsDict) {
    this.wordsDict = wordsDict;
  }

  public int shortest(String word1, String word2) {
    int count = 0;
    for (int i = 0; i < wordsDict.length; i++) {
      String word = wordsDict[i];
      if (word.equals(word1)) {
        count = calculateDistance(i, word2, count);
      } else if (word.equals(word2)) {
        count = calculateDistance(i, word1, count);
      }
    }
    return count;
  }

  private int calculateDistance(int i, String inputWord, int count) {
    int jCount = 0;
    for (int j = i + 1; j < this.wordsDict.length; j++) {
      String word = wordsDict[j];
      jCount++;
      if (word.equals(inputWord)) {
        if (count == 0) {
          return jCount;
        } else if (jCount < count) {
          return jCount;
        }
        break;
      }
    }
    return count;
  }
}

/**
 * Your WordDistance object will be instantiated and called as such: WordDistance obj = new
 * WordDistance(wordsDict); int param_1 = obj.shortest(word1,word2);
 */
