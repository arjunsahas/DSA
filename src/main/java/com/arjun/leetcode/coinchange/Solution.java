package com.arjun.leetcode.coinchange;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] sum = new int[amount + 1];
        Arrays.fill(sum, -1);
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && sum[i - coins[j]] + 1 != sum[i]) {
                        sum[i] = sum[i - coins[j]] + 1;
                }
            }
        }
        return sum[amount] == 0 ? -1 : sum[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{2, 3}, 4));
    }
}



