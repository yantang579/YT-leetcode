package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/2.
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * <p>
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimetoBuyandSellStockwithCooldown {
    /**
     * 用状态机转换(顺时针)
     *
     *    （自旋）
     *      s0
     *      /\
     *  buy/  \rest
     *    /    \
     *  s1——————s2
     *     sell
     * (自旋)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices==null ||prices.length==0) return 0;
        int len=prices.length;
        int[] s0=new int[len];
        int[] s1=new int[len];
        int[] s2=new int[len];
        s0[0]=0;
        s1[0]=-prices[0];
        s2[0]=Integer.MIN_VALUE;
        for(int i=1;i<len;i++){
            s0[i]=Math.max(s2[i-1],s0[i-1]);
            s1[i]=Math.max(s1[i-1],s0[i-1]-prices[i]);
            s2[i]=s1[i-1]+prices[i];
        }
        return Math.max(s0[len-1],s2[len-1]);
    }
}
