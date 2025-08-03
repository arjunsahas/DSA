package com.arjun.leetcode._1_twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum Problem - Find two numbers that add up to target
 *
 * <p>Problem: Given an array of integers nums and an integer target, return indices of the two
 * numbers such that they add up to target.
 *
 * <p>Time Complexity: O(n) - HashMap approach Space Complexity: O(n) - HashMap storage
 */
class Solution {

  /**
   * Optimized solution using HashMap for O(n) time complexity
   *
   * @param nums array of integers
   * @param target target sum
   * @return indices of two numbers that add up to target
   */
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }

      map.put(nums[i], i);
    }

    throw new IllegalArgumentException("No two sum solution found");
  }

  /**
   * Brute force solution with O(n²) time complexity
   *
   * @param nums array of integers
   * @param target target sum
   * @return indices of two numbers that add up to target
   */
  public int[] twoSumBruteForce(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    throw new IllegalArgumentException("No two sum solution found");
  }
}
