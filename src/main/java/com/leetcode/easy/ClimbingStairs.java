package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/8.
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * Input: 2
 * Output:  2
 * Explanation:  There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * Example 2:
 * Input: 3
 * Output:  3
 * Explanation:  There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {
    /**
     * Time Limit Exceeded
     * Recursive
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else return climbStairs(n - 2) + climbStairs(n - 1);
    }

    /**
     * Dynamic pragraming
     * but lots of spaces
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int res[]=new int[n+1];
        res[0]=0;
        res[1]=1;
        res[2]=2;
        for(int i=3;i<=n;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res[n];
    }

    /**
     * Dynamic pragraming
     * less space
     *
     * @param n
     * @return
     */
    public int climbStairs3(int n){
        if(n==1)return 1;
        int pre=1,cur=1,tmp;
        for(int i=2;i<n;i++){
            tmp=cur;
            cur=pre+cur;
            pre=tmp;
        }
        return cur;
    }
}
