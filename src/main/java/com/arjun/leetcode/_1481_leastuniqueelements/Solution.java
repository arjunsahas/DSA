package com.arjun.leetcode._1481_leastuniqueelements;

import java.util.*;

class Solution {
  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    int count = 0;
    int size = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (!map.containsKey(arr[i])) {
        map.put(arr[i], 1);
        size++;
      } else map.put(arr[i], map.get(arr[i]) + 1);
    }
    Map<Integer, Integer> sortedMap = sortByComparator(map, true);
    for (Map.Entry<Integer, Integer> mp : sortedMap.entrySet()) {
      // Remove if current value is less than
      // or equal to mi
      if (mp.getKey() <= k) {
        k -= mp.getKey();
        count++;
      }
      // Return the remaining size
      else return size - count;
    }

    return size - count;
  }

  private Map<Integer, Integer> sortByComparator(
      Map<Integer, Integer> unsortMap, final boolean order) {

    List<Map.Entry<Integer, Integer>> list = new LinkedList<>(unsortMap.entrySet());

    // Sorting the list based on values
    Collections.sort(
        list,
        (Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) -> {
          if (order) {
            return o1.getValue().compareTo(o2.getValue());
          } else {
            return o2.getValue().compareTo(o1.getValue());
          }
        });

    // Maintaining insertion order with the help of LinkedList
    Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
    for (Map.Entry<Integer, Integer> entry : list) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }

    return sortedMap;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().findLeastNumOfUniqueInts(new int[] {4, 3, 1, 1, 3, 3, 2}, 3));
  }
}
