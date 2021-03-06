package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/2.
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 * because they are adjacent houses.
 * Example 2:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums==null ||nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return 0;
        int res1=rob(nums,0,nums.length-2);
        int res2=rob(nums,1,nums.length-1);
        return res1>res2?res1:res2;
    }
    public int rob(int[] nums,int left,int right){
        int len=right-left+1;
        int[] dp=new int[len];
        dp[0]=nums[left];
        dp[1]=Math.max(nums[left+1],nums[left]);
        for(int i=2;i<len;i++){
            dp[i]=Math.max(dp[i-2]+nums[i+left],dp[i-1]);
        }
        return dp[len-1];
    }
}
