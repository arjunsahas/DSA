package com.arjun.algorithms.dfs.problem;

import java.util.*;

public class DFSProblem {

  static class Node {
    int x;
    int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static class Region {
    List<Node> nodes = new ArrayList<>();
  }

  public static int getBiggestRegion(int[][] matrix) {
    List<Region> regions = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 1) {
          if (regions.size() == 0) {
            Region r = new Region();
            r.nodes.add(new Node(i, j));
            regions.add(r);
          } else {
            Region r = checkInRegion(regions, i, j);
            if (r != null) {
              r.nodes.add(new Node(i, j));
            } else {
              Region r1 = new Region();
              r1.nodes.add(new Node(i, j));
              regions.add(r1);
            }
          }
        }
      }
    }
    Collections.sort(
        regions,
        new Comparator<Region>() {
          public int compare(Region r1, Region r2) {
            if (r1.nodes.size() > r2.nodes.size()) {
              return -1;
            } else if (r1.nodes.size() < r2.nodes.size()) {
              return 1;
            } else return 0;
          }
        });
    return regions.get(0).nodes.size();
  }

  static Region checkInRegion(List<Region> regions, int i, int j) {
    for (Region region : regions) {
      for (Node node : region.nodes) {
        if (checkAdjacency(node.x, node.y, i, j)) {
          return region;
        }
      }
    }
    return null;
  }

  static boolean checkAdjacency(int x, int y, int i, int j) {
    return ((i + 1 == x && j == y)
        || (i - 1 == x && j == y)
        || (i == x && j + 1 == y)
        || (i == x && j - 1 == y)
        || (i - 1 == x && j - 1 == y)
        || (i + 1 == x && j + 1 == y)
        || (i - 1 == x && j + 1 == y)
        || (i + 1 == x && j - 1 == y));
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int grid[][] = new int[n][m];
    for (int grid_i = 0; grid_i < n; grid_i++) {
      for (int grid_j = 0; grid_j < m; grid_j++) {
        grid[grid_i][grid_j] = in.nextInt();
      }
    }
    System.out.println(getBiggestRegion(grid));
  }
}
