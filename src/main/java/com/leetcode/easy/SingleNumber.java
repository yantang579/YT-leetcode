package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lqy on 2017/11/27.
 * <p>
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * 要求线性，所以不能用哈希表
 * 使用^异或
 *
 * 0^N=N
 * N^N=0
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            res ^= nums[i];
        }
        return res;
    }

}
