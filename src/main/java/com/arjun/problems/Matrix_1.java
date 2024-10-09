package com.arjun.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/** Created by arjuns on 13/1/17. */
public class Matrix_1 {
  private static List<List<String>> lists = new ArrayList<>();

  public static void main(String[] args) {
    //        Scanner scanner = new Scanner(System.in);
    //        scanner.useDelimiter(System.getProperty("line.separator"));
    //        int n = scanner.nextInt();
    //        int m = scanner.nextInt();
    //        String[][] matrix = new String[n][m];
    //        for (int i = 0; i < n; i++) {
    //            String next = scanner.next();
    //            String[] split = next.split(" ");
    //            for (int j = 0; j < m; j++) {
    //                matrix[i][j] = split[j];
    //            }
    //        }
    //        printMatrix(n, m, matrix);

    String[][] matrix =
        new String[][] {
          {"g", "g", "g", "g", "g", "g", "g", "g", "g"},
          {"g", "b", "b", "g", "b", "g", "g", "g", "g"},
          {"b", "g", "g", "g", "b", "g", "g", "g", "g"},
          {"g", "b", "g", "g", "g", "g", "g", "g", "g"},
          {"g", "g", "g", "g", "g", "g", "g", "b", "b"},
          {"g", "b", "b", "b", "g", "g", "g", "b", "b"},
          {"g", "b", "g", "g", "g", "g", "g", "b", "g"},
          {"g", "g", "b", "g", "g", "g", "g", "b", "g"}
        };

    int n = matrix.length;
    int m = matrix[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        String content = matrix[i][j];
        if (isGood(content) && !isMatrixEdge(n, m, i, j)) {
          constructShape(n, m, i, j, matrix);
        }
      }
    }
    System.out.println(lists);
    calculateProduct();
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
        addToList(shapeList);
      }
    }
  }

  private static void addToList(final List<String> shapeList) {
    if (lists.size() == 0) {
      lists.add(shapeList);
    } else {
      ListIterator<List<String>> iterator = lists.listIterator();
      while (iterator.hasNext()) {
        List<String> existingShape = iterator.next();
        if (existingShape.size() == shapeList.size()) {
          addShapeList(shapeList, existingShape, iterator);
        } else if (shapeList.size() > existingShape.size()) {
          addShapeList1(shapeList, existingShape, iterator);
        } else if (shapeList.size() < existingShape.size()) {
          addShapeList1(shapeList, existingShape, iterator);
        }
      }
    }
  }

  private static void addShapeList(
      final List<String> shapeList,
      final List<String> existingShape,
      final ListIterator<List<String>> iterator) {
    boolean found = false;
    for (String s : existingShape) {
      if (shapeList.contains(s)) {
        found = true;
        break;
      }
    }
    if (!found) {
      iterator.add(shapeList);
    }
  }

  private static void addShapeList1(
      final List<String> shapeList,
      final List<String> existingShape,
      final ListIterator<List<String>> iterator) {
    for (String s : existingShape) {
      if (shapeList.contains(s)) {
        iterator.remove();
        iterator.add(shapeList);
        break;
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

  private static void calculateProduct() {
    int area = 1;
    for (List<String> areaList : lists) {
      area = area * areaList.size();
    }
    System.out.println(area);
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
