package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/7.
 * <p>
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 * <p>
 * Example 1:
 * Input: 16
 * Returns: True
 * Example 2:
 * Input: 14
 * Returns: False
 */
public class ValidPerfectSquare {
    /**
     * 使用指数速度缩小范围
     * 这个方法不行：x的平方大于Integer.MAX_VALUE时，while的判断式不对
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;
        int x = num / 2;
        while (x * x > num) {
            x /= 2;
        }
        for (int i = x; i < 2 * x; i++) {
            if (i * i == num)
                return true;
        }
        return false;
    }

    /**
     * 1 = 1
     * 4 = 1 + 3
     * 9 = 1 + 3 + 5
     * 16 = 1 + 3 + 5 + 7
     * 25 = 1 + 3 + 5 + 7 + 9
     * 36 = 1 + 3 + 5 + 7 + 9 + 11
     * ....
     * 1+3+...+(2n-1) = (2n-1 + 1)n/2 = n*n
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
        int k=1;
        while(num>0){
            num-=k;
            k+=2;
        }
        if(num==0)return true;
        return false;
    }
}
