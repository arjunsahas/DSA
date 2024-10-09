package com.arjun.leetcode._438_find_anagrams;

import java.util.*;

public class Solution {

  public List<Integer> findAnagrams(String s, String p) {
    Map<Character, Boolean> map = new HashMap<>();
    for (int i = 0; i < p.length(); i++) {
      map.put(p.charAt(i), false);
    }
    List<Integer> anagramIndex = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      int span = i;
      int jLength = (span + p.length()) <= s.length() ? span + p.length() : span;
      reset(map);
      for (int j = i; j < jLength; j++) {
        if (map.get(s.charAt(j)) == null) {
          break;
        } else {
          map.put(s.charAt(j), true);
        }
      }
      Boolean isAnagram = isAnagram(map.values());
      if (isAnagram) anagramIndex.add(i);
    }
    return anagramIndex;
  }

  private boolean isAnagram(Collection<Boolean> values) {
    Boolean isAnagram = true;
    for (Boolean value : values) {
      isAnagram = isAnagram && value;
    }
    return isAnagram;
  }

  private void reset(Map<Character, Boolean> map) {
    for (Character c : map.keySet()) {
      map.put(c, false);
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    List<Integer> anagrams = solution.findAnagrams("ababababab", "aab");
    System.out.println(anagrams);
  }
}
