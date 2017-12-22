package com.leetcode.easy;

import java.util.Arrays;

/**
 * Created by lqy on 2017/12/8.
 * <p>
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
 * <p>
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
 * <p>
 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
 * <p>
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 * Example 1:
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 * Example 2:
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses c
 *
 * 解析：
 * 遍历houses，对没有个house，在heaters中用二分查找比house大的最小的heater
 * 1、如果house<heaters中所有元素，则最小cover是heaters[0]-house
 * 2、如果house>heaters中所有元素，则最小cover是house-heaters[heaters.length-1]
 * 3、二分查找到heaters[high-1] < house < heaters[high]，则最小cover是距离house最近的heater与house的绝对值
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        if(houses.length==0 || heaters.length==0) return 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res=0;
        for(int house:houses){
            res=Math.max(res,binarySearch(heaters,house));
        }
        return res;
    }
    public int binarySearch(int []heaters,int house){
        int length=heaters.length;
        int minLen=0;
        if(house<=heaters[0])
            return heaters[0]-house;
        else if(house>heaters[length-1])
            return house-heaters[length-1];
        else{
            int low=0,high=length-1;
            int middle=(high-low)/2+low;
            while(low<high){
                if(heaters[middle]>=house) high=middle;
                else low=middle+1;
                middle=(high-low)/2+low;
            }
            minLen=Math.min(heaters[high]-house,house-heaters[high-1]);
        }
        return minLen;
    }
}
