package com.leetcode.medium;

import java.util.Arrays;

/**
 * Created by lqy on 2018/5/29.
 * <p>
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int flag=0;//-1表示sum<target,1表示sum>target,0表示sum=target
        for(int i=0;i<nums.length-2;i++){
            int[] temp=TwoSumofThreeSumClosest(nums,target-nums[i],i+1,nums.length-1,min,flag);
            if(temp[0]<min){
                min=temp[0];
                flag=temp[1];
            }
        }
        if(flag==0) return target;
        else return flag==1?target+min:target-min;
    }

    /**
     *
     * @param nums
     * @param target
     * @param low
     * @param high
     * @return
     */
    private int[] TwoSumofThreeSumClosest(int[] nums,int target,int low,int high,int min,int flag){
        int minabs=min;
        int PorN=flag;
        while(low<high){
            int sum=nums[low]+nums[high];
            if(target==sum){
                return new int[] {0,0};
            }
            if(sum<target){
                if(minabs>target-sum) {
                    minabs=target-sum;
                    PorN=-1;
                }
                low++;
            }
            if(sum>target){
                if(minabs>sum-target) {
                    minabs=sum-target;
                    PorN=1;
                }
                high--;
            }
        }
        return new int[]{minabs,PorN};
    }
}
