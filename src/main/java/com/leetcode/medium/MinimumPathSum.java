package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/2.
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int[][] dp=new int[grid.length+1][grid[0].length+1];
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<dp.length;i++){
            dp[i][1]=dp[i-1][1]+grid[i-1][0];
        }
        for(int i=1;i<dp[0].length;i++){
            dp[1][i]=dp[1][i-1]+grid[0][i-1];
        }
        for(int i=2;i<dp.length;i++){
            for(int j=2;j<dp[0].length;j++){
                dp[i][j]=Math.min(dp[i-1][j]+grid[i-1][j-1],dp[i][j-1]+grid[i-1][j-1]);
            }
        }
        return dp[grid.length][grid[0].length];
    }

    public static void main(String[] args) {
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        MinimumPathSum minimumPathSum=new MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(grid));
    }
}
