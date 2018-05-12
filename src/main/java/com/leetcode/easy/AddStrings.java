package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/7.
 * <p>
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        String res = "";
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? num1.charAt(i--) - 48 : 0;
            int y = j >= 0 ? num2.charAt(j--) - 48 : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            res = String.valueOf(sum % 10) + res;
        }
        return carry > 0 ? "1" + res : res;
    }

    /**
     * StringBuilder非常快啊
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings2(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            res.append(sum % 10);
        }
        if(carry>0)
            res.append(1);
        return res.reverse().toString();
    }
}
