package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/7.
 * <p>
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Note: Your solution should be in logarithmic time complexity.时间复杂度是O(logn)
 */

/**
 * 如果考虑普通的方法，不考虑时间复杂度，可以求阶乘之后，取余10，判断0的个数
 * 但是在N稍大的时候，就会导致阶乘的结果溢出
 * <p>
 * 考虑时间复杂度和溢出，解题思路如下：
 * 1、考虑n!的质数因子
 *      因为10的产生是2*5，而在阶乘中2的个数永远是多余5的。例如：
 *      11! = 11 * 7 * 5^2 * 3^4 * 2^8
 *      7! = 7 * 5 * 3 * 2^4
 * 2、因此考虑n!中质数因子5的个数
 * 3、怎么计算5的个数，有一个方法是计算floor(n/5)，但是诸如25，125之类的数字有不止一个5，所以需要计算floor(n/25),floor(n/125)
 * 4、所以，n!后缀0的个数 = n!质因子中5的个数 = floor(n/5) + floor(n/25) + floor(n/125) + ....
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int res=0,i=5;
        while(n>0){
            n/=5;
            res+=n;
        }
        return res;
    }
}