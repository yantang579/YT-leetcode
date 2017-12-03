package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lqy on 2017/11/22.
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
    /**
     * 方法一：
     * 使用hashset
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.add(num))
                return true;
        }
        return false;
    }

    /**
     * 方法二：
     * 使用排序，然后查找
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums){
        if(nums.length==0)
            return false;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
