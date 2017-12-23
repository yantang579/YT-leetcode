package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/23.
 * <p>
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * Example 1:
 * Input: "abab"
 * <p>
 * Output: True
 * <p>
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 * <p>
 * Output: False
 * Example 3:
 * Input: "abcabcabcabc"
 * <p>
 * Output: True
 * <p>
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {
    /**
     *  Time Limit Exceeded??
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        int len=s.length();
        int count=2;//the subString copies 'count' times
        for(int i=len/count;count<=len;count++,i=len/count){
            if(len%i==0){
                StringBuilder str= new StringBuilder();
                String subStr=s.substring(0,i);
                for(int j=0;j<count;j++){
                    str.append(subStr);
                }
                if(str.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
