package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/7.
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 * <p>
 * x is guaranteed to be a non-negative integer.
 * <p>
 * Example 1:
 *      Input: 4
 *      Output: 2
 * Example 2:
 *      Input: 8
 *      Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
 */
public class Sqrt_x {
    public int mySqrt(int x) {
        int res= (int) Math.sqrt(x);
        return res;
    }

    /**
     * time limited???
     * @param x
     * @return
     */
    public int mySqrt2(int x){
        int left=0;int right=x;
        int mid=0;
        while(left+1<right){
            mid=(left+right)/2;
            if(mid*mid<x)
                left=mid;
            else if(mid*mid>x)
                right=mid;
            else
                return mid;
        }
        return right*right <= x?right:left;
    }
}
