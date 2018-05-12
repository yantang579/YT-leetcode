package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/7.
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        while(n>1){
            if(n%2!=0)
                return false;
            n/=2;
        }
        return true;
    }
}
