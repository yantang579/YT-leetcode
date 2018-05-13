package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lqy on 2018/5/13.
 * <p>
 * <p>
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class SubsetsII {
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.add(new ArrayList<Integer>());
        if(nums.length==0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            subsetsWithDupHelper(nums,used,0,i+1,new ArrayList<Integer>());
        }
        return res;
    }
    private void subsetsWithDupHelper(int[] nums,boolean[] used,int index,int count,List<Integer> list){
        if(count==0){
            res.add(new ArrayList<Integer>(list));
            return ;
        }
        for(int i=index;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;
            if(!used[i]){
                list.add(nums[i]);
                used[i]=true;
                subsetsWithDupHelper(nums,used,i+1,count-1,list);
                list.remove(list.size()-1);
                used[i]=false;
            }

        }
    }
    public static void main(String[] args) {
        int[] nums=new int[]{1,1,2};
        SubsetsII subsets=new SubsetsII();
        System.out.println(subsets.subsetsWithDup(nums));
    }
}
