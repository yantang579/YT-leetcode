package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/8.
 * <p>
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * <p>
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsofaString {
    /**
     * vowels:a,e,i,o,u,A,E,I,O,U
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        if(s.length()==0) return s;
        int i=0,j=s.length()-1;
        StringBuilder res= new StringBuilder();
        while(i<s.length()){
            res.append(s.charAt(i++));
        }
        i=0;
        while(i<j){
            if(!isVowels(s.charAt(i)))
                i++;
            else if(!isVowels(s.charAt(j)))
                j--;
            else{
                res.setCharAt(i,s.charAt(j));
                res.setCharAt(j,s.charAt(i));
                i++;j--;
            }
        }
        return res.toString();
    }
    public boolean isVowels(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public String reverseVowels2(String s){
        char[] res=s.toCharArray();
        int i=0,j=s.length()-1;
        String vowels="aeiouAEIOU";
        while(i<j){
            while(i<j && vowels.indexOf(res[i])<0)
                i++;
            while(i<j && vowels.indexOf(res[j])<0)
                j--;
            char temp=res[i];
            res[i]=res[j];
            res[j]=temp;
            i++;
            j--;
        }
        return new String(res);
    }
}

