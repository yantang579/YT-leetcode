package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lqy on 2017/11/27.
 * <p>
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example: 19 is a happy number
 * <p>
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Credits:
 * Special thanks to @mithmatt and @ts for adding this problem and creating all test cases.
 *
 * 解析：
 * 如果不能等于1，那么将循环，
 * 所以重点就是使用set数据结构，
 * 如果set中已经有了这个数字，那么set.add就会跳出循环——return false
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> isLoop = new HashSet<Integer>();
        int squareNum = 0, remain = 0;
        while (isLoop.add(n)) {
            squareNum = 0;
            while (n > 0) {
                remain = n % 10;
                squareNum += remain * remain;
                n = n / 10;
            }
            if (squareNum == 1) return true;
            else n = squareNum;
        }
        return false;
    }
}
