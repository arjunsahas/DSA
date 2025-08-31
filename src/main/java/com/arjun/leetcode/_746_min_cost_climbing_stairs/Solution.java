package com.arjun.leetcode._746_min_cost_climbing_stairs;

public class Solution {
    
    /**
     * Calculates the minimum cost to reach the top of the stairs.
     * You can either start from step 0 or step 1, and at each step,
     * you can climb either one or two steps.
     *
     * @param cost An array where cost[i] is the cost of step i.
     * @return The minimum cost to reach the top.
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // dp[i] will hold the minimum cost to reach step i
        int[] dp = new int[n + 1]; 
        
        // Base cases: no cost to start at step 0 or step 1
        dp[0] = 0;
        dp[1] = 0;
        
        // Build up the dp array from step 2 to n
        for (int i = 2; i <= n; i++) {
            // To reach step i, you can come from step i-1 or i-2
            // Add the cost of the step you came from
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        
        // The answer is the minimum cost to reach the top (step n)
        return dp[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] cost = {10, 15, 20};
        System.out.println(sol.minCostClimbingStairs(cost)); // Output: 15

        //additional test cases
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(sol.minCostClimbingStairs(cost2)); // Output: 6

        int[] cost3 = {0, 0, 0, 1};
        System.out.println(sol.minCostClimbingStairs(cost3)); // Output: 0
    }
}
