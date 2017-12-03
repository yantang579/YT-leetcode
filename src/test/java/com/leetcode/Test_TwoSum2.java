package com.leetcode;

import com.leetcode.easy.TwoSum2;
/**
 * Created by lqy on 2017/11/22.
 */
public class Test_TwoSum2 {
    public static void main(String[] args){
        int[] numbers=new int[]{5,25,75};
        int target=100;
        TwoSum2 test=new TwoSum2();
        int[] result=new int[2];
        result=test.twoSum(numbers,target);
        System.out.println(result[0]);
        System.out.println(result[1]);

    }
}
