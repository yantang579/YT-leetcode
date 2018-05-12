package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/2.
 * <p>
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<=n;i++){
            for(int j=1;i+j*j<=n;j++){
                dp[i+j*j]=Math.min(dp[i]+1,dp[i+j*j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares=new PerfectSquares();
        System.out.println(perfectSquares.numSquares(4));
    }
}
