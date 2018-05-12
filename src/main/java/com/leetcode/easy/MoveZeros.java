package com.leetcode.easy;

/**
 * Created by lqy on 2017/11/22.
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 *      You must do this in-place without making a copy of the array.
 *      Minimize the total number of operations.
 */
public class MoveZeros {
    /**
     * 时间复杂度为o(n)
     * 设置一个newIndex，将遍历的所有部位0的元素重新填写
     * @param nums
     */
    public void moveZeros(int[] nums){
        int length=nums.length;
        int newIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
                nums[newIndex++]=nums[i];
        }
        for(int i=newIndex;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
