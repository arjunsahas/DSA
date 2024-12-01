package com.arjun.interviewbit.merge_overlapping_intervals;

import java.util.ArrayList;
import java.util.List;

/** https://www.interviewbit.com/problems/merge-overlapping-intervals/ */
public class Solution {
  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    intervals.sort(
        (o1, o2) -> {
          if (o1.start == o2.start) return 0;
          return o1.start < o2.start ? -1 : 1;
        });

    int start = 0;
    int end = 0;
    for (int i = 0; i < intervals.size(); i++) {
      Interval iInterval = intervals.get(i);
      Interval i1Interval = null;
      if (i != intervals.size() - 1) {
        i1Interval = intervals.get(i + 1);
        if ((i1Interval.start >= iInterval.start && i1Interval.start < iInterval.end)) {
          start = Math.max(start, iInterval.start);
          end = Math.max(end, i1Interval.end);
        }
      }
    }

    System.out.println(start);
    System.out.println(end);

    return intervals;
  }

  public static void main(String[] args) {
    List<Interval> insert =
        new Solution()
            .merge(
                new ArrayList<>(
                    List.of(new Interval(1, 3), new Interval(6, 9), new Interval(2, 5))));
    System.out.println(insert);
    insert =
        new Solution()
            .merge(
                new ArrayList<>(
                    List.of(
                        new Interval(1, 2),
                        new Interval(3, 5),
                        new Interval(6, 7),
                        new Interval(8, 10),
                        new Interval(12, 16),
                        new Interval(4, 9))));
    System.out.println(insert);
    insert =
        new Solution()
            .merge(
                new ArrayList<>(
                    List.of(new Interval(1, 2), new Interval(3, 6), new Interval(10, 8))));
    System.out.println(insert);

    insert =
        new Solution()
            .merge(
                new ArrayList<>(
                    List.of(new Interval(5, 6), new Interval(7, 8), new Interval(1, 2))));
    System.out.println(insert);

    insert =
        new Solution()
            .merge(
                new ArrayList<>(
                    List.of(new Interval(3, 5), new Interval(8, 10), new Interval(1, 12))));
    System.out.println(insert);

    insert =
        new Solution()
            .merge(
                new ArrayList<>(
                    List.of(new Interval(3, 5), new Interval(8, 10), new Interval(3, 10))));
    System.out.println(insert);
  }
}
