package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/25.
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    /**
     * 将strs数组中的第一个string作为前缀prefix，
     * 然后与数组中剩余的所有字符串进行比较，indexOf(str)==0
     * 如果不满足就删掉prefix的最后一个字母
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0 || strs==null)  return "";
        String str=strs[0];
        int i=1;
        while(i<strs.length){
            while(strs[i].indexOf(str)!=0) str=str.substring(0,str.length()-1);
            i++;
        }
        return str;
    }
}
