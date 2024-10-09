package com.arjun.leetcode.numberofislands;

public class Solution2 {
  public int numIslands(char[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    char[][] visitedGrid = new char[n][m];
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        char c = grid[i][j];
        if (c == '1' && !isVisited(i, j, visitedGrid)) {
          dfs(grid, i, j, n, m, visitedGrid);
          count++;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(visitedGrid[i][j] + " ");
      }
      System.out.println("\n");
    }
    return count;
  }

  private boolean isVisited(int i, int j, char[][] visitedGrid) {
    return visitedGrid[i][j] == '1';
  }

  private void dfs(char[][] grid, int i, int j, int n, int m, char[][] visitedGrid) {
    if (isSafe(i, j, n, m) && grid[i][j] == '1') {
      visitedGrid[i][j] = '1';
      checkAdjacentPlaces(i, j, n, m, grid, visitedGrid);
      if (i < n) dfs(grid, i + 1, j, n, m, visitedGrid);
      else if (j < m) dfs(grid, i, j + 1, n, m, visitedGrid);
    }
    if (isSafe(i, j, n, m) && grid[i][j] == '1') {
      visitedGrid[i][j] = '1';
      checkAdjacentPlaces(i, j, n, m, grid, visitedGrid);
      if (j < m) dfs(grid, i, j + 1, n, m, visitedGrid);
    }
  }

  public void checkAdjacentPlaces(int i, int j, int n, int m, char[][] grid, char[][] visitedGrid) {
    if (isSafe(i, j + 1, n, m) && grid[i][j + 1] == '1') {
      visitedGrid[i][j + 1] = '1';
    }
    if (isSafe(i, j - 1, n, m) && grid[i][j - 1] == '1') {
      visitedGrid[i][j - 1] = '1';
    }
    if (isSafe(i + 1, j, n, m) && grid[i + 1][j] == '1') {
      visitedGrid[i + 1][j] = '1';
    }
    if (isSafe(i - 1, j, n, m) && grid[i - 1][j] == '1') {
      visitedGrid[i - 1][j] = '1';
    }
  }

  public boolean isSafe(int i, int j, int n, int m) {
    return i < n && j < m && i >= 0 && j >= 0;
  }
}
