package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;

/**
 * Created by lqy on 2017/11/22.
 *
 * Rotate an array of n elements to the right by k steps.
 *
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * Note:
 *      Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *
 */
public class RotateArray {
    /**
     * 方法一：
     * k=k%nums.length;
     * 将数组中最后k个元素放入list中
     * 将数组前k-1个元素后移
     * 将list中的k个元素放入数组前k-1个位置
     */
    public void rotate(int[] nums,int k){
        List<Integer> temp =new ArrayList<Integer>();
        k=k%nums.length;
        int n=nums.length;
        for(int i=k;i>0;i--){
            temp.add(nums[n-i]);
        }
        for(int i=n-1;i>=k;i--){
            nums[i]=nums[i-k];
        }
        for(int i=k-1;i>=0;i--){
            nums[i]=temp.get(i);
        }
    }
    /**
     * 方法二：
     * k=k%nums.length;
     * 将数组全部翻转
     * 将0~k-1元素翻转
     * 将k~length-1元素翻转
     */
    public void rotate2(int[] nums,int k){
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

    /**
     * 方法三：
     * 利用System.arraycopy(int[] from,int start,int[] to,int start,int length);
     * Array.copyof(int[] from,int length);
     * Array.copyofrange(int[] from ,int start,int end)  （包括start，不包括end）;
     * 方法
     */
    public void rotate3(int[] nums,int k){
        k=k%nums.length;
        int[] part1= Arrays.copyOf(nums,nums.length-k);
        int[] part2=Arrays.copyOfRange(nums,nums.length-k,nums.length);
        System.arraycopy(part2,0,nums,0,part2.length);
        System.arraycopy(part1,0,nums,part2.length,part1.length);
    }
}
