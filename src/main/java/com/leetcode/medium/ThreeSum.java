package com.leetcode.medium;

import java.util.*;

/**
 * Created by lqy on 2018/5/29.
 * <p>
 * Given an array nums of n integers,
 * are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 &&nums[i]==nums[i-1])
                continue;
            else {
                List<List<Integer>> twoNumbers=this.TwoSum(nums,i+1,-nums[i]);
                for(List<Integer> temp:twoNumbers){
                    result.add(temp);
                }
            }
        }
        return result;
    }
    private List<List<Integer>> TwoSum(int[] nums,int start,int target){
        Set<Integer> set=new HashSet<Integer>();
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        for(int i=start;i<nums.length;i++){
            if(set.contains(target-nums[i])){
                ArrayList<Integer> temp=new ArrayList<Integer>();
                temp.add(-target);
                temp.add(nums[i]);
                temp.add(target-nums[i]);
                if(!res.contains(temp))
                    res.add(temp);
            }
            set.add(nums[i]);

        }
        return res;
    }
    /**
     * 思路就是：
     * 1、数字排序
     * 2、最外层循环选择一个数，假设其坐标为start
     * 3、从选择的这个数的右侧开始，即[start+1,...,nums.length]这个数组中，用碰撞指针找到两个num和nums[start]的和等于0
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 &&nums[i]==nums[i-1])
                continue;
            else {
                int left=i+1,right=nums.length-1;
                while(left<right){
                    int sum=nums[i]+nums[left]+nums[right];
                    if(sum==0){
                        List<Integer> temp=new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        result.add(temp);
                        while(left<right&&nums[left]==nums[left+1]) left++;
                        while(left<right&&nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    }
                    else if(sum>0) right--;
                    else left++;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum=new ThreeSum();
        int[] nums=new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(threeSum.threeSum2(nums));
    }
}
