package com.leetcode;

import com.leetcode.classes.ListNode;
import com.leetcode.easy.PalindromeLinkedList;

/**
 * Created by lqy on 2017/12/6.
 */
public class Test_PalindromeLinkedList {
    public static void main(String args[]){
        ListNode list= new ListNode(1);
        ListNode node= new ListNode(2);
        list.next=node;
        node.next=null;
        PalindromeLinkedList test= new PalindromeLinkedList();
        boolean res=test.isPalindrome(list);
    }
}
