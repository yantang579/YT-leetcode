package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/7.
 * <p>
 * <p>
 * Related to question Excel Sheet Column Title
 * <p>
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 *      A -> 1
 *      B -> 2
 *      C -> 3
 * ...
 *      Z -> 26
 *      AA -> 27
 *      AB -> 28
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int i=0;
        int res=0;
        while(i<s.length()){
            res=res*26+s.charAt(i)-'A'+1;
            i++;
        }
        return res;
    }
}
