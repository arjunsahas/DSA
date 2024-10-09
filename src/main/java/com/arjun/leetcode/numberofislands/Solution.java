package com.arjun.leetcode.numberofislands;

class Solution {
  public int numIslands(char[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    char[][] visitedGrid = new char[n][m];
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (isNotVisited(i, j, grid, visitedGrid)) {
          dfs(grid, i, j, n, m, visitedGrid);
          count++;
        }
      }
    }
    return count;
  }

  private boolean isNotVisited(int i, int j, char[][] grid, char[][] visitedGrid) {
    return grid[i][j] == '1' && visitedGrid[i][j] != '1';
  }

  private void dfs(char[][] grid, int i, int j, int n, int m, char[][] visitedGrid) {
    if (!isSafe(i, j, n, m)) {
      return;
    }
    if (isNotVisited(i, j, grid, visitedGrid)) {
      visitedGrid[i][j] = '1';
      dfs(grid, i, j + 1, n, m, visitedGrid);
      dfs(grid, i, j - 1, n, m, visitedGrid);
      dfs(grid, i + 1, j, n, m, visitedGrid);
      dfs(grid, i - 1, j, n, m, visitedGrid);
    }
  }

  public boolean isSafe(int i, int j, int n, int m) {
    return i < n && j < m && i >= 0 && j >= 0;
  }

  public static void main(String[] args) {
    char[][] input = {
      {'1', '1', '0', '0', '1'}, //
      {'1', '1', '0', '0', '1'}, //
      {'1', '1', '0', '0', '1'}, //
    };

    char[][] input1 = {
      {'1', '1', '0', '0', '1'}, //
      {'1', '1', '0', '0', '1'}, //
      {'1', '1', '0', '0', '1'}, //
      {'1', '1', '0', '0', '1'}, //
    };

    char[][] input2 = {
      {'1', '1', '0', '0', '1'}, //
      {'1', '1', '0', '0', '1'}, //
      {'1', '1', '0', '0', '1'}, //
      {'1', '1', '1', '0', '1'}, //
    };

    char[][] input3 = {
      {'1', '0', '1', '1', '1'}, //
      {'1', '0', '1', '0', '1'}, //
      {'1', '1', '1', '0', '1'}, //
    };
    int numIslands = new Solution().numIslands(input3);
    System.out.println("Number of islands: " + numIslands);
  }
}
