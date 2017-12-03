package com.leetcode.easy;

/**
 * Created by lqy on 2017/11/23.
 * <p>
 * Given a non-empty array of integers,
 * return the third maximum number in this array.
 * If it does not exist, return the maximum number.
 * The time complexity must be in O(n).
 *
 * 需要注意的问题是：可能出现long型的非常小的值
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if (nums.length == 0)
            return 0;
        long max[] = new long[]{Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};

        for (int num : nums) {
            if (num > max[2]) {
                max[0] = max[1];
                max[1] = max[2];
                max[2] = num;
            } else if (num > max[1] && num < max[2]) {
                max[0] = max[1];
                max[1] = num;
            } else if (num > max[0] && num < max[1]) {
                max[0] = num;
            }
        }
        return (max[0] == Long.MIN_VALUE) ? (int) max[2] : (int) max[0];
    }
}
