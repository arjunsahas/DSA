package com.arjun.leetcode;

import java.util.Arrays;

public class Solution111 {

    public int twoCitySchedCost(int[][] costs) {
        int totalCosts = 0;
        Arrays.sort(costs, (o1, o2) -> (o1[0] - o1[1]) - (o2[0] - o2[1]));
        int n = costs.length /2 ;
        for (int i = 0; i < n; i++) {
            totalCosts += costs[i][0];
            totalCosts += costs[i + n][1];
        }
        return totalCosts;
    }
}
