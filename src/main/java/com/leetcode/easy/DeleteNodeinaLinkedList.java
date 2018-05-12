package com.leetcode.easy;

import com.leetcode.classes.ListNode;

/**
 * Created by lqy on 2017/12/3.
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        while(node.next.next!=null){
            node.val=node.next.val;
            node=node.next;
        }
        node.val=node.next.val;
        node.next=null;
    }
}
