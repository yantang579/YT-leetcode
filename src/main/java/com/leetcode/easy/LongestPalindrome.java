package com.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lqy on 2017/11/28.
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * <p>
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {
    /**
     * 这种方法是错的
     * 如果s=ccc
     * 那么返回2,
     * 正确应该返回3
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        if(s.length()==0)
            return 0;
        char[] letters=s.toCharArray();
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<letters.length;i++){
            int j=map.getOrDefault(letters[i],0);
            map.put(letters[i],j+1);
        }
        int res=0;
        boolean key=true;
        for(Map.Entry entry:map.entrySet()){
            int value=(Integer)entry.getValue();
            if(value%2==0)
                res+=value;
            else if(value!=1) {
                res=res+value-1;
            }
            else{
                if(key){
                    res++;
                    key=false;
                }
            }
        }
        return res;
    }

    public int longestPalindrome2(String s){
        if(s.length()==0)
            return 0;
        int count=0;
        Set<Character> set=new HashSet<Character>();
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }
            else{
                count++;
                set.remove(s.charAt(i));
            }
        }
        if(!set.isEmpty())
            return count*2+1;
        return count*2;
    }
}
