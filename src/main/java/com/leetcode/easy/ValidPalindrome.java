package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/8.
 * <p>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p>
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    /**
     * 只保留字母和数字，去掉空格、标点字符
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if(s.length()==0 || s==null) return true;
        int i=0,j=s.length()-1;
        while(i<j){
            if(!isValid(s.charAt(i)))
                i++;
            else if(!isValid(s.charAt(j)))
                j--;
            else if(isSame(s.charAt(i),s.charAt(j))){
                i++;j--;
            }
            else
                return false;
        }
        return true;
    }

    public boolean isValid(char c){
        if((c>='A'&&c<='Z')||(c>='a'&&c<='z')||(c>='0'&&c<='9'))
            return true;
        return false;
    }
    public boolean isSame(char c1,char c2){
        if(c1>='A'&&c1<='Z')
            c1=(char)(c1-'A'+'a');
        if(c2>='A'&&c2<='Z')
            c2=(char)(c2-'A'+'a');
        return c1==c2;
    }
}
