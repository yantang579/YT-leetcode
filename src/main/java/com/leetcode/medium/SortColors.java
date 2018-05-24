package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/24.
 * <p>
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int count0=0,count1=0,count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)count0++;
            else if(nums[i]==1)count1++;
            else count2++;
        }
        for(int i=0;i<nums.length;i++){
            if(count0-->0) nums[i]=0;
            else if(count1-->0) nums[i]=1;
            else nums[i]=2;
        }
        return;
    }
}
