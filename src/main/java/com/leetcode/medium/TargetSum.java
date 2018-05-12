package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/7.
 * <p>
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * <p>
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * <p>
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class TargetSum {
    /**
     * 第一种思路，二维dp数组
     * i表示用前i个数组
     * j-1000表示要凑成的数字，因为所有的最大不超过1000，也就是说最小不小于-1000，因此申请数组为2001个。
     * dp公式是：
     * dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j+nums[i-1]]
     * 表示，前i-1个数字组成j-nums[i-1]，加上当前数字组成j的个数 + 前i-1个数字组成j+nums[i-1]，减去当前数字组成j的个数
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        if(nums==null||nums.length==0||S>1000 ||S<-1000) return 0;
        int[][] dp=new int[nums.length+1][2001];
        dp[0][1000]=1;
        for(int i=1;i<=nums.length;i++){
            for(int j=0;j<=2000;j++){
                if(j<nums[i-1])
                    dp[i][j]=dp[i-1][j+nums[i-1]];
                else if(j+nums[i-1]>2000)
                    dp[i][j]=dp[i-1][j-nums[i-1]];
                else
                    dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j+nums[i-1]];
            }
        }
        return dp[nums.length][S+1000];
    }

    /**
     * 对方法1的优化
     * 两个优化
     * 1、二维数组改成一维数组
     * 2、第二层循环不是计算所有的j值，而是去检查当前层dp[j]是否为0，如果不为0，则将dp[j-nums[i-1]]和dp[j+nums[i-1]]更新
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays2(int[] nums, int S) {
        if(nums==null||nums.length==0||S>1000 ||S<-1000) return 0;
        int[] dp=new int[2001];
        dp[1000]=1;
        for(int i=0;i<nums.length;i++){
            int[] newDp=new int[2001];
            for(int j=0;j<=2000;j++){
                if(dp[j]!=0){
                    if(j>=nums[i]) newDp[j-nums[i]]+=dp[j];
                    if(j+nums[i]<=2000) newDp[j+nums[i]]+=dp[j];
                }
            }
            dp=newDp;
        }
        return dp[S+1000];
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,1,1,1,1};
        TargetSum targetSum=new TargetSum();
        System.out.println(targetSum.findTargetSumWays2(nums,3));
    }
}
