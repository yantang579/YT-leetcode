package com.leetcode.easy;

import com.leetcode.classes.ListNode;

/**
 * Created by lqy on 2017/12/3.
 * <p>
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    /**
     * 思路：
     * 1、遍历一遍判断长度。
     * 2、压入栈中。
     *      2.1 如果长度n为奇数，则将n/2压入栈中，对n/2+1跳过，从n/2+2开始出栈，判断是否相等，直到栈空
     *      2.2 如果长度n为偶数，则将n/2压入栈中，从n/2+1开始出栈，判断是否相等，直到栈空
     * 时间复杂度为O(n)，空间复杂度为O(n)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

    }
}
