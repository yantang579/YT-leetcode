package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/23.
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * <p>
 * Please note that the string does not contain any non-printable characters.
 * <p>
 * Example:
 * <p>
 * Input: "Hello, my name is John"
 * Output: 5
 */
public class NumberofSegmentsinaString {
    /**
     * wrong answer:", , , ,        a, eaefa"
     * @param s
     * @return
     */
    public int countSegmentsF(String s) {
        if(s==null ||s.length()==0) return 0;
        String[] res=s.split(" ");
        return res.length;
    }
    public int countSegments(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' ')){
                count++;
            }
        }
        return count;
    }
}
