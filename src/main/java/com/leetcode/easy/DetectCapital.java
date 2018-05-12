package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/22.
 * <p>
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * <p>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1:
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(isLowercase(word.charAt(0))){
            for(int i=1;i<word.length();i++){
                if(!isLowercase(word.charAt(i))) return false;
            }
        }
        else {
            int num=0;
            for(int i=1;i<word.length();i++){
                if(isLowercase(word.charAt(i))) num++;
            }
            if(num!=word.length()-1 && num!=0) return false;
        }
        return true;
    }
    public boolean isLowercase(char c){
        if(c>='a'&&c<='z') return true;
        return false;
    }
}
