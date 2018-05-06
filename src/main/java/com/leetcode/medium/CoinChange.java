package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/6.
 * <p>
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * <p>
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {

    /**
     * 完全背包问题，从数组中选出物品，每个物品数量infinite，使其金额凑成amount
     *
     * 完全背包问题的公式：
     * F(i,j)=max{F(i-1,j),F(i,j-w[i])+v[i]}
     *
     * 当前问题公式：
     * F(i,j)=min{F(i-1,j),F(i,j-w[i])+1}
     *
     * 初始条件：
     * 第一列表示，amount=0，所以第一列都为0
     * 第一行表示，用{}空的数组凑amount，所以除了dp[0][0]=0，其与都是Integer.MAX_VALUE
     *
     * 二维dp数组可以转换成一维dp数组：
     * F(j)=min{F(j),F(j-w[i])+1} 从左向右刷新数组
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0) return -1;
        if(amount==0) return 0;
        int[] dp=new int[amount+1];
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]<=j){
                    dp[j]=Math.min(dp[j],dp[j-coins[i-1]]==Integer.MAX_VALUE?dp[j-coins[i-1]]:dp[j-coins[i-1]]+1);
                }
            }
        }

        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] coins={1};
        CoinChange coinChange=new CoinChange();
        System.out.println(coinChange.coinChange(coins,2));
    }
}
