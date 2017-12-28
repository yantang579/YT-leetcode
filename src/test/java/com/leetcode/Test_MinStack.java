package com.leetcode;
import com.leetcode.easy.MinStack;
/**
 * Created by lqy on 2017/12/28.
 */
public class Test_MinStack {
    public static void main(String[] args){
        MinStack test=new MinStack();
        test.push(-2);
        test.push(0);
        test.push(-3);
        System.out.println(test.getMin());
        test.pop();
        System.out.println(test.top());
        System.out.println(test.getMin());
    }
}
