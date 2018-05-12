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

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList {
    /**
     * 思路：
     * 遍历一遍判断长度
     * 遍历一遍将val放入数组中
     * 两个指针一个从前一个从后判断是否相等
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head){
        ListNode temp;
        temp=head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        temp=head;
        int[] valArray= new int[len];
        int i=0,j=valArray.length-1;
        while(temp!=null){
            valArray[i]=temp.val;
            i++;
            temp=temp.next;
        }
        i=0;
        while(i<=j){
            if(valArray[i]!=valArray[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}
