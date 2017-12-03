package com.leetcode.easy;

/**
 * Created by lqy on 2017/11/20.
 *
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example:
 *      Given nums = [1,1,2],
 *      Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *      It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums){
        int length=1,left=0,right;
        if(nums.length==0) return 0;

        for(right=1;right<nums.length;right++){
            if(nums[right]!=nums[left]){
                nums[++left]=nums[right];
                length++;
            }
        }
        return length;
    }
}
