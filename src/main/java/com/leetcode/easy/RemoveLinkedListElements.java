package com.leetcode.easy;
import com.leetcode.classes.ListNode;


/**
 * Created by lqy on 2017/12/3.
 * <p>
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * <p>
 * Credits:
 * Special thanks to @mithmatt for adding this problem and creating all test cases.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return null;
        ListNode pre=new ListNode(0);
        pre.next=null;
        ListNode res=pre;
        ListNode current=head;
        while(current!=null){
            if(current.val!=val){
                pre.next=current;
                pre=pre.next;
            }
            current=current.next;
        }
        pre.next=null;
        return res.next;
    }
}
