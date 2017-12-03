package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lqy on 2017/11/28.
 * <p>
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * <p>
 * Credits:
 * Special thanks to @minglotus6 for adding this problem and creating all test cases.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words= str.split(" ");
        HashMap<Character, String> map = new HashMap<Character, String>();
        if(words.length!= pattern.length())
            return false;

        for(int i=0; i<words.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(words[i]))
                    return false;
            }else{
                if(map.containsValue(words[i])) //要注意是双向映射
                    return false;
                map.put(c, words[i]);
            }
        }
        return true;
    }
}
