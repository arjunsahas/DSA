package com.arjun.leetcode.shortest_word_distance2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution1 {

  class WordDistance {

    private String[] wordsDict;
    private Map<String, Set<Integer>> wordVsPositions;

    public WordDistance(String[] wordsDict) {
      this.wordsDict = wordsDict;
      wordVsPositions = new HashMap<>();
    }

    public int shortest(String word1, String word2) {
      int minDistance = wordsDict.length;

      Set<Integer> positions1 = wordVsPositions.get(word1);
      Set<Integer> positions2 = wordVsPositions.get(word2);

      if (positions1 != null && positions2 != null) {
        List<Integer> pos1List = new ArrayList(positions1);
        List<Integer> pos2List = new ArrayList(positions2);

        int pos1 = -1;
        int pos2 = -1;
        for (int i = 0; i < pos1List.size(); i++) {
          for (int j = 0; j < pos2List.size(); j++) {
            if (pos1List.get(i) < pos1List.get(j)) {
              minDistance = Math.min(pos1List.get(i), pos2List.get(j));
              break;
            }
          }
        }
        return minDistance;
      }

      int pos1 = -1;
      int pos2 = -1;
      for (int i = 0; i < wordsDict.length; i++) {
        if (word1.equals(wordsDict[i])) {
          pos1 = i;
          storeCache(word1, pos1);
        } else if (word2.equals(wordsDict[i])) {
          pos2 = i;
          storeCache(word2, pos2);
        }
        if (pos1 != -1 && pos2 != -1) {
          minDistance = Math.min(minDistance, Math.abs(pos2 - pos1));
        }
      }
      return minDistance;
    }

    private void storeCache(String word, int position) {
      Set<Integer> positions = wordVsPositions.get(word);
      if (positions != null) {
        positions.add(position);
      } else {
        positions = new TreeSet<>();
        positions.add(position);
      }
    }
  }
}
