package com.arjun.leetcode._1431_candies;

import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int largestNumber = 0;
    List<Boolean> result = new ArrayList<>();
    for (int i = 0; i < candies.length; i++) {
      if (candies[i] > largestNumber) largestNumber = candies[i];
    }
    for (int i = 0; i < candies.length; i++) {
      if ((candies[i] + extraCandies) >= largestNumber) result.add(true);
      else result.add(false);
    }
    return result;
  }

  public static void main(String[] args) {
    new Solution().kidsWithCandies(new int[] {2, 3, 5, 1, 3}, 3);
  }
}
