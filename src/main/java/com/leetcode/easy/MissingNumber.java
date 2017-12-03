package com.leetcode.easy;

import java.util.Arrays;

/**
 * Created by lqy on 2017/11/22.
 * <p>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {
    /**
     * 数组排序
     * 遍历数组，找到missing number
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != i)
                return i;
        }
        return nums.length;
    }

    /**
     * 求n个数的和
     * 去n-1个数的和
     * 相减
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int total = (nums.length + 1) * nums.length / 2;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        return total-sum;
    }
}
