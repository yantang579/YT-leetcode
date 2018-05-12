package com.leetcode.easy;

import java.util.Arrays;

/**
 * Created by lqy on 2017/11/23.
 *
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

     Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

     Example 1:
         Input: flowerbed = [1,0,0,0,1], n = 1
         Output: True
     Example 2:
         Input: flowerbed = [1,0,0,0,1], n = 2
         Output: False
     Note:
         The input array won't violate no-adjacent-flowers rule.
         The input array size is in the range of [1, 20000].
         n is a non-negative integer which won't exceed the input array size.
 */
public class CanPlaceFlowers {

    /**
     * 要考虑两个问题，
     * 1、边界：index为0和length-1的两个元素，如果是0，那么三元组的中间值需要考虑这两个元素。即左边和右边再加一个0；
     * 2、判断可以放花，需要将flowerbed[i+1]修改为1；
     * 3、考虑flower=0的情况
     * 4、考虑length=1的情况
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flower=n;
        int length=flowerbed.length;
        if(length==1 && flowerbed[0]==0){
            flower--;
            flowerbed[0]=1;
        }

        if(flowerbed[0]==0 && length>1){
            if(flower>=0 && flowerbed[1]==0){
                flower--;
                flowerbed[0]=1;
            }
        }
        for(int i=0;i<flowerbed.length-2;i++){
            if(flower>=0 && flowerbed[i]==0 && flowerbed[i+1]==0 && flowerbed[i+2]==0){
                flower--;
                flowerbed[i+1]=1;
            }

        }
        if(flowerbed[length-1]==0){
            if(flower>=0 && flowerbed[length-2]==0){
                flower--;
                flowerbed[length-1]=1;
            }
        }
        if(flower>0){
            return false;
        }
        return true;
    }
}
