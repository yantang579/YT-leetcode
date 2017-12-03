package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lqy on 2017/12/3.
 * <p>
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 * <p>
 * If there is no answer, return the empty string.
 * Example 1:
 * Input:
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 * Example 2:
 * Input:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation:
 * Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 * Note:
 * <p>
 * All the strings in the input will only contain lowercase letters.
 * The length of words will be in the range [1, 1000].
 * The length of words[i] will be in the range [1, 30].
 */
public class LongestWordinDictionary {
    /**
     * 这种方式就是将String[]排序，这样自然字母排序就会升序排列，单词的子串也会在前边
     * 第一步：将所有1个字母的放到set中
     * 第二步：从word.length>=2开始，判断其去掉最后一个字母的子串是不是在set中
     *          如果在，说明其有可能成为最长的单词
     *          如果没有，则不管了
     * 在这个for循环中，记得res更新的比较要看word.length>res.length,因为apply在apple后面，但是不能更新掉apple
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String res="";
        Set<String> set = new HashSet<String>();
        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0,word.length()-1))){
                res=word.length()>res.length()?word:res;
                set.add(word);
            }
        }
        return res;
    }
}
