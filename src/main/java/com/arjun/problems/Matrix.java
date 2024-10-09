package com.arjun.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Created by arjuns on 13/1/17. */
public class Matrix {
  private static List<List<String>> lists = new ArrayList<>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    scanner.useDelimiter(System.getProperty("line.separator"));
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    String[][] matrix = new String[n][m];
    for (int i = 0; i < n; i++) {
      String next = scanner.next();
      String[] split = next.split(" ");
      for (int j = 0; j < m; j++) {
        matrix[i][j] = split[j];
      }
    }
    printMatrix(n, m, matrix);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        String content = matrix[i][j];
        if (isGood(content) && !isMatrixEdge(n, m, i, j)) {
          constructShape(n, m, i, j, matrix);
        }
      }
    }
    System.out.println(lists);
  }

  private static void constructShape(
      final int n, final int m, final int i, final int j, final String[][] matrix) {
    List<String> left = getLeft(matrix, i, j);
    List<String> right = getRight(m, matrix, i, j);
    int leftRightMinSize = findMinimumSize(left.size(), right.size());

    if (leftRightMinSize > 0) {
      List<String> top = getTop(matrix, i, j);
      List<String> bottom = getBottom(n, matrix, i, j);
      int topBottomMinSize = findMinimumSize(top.size(), bottom.size());
      if (topBottomMinSize > 0) {
        int minSize = findMinimumSize(leftRightMinSize, topBottomMinSize);
        List<String> shapeList = new ArrayList<>();
        shapeList.add("" + i + j);
        constructShapeList(minSize, left, right, shapeList);
        constructShapeList(minSize, top, bottom, shapeList);
        lists.add(shapeList);
      }
    }
  }

  private static void constructShapeList(
      int minSize,
      final List<String> subList1,
      final List<String> subList2,
      final List<String> shapeList) {
    shapeList.addAll(subList1.subList(0, minSize));
    shapeList.addAll(subList2.subList(0, minSize));
  }

  private static int findMinimumSize(int listSize1, int listSize2) {
    int size = 0;
    if (listSize1 > 0 && listSize2 > 0) {
      int diff = listSize1 - listSize2;
      if (diff != 0) {
        int sign = Integer.signum(diff);
        if (sign == -1) size = listSize1;
        else if (sign == 1) {
          size = listSize2;
        }
      } else {
        size = listSize1;
      }
    }
    return size;
  }

  private static List<String> getRight(int m, final String[][] matrix, int i, int j) {
    List<String> list = new ArrayList<>();
    while (++j < m) {
      if (compareAndAdd(matrix[i][j], i, j, list)) break;
    }
    return list;
  }

  private static List<String> getLeft(final String[][] matrix, final int i, int j) {
    List<String> list = new ArrayList<>();
    while (j > 0) {
      j--;
      if (compareAndAdd(matrix[i][j], i, j, list)) break;
    }
    return list;
  }

  private static List<String> getBottom(int n, final String[][] matrix, int i, int j) {
    List<String> list = new ArrayList<>();
    while (++i < n) {
      if (compareAndAdd(matrix[i][j], i, j, list)) break;
    }
    return list;
  }

  private static List<String> getTop(final String[][] matrix, int i, int j) {
    List<String> list = new ArrayList<>();
    while (i > 0) {
      i--;
      if (compareAndAdd(matrix[i][j], i, j, list)) break;
    }
    return list;
  }

  private static boolean compareAndAdd(
      final String content, final int i, final int j, final List<String> list) {
    if (isGood(content)) {
      list.add("" + i + j);
    } else return true;
    return false;
  }

  private static boolean isGood(String content) {
    return content.equals("g");
  }

  private static boolean isMatrixEdge(int n, int m, int i, int j) {
    if ((i == 0 || i + 1 == n) || (j == 0 || j + 1 == m)) return true;
    else return false;
  }

  private static void printMatrix(int n, int m, String matrix[][]) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (j + 1 == m) System.out.println(matrix[i][j]);
        else System.out.print(matrix[i][j]);
      }
    }
  }
}
