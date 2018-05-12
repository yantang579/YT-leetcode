package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/6.
 * <p>
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p>
 * click to show spoilers.
 * <p>
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * <p>
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * <p>
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 * <p>
 * There is a more generic way of solving this problem.
 */

/**
 * 需要注意的几个点：
 * 1、不要申请多余的空间，因此不能将整数转成string
 * 2、负数如何判断是不是回文
 * 3、如果使用反转整数，如何判断那些反转后会overflow的整数
 */
public class PalindromeNumber {
    /**
     * 思路：
     * 将字符串翻转一半，这样就不需要考虑overflow的问题
     * @param x
     * @return
     */
    public boolean isPalindrome(int x){
        if(x<0 || (x!=0&&x%10==0)) return false;
        int res=0;
        while(x>res){
            res=res*10+x%10;
            x=x/10;
        }
        return (res==x || res/10==x)?true:false;
    }
}
