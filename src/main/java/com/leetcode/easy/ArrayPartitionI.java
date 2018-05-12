package com.leetcode.easy;

import java.util.Arrays;

/**
 * Created by lqy on 2017/11/23.
 *
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

     Example 1:
        Input: [1,4,3,2]
        Output: 4
        Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).

    Note:
        n is a positive integer, which is in the range of [1, 10000].
        All the integers in the array will be in the range of [-10000, 10000].
 */

/**
 * 在考虑一种情况，是将2n个元素，分成n对，每对取max，然后求max（ai+bi）的总和最小
 */
public class ArrayPartitionI {

    /**
     * 方法一：排序，取奇数个
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        for(int i=0;i<nums.length-1;i=i+2){
            res+=nums[i];
        }
        return res;
    }

    /**
     * 方法二：空间换时间，因为题目要求中设定了n的取值范围和nums的取值范围
     */
    public int arrayPairSum2(int[] nums) {
        int[] exists = new int[20001];
        for (int num : nums) {
            exists[num+10000]++;
        }
        int sum = 0;
        boolean odd = true;
        for (int i = 0; i < 20001; i++) {
            while (exists[i] > 0) {
                if (odd) {
                    sum += i-10000;
                }
                odd = !odd;
                exists[i]--;
            }
        }
        return sum;
    }
}
