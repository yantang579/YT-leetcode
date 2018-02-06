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

    /**
     * 设这个数为n，用一个初值为0的数result保存反转后的结果
     * 用1对n进行求与，其结果与result进行相加，
     * 再对n向右进行一位移位，对result向左进行一位移位
     * 直到n的最后一位处理完。
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n>>>=1;
            if(i<31) {
                result<<=1;
            }
        }
        return result;
    }
}
