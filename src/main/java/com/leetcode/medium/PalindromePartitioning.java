package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lqy on 2018/5/12.
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */

public class PalindromePartitioning {
    List<List<String>> res=new ArrayList<List<String>>();
    public List<List<String>> partition1(String s) {
        if(s==null||s.length()==0)return res;
        partitionHelper1(s,0,new ArrayList<String>());
        return res;
    }
    private void partitionHelper1(String s,int index,List<String> list){
        if(index==s.length()){
            res.add(new ArrayList<String>(list));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome1(s.substring(index,i+1))){
                list.add(s.substring(index,i+1));
                partitionHelper1(s,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }

    /**
     * o(n)方法遍历
     * @param s
     * @return
     */
    private boolean isPalindrome1(String s){
        if(s.length()==0)return false;
        for(int i=0,j=s.length()-1;i<=j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }

    /**
     * 修改了判断回文子串的方式，改成动态规划法判断回文子串
     * @param s
     * @return
     */
    public List<List<String>> partition2(String s) {
        if(s==null||s.length()==0)return res;
        boolean[][] isPalindrome=new boolean[s.length()][s.length()];
        setIsPalindrome(isPalindrome,s);
        partitionHelper2(s,0,new ArrayList<String>(),isPalindrome);
        return res;
    }

    /**
     * p[i][j]=(str[i]==str[j]) && p[i+1][j-1]
     * @param isPalindrome
     * @param s
     */
    private void setIsPalindrome(boolean[][] isPalindrome,String s){
        for(int i=0;i<s.length();i++){
            isPalindrome[i][i]=true;
        }
        for(int i=s.length()-2;i>=0;i--){
            for(int j=i+1;j<=s.length()-1;j++){
                isPalindrome[i][j]=(i+1<=j-1?isPalindrome[i+1][j-1]:true)&&(s.charAt(i)==s.charAt(j));
            }
        }
        /*
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                System.out.print(isPalindrome[i][j]+" ");
            }
            System.out.println("\n");
        }
        */
    }
    private void partitionHelper2(String s,int index,List<String> list,boolean[][] isPalindrome){
        if(index==s.length()){
            res.add(new ArrayList<String>(list));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome[index][i]){
                list.add(s.substring(index,i+1));
                partitionHelper2(s,i+1,list,isPalindrome);
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning=new PalindromePartitioning();
        System.out.println(palindromePartitioning.partition2("aab"));
    }
}
