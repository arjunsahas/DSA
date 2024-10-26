package com.arjun.interviewbit.merge_intervals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/merge-intervals/
 *
 * <p>The core logic for overlapping intervals should be the below newinterval.start is between
 * interval.start and interval.end or newinterval.end is between interval.start and interval.end or
 * interval.start and interval.end is within the range of newinterval.start and newinterval.end
 *
 * <p>If an inteval satisfies this core logic, then we can use a stack to push it. Then, we can pop
 * the stack one by one.
 *
 * <p>The logic for new interval that does not overlap is.
 *
 * <p>Corner cases are a huge problem here. 1. new interval has no overlap (lesser and greater) 2.
 * new interval has overlap with the entire range.
 */
public class Solution1 {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    if (newInterval.end < newInterval.start) {
      int temp = newInterval.start;
      newInterval.start = newInterval.end;
      newInterval.end = temp;
    }

    Stack<Interval> stack = new Stack<>();

    Iterator<Interval> iterator = intervals.iterator();
    while (iterator.hasNext()) {
      Interval interval = iterator.next();
      if ((newInterval.start >= interval.start && newInterval.start < interval.end)
          || (newInterval.end > interval.start && newInterval.end <= interval.end)
          || (interval.start > newInterval.start && interval.end < newInterval.end)) {
        stack.push(interval);
        iterator.remove();
      }
    }

    if (!stack.isEmpty()) {
      int count = 0;
      int end = 0;
      int start = 0;
      int stackSize = stack.size();
      while (!stack.isEmpty()) {
        Interval interval = stack.pop();
        if (count == 0) {
          end = Math.max(interval.end, newInterval.end);
        }
        if (count == stackSize - 1) {
          start = Math.min(interval.start, newInterval.start);
        }
        count++;
      }
      if (start != 0 && end != 0) intervals.add(new Interval(start, end));
    } else intervals.add(newInterval);

    intervals.sort((o1, o2) -> o1.start < o2.start && o1.end < o2.end ? -1 : 1);
    return intervals;
  }

  public static void main(String[] args) {
    List<Interval> insert =
        new Solution1()
            .insert(
                new ArrayList<>(List.of(new Interval(1, 3), new Interval(6, 9))),
                new Interval(2, 5));
    System.out.println(insert);
    insert =
        new Solution1()
            .insert(
                new ArrayList<>(
                    List.of(
                        new Interval(1, 2),
                        new Interval(3, 5),
                        new Interval(6, 7),
                        new Interval(8, 10),
                        new Interval(12, 16))),
                new Interval(4, 9));
    System.out.println(insert);
    insert =
        new Solution1()
            .insert(
                new ArrayList<>(List.of(new Interval(1, 2), new Interval(3, 6))),
                new Interval(10, 8));
    System.out.println(insert);

    insert =
        new Solution1()
            .insert(
                new ArrayList<>(List.of(new Interval(5, 6), new Interval(7, 8))),
                new Interval(1, 2));
    System.out.println(insert);

    insert =
        new Solution1()
            .insert(
                new ArrayList<>(List.of(new Interval(3, 5), new Interval(8, 10))),
                new Interval(1, 12));
    System.out.println(insert);

    insert =
        new Solution1()
            .insert(
                new ArrayList<>(List.of(new Interval(3, 5), new Interval(8, 10))),
                new Interval(3, 10));
    System.out.println(insert);
  }
}
