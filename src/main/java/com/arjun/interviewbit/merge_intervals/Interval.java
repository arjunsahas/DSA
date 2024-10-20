package com.arjun.interviewbit.merge_intervals;

public class Interval {
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
    return "Interval{" + "start=" + start + ", end=" + end + '}';
  }
}
