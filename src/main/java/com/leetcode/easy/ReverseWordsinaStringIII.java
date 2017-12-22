package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/22.
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        String[] wordsArray=s.split(" ");
        for(int i=0;i<wordsArray.length;i++){
            wordsArray[i]=reverseWord(wordsArray[i]);
        }
        String res="";
        for(String word:wordsArray){
            res+=word;
            res+=" ";
        }
        res=res.substring(0,res.length()-1);
        return res;
    }
    public String reverseWord(String s){
        char[] ch=s.toCharArray();
        for(int i=0,j=ch.length-1;i<j;i++,j--){
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
        }
        String res=String.valueOf(ch);
        return res;
    }
}
