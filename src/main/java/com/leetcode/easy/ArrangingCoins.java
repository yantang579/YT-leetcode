package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/7.
 * <p>
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * <p>
 * Given n, find the total number of full staircase rows that can be formed.
 * <p>
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * <p>
 * Example 1:
 * <p>
 * n = 5
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * <p>
 * n = 8
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 4th row is incomplete, we return 3.
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if(n==0) return 0;
        int total=0;
        for(int i=1;n>0;i++){
            n=n-i;
            if(n>=0)
                total++;
        }
        return total;
    }

    /**
     * 1+2+3+……+x<=n
     * (1+x)*x/2<=n
     * 1/2 * x^2 + 1/2 * x <= n
     * @param n
     * @return
     */
    public int arrangeCoins2(int n){
        int start = 0;
        int end = n;
        int mid;
        while (start <= end){
            mid = (start + end) >>> 1;
            if ((0.5 * mid * mid + 0.5 * mid ) <= n){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start - 1;
    }
}
