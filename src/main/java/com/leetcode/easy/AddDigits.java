package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/7.
 * <p>
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * For example:
 * <p>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * <p>
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 * 本题与happynumber题目相似，但是happynumber是可能产生循环的，得不到1，本题不会
 */
public class AddDigits {
    /**
     * 传统方法
     * @param num
     * @return
     */
    public int addDigits(int num) {
        while(num/10>0){
            int sum=0;
            while(num>0){
                sum+=num%10;
                num/=10;
            }
            num=sum;
        }
        return num;
    }

    public int addDigits2(int num) {
        return num==0?0:(num%9==0?9:num%9);
    }
}
