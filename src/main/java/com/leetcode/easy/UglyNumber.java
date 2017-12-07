package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/7.
 * <p>
 * Write a program to check whether a given number is an ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * <p>
 * Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if(num<=0) return false;
        while(num>0){
            if(num%2!=0)
                break;
            num/=2;
        }
        while(num>0){
            if(num%3!=0)
                break;
            num/=3;
        }
        while(num>0){
            if(num%5!=0)
                break;
            num/=5;
        }
        if(num==1) return true;
        return false;
    }
}
