package com.leetcode.easy;

import java.util.Arrays;

/**
 * Created by lqy on 2017/11/24.
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.

         Example 1:
             Input: [1,2,3]
             Output: 6
         Example 2:
             Input: [1,2,3,4]
             Output: 24
         Note:
             The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
             Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

    注意事项：
        nums的取值范围是[-1000,1000]，使三个数的乘积最大，可以有两种情况：
        1、（-c）*（-b）*（a）
        2、c*b*a
 */
public class MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums){
        int res;
        int length=nums.length;
        Arrays.sort(nums);
        res=nums[0]*nums[1]>=nums[length-2]*nums[length-3]?nums[0]*nums[1]:nums[length-2]*nums[length-3];
        res*=nums[length-1];
        return res;
    }
}
