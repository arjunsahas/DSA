package com.arjun.leetcode.numberofislands;

public class Solution1 {
    
    char land = '1';
    char water = '0';
    int islands = 0;
    public int numIslands(char[][] grid) {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == land)
                {
                    islands++;
                    visitNearByLands(grid,i,j);
                }
            }
        }
        return islands;
    }
    
    public void visitNearByLands(char[][] grid,int x,int y)
    {
        if(x>=grid.length || y>=grid[0].length || x<0 || y<0)
        {
            return;
        }
        if(grid[x][y] == water)
        {
            return;
        }
        grid[x][y] = water;
        visitNearByLands(grid,x+1,y);
        visitNearByLands(grid,x,y-1);
        visitNearByLands(grid,x-1,y);
        visitNearByLands(grid,x,y+1);
    }

    public static void main(String[] args) {
        char[][] input = { { '1', '1', '0', '0', '1' }, //
                { '1', '1', '0', '0', '1' }, //
                { '1', '1', '0', '0', '1' }, //
        };

        char[][] input1 = { { '1', '1', '0', '0', '1' }, //
                { '1', '1', '0', '0', '1' }, //
                { '1', '1', '0', '0', '1' }, //
                { '1', '1', '0', '0', '1' }, //
        };

        char[][] input2 = { { '1', '1', '0', '0', '1' }, //
                { '1', '1', '0', '0', '1' }, //
                { '1', '1', '0', '0', '1' }, //
                { '1', '1', '1', '0', '1' }, //
        };

        char[][] input3 = { { '1', '0', '1', '1', '1' }, //
                            { '1', '0', '1', '0', '1' }, //
                            { '1', '1', '1', '0', '1' }, //
        };
        int numIslands = new Solution().numIslands(input3);
        System.out.println("Number of islands: " + numIslands);
    }
}
