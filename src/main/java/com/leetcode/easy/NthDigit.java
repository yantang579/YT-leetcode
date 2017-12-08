package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/7.
 * <p>
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).
 * <p>
 * Example 1:
 * Input: 3
 * Output: 3
 * <p>
 * Example 2:
 * Input: 11
 * Output: 0
 * <p>
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */

public class NthDigit {
    /**
     * Straight forward way to solve the problem in 3 steps:
     * 1.find the length of the number where the nth digit is from
     * 2.find the actual number where the nth digit is from
     * 3.find the nth digit and return
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int len = 1;
        int round = 9;
        int start = 1;
        while (n > len * round) {
            n -= len * round;
            len+=1;
            round *= 10;
            start *= 10;
        }
        start+=(n-1)/len;
        String s=Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }


}//2147483647
