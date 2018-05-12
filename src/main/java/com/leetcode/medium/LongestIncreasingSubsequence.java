package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/7.
 * <p>
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * <p>
 * Your algorithm should run in O(n2) complexity.
 * <p>
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {
    /**
     * lis[i]=max{lis[j]+1} 0<=j<i
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int[] lis=new int[nums.length];
        for(int i=0;i<lis.length;i++) lis[i]=1;
        for(int i=1;i<lis.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    lis[i]=Math.max(lis[i],lis[j]+1);
                }
            }
        }
        int max=1;
        for(int i=0;i<lis.length;i++){
            max=Math.max(lis[i],max);
        }
        return max;
    }
    public int lengthOfLIS2(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int[] lis=new int[nums.length];
        lis[0]=1;
        for(int i=1;i<lis.length;i++){
            if(nums[i]>nums[i-1])
                lis[i]=lis[i-1]+1;
            else lis[i]=lis[i-1];
        }
        return lis[nums.length-1];
    }

}
