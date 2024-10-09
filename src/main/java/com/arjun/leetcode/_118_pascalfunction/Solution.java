package com.arjun.leetcode._118_pascalfunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> motherList = new ArrayList<>();
    if (numRows == 0) {
      return motherList;
    }
    int r, c;
    r = c = numRows;
    int[][] result = pascalRow(r, c);
    for (int i = 0; i < result.length; i++) {
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j < c + 1; j++) {
        if (result[i][j] > 0) {
          list.add(result[i][j]);
        }
      }
      if (!list.isEmpty()) motherList.add(list);
    }
    return motherList;
  }

  private int[][] pascalRow(int r, int c) {
    int[][] matrix = new int[r + 1][c + 1];
    for (int[] row : matrix) {
      Arrays.fill(row, 0);
    }
    matrix[1][1] = 1;
    int i = 1;
    while (i <= c) {
      pascalfn(r, i, matrix);
      i++;
    }
    return matrix;
  }

  private int pascalfn(int r, int c, int[][] result) {
    if (r == 0 || c == 0) return 0;
    if (r == 1 || c == 1 || r == c) {
      result[r][c] = 1;
      return result[r][c];
    }
    if (result[r][c] != 0) {
      return result[r][c];
    }
    result[r][c] = pascalfn(r - 1, c - 1, result) + pascalfn(r - 1, c, result);
    return result[r][c];
  }

  public static void main(String[] args) {
    List<List<Integer>> generate = new Solution().generate(7);
    System.out.println(generate);
  }
}
