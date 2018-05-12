package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/7.
 * <p>
 * <p>
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 *
 * 10进制--->27进制
 * 注意事项：
 * A-Z对应1-26
 * 普通进制中是从0开始对应的
 *
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
    String res="";
        while(n!=0){
            res=(char)((n-1)%26+'A')+res;
            n=(n-1)/26;
        }
        return res;
    }
}
