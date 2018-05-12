package com.leetcode.medium;

import java.util.*;

/**
 * Created by lqy on 2018/5/12.
 * <p>
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class CombinationSum {
    List<List<Integer>> res=new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null||candidates.length==0) return res;
        combinationSumHelper(candidates,new ArrayList<Integer>(),candidates.length-1,target);
        return res;
    }

    /**
     * candidates 数组是升序的
     * index 从末尾开始
     * @param candidates
     * @param list
     * @param index
     */
    private void combinationSumHelper(int[] candidates,List<Integer> list,int index,int target){
        if(index==-1 && target==0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=index;i>=0;i--){
            if(candidates[i]>target) continue;
            for(int j=1;candidates[i]*j<=target;j++){
                list.add(candidates[i]);
                combinationSumHelper(candidates,list,index-1,target-candidates[i]);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates=new int[]{2,3,6,7};
        CombinationSum combinationSum=new CombinationSum();
        System.out.println(combinationSum.combinationSum(candidates,7));
    }
}
