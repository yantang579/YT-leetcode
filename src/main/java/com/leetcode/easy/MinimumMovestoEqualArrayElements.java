package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/7.
 * <p>
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 3
 * <p>
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * <p>
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * <p>
 * 解题思路：
 * 将n-1个元素+1相当于将1个元素-1
 * 所以最简单的算法是，将所有元素都减为数组中最小的元素的值
 * <p>
 * minMoves=sum(array)-array.length * minNum
 */
public class MinimumMovestoEqualArrayElements {
    public int minMoves(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            min=min<nums[i]?min:nums[i];
            sum+=nums[i];
        }
        return sum-nums.length*min;
    }
}
