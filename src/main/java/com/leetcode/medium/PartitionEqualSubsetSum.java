package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/6.
 * <p>
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 * <p>
 * Input: [1, 5, 11, 5]
 * <p>
 * Output: true
 * <p>
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * <p>
 * Input: [1, 2, 3, 5]
 * <p>
 * Output: false
 * <p>
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        boolean[][] dp=new boolean[nums.length+1][sum/2+1];
        dp[0][0]=true;
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=sum/2;j++){
                dp[i][j]=dp[i-1][j]||(j-nums[i-1]>=0?dp[i-1][j-nums[i-1]]:false);
            }
        }
        return dp[nums.length][sum/2];
    }

    public boolean canPartition2(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        boolean[] dp=new boolean[sum/2+1];
        dp[0]=true;
        for(int i=1;i<=nums.length;i++){
            for(int j=sum/2;j >= nums[i - 1];j--){
                dp[j]=dp[j]||dp[j-nums[i-1]];
            }
        }
        return dp[sum/2];
    }

    public static void main(String[] args) {
        int nums[]={1,5,11,5};
        PartitionEqualSubsetSum partitionEqualSubsetSum=new PartitionEqualSubsetSum();
        System.out.println(partitionEqualSubsetSum.canPartition2(nums));
    }
}
