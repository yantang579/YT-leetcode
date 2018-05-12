package com.leetcode.easy;

import java.util.Arrays;

/**
 * Created by lqy on 2017/11/22.
 * <p>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    /*Boyer-Moore Algorithm多数投票法*/
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            count += nums[i] == res ? 1 : -1;
            if (count <= 0) {
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }
    /*排序后返回中点值就是众数*/
    public int majorityElementBySort(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
