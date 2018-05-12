package com.leetcode.easy;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by lqy on 2017/12/27.
 * <p>
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class ImplementStackusingQueues {

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */

    /**
     * Initialize your data structure here.
     */
    public Queue<Integer> qu1;
    public Queue<Integer> qu2;
    public ImplementStackusingQueues() {
        qu1=new LinkedList<Integer>();
        qu2=new LinkedList<Integer>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        qu1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while(qu1.size()>1){
            qu2.add(qu1.poll());
        }
        int res=qu1.poll();
        while(!qu2.isEmpty()){
            qu1.add(qu2.poll());
        }
        return res;
    }

    /**
     * Get the top element.
     */
    public int top() {
        while(qu1.size()>1){
            qu2.add(qu1.poll());
        }
        int res=qu1.poll();
        qu2.add(res);
        while(!qu2.isEmpty()){
            qu1.add(qu2.poll());
        }
        return res;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return qu1.isEmpty();
    }
}
