package com.arjun.leetcode._1456_max_vowels;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int maxVowels(String s, int k) {
    int maxVowelCount = 0;
    int prevVowelCount = 0;
    String vowels = "aeiou";
    Map<Character, Boolean> map = new HashMap<>();
    for (int i = 0; i < vowels.length(); i++) {
      map.put(vowels.charAt(i), false);
    }
    for (int i = 0; i < s.length(); i++) {
      int jLength = (i + k) <= s.length() ? i + k : i;
      int localVowelCount = 0;
      if (i == 0) {
        for (int j = i; j < jLength; j++) {
          if (map.get(s.charAt(j)) != null) {
            localVowelCount++;
            if (j > i) {
              prevVowelCount++;
            }
          }
          // System.out.println(s.charAt(j));
          // System.out.println(localVowelCount);
          if (localVowelCount > maxVowelCount) {
            maxVowelCount = localVowelCount;
          }
        }
      } else {
        if (map.get(s.charAt(jLength)) != null) {
          localVowelCount++;
        }
        localVowelCount = localVowelCount + prevVowelCount;
        if (localVowelCount > maxVowelCount) {
          maxVowelCount = localVowelCount;
        }
        prevVowelCount = localVowelCount;
      }
    }
    return maxVowelCount;
  }

  public static void main(String[] args) {}
}
