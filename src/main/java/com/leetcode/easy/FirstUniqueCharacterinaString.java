package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lqy on 2017/12/23.
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        int[] array=new int[26];
        for(int i=0;i<s.length();i++){
            array[s.charAt(i)-'a']++;
        }
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<array.length;i++){
            if(array[i]==1) list.add(i);
        }
        for(int i=0;i<s.length();i++){
            if(list.contains(s.charAt(i)-'a')) return i;
        }
        return -1;
    }
}
