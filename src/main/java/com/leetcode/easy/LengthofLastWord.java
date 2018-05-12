package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/25.
 * <p>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        String[] strArray=s.split(" ");
        if(strArray.length==0) return 0;
        String res=strArray[strArray.length-1];
        return res.length();
    }
    public int lengthOfLastWord2(String s){
        s=s.trim();//Remove the prefix or suffix in a string
        int lastIndex=s.lastIndexOf(" ")+1;
        return s.length()-lastIndex;
    }
}
