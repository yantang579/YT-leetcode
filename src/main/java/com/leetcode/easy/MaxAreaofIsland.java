package com.leetcode.easy;

/**
 * Created by lqy on 2017/11/24.
 * <p>
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * <p>
 * Example 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class MaxAreaofIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int maxArea=0;
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                if(grid[i][j]==1)
                    maxArea=Math.max(maxArea,dfs(grid,i,j));
        return maxArea;
        }
    public int dfs(int grid[][],int row ,int col){
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col]==1){
            grid[row][col]=0;
            return 1+dfs(grid,row-1,col)+dfs(grid,row,col-1)+dfs(grid,row+1,col)+dfs(grid,row,col+1);
        }
        return 0;
    }
}
