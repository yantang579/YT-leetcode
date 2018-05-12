package com.leetcode.easy;

import java.util.Stack;

/**
 * Created by lqy on 2017/12/25.
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '{' || cur == '(' || cur == '[') st.push(cur);
            else {
                if(st.empty()) return false;
                String pre = st.pop().toString();
                if (cur == ')' && pre.charAt(0) != '(') return false;
                if (cur == '}' && pre.charAt(0) != '{') return false;
                if (cur == ']' && pre.charAt(0) != '[') return false;
            }
        }
        if(st.empty()) return true;
        return false;
    }
}
