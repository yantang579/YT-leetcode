package com.leetcode.medium;

import java.util.*;

/**
 * Created by lqy on 2018/5/31.
 * <p>
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key=String.valueOf(temp);
            List<String> list;
            if (map.containsKey(key)) {
                list = map.get(key);
                list.add(str);
                map.put(key, list);
            } else {
                list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] str=new String[]{"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams groupAnagrams=new GroupAnagrams();
        groupAnagrams.groupAnagrams(str);
    }
}
