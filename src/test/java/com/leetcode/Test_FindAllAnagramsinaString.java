package com.leetcode;

import com.leetcode.easy.FindAllAnagramsinaString;
/**
 * Created by lqy on 2017/11/28.
 */
public class Test_FindAllAnagramsinaString {
    public static void main(String args[]){
        String s="abab";
        String p="ab";
        FindAllAnagramsinaString test =new FindAllAnagramsinaString();
        test.findAnagrams(s,p);
    }
}
