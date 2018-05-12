package com.leetcode.easy;
import com.leetcode.classes.ListNode;
/**
 * Created by lqy on 2017/12/3.
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode pre=head;
        ListNode current=head.next;

        while(current!=null){
            if(current.val==pre.val){
                current=current.next;
            }else {
                pre.next=current;
                pre=current;
                current=current.next;
            }
        }
        pre.next=current;
        return head;
    }
}
