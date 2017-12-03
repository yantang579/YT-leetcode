package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lqy on 2017/11/30.
 * <p>
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 * <p>
 * Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
 * <p>
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Note:
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order.
 * <p>
 * 解析思路：
 * <p>
 * 首先排序，那么正常情况下，nums[i]==i+1
 * 两种特殊情况，
 * 1、先遇到出现两次的数：nums[i] < i + 1
 * 2、先遇到少出现的数：nums[i] > i + 1
 * 注意两个数字返回数组中的位置
 *
 * 然后另一个数用求和相减得到
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        Arrays.sort(nums);
        int sum = 0, key = 0;
        int total = (1 + nums.length) * nums.length / 2;

        for (int num : nums) sum += num;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < i + 1) {
                res[0] = nums[i];
                sum -= nums[i];
                key = 1;
                break;
            }
            if (nums[i] > i + 1) {
                res[1] = i + 1;
                sum = sum + i + 1;
                key = 0;
                break;
            }
        }
        res[key] = Math.abs(total - sum);
        return res;
    }
}
