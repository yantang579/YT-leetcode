package com.leetcode.easy;

import com.leetcode.classes.ListNode;

/**
 * Created by lqy on 2017/12/3.
 * <p>
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pre;
        pre=head;
        while(l1!=null && l2 !=null ){
            if(l1.val>l2.val){
                pre.next=l2;
                l2=l2.next;
                pre=pre.next;
            }
            else {
                pre.next=l1;
                l1=l1.next;
                pre=pre.next;
            }
        }
        if(l1!=null)
            pre.next=l1;

        else
            pre.next=l2;
        return head.next;

    }
}
