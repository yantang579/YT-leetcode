package com.leetcode.easy;

/**
 * Created by lqy on 2017/11/21.
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i]+=1;
            if (digits[i]==10)
                digits[i]=0;
            else
                break;
        }
        if(digits[0]==0){
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
