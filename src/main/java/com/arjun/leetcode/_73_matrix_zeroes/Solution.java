package com.arjun.leetcode._73_matrix_zeroes;

import java.util.*;

class Solution {
  public void setZeroes(int[][] matrix) {

    Set<Pair> location = new HashSet<>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          location.add(new Pair(i, j));
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        Pair pair = new Pair(i, j);
        if (matrix[i][j] == 0 && location.contains(pair)) {
          markHorizontalZeros(matrix[i]);
          markVerticalZeros(matrix, j);
          location.remove(pair);
        }
      }
    }
  }

  private void markVerticalZeros(int[][] matrix, int j) {
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][j] = 0;
    }
  }

  private void markHorizontalZeros(int[] matrix) {
    Arrays.fill(matrix, 0);
  }

  public static void main(String[] args) {
    int[][] matrix = {
      {1, 1, 1}, //
      {1, 0, 1}, //
      {1, 1, 1}
    };
    new Solution().setZeroes(matrix);
    System.out.println(Arrays.deepToString(matrix));

    matrix = new int[][] {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
    new Solution().setZeroes(matrix);
    System.out.println(Arrays.deepToString(matrix));
  }

  static class Pair {
    int row;
    int column;

    public Pair(int i, int j) {
      this.row = i;
      this.column = j;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Pair pair = (Pair) o;
      return row == pair.row && column == pair.column;
    }

    @Override
    public int hashCode() {
      return Objects.hash(row, column);
    }
  }
}
