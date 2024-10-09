package com.arjun.leetcode._275_hindex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
  public int hIndex(int[] citations) {
    if (citations.length == 0) return 0;
    if (citations.length == 1) return Math.min(1, citations[0]);
    List<Integer> listCitations = new ArrayList<>();
    for (int i : citations) {
      listCitations.add(i);
    }
    Collections.reverse(listCitations);
    int hIndex = 0;
    for (int i = 0; i < listCitations.size(); i++) {
      hIndex++;
      if (listCitations.get(i) == hIndex) {
        return hIndex;
      }
      if (listCitations.get(i) < hIndex) {
        return hIndex - 1;
      }
    }
    return hIndex;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().hIndex(new int[] {3, 3, 5, 8, 25}));
  }
}
