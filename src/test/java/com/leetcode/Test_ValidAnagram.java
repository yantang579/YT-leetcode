package com.leetcode;

import com.leetcode.easy.WordPattern;
/**
 * Created by lqy on 2017/11/28.
 */
public class Test_ValidAnagram {
    public static void main(String args[]){
        String s="abba";
        String t="dog cat cat dog";

        WordPattern test= new WordPattern();
        test.wordPattern(s,t);
    }
}
