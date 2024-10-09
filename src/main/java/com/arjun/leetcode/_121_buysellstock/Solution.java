package com.arjun.leetcode._121_buysellstock;

class Solution {
  private static int maxProfit;

  public int maxProfit(int[] prices) {
    int leastCost = -1;
    int profit = -1;
    for (int day = 0; day < prices.length; day++) {
      if (prices[day] < leastCost || leastCost == -1) {
        leastCost = prices[day];
      }
      profit = Math.max(profit, prices[day] - leastCost);
    }
    return profit;
  }

  public static void main(String[] args) {
    maxProfit = new Solution().maxProfit(new int[] {7, 6, 4, 3, 1});
    System.out.println(maxProfit);
  }
}
