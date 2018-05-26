package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/26.
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: [2,3,1,2,4,3], s = 7
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null ||nums.length==0) return 0;
        int left=0;//滑动窗口左边界
        int right=0;//滑动窗口右边界
        int minLen=nums.length;//当前最小的长度
        int sum=nums[0];//当前滑动窗口内的和
        boolean flag=false;
        while(right<nums.length){
            if(sum>=s){
                flag=true;
                minLen=Math.min(minLen,right-left+1);
                sum-=nums[left];
                left++;
            }else{
                if(right+1<nums.length){
                    right++;
                    sum+=nums[right];
                } else break;
            }
        }
        return flag==true?minLen:0;

    }
}
