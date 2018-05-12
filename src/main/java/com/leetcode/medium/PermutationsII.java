package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lqy on 2018/5/12.
 * <p>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        permuteUniqueHelper(nums, new boolean[nums.length], res, new ArrayList<Integer>());
        return res;
    }

    private void permuteUniqueHelper(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) continue;
            if(!used[i]){
                used[i]=true;
                list.add(nums[i]);
                permuteUniqueHelper(nums,used,res,list);
                list.remove(list.size()-1);
                used[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{3,3,0,3};
        PermutationsII permutationsII=new PermutationsII();
        System.out.println(permutationsII.permuteUnique(nums));
    }
}
