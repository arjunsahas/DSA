package com.arjun.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Plus_Arjun {
  private static List<List<String>> lists = new ArrayList<>();
  private static List<String> listspos = new ArrayList<>();

  public static void main(String[] args) {

    // Get User Input block starts

    Scanner scanner = new Scanner(System.in);
    scanner.useDelimiter(System.getProperty("line.separator"));

    System.out.println("Enter matrix number between 2 and 15!!!: \n");

    System.out.println("Enter row num : \n");
    int n = scanner.nextInt();

    System.out.println("Enter column number : \n");
    int m = scanner.nextInt();

    // Get User Input block starts

    String[][] matrix = new String[n][m];

    int prodplus = 1;
    int valid = 0;

    for (int i = 0; i < n; i++) {
      System.out.println("Enter row " + (i + 1) + " : \n");
      String next = scanner.next();
      String[] split = next.split(" ");

      for (int j = 0; j < m; j++) {
        matrix[i][j] = split[j];
      }
    }

    printMatrix(n, m, matrix);

    if (!isValidMatrix(n, m, matrix)) {

      System.out.println("No Valid PLUS possible with bad cells!!!");
      System.exit(0);
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        String content = matrix[i][j];
        if (isGood(content) && !isMatrixEdge(n, m, i, j)) {
          constructShape(n, m, i, j, matrix);
        }
      }
    }

    for (int idx = 0; idx < lists.size(); idx++) {
      listspos.add(lists.get(idx).toString());
    }

    // Sorting plus store list based on length
    listspos = listSort(listspos);

    if (!lists.isEmpty()) {
      prodplus = plusOverlapFinding(listspos);
    }

    System.out.println("MaxProdPlus:" + prodplus);
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
    return content.equals("G");
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

  private static boolean isValidMatrix(int n, int m, String matrix[][]) {
    boolean valid = false;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j].equals("G")) {
          valid = true;
          break;
        }
      }
      if (valid) break;
    }
    return valid;
  }

  private static List<String> listSort(List<String> listxy) {
    for (int i = 0; i < listxy.size(); i++) {
      for (int j = 0; j < listxy.size() - i - 1; j++) {
        if ((listxy.get(j)).length() < (listxy.get(j + 1)).length()) {
          Collections.swap(listxy, j, j + 1);
        }
      }
    }
    return listxy;
  }

  // Below code finds overlap plus and final product

  private static int plusOverlapFinding(List<String> plusxypos) {

    String compute1 = new String();
    String compute2 = new String();

    String[] pair_comp;

    int comp_counter = 0;
    int id1;
    int id2;

    int overlapflag = 0;

    List<Integer> key_store_plus = new ArrayList<Integer>();

    int match_cnt = 0;
    System.out.println("Hi:" + plusxypos);

    if (plusxypos.size() > 1) {

      for (int j = 0; j < plusxypos.size(); j++) {

        compute1 = plusxypos.get(j).toString();

        System.out.println("OUTET1:" + compute1);
        overlapflag = 1;

        /*pair1 = compute1.substring(compute1.indexOf("=") + 1,
        compute1.length());*/

        pair_comp = compute1.split(",");
        // System.out.println("HiiiSpl:"+pair_comp);

        for (int k = j + 1; k < plusxypos.size(); k++) {

          compute2 = plusxypos.get(k).toString();
          /*compute3 = compute2.substring(compute2.indexOf("=") + 1,
          compute2.length());*/

          for (String s_val : pair_comp) {
            System.out.println("OUTET2:" + compute2 + ":" + s_val);

            id1 = s_val.indexOf("[");
            id2 = s_val.indexOf("]");

            if (id1 >= 0) {

              s_val = s_val.substring(id1 + 1);
            }

            if (id2 > 0) {

              s_val = s_val.substring(0, id2);
            }

            match_cnt = compute2.indexOf(s_val);

            if (match_cnt >= 0) {
              System.out.println("Break!!!" + s_val);
              break;
            }

            comp_counter = comp_counter + 1;
          }

          if (comp_counter == pair_comp.length) {
            key_store_plus.add(compute1.split(",").length);
            break;
          }
          comp_counter = 0;
        }
        // System.out.println("Hi:"+plusxypos);

      }

    } else {
      compute1 = plusxypos.get(0).toString();
      key_store_plus.add(compute1.split(",").length);
    }

    if (overlapflag == 1 && key_store_plus.size() == 0) {
      compute1 = plusxypos.get(0).toString();
      key_store_plus.add(compute1.split(",").length);
    }

    System.out.println("Final:" + key_store_plus);

    if (key_store_plus.size() > 1) {
      return key_store_plus.get(0) * key_store_plus.get(1);
    } else {
      return key_store_plus.get(0) * 1;
    }
  }
}
