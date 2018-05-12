package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/6.
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        String res = "";
        int i = a.length() - 1, j = b.length() - 1, carryBit = 0;
        while (i >= 0 && j >= 0) {
            int p = i >= 0 ? a.charAt(i--) - '0' : 0;
            int q = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = p + q + carryBit;
            res = String.valueOf(sum % 2) + res;
            carryBit = sum / 2;
        }
        return carryBit == 1 ? "1" + res : res;

    }
}
