package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lqy on 2017/11/23.
 * <p>
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 * Here a k-diff pair is defined as an integer pair (i, j),
 * where i and j are both numbers in the array and their absolute difference is k.
 * <p>
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 */
public class KdiffPairsinanArray {

    /**
     * 方法一，哈希map
     * 将nums数组中的元素放入hashmap中
     * key为nums中元素的值，value为出现的次数
     * 遍历hashmap，根据k的值做两种处理
     *      1、k==0，判断entry.getValue的值>=2
     *      2、k>0，判断当前key+k是否存在
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        if (nums.length == 0 || k < 0)
            return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    res++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)){
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 方法二：
     * 对数组排序，然后设置两个指针，进行判断
     * 注意：
     *      1、相同数字只算一对，所以要在diff==k时，判断right的下一个或者left的下一个是否和当前值一致
     * @param nums
     * @param k
     * @return
     */
    public int findPairs2(int[] nums,int k){
        if(nums.length==0 || k<0){
            return 0;
        }
        int left=0,right=1,count=0,diff;
        Arrays.sort(nums);
        while(right<nums.length){
            diff=nums[right]-nums[left];
            if(diff<k)
                right++;
            else if(diff>k)
                left++;
            else{
                left++;
                right++;
                count++;
                while(right<nums.length && nums[right]==nums[right-1])
                    right++;
                while(left<nums.length && nums[left]==nums[left-1])
                    left++;
            }
            if(left==right)
                right++;
        }
        return count;
    }
}
