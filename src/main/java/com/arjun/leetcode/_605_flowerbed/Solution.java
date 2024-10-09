package com.arjun.leetcode._605_flowerbed;

class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int flowerbedLength = flowerbed.length;
    if (n > ((flowerbedLength % 2) == 0 ? flowerbedLength : flowerbedLength + 1) / 2) return false;
    if (flowerbed.length == 1 && flowerbed[0] == 1 && n == 0) return true;
    if (flowerbed.length == 1 && flowerbed[0] == 1 && n == 1) return false;
    if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 0) return true;
    if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1) return true;
    int i = 0;
    while (i < flowerbedLength) {
      if ((i - 1) >= 0
          && (i + 1) < flowerbedLength
          && flowerbed[i - 1] == 0
          && flowerbed[i] == 0
          && flowerbed[i + 1] == 0) {
        flowerbed[i] = 1;
        n--;
      }
      if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
        flowerbed[i] = 1;
        n--;
      }
      if (i == flowerbedLength - 1 && flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
        flowerbed[i] = 1;
        n--;
      }
      i++;
    }
    return n <= 0;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 2));
    System.out.println(new Solution().canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 1));
    System.out.println(new Solution().canPlaceFlowers(new int[] {0, 0, 0, 0, 1}, 2));
    System.out.println(new Solution().canPlaceFlowers(new int[] {0, 0, 0, 0, 0}, 3));
    System.out.println(new Solution().canPlaceFlowers(new int[] {0, 0, 0, 0, 1}, 3));
    System.out.println(new Solution().canPlaceFlowers(new int[] {0, 0, 0, 0, 1}, 4));
    System.out.println(new Solution().canPlaceFlowers(new int[] {0, 0, 1, 0, 0}, 1));
  }
}
