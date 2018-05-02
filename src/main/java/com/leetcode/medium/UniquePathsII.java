package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/2.
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null ||obstacleGrid.length==0) return 0;
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[][] dp=new int[n][m];
        if(obstacleGrid[0][0]==0) dp[0][0]=1;
        for(int i=1;i<m;i++)
            if(obstacleGrid[0][i]==0 && dp[0][i-1]==1) dp[0][i]=1;
            else dp[0][i]=0;
        for(int i=1;i<n;i++)
            if(obstacleGrid[i][0]==0 && dp[i-1][0]==1) dp[i][0]=1;
            else dp[i][0]=0;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(obstacleGrid[i][j]==0)
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                else
                    dp[i][j]=0;
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        UniquePathsII uniquePathsII=new UniquePathsII();
        int[][] grid=new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsII.uniquePathsWithObstacles(grid));
    }
}
