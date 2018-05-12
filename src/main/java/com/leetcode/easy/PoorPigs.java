package com.leetcode.easy;

/**
 * Created by yantang on 2018/2/10.
 * <p>
 * There are 1000 buckets, one and only one of them contains poison, the rest are filled with water.
 * They all look the same. If a pig drinks that poison it will die within 15 minutes.
 * What is the minimum amount of pigs you need to figure out which bucket contains the poison within one hour.
 * Answer this question, and write an algorithm for the follow-up general case.
 * Follow-up:
 * If there are n buckets and a pig drinking poison will die within m minutes,
 * how many pigs (x) you need to figure out the "poison" bucket within p minutes?
 * There is exact one bucket with poison.
 */
public class PoorPigs {
    /**
     *
     * 题目举例是：如果有1000桶水，其中有一个是有毒的。
     * 一头猪喝下水15min后如果死亡，则这桶水有毒。
     * 问题是需要多少头猪在1h内知道哪桶水是毒水。
     *
     * 一头猪在1h内可以进行4轮实验，那么就可以判断5桶水是否有毒。即有0,1,2,3,4五种状态。
     * 同样，如果有2头猪，就可以判断5^2=25桶水是否有毒。
     * 对1000桶水进行5进制编码，5^5>1000，所以5头猪就可以覆盖1000桶水。
     * 所以，给定minutesToTest和minutesToDie，确定进制单位为base=minutesToTest/minutesToDie+1
     * 需要猪的个数为：base^poorPigs>buckets
     *
     * @param buckets
     * @param minutesToDie
     * @param minutesToTest
     * @return
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest){
        int result=0;
        if(buckets==1) return result;
        else {
            int base=minutesToTest/minutesToDie+1;
            while(Math.pow(base,result)<buckets){
                result++;
            }
            return result;
        }
    }
}
