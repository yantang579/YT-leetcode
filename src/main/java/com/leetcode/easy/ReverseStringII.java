package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/23.
 * Given a string and an integer k,
 * you need to reverse the first k characters for every 2k characters counting from the start of the string.
 * If there are less than k characters left, reverse all of them.
 * If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */

/**
 * 注意事项：
 * 对s以2k为单位进行截取，对每个截取单位t
 * t.length<=k:全部反转
 * k<t.length<2k:翻转前k个，后面保持
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        StringBuilder res=new StringBuilder();
        if(s.length()<=k) return reverse(s);
        int len=0;
        boolean mark=true;
        while(len+k<=s.length()){
            String temp=s.substring(len,len+k);
            if(mark==true) {
                res.append(reverse(temp));
                mark=false;
            }
            else{
                res.append(temp);
                mark=true;
            }
            len+=k;
        }
        String temp=s.substring(len,s.length());
        if(mark==true) res.append(reverse(temp));
        else res.append(temp);
        return res.toString();
    }
    public String reverse(String s){
        if(s.length()==0)
            return "";
        StringBuilder res= new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}
