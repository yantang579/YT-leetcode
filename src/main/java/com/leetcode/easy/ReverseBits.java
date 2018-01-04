package com.leetcode.easy;

/**
 * Created by lqy on 2018/1/4.
 * <p>
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        StringBuilder str=new StringBuilder();
        while(n!=0){
            str.append(n%2);
            n=n/2;
        }
        while(str.length()<32){
            str.append(0);
        }
        int res=0;
        int factor=1;
        for(int i=str.length()-1;i>=0;i--){
            res+=str.charAt(i)*factor;
            factor*=2;
        }
        return res;
    }
}
