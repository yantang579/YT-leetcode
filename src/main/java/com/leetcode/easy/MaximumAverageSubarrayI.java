package com.leetcode.easy;

/**
 * Created by lqy on 2017/11/24.
 *
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

         Example 1:
             Input: [1,12,-5,-6,50,3], k = 4
             Output: 12.75
             Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
         Note:
             1 <= k <= n <= 30,000.
             Elements of the given array will be in the range [-10,000, 10,000].

 * Double.MIN_VALUE竟然不是最小的double值！！！！！
 */
public class MaximumAverageSubarrayI {
    /**
     * 这种方式超时,TLE,O(n*k)
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        double res=Double.NEGATIVE_INFINITY;
        double local=0;
        for(int i=0;i<=nums.length-k;i++){
            for(int j=i;j<k+i;j++){
                local+=nums[j];
            }
            if(local>res)
                res=local;
            local=0;
        }
        return res/k;
    }
    public double findMaxAverage2(int[] nums,int k){
        double res;
        double local=0;
        for(int i=0;i<k;i++){
            local+=nums[i];
        }
        res=local;
        for(int i=k;i<nums.length;i++){
            local=local+nums[i]-nums[i-k];
            res=res>local?res:local;
        }
        return res/k;
    }
}
