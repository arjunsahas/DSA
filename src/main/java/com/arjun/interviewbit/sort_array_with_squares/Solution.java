package com.arjun.interviewbit.sort_array_with_squares;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.interviewbit.com/problems/sort-array-with-squares/
 *
 * <p>Intuition: There are many ways to solve this. 1. Simplest way is to square the number and
 * finally sort it. 2. use priority queue with comparator and sort them in natural order. 3. The
 * array is already sorted. So, when we square the numbers, only the negative integers needs to be
 * sorted.
 */
public class Solution {
  public ArrayList<Integer> solve(ArrayList<Integer> A) {
    PriorityQueue<Integer> integers = new PriorityQueue<>(Comparator.naturalOrder());

    A.forEach(integer -> integers.offer(integer * integer));
    ArrayList<Integer> returnList = new ArrayList<>();
    while (!integers.isEmpty()) {
      returnList.add(integers.poll());
    }
    return returnList;
  }

  public ArrayList<Integer> solve1(ArrayList<Integer> A) {
    ArrayList<Integer> returnList1 = new ArrayList<>();

    // square the positive numbers
    for (int i = 0; i < A.size(); i++) {
      Integer val = A.get(i);
      if (val > 0) returnList1.add(val * val);
    }

    // square the negative numbers
    ArrayList<Integer> returnList2 = new ArrayList<>();
    for (int i = 0; i < A.size(); i++) {
      Integer val = A.get(i);
      if (val <= 0) {
        returnList2.add(0, val * val);
      }
    }

    ArrayList<Integer> returnList = new ArrayList<>();

    int i = 0, j = 0;
    while (i < returnList1.size() && j < returnList2.size()) {
      if (returnList1.get(i) > returnList2.get(j)) {
        returnList.add(returnList2.get(j++));
      } else {
        returnList.add(returnList1.get(i++));
      }
    }
    return returnList;
  }

  public static void main(String[] args) {
    ArrayList<Integer> integers =
        new Solution().solve(new ArrayList<>(List.of(-6, -3, -1, 2, 4, 5)));
    System.out.println(integers);

    integers = new Solution().solve(new ArrayList<>(List.of(-5, -4, -2, 0, 1)));
    System.out.println(integers);

    integers = new Solution().solve1(new ArrayList<>(List.of(-6, -3, -1, 2, 4, 5)));
    System.out.println(integers);

    integers = new Solution().solve1(new ArrayList<>(List.of(-5, -4, -2, 0, 1)));
    System.out.println(integers);
  }
}
