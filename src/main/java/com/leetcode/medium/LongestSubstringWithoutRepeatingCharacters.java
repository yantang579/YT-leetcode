package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/26.
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * <p>
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0, right = -1;
        int maxLen = 1;
        int[] freq = new int[256];
        while (left < s.length()) {
            if (right + 1 < s.length() && freq[s.charAt(right+1)] == 0) {
                freq[s.charAt(++right)]++;
            } else {
                freq[s.charAt(left++)]--;
            }
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }

}
