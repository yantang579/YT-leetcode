package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/8.
 * <p>
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 *
 * 使nums[i]记录nums[0]-nums[i]的和
 */
public class RangeSumQueryImmutable {
    /**
     * public NumArray(int[] nums) {}
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
    int[] nums;
    public RangeSumQueryImmutable(int[] nums){
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        this.nums=nums;
    }

    public int sumRange(int i, int j) {
        if(i==0) return nums[j];
        else return nums[j]-nums[i-1];
    }
}
