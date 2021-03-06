package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/7.
 *
 * Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion?
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        while(n>1){
            if(n%3!=0)
                return false;
            n/=3;
        }
        return true;
    }

}
