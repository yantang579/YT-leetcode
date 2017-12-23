package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/23.
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
 * <p>
 * For example, with A = "abcd" and B = "cdabcdab".
 * <p>
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 * <p>
 * Note:
 * The length of A and B will be between 1 and 10000.
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int count=B.length()/A.length();
        if(B.length()%A.length()!=0) count++;
        StringBuilder reA=new StringBuilder();
        for(int i=0;i<count;i++)
            reA.append(A);
        for(int i=0;i<reA.length()-B.length()+1;i++){
            if(reA.substring(i,B.length()+i).equals(B)) return count;
        }
        count++;
        reA.append(A);
        for(int i=0;i<reA.length()-B.length()+1;i++){
            String a=reA.substring(i,B.length()+i);
            if(a.equals(B)) return count;
        }
        return -1;
    }
}
