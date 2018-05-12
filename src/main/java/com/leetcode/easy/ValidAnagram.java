package com.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lqy on 2017/11/28.
 * <p>
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * <p>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),0);
            map.put(s.charAt(i),map.get(s.charAt(i))+1);
        }

        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i)))
                return false;
            else{
                if(map.get(t.charAt(i))<0)
                    return false;
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
            }
        }
        return true;
    }

    /**
     * 不用map，只有26个英文小写字母，ascii码-97对应0-25,
     * 与map的含义一致。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s,String t){
        if (s.length() != t.length()) return false;

        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) map[s.charAt(i)-97]++;
        for (int i = 0; i < t.length(); i++) map[t.charAt(i)-97]--;
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) return false;
        }
        return true;
    }
}
