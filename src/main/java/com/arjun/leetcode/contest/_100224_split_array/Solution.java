package com.arjun.leetcode.contest._100224_split_array;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean isPossibleToSplit(int[] nums) {
    Set<Integer> integerSet1 = new HashSet<>();
    Set<Integer> integerSet2 = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      boolean add = integerSet1.add(nums[i]);
      if (!add) {
        boolean add1 = integerSet2.add(nums[i]);
        if (!add1) return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    boolean possibleToSplit = new Solution().isPossibleToSplit(new int[] {1, 1, 2, 2, 3, 4});
    System.out.println(possibleToSplit);

    possibleToSplit = new Solution().isPossibleToSplit(new int[] {1, 1, 1, 1});
    System.out.println(possibleToSplit);

    possibleToSplit = new Solution().isPossibleToSplit(new int[] {0, 1, 0, 1});
    System.out.println(possibleToSplit);
  }
}
