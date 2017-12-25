package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/25.
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindromeII {
    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int l = -1, r = s.length();
        while (++l < --r) {
            if (s.charAt(l) != s.charAt(r)) return (isPalindrome(s, l, r + 1) || isPalindrome(s, l - 1, r));
        }
        return true;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while (++l < --r) {
            if (s.charAt(l) != s.charAt(r)) return false;
        }
        return true;
    }
}
