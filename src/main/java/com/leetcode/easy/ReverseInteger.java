package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/6.
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output:  321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int res=0;

        while(x!=0){
            if(res>Integer.MAX_VALUE/10 || res<Integer.MIN_VALUE/10){
                return 0;
            }
            res=res*10+x%10;
            x=x/10;
        }
        return res;
    }
}
