package com.leetcode.easy;

import java.util.Arrays;

/**
 * Created by lqy on 2017/11/23.
 *
 *  Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 *  then the whole array will be sorted in ascending order, too.
 *  You need to find the shortest such subarray and output its length.
 *
 *  找到数组中最小的一个连续子阵，只要使这个子阵ascending order，则整个数组zscending order。
 *
 *  Example 1:
 *        Input: [2, 6, 4, 8, 10, 9, 15]
 *        Output: 5
 *        Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 *    Note:
 *        Then length of the input array is in range [1, 10,000].
 *        The input array may contain duplicates, so ascending order here means <=.
 */
public class ShortestUnsortedContinuousSubarray    {
    /**
     * 时间复杂度是O(nlogn)
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums){
        int[] sortedNums=new int[nums.length];
        System.arraycopy(nums,0,sortedNums,0,nums.length);
        Arrays.sort(sortedNums);
        int start=0,end=nums.length-1;
        while(start<nums.length && sortedNums[start]==nums[start]){
            start++;
        }
        while(end>=0 && sortedNums[end]==nums[end]){
            end--;
        }
        return end-start+1;
    }
}
