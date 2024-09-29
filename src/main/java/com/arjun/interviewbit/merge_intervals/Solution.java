package com.arjun.interviewbit.merge_intervals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int minInSet = 0;
        int maxInSet = 0;
        for (Interval interval : intervals) {
            if (newInterval.start > interval.start && newInterval.start < interval.end) { // for e.g I(2,4) NI (3,5)
                minInSet = interval.start;
                maxInSet = Math.max(maxInSet, newInterval.end);
            }
            if (newInterval.end > interval.start && newInterval.end < interval.end) { // for e.g I(8,10) NI(4,9)
                maxInSet = Math.max(maxInSet, interval.end);
            }
        }
        System.out.println(minInSet);
        System.out.println(maxInSet);

        ArrayList<Interval> intervals1 = new ArrayList<>(intervals);

        if (maxInSet == 0 && minInSet == 0) {
            intervals1.add(newInterval);
        } else {
            Iterator<Interval> iterator = intervals1.iterator();
            while (iterator.hasNext()) {
                Interval next = iterator.next();
                if (next.start >= minInSet && next.end <= maxInSet) {
                    iterator.remove();
                }
            }
            intervals1.add(new Interval(minInSet, maxInSet));
        }


        return intervals1;
    }

    public static void main(String[] args) {
        List<Interval> insert = new Solution().insert(List.of(new Interval(1, 3), new Interval(6, 9)), new Interval(2, 5));
        System.out.println(insert);
        insert = new Solution().insert(List.of(new Interval(1, 2), new Interval(3, 5), new Interval(6, 7), new Interval(8, 10), new Interval(12, 16)), new Interval(4, 9));
        System.out.println(insert);
        insert = new Solution().insert(List.of(new Interval(1, 2), new Interval(3, 6)), new Interval(10, 8));
        System.out.println(insert);
    }

    static class Interval {
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
