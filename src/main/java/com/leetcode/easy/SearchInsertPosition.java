package com.leetcode.easy;

/**
 * Created by lqy on 2017/11/20.
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *      Input: [1,3,5,6], 5
 *      Output: 2
 * Example 2:
 *      Input: [1,3,5,6], 2
 *      Output: 1
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low=0,high=nums.length-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) high=high-1;
            else low=low+1;
        }
        return low;
    }
}
