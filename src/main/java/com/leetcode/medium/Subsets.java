package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lqy on 2018/5/13.
 * <p>
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<Integer>());
        if(nums.length==0) {
            return res;
        }
        for(int i=0;i<nums.length;i++){
            subsetsHelper(nums,0,i+1,new ArrayList<Integer>());
        }
        return res;
    }
    /**
     *
     * @param nums 数的集合
     * @param index 开始的序号
     * @param count 当前子集应该凑满的数量
     * @param list 当前子集
     */
    private void subsetsHelper(int[] nums,int index,int count,List<Integer> list){
        if(count==0){
            res.add(new ArrayList<Integer>(list));
            return ;
        }
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            subsetsHelper(nums,i+1,count-1,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3};
        Subsets subsets=new Subsets();
        System.out.println(subsets.subsets(nums));
    }
}
