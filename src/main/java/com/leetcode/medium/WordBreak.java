package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lqy on 2018/5/6.
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class WordBreak {
    /**
     * 一维dp数组,二层循环：
     * for(i:0->s.length) 表示s从0到i的子串能否通过wordDict中的字符串拼接而成
     *  for(j:0->i) 表示s从j到i的子串能否在wordDict中找到对应的字符串且s从0到j能否通过wordDict中的字符串拼接而成
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null||s.length()==0) return false;
        if(wordDict==null) return false;
        boolean[] dp=new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            if(wordDict.contains(s.substring(0,i+1))){
                dp[i]=true;
                continue;
            }
            for(int j=1;j<=i;j++){
                if(dp[j-1]&&wordDict.contains(s.substring(j,i+1))) {
                    dp[i] = true;
                    continue;
                }
            }
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        String s="ab";
        List<String> wordDict=new ArrayList<String>();
        wordDict.add("a");
        wordDict.add("b");
        WordBreak wordBreak=new WordBreak();
        System.out.println(wordBreak.wordBreak(s,wordDict));
    }
}
