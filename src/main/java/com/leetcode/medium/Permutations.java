package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lqy on 2018/5/9.
 * <p>
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums==null ||nums.length==0) return res;
        permuteHelper(nums,0,res,new ArrayList<Integer>());
        return res;
    }
    private void permuteHelper(int[] nums,int index,List<List<Integer>> res,List<Integer> list){
        if(index==nums.length){
            res.add(list);
            return ;
        }
        for(int i=index;i<nums.length;i++){
            ArrayList<Integer> list1=new ArrayList<Integer>(list);
            int temp=nums[index];
            nums[index]=nums[i];
            nums[i]=temp;
            list1.add(nums[index]);
            permuteHelper(nums,index+1,res,list1);
            temp=nums[index];
            nums[index]=nums[i];
            nums[i]=temp;
        }
        return;
    }
}
