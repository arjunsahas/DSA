package com.arjun.leetcode.sorroundingregions;

class Solution {
    public void solve(char[][] grid) {

        int R = grid.length;
        int C = grid[0].length;
        char[][] isVisited = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if ((i == 0 || i == R - 1 || j == 0 || j == C - 1) && (grid[i][j] == 'O' && isVisited[i][j] != '1')) {
                    captureRegion(i, j, grid, isVisited);
                }
            }
        }

        for (int i = 0; i < isVisited.length; i++) {
            for (int j = 0; j < isVisited[0].length; j++) {
                if (isVisited[i][j] != '1' && grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
                System.out.print(grid[i][j] + "\t");
            }
            System.out.print("\n");
        }

    }

    private void captureRegion(int i, int j, char[][] grid, char[][] isVisited) {
        if (!isSafe(i, j, grid.length, grid[0].length))
            return;

        if (grid[i][j] == 'O' && isVisited[i][j] != '1') {
            isVisited[i][j] = '1';
            captureRegion(i, j + 1, grid, isVisited);
            captureRegion(i + 1, j, grid, isVisited);
            captureRegion(i - 1, j, grid, isVisited);
            captureRegion(i, j - 1, grid, isVisited);
        }
    }

    private boolean isSafe(int i, int j, int n, int m) {
        return i < n && j < m && i >= 0 && j >= 0;
    }

    public static void main(String[] args) {
        char[][] input1 = { { 'X', 'X', 'X', 'X', 'X' }, //
                { 'X', 'X', 'O', 'O', 'X' }, //
                { 'X', 'X', 'O', 'O', 'O' }, //
                { 'X', 'O', 'X', 'X', 'X' }, //
                { 'X', 'X', 'X', 'X', 'X' } //
        };
        new Solution().solve(input1);
    }

}