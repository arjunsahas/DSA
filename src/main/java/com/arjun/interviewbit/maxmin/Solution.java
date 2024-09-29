package com.arjun.interviewbit.maxmin;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solve(List<Integer> A) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i : A) {
            if (i < low) low = i;
            if (i > high) high = i;
        }
        return low + high;
    }

    public static void main(String[] args) {
        int solve = new Solution().solve(List.of(1, 2, 4, 5, -4, 2));
        System.out.println(solve);
        solve = new Solution().solve(List.of(1, 3, 4, 1));
        System.out.println(solve);
        solve = new Solution().solve(List.of(-1, -3, -4, -1));
        System.out.println(solve);
    }
}
