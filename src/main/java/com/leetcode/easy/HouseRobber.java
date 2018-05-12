package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/8.
 * <p>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    /**
     * 设计数组maxRob
     * maxRob[i]记录nums[i]及之前的店铺最大盗取金额
     * 每次到新的店铺i，可以选择盗取或者不盗取，而盗取需要i-1的店铺没有盗取。所以，递推公式为：
     * maxRob[i]=max{maxRob[i-2]+nums[i],maxRob[i-1]}
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] maxRob = new int[nums.length];
        maxRob[0] = nums[0];
        maxRob[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            maxRob[i] = Math.max(maxRob[i - 2] + nums[i], maxRob[i - 1]);
        }
        return maxRob[nums.length - 1];
    }

    public int rob2(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int pre=nums[0];
        int cur=Math.max(nums[0],nums[1]);
        int tmp;
        for(int i=1;i<nums.length-1;i++){
            tmp=cur;
            cur=Math.max(nums[i+1]+pre,cur);
            pre=tmp;
        }
        return cur;
    }
}
