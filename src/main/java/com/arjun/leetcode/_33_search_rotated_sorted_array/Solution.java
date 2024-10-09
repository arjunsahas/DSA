package com.arjun.leetcode._33_search_rotated_sorted_array;

public class Solution {
  public int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    while (l <= r) {
      int mid = (l + r) / 2;

      if (nums[mid] == target) {
        return mid;
      }

      if (nums[mid] <= nums[r]) {
        if (target > nums[mid] && target <= nums[r]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      } else {
        if (target > nums[l] && target <= nums[mid]) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int search = new Solution().search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0);
    System.out.println(search);
  }
}
