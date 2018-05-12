package com.leetcode.easy;

/**
 * Created by yantang on 2018/2/11.
 * <p>
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 2^31.
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *       ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int result=0;
        for(int i=0;i<32;i++){
            result+=((x&1)^(y&1));
            x>>=1;
            y>>=1;
        }
        return result;
    }
    public int hammingDistance2(int x,int y){
        int result=0;
        int num=x^y;
        for(int i=0;i<32;i++){
            result+=num&1;
            num=num>>1;
        }
        return result;
    }
}
