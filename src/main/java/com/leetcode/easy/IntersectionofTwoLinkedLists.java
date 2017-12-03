package com.leetcode.easy;

import com.leetcode.classes.ListNode;

/**
 * Created by lqy on 2017/12/3.
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * <p>
 * For example, the following two linked lists:
 * <p>
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * <p>
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * Credits:
 * Special thanks to @stellari for adding this problem and creating all test cases.
 */
public class IntersectionofTwoLinkedLists {
    /**
     * 先遍历两个链表，得到两个链表的长度，然后长的链表先走，两个链表一样长之后一起走，如果相同则返回，如果不同则返回null
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int lenA = 0, lenB = 0;
        while (a != null) {
            lenA++;
            a = a.next;
        }
        while (b != null) {
            lenB++;
            b = b.next;
        }
        a = headA;
        b = headB;
        while (a != null &&b!=null && a!=b){
            if(lenA>lenB){
                a=a.next;
                lenA--;
            }else if(lenB>lenA){
                b=b.next;
                lenB--;
            }else {
                a=a.next;
                b=b.next;
            }
        }
        if(a==b) return a;
        return null;
    }
}
