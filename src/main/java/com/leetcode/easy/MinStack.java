package com.leetcode.easy;

import java.util.Stack;

/**
 * Created by lqy on 2017/12/27.
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    /** initialize your data structure here. */

    /**
     * use only 1 stack
     */
    Stack<Long> st;
    long min;
    public MinStack() {
        st=new Stack<Long>();
    }

    public void push(int x) {
        if(st.empty()){
            min=(long)x;
            st.push(0L);
        }else{
            st.push(x-min);
            if(x-min<0) min=x;
        }


    }

    public void pop() {
        long temp=st.pop();
        if(temp<0){
            min=min-temp;
        }
    }

    public int top() {
        long temp=st.peek();
        if(temp<0) return (int)min;
        return (int)(temp+min);
    }

    public int getMin() {
        return (int)min;
    }
}
