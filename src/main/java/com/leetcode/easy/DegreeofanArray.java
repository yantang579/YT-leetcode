package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lqy on 2017/11/24.
 * <p>
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * <p>
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 * <p>
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeofanArray {
    public int findShortestSubArray(int[] nums) {
        if(nums.length==1)
            return 1;
        Map<Integer,Integer> count=new HashMap<Integer, Integer>();
        Map<Integer,Integer> start=new HashMap<Integer, Integer>();
        Map<Integer,Integer> end=new HashMap<Integer, Integer>();
        int MaxDegree=0;

        for(int i=0;i<nums.length;i++){
            if(!count.containsKey(nums[i])){
                count.put(nums[i],0);
                start.put(nums[i],i);
            }
            count.put(nums[i],count.get(nums[i])+1);
            end.put(nums[i],i);
            MaxDegree=Math.max(MaxDegree,count.get(nums[i]));
        }
        if(MaxDegree==1)
            return 1;

        int minLength=Integer.MAX_VALUE;
        for(Integer key:count.keySet()){
            if(count.get(key)==MaxDegree){
                minLength=Math.min(end.get(key)-start.get(key)+1,minLength);
            }
        }
        return minLength;
    }
}
