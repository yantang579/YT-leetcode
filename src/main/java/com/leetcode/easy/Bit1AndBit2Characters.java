package com.leetcode.easy;

/**
 * Created by lqy on 2017/11/24.
 * <p>
 * <p>
 * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
 * <p>
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
 * <p>
 * Example 1:
 * Input:
 * bits = [1, 0, 0]
 * Output: True
 * Explanation:
 * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 * Example 2:
 * Input:
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation:
 * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 * Note:
 * <p>
 * 1 <= len(bits) <= 1000.
 * bits[i] is always 0 or 1.
 */
public class Bit1AndBit2Characters {
    public boolean isOneBitCharacter(int[] bits) {
        int len=bits.length;
        if(len==1)
            return true;
        if(len==2){
            if (bits[0]==0)
                return true;
            else
                return false;
        }
        if(bits[len-3]==0&&bits[len-2]==0)
            return true;
        if(bits[len-3]==0&&bits[len-2]==1)
            return false;
        int i;
        for(i=0;i<len-1;i++){
            if(bits[i]==1)
                i++;
        }
        if(i==len-1)
            return true;
        else
            return false;
    }

    public boolean isOneBitCharacter2(int[] bits) {
        int len=bits.length;
        int i;
        for(i=0;i<len-1;i++){
            if(bits[i]==1)
                i++;
        }
        if(i==len-1)
            return true;
        else
            return false;
    }
}
