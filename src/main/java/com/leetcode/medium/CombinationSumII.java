package com.leetcode.medium;

import java.util.*;

/**
 * Created by lqy on 2018/5/13.
 * <p>
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class CombinationSumII {

    Set<List<Integer>> temp=new HashSet<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates==null||candidates.length==0) return new ArrayList<List<Integer>>(temp);
        Arrays.sort(candidates);
        combinationSum2Helper(candidates,new ArrayList<Integer>(),candidates.length-1,target);
        return new ArrayList<List<Integer>>(temp);
    }
    private void combinationSum2Helper(int[] candidates,List<Integer> list,int index,int target){
        if(target==0){
            temp.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=index;i>=0;i--){
            if(candidates[i]>target) continue;
            list.add(candidates[i]);
            combinationSum2Helper(candidates,list,i-1,target-candidates[i]);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates=new int[]{10,1,2,7,6,1,5};
        CombinationSumII combinationSum2=new CombinationSumII();
        System.out.println(combinationSum2.combinationSum2(candidates,8));
    }
}
