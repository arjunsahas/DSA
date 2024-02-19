package com.arjun.leetcode.min_cost_of_climbing_stairs;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        return climb(cost.length - 1, cost);
    }

    private int climb(int i, int[] cost) {
        if (i <= 1) return 0;

        if (memo.get(i) != null) {
            return memo.get(i);
        }

        int minCost = Math.min(cost[i - 1] + climb(i - 1, cost), cost[i - 2] + climb(i - 2, cost));
        memo.put(i, minCost);
        return memo.get(i);
    }
}