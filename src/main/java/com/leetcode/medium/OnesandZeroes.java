package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/6.
 * <p>
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
 * <p>
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.
 * <p>
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
 * <p>
 * Note:
 * The given numbers of 0s and 1s will both not exceed 100
 * The size of given string array won't exceed 600.
 * Example 1:
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 * <p>
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 * Example 2:
 * Input: Array = {"10", "0", "1"}, m = 1, n = 1
 * Output: 2
 * <p>
 * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 */
public class OnesandZeroes {
    /**
     * 三维数组优化成二维数组
     * 二维数组的i、j分别表示0和1的个数
     * 最外层循环遍历strs数组
     * 递推公式(i和j从右向左遍历)：
     * dp[i][j]=max{dp[i][j],dp[i-zeros][j=ones]+1}
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs==null||strs.length==0) return 0;
        if(m==0&&n==0) return 0;
        int[][] dp=new int[m+1][n+1];
        for(String str:strs){
            int zeros=findcountsof0(str);
            int ones=str.length()-zeros;
            for(int i=m;i>=zeros;i--){
                for(int j=n;j>=ones;j--){
                    dp[i][j]=Math.max(dp[i][j],dp[i-zeros][j-ones]+1);
                }
            }
        }
        return dp[m][n];
    }
    public int findcountsof0(String str){
        int res=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0') res++;
        }
        return res;
    }
}
