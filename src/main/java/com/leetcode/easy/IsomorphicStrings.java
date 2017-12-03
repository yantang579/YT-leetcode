package com.leetcode.easy;

import java.util.*;

/**
 * Created by lqy on 2017/11/27.
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * <p>
 * For example,
 * Given "egg", "add", return true.
 * <p>
 * Given "foo", "bar", return false.
 * <p>
 * Given "paper", "title", return true.
 * <p>
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings {

    /**
     * 这种方法的时间复杂度和空间复杂度都最小。
     * 两个数组m1和m2分别用来存储s和t字符串的256个ascii码
     * 记录charater最后出现的位置
    * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        Arrays.fill(m1,0);
        Arrays.fill(m2,0);
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    /**
     * 这种方法是使用哈希表
     * 一个hashmap：key为s中的字符，value为t中的字符，意思是，s中的这个字符，替换成t中的这个字符
     * 一个set，用来存储t中的字符。
     * for i:s
     *  if  i存在在hashmap中的keyset中（说明i在之前遇到过，并且进行了替换）
     *      if value(i) != t(i) return false;
     *  if  i不存在在hashmap中的keyset中（说明i在之前没有遇到过）
     *      if set中存在t(i) return false; （说明t中该字符出现过，并且进行了替换，但是hashmap中没有，导致出现多个字符映射到一个字符）
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic2(String s,String t){
        Map<Character,Character> map=new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                if(set.contains(t.charAt(i)))
                    return false;
                map.put(s.charAt(i),t.charAt(i));
                set.add(t.charAt(i));
            }
            else{
                if(map.get(s.charAt(i))!= t.charAt(i))
                    return false;
            }
        }
        return true;
    }
}
