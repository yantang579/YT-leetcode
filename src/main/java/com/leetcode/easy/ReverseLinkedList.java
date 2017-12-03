package com.leetcode.easy;

import com.leetcode.classes.ListNode;


/**
 * Created by lqy on 2017/12/3.
 * <p>
 * Reverse a singly linked list.
 * <p>
 * <p>
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList {
    /**
     * iterative
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        ListNode dummy= new ListNode(0);
        dummy.next=null;
        ListNode current=head;
        while(head!=null){
            current=head;
            head=head.next;
            current.next=dummy.next;
            dummy.next=current;
        }
        return dummy.next;
    }

    /**
     * recursive
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head){
        if(head==null ||head.next==null)
            return head;
        ListNode cur=head;
        ListNode post=head.next;
        ListNode reverse=reverseList2(post);
        post.next=cur;
        cur.next=null;
        return reverse;
    }
}
