package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/2.
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * <p>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()+1];
        if(s.length()==1 && s.charAt(0)=='0') return 0;
        dp[0]=1;
        dp[1]=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='0' ) {
                if (s.charAt(i-1)=='1'||s.charAt(i-1)=='2') dp[i+1]=dp[i];
                else return 0;
            }
            else if(s.charAt(i-1)=='1' && s.charAt(i)>='1' &&s.charAt(i)<='9') dp[i+1]=dp[i]+dp[i-1];
            else if(s.charAt(i-1)=='2' && s.charAt(i)>='1' &&s.charAt(i)<='6') dp[i+1]=dp[i]+dp[i-1];
            else dp[i+1]=dp[i];
        }
        return dp[s.length()];
    }
}
