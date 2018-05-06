package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/6.
 * <p>
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 * <p>
 * Example:
 * <p>
 * nums = [1, 2, 3]
 * target = 4
 * <p>
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * <p>
 * Note that different sequences are counted as different combinations.
 * <p>
 * Therefore the output is 7.
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 */
public class CombinationSumIV {
    /**
     * dp公式：
     * dp[j]=sum{dp[j-nums[i]]}, (i:0,1,2······,n-1)
     *
     * target-nums[i] 变为 target，只有一种途径，也就是加上nums[i];那么这种途径带来的次数是dp[target-nums[i]];
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        if(nums==null||nums.length==0) return 0;
        if (target<0) return 0;
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int j=1;j<=target;j++){
            for(int i=0;i<nums.length;i++){
                if(j>=nums[i]){
                    dp[j]+=dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
}
