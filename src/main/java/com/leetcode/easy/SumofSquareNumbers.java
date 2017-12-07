package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/7.
 * <p>
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 * <p>
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 * Input: 3
 * Output: False
 */
public class SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= Math.sqrt(c); i++) {
            int t = (int) Math.sqrt(c - i * i);
            if (t * t == c - i * i)
                return true;
        }
        return false;
    }
}
