package com.leetcode.easy;
import com.leetcode.classes.ListNode;
/**
 * Created by lqy on 2017/12/3.
 * <p>
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle {
    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head==null ||head.next==null)
            return false;
        ListNode fast=head.next.next;
        ListNode slow = head;
        while(true){
            if(fast==null || fast.next ==null){
                return false;
            }
            else if (fast.next==slow ||fast==slow){
                return true;
            }
            else {
                fast=fast.next.next;
                slow=slow.next;
            }
        }
    }

}
