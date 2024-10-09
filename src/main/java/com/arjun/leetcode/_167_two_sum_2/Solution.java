package com.arjun.leetcode._167_two_sum_2;

class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int mid = binarySearch(numbers, target);
    for (int i = 0; i <= mid; i++) {
      for (int j = i + 1; j <= mid; j++) {
        int add = numbers[i] + numbers[j];
        if (add == target) {
          return new int[] {i, j};
        }
      }
    }
    return new int[1];
  }

  private int binarySearch(int[] numbers, int target) {
    int mid = 0;
    int start = 0;
    int end = 0;
    int length = numbers.length;
    while (end >= start) {
      mid = length % 2 == 0 ? length / 2 : (length / 2) + 1;
      if (numbers[start + mid] <= 0 && numbers[start + mid] > target) {
        start = 0;
        end = mid;
      } else if (numbers[start + mid] > 0 && numbers[start + mid] > target) {
        start = 0;
        end = mid;
      } else {
        start = mid;
        break;
      }
      length = end - start;
    }
    return mid;
  }

  public static void main(String[] args) {
    //        int[] ints = new Solution().twoSum(new int[]{-10, -9, -3, 0, 4, 5}, -13);

    int[] ints = new Solution().twoSum(new int[] {0, 1, 5, 10, 17, 19}, 6);

    ints = new Solution().twoSum(new int[] {0, 1, 5, 10, 17, 19, 23121212, 121212121}, 144333333);
  }
}
