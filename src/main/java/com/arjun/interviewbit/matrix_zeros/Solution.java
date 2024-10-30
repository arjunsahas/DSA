package com.arjun.interviewbit.matrix_zeros;

import java.util.*;

/**
 * https://www.interviewbit.com/problems/set-matrix-zeros/
 *
 * <p>Intuition: We can pass through the matrix to find the points where zeros are present and store
 * in a list. Then go over the list and mark the rows and columns as zero.
 *
 * <p>In the first iteration using Index, I am not weeding out the duplicate row and column indexes.
 * This leads to Time Limit Exceeded. The second iteration takes care of the issue by deduplicating
 * the rows and columns.
 */
public class Solution {
  public void setZeroes(ArrayList<ArrayList<Integer>> a) {
    ArrayIndex indexList = new ArrayIndex();
    for (int i = 0; i < a.size(); i++) {
      for (int j = 0; j < a.get(0).size(); j++) {
        if (a.get(i).get(j) == 0) {
          indexList.rowList.add(i);
          indexList.columnList.add(j);
        }
      }
    }

    for (int i = 0; i < a.size(); i++) {
      ArrayList<Integer> row = a.get(i);
      if (indexList.rowList.contains(i)) Collections.fill(row, 0);
      for (Integer column : indexList.columnList) {
        row.set(column, 0);
      }
    }
  }

  class Index { // first iteration

    public Index(int row, int column) {
      this.row = row;
      this.column = column;
    }

    int row;
    int column;
  }

  static class ArrayIndex { // second iteration.
    Set<Integer> rowList = new HashSet<>();
    Set<Integer> columnList = new HashSet<>();
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
    matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
    matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
    new Solution().setZeroes(matrix);
    printMatrix(matrix.size(), matrix.get(0).size(), matrix);

    matrix = new ArrayList<>();
    matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
    matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
    matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
    new Solution().setZeroes(matrix);
    printMatrix(matrix.size(), matrix.get(0).size(), matrix);

    matrix = new ArrayList<>();
    matrix.add(new ArrayList<>(Arrays.asList(1, 1)));
    matrix.add(new ArrayList<>(Arrays.asList(1, 1)));
    matrix.add(new ArrayList<>(Arrays.asList(1, 0)));
    matrix.add(new ArrayList<>(Arrays.asList(0, 1)));
    matrix.add(new ArrayList<>(Arrays.asList(1, 1)));
    matrix.add(new ArrayList<>(Arrays.asList(1, 1)));

    new Solution().setZeroes(matrix);
    printMatrix(matrix.size(), matrix.get(0).size(), matrix);
  }

  private static void printMatrix(int n, int m, ArrayList<ArrayList<Integer>> matrix) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (j + 1 == m) System.out.println(matrix.get(i).get(j));
        else System.out.print(matrix.get(i).get(j));
      }
    }
    System.out.println();
  }
}
