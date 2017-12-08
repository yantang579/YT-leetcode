package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/8.
 * <p>
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString {
    public String reverseString(String s) {
        if(s.length()==0)
            return "";
        StringBuilder res= new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}
