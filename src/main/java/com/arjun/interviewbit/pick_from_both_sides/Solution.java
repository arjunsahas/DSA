package com.arjun.interviewbit.pick_from_both_sides;


import java.util.*;

/** This is a sliding window problem. */
public class Solution {
  public int solve(List<Integer> A, int B) {
    if (B > A.size()) return -1;
    if (A.size() == 1) return A.get(0);
    if (A.size() == 2) return A.get(0) > A.get(1) ? A.get(0) : A.get(1);

    int startWindow = 0;
    int endWindow = B;
    List<Integer> localSums = new ArrayList<>();
    for (int i = 0; i < B + 1; i++) {
      int sum = 0;
      for (int j = startWindow; j < endWindow; j++) {
        int pos = j < 0 ? j + A.size() : j;
        sum = sum + A.get(pos);
      }
      localSums.add(sum);
      startWindow--;
      endWindow--;
    }
    Collections.sort(localSums, Comparator.reverseOrder());
    return !localSums.isEmpty() ? localSums.iterator().next() : 0;
  }

  public static void main(String[] args) {
    int solve = new Solution().solve(new ArrayList<>(List.of(5, -2, 3, 1, 2)), 3);
    System.out.println(solve);

    solve = new Solution().solve(new ArrayList<>(List.of(5, -2, 3, 1, 2)), 4);
    System.out.println(solve);

    solve = new Solution().solve(new ArrayList<>(List.of(5, -2, 3, 1, 2)), 5);
    System.out.println(solve);

    solve = new Solution().solve(new ArrayList<>(List.of(1, 2)), 1);
    System.out.println(solve);

    Integer[] array =
        new Integer[] {
          -584, -714, -895, -512, -718, -545, 734, -886, 701, 316, -329, 786, -737, -687, -645, 185,
          -947, -88, -192, 832, -55, -687, 756, -679, 558, 646, 982, -519, -856, 196, -778, 129,
          -839, 535, -550, 173, -534, -956, 659, -708, -561, 253, -976, -846, 510, -255, -351, 186,
          -687, -526, -978, -832, -982, -213, 905, 958, 391, -798, 625, -523, -586, 314, 824, 334,
          874, -628, -841, 833, -930, 487, -703, 518, -823, 773, -730, 763, -332, 192, 985, 102,
          -520, 213, 627, -198, -901, -473, -375, 543, 924, 23, 972, 61, -819, 3, 432, 505, 593,
          -275, 31, -508, -858, 222, 286, 64, 900, 187, -640, -587, -26, -730, 170, -765, -167, 711,
          760, -104, -333
        };
    solve = new Solution().solve(Arrays.asList(array), 32);
    System.out.println(solve);
  }
}
