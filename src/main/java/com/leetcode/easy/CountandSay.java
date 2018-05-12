package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/23.
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 */
public class CountandSay {
    /**
     * 计算strs[i] 只能从strs[i-1]得到
     * 因此用数组储存1-n的return
     * strs[n-1]放置n的output字符串
     * <p>
     * 循环中的几点注意事项：
     * 考虑到第一个数字和最后一个数字的count值计算
     * 每次换数字的时候，count清零，在if外面count++
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String[] strs = new String[n];
        strs[0] = "1";
        for (int i = 1; i < n; i++) {
            char number = '0';
            int count = 0;
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < strs[i - 1].length()) {
                if (number != strs[i - 1].charAt(j)) {
                    if (count != 0) {
                        sb.append(count);
                        sb.append(number);
                    }
                    number = strs[i - 1].charAt(j);
                    count = 0;
                }
                j++;
                count++;
            }
            sb.append(count);
            sb.append(number);
            strs[i] = sb.toString();
        }
        return strs[n - 1];
    }
}
