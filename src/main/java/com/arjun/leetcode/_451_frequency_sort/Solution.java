package com.arjun.leetcode._451_frequency_sort;

import java.util.*;
import java.util.Map.Entry;

class Solution {
  public String frequencySort(String s) {
    Map<Character, Integer> freqMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      Integer freq = freqMap.get(c);
      if (freq == null) {
        freqMap.put(c, 1);
      } else freqMap.put(c, freq + 1);
    }
    // Collections.sort(freqMap.values());
    System.out.println(freqMap);

    Map<Character, Integer> sortedMap = sortByComparator(freqMap, false);

    System.out.println(sortedMap);
    return null;
  }

  private Map<Character, Integer> sortByComparator(
      Map<Character, Integer> unsortMap, final boolean order) {

    List<Entry<Character, Integer>> list = new LinkedList<>(unsortMap.entrySet());

    // Sorting the list based on values
    Collections.sort(
        list,
        (Entry<Character, Integer> o1, Entry<Character, Integer> o2) -> {
          if (order) {
            return o1.getValue().compareTo(o2.getValue());
          } else {
            return o2.getValue().compareTo(o1.getValue());
          }
        });

    // Maintaining insertion order with the help of LinkedList
    Map<Character, Integer> sortedMap = new LinkedHashMap<>();
    for (Entry<Character, Integer> entry : list) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }

    return sortedMap;
  }
}
