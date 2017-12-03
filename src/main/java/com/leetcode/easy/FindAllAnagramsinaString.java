package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lqy on 2017/11/28.
 * <p>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsinaString {

    /**
     * 707ms,太慢了
     * s串每次截取p.length长度的子串，与p判断是否是乱序字谜
     * 乱序字谜isAnagram用的是之前的代码
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        int pLen = p.length();
        for (int i = 0; i < s.length() - pLen + 1; i++) {
            if (this.isAnagram(s.substring(i, i + pLen), p))
                result.add(i);
        }
        return result;
    }

    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) map[s.charAt(i) - 97]++;
        for (int i = 0; i < t.length(); i++) map[t.charAt(i) - 97]--;
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) return false;
        }
        return true;
    }

    /**
     * 方法二：
     * 利用滑动窗口Sliding Window
     * 首先统计字符串p的字符个数
     * 然后用两个变量left和right表示滑动窗口的左右边界
     * 用变量count表示字符串p中需要匹配的字符个数
     * 然后开始循环while
     *      如果右边界的字符已经在哈希表中了，说明该字符在p中有出现，
     *      则count自减1，然后哈希表中该字符个数自减1，右边界自加1，
     *      如果此时count减为0了，说明p中的字符都匹配上了，那么将此时左边界加入结果res中
     *      如果此时right和left的差为p的长度，说明此时应该去掉最左边的一个字符，
     *      我们看如果该字符在哈希表中的个数大于等于0，说明该字符是p中的字符，
     *      为啥呢，因为上面我们有让每个字符自减1，如果不是p中的字符，那么在哈希表中个数应该为0，自减1后就为-1，所以这样就知道该字符是否属于p，
     *      如果我们去掉了属于p的一个字符，cnt自增1
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--;
            //if(hash[s.charAt(right)]>=1){
            // count--;
            // hash[s.charAt(right)]--;
            // right++;
            // }

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }
}
