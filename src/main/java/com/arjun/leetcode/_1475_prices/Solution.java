package com.arjun.leetcode._1475_prices;

class Solution {
  public int[] finalPrices(int[] prices) {
    int[] newPrices = new int[prices.length];
    for (int i = 0; i < prices.length; i++) {
      int j = i + 1;
      while (j < prices.length) {
        if (prices[i] >= prices[j]) {
          newPrices[i] = prices[i] - prices[j];
          break;
        }
        j++;
      }
    }
    return newPrices;
  }

  public static void main(String[] args) {
    new Solution().finalPrices(new int[] {8, 4, 6, 2, 3});
  }
}
