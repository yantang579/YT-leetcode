package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/22.
 * <p>
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * <p>
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 *
 * 解析：
 * 走楼梯，每次走一级或者两级，计算走到楼梯顶端的最小花费
 * 数组中是从第一级楼梯到最后一级楼梯的花费，楼梯顶端是需要走到最后一个数组元素的下一个
 *
 * 动态规划问题
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==0 || cost.length==1) return 0;
        if(cost.length==2) return Math.max(cost[0],cost[1]);
        for(int i=2;i<=cost.length-1;i++){
            cost[i]=Math.min(cost[i]+cost[i-1],cost[i]+cost[i-2]);
        }
        return Math.min(cost[cost.length-1],cost[cost.length-2]);
    }
}
