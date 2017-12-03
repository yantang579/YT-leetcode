package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lqy on 2017/11/29.
 * <p>
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
 * <p>
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 * <p>
 * Example 1:
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * Note: The length of the input array will not exceed 20,000.
 *
 * 题目解析：
 * 将nums数组中的所有数字都加入到哈希表中
 * 然后遍历哈希表，判断每个数是不是有比它大1的数
 * 如果有，计算着两个数的个数之和
 * 取个数最大的两个数
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map= new HashMap<Integer, Integer>();
        int res=0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int num:map.keySet()){
            if(map.containsKey(num+1)){
                res=Math.max(res,map.get(num)+map.get(num+1));
            }
        }
        return res;
    }
}
