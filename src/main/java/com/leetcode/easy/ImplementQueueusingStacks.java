package com.leetcode.easy;

import java.util.Stack;

/**
 * Created by lqy on 2017/12/27.
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class ImplementQueueusingStacks {

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */

    /** Initialize your data structure here. */
    Stack<Integer> st1;
    Stack<Integer> st2;
    public ImplementQueueusingStacks() {
        st1=new Stack<Integer>();
        st2=new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!st1.empty()){
            st2.push(st1.pop());
        }
        int res=st2.pop();
        while(!st2.empty()){
            st1.push(st2.pop());
        }
        return res;
    }

    /** Get the front element. */
    public int top() {
        while(!st1.empty()){
            st2.push(st1.pop());
        }
        int res=st2.peek();
        while(!st2.empty()){
            st1.push(st2.pop());
        }
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.empty();
    }
}
