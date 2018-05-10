package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lqy on 2018/5/10.
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combinations {
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        if(k>n) return res;
        combineHelper2(nums,0,k,new ArrayList<Integer>());
        return res;
    }

    /**
     * 从nums数组中的index-nums.length中选择k个
     * @param nums
     * @param index
     * @param k
     */
    private void combineHelper(int[] nums,int index,int k,List<Integer> list) {
        if(k==0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(index>=nums.length) return;
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            combineHelper(nums,i+1,k-1,list);
            list.remove(list.size()-1);
        }
    }

    /**
     * 回溯法的剪枝
     * @param nums
     * @param index
     * @param k
     * @param list
     */
    private void combineHelper2(int[] nums,int index,int k,List<Integer> list) {
        if(k==0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(index>=nums.length) return;
        for(int i=index;i<nums.length-k+1;i++){
            list.add(nums[i]);
            combineHelper2(nums,i+1,k-1,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations=new Combinations();
        System.out.println(combinations.combine(4,2));
    }
}
