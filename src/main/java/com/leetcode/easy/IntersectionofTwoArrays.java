package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lqy on 2017/11/28.
 * <p>
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<Integer>();
        Set<Integer> integerSet = new HashSet<Integer>();//可以用arraylist，但是要注意，set中已经放入arraylist中的数字要删除，不然重复数字又会放入arraylist
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                integerSet.add(nums2[i]);
            }
        }
        int[] res=new int[integerSet.size()];
        int i=0;
        for(int num:integerSet){
            res[i++]=num;
        }
        return res;
    }
}
