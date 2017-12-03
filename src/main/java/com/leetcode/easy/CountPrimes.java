package com.leetcode.easy;

import java.util.Arrays;

/**
 * Created by lqy on 2017/11/27.
 * <p>
 * Description:
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Credits:
 * Special thanks to @mithmatt for adding this problem and creating all test cases.
 */
public class CountPrimes {
    /**
     * 解析：
     * 给出一个非负数，然后返回比它小的所有质数的个数
     * <p>
     * 判断每一个数是不是质数，这个方法超时
     */
    public int countPrimes(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return 0;
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimeNum(i))
                res++;
        }
        return res;
    }

    public boolean isPrimeNum(int num) {
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    /**
     * 思路：
     * 我们知道2是最小的质数，那么2的倍数均不为质数（因为它们可以分解为一个数*2），所以我们可以将小于n的数中2的倍数，全部排除掉。
     * 排除掉2的整数倍后，剩下的数中大于2的最小的数就是下一个质数，也就是3.
     * 同样我们可以排除掉小于n的数中3的整数倍的数，得到下一个质数为5.
     */
    public int countPrimes2(int n){
        if(n==0 ||n==1||n==2){
            return 0;
        }
        boolean[] isPrimes=new boolean[n];
        Arrays.fill(isPrimes,false);
        int count=0;
        for(int i=2;i<n;i++){
            if(isPrimes[i]==false){
                count++;
                for(int j=2;j<n;j++){
                    isPrimes[i*j]=true;
                }
            }
        }
        return count;
    }
}
