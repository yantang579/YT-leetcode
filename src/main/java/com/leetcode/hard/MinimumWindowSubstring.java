package com.leetcode.hard;

/**
 * Created by lqy on 2018/5/26.
 * <p>
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        String res = "";
        int[] hash=new int[256];
        for(char c:t.toCharArray()){
            hash[c]++;
        }
        int left=0;//滑动窗口的左边界
        int count=0;
        int minLen=s.length()+1;
        int [] desArr=new int[256];
        for(int right=0;right<s.length();right++){
            if(hash[s.charAt(right)]!=0){
                desArr[s.charAt(right)]++;
                if(desArr[s.charAt(right)]<=hash[s.charAt(right)]) count++;
            }
            while(count==t.length()){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    res=s.substring(left,right+1);
                }
                if(hash[s.charAt(left)]!=0){
                    desArr[s.charAt(left)]--;
                    if(desArr[s.charAt(left)]<hash[s.charAt(left)]) count--;
                }
                ++left;
            }
        }
        return res;
    }
}
