package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lqy on 2017/11/22.
 * Given an array of integers and an integer k, find out
 * whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the difference between i and j is at most k.
 */
public class ContainsDuplicate2 {
    public boolean containsDuplicate(int[] nums,int k){
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) {
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}