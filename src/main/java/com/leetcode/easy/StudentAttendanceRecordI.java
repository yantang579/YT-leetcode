package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/23.
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * <p>
 * You need to return whether the student could be rewarded according to his attendance record.
 * <p>
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int Alen=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A'){
                Alen++;
                if(Alen>1) return false;
            }
            if(s.charAt(i)=='L'){
                if(i+1<s.length() && i+2<s.length()&& s.charAt(i+1)=='L'&&s.charAt(i+2)=='L') return false;
            }
        }
        return true;
    }
}
