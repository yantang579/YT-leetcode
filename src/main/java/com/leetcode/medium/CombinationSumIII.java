package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lqy on 2018/5/13.
 * <p>
 * <p>
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * Note:
 * <p>
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums=new int[9];
        for(int i=0;i<9;i++){
            nums[i]=i+1;
        }
        if(k>9||k<0||n>45||n<0) return res;
        combinationSum3Helper(nums,k,n,0,new ArrayList<Integer>());
        return res;
    }
    private void combinationSum3Helper(int[] nums,int k,int n,int index,List<Integer> list){
        if(k==0&&n==0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            combinationSum3Helper(nums,k-1,n-nums[i],i+1,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII combinationSumIII=new CombinationSumIII();
        System.out.println(combinationSumIII.combinationSum3(3,7));
        System.out.println(combinationSumIII.combinationSum3(3,9));
    }
}
