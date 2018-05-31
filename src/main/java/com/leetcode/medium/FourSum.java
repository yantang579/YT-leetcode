package com.leetcode.medium;

import java.util.*;

/**
 * Created by lqy on 2018/5/29.
 * <p>
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0||nums.length<4) return res;

        Arrays.sort(nums);
        if(nums[0]*4>target||nums[nums.length-1]*4<target) return res;
        int curNum;
        int max=nums[nums.length-1];
        for(int i=0;i<nums.length-3;i++){
            curNum=nums[i];
            if(i>0 && curNum==nums[i-1]) continue;
            if(curNum+3*max<target) continue;
            if(curNum*4>target) break;
            if(curNum*4==target && i+3<nums.length && nums[i+3]==curNum){
                res.add(Arrays.asList(curNum,curNum,curNum,curNum));
                break;
            }
            ThreeNumsofFourSum(nums,target-curNum,i+1,nums.length-1,curNum,res);
        }
        return res;
    }

    /**
     *
     * @param nums
     * @param target
     * @param start
     * @param end
     * @param num1
     * @param fourSum
     */
    public void ThreeNumsofFourSum(int[] nums,int target,int start,int end,int num1,List<List<Integer>> fourSum){
        if(start+1>=end) return;
        if(nums[start]*3>target||nums[end]*3<target) return ;
        int curNum;
        int max=nums[end];
        for(int i=start;i<end-1;i++){
            curNum=nums[i];
            if(i>start&&curNum==nums[i-1]) continue;
            if(curNum+max*2<target) continue;;
            if(curNum*3>target) break;
            if(curNum*3==target && i+2<=end &&nums[i+2]==curNum) {
                fourSum.add(Arrays.asList(num1,curNum,curNum,curNum));
                break;
            }
            TwoNumsofFourSum(nums,target-curNum,i+1,end,num1,curNum,fourSum);
        }
        return;
    }

    /**
     *
     * @param nums
     * @param target
     * @param start
     * @param end
     * @param num1
     * @param num2
     * @param fourSum
     */
    public void TwoNumsofFourSum(int[] nums,int target,int start,int end,int num1,int num2,List<List<Integer>> fourSum){
        if(start>=end) return;
        if(nums[start]*2>target || nums[end]*2<target) return;
        int i=start,j=end,sum,x;
        while(i<j){
            sum=nums[i]+nums[j];
            if(sum==target){
                fourSum.add(Arrays.asList(num1,num2,nums[i],nums[j]));
                while(i+1<j && nums[i+1]==nums[i]) i++;
                i++;
                while(i<j-1 && nums[j]==nums[j-1]) j--;
                j--;
            }
            if(sum>target) j--;
            if(sum<target) i++;
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,0,-1,0,-2,2};
        int target=0;
        FourSum fourSum=new FourSum();
        fourSum.fourSum(nums,target);
    }
}
