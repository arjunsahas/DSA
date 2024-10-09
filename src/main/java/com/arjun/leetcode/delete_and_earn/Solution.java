package com.arjun.leetcode.delete_and_earn;

import java.util.*;

class Solution {
  Map<Integer, Integer> memo = new HashMap<>();

  public int deleteAndEarn(int[] nums) {
    Arrays.sort(nums);
    Map<Integer, Integer> reps = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (reps.containsKey(nums[i])) reps.put(nums[i], reps.get(nums[i]) + 1);
      else reps.put(nums[i], 1);
    }

    List<Integer> newNums = new ArrayList<>(reps.keySet());

    return deleteAndEarn(newNums.size() - 1, newNums, reps);
  }

  private int deleteAndEarn(int i, List<Integer> nums, Map<Integer, Integer> reps) {
    if (i == 0) return 0;
    if (i == 1) return nums.get(1) * reps.get(nums.get(1));

    if (memo.get(i) != null) {
      return memo.get(i);
    }

    memo.put(
        i,
        Math.max(
            deleteAndEarn(i - 1, nums, reps),
            deleteAndEarn(i - 2, nums, reps) + (nums.get(i) * reps.get(nums.get(i)))));

    return memo.get(i);
  }

  public static void main(String[] args) {
    int i = new Solution().deleteAndEarn(new int[] {3, 4, 2});
    System.out.println(i);
  }
}
