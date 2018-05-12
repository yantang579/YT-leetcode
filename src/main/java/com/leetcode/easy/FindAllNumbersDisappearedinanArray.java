package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lqy on 2017/11/23.
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twiand others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *      Input:
 *          [4,3,2,7,8,2,3,1]
 *      Output:
 *          [5,6]
 *
 */
public class FindAllNumbersDisappearedinanArray {

    /**
     * 方法一：
     * 非常棒的方法：
     * 思路是这样的：每一个数字都应该它原来的位置上，但是如果sort或者exchange，就会花费更多的时间和空间，但是可以进行标记。不会影响后续判断的标记。
     * 对每一个nums[i],nums[i]-1是该元素应该在的位置，因此将nums[nums[i]-1]*=-1;
     * 但是要考虑后面遇到的nums[i]已经成了负值，因此index应该是
     * index=(nums[i]>0?nums[i]:-nums[i])-1
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<Integer>();
        int index;
        for(int num:nums){
            index=(num>0?num:-num)-1;
            if(nums[index]>0)
                nums[index]*=-1;

        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res.add(i+1);
            }
        }
        return res;
   }

    /**
     * 方法二：时间复杂度是o(n)，空间复杂度是o(n)
     * 遍历两遍，
     * 第一遍判断所有元素，如果isExist该元素为false则设为true，一边遍历后，所有元素中false的则为不存在的值
     * 第二遍遍历isExist，如果为false，res.add()加入该元素的index即元素的值。
     *
     * 注意事项：0~n-1与1~n
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums){
        List<Integer> res=new ArrayList<Integer>();
        boolean[] isExist=new boolean[nums.length+1];
        Arrays.fill(isExist,false);
        for(int i=0;i<nums.length;i++){
            if(!isExist[nums[i]])
                isExist[nums[i]]=true;
        }
        for(int i=1;i<=nums.length;i++){
            if(!isExist[i]){
                res.add(i);
            }
        }
        return res;
    }
}
