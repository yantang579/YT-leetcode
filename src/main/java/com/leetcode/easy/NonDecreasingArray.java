package com.leetcode.easy;

/**
 * Created by lqy on 2017/11/24.
 * <p>
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 * <p>
 * Example 1:
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first  4  to  1  to get a non-decreasing array.
 * <p>
 * <p>
 * Example 2:
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * <p>
 * Note: The n belongs to [1, 10,000].
 *
 * greedy贪婪
 */
public class NonDecreasingArray {
    public boolean CheckPossibility(int[] nums){
        if(nums.length==1)
            return true;
        int count=0;
        for(int i=1;i<nums.length &&count<=1 ;i++){
            if(nums[i-1]>nums[i]){//发现逆序，i-1元素比i元素大
                count++;
                if(i>1 && nums[i-2]>nums[i])
                    nums[i]=nums[i-1];
                else
                    nums[i-1]=nums[i];
            }
        }
        if(count>1)
            return false;
        return true;
    }

    /**
     * 思路不对！！！
     * 其实考虑三个数是对的，但是没有把握住核心
     * 考虑三个数的原因，是我们比较到两个数发现逆序的时候，
     * 有可能修改第一个数，有可能修改第二个数，
     * 而具体修改哪个数，取决于再前面一个数
     * 因此需要考虑三个数。
     *
    public boolean CheckPossibility(int[] nums) {
        if (nums.length == 1)
            return true;
        int count = 0;
        boolean flag;
        flag = nums[0] >= Integer.MIN_VALUE && nums[1] >= nums[0];
        if (!(flag)) {
            count++;
            nums[0] = nums[1];
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (!(nums[i] >= nums[i - 1] && nums[i + 1] >= nums[i] && nums[i + 1] >= nums[i - 1])) {
                count++;
                nums[i] = nums[i + 1];
            }

        }
        if (!(nums[nums.length - 1] >= nums[nums.length - 2] && Integer.MAX_VALUE >= nums[nums.length - 1])) {
            count++;
            nums[nums.length - 1] = Integer.MAX_VALUE;
        }

        if (count > 1)
            return false;
        return true;
    }
    */
}
