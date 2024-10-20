package com.arjun.interviewbit.segregate_zero_one;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.interviewbit.com/problems/segregate-0s-and-1s-in-an-array/
 *
 * <p>Collect the number of ones and then precede them with zeros
 */
public class Solution {
  public ArrayList<Integer> solve(ArrayList<Integer> A) {
    List<Integer> collect =
        A.stream().filter(integer -> integer.equals(1)).collect(Collectors.toList());
    int size = collect.size();
    for (int i = 0; i < (A.size() - size); i++) {
      collect.add(0, 0);
    }
    return new ArrayList<>(collect);
  }

  public static void main(String[] args) {
    ArrayList<Integer> solve = new Solution().solve(new ArrayList<>(List.of(0, 1, 0)));
    System.out.println(solve);

    solve = new Solution().solve(new ArrayList<>(List.of(1, 1, 0)));
    System.out.println(solve);

    solve =
        new Solution().solve(new ArrayList<>(List.of(0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1)));
    System.out.println(solve);

    solve =
        new Solution()
            .solve(new ArrayList<>(List.of(0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0)));
    System.out.println(solve);
  }
}
