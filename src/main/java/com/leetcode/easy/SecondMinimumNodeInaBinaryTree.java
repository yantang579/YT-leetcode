package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by yantang on 2018/1/1.
 * <p>
 * Given a non-empty special binary tree consisting of nodes with the non-negative value,
 * where each node in this tree has exactly two or zero sub-node.
 * If the node has two sub-nodes,
 * then this node's value is the smaller value among its two sub-nodes.
 *
 * Given such a binary tree,
 * you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 * If no such second minimum value exists, output -1 instead.
 */
public class SecondMinimumNodeInaBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null) return -1;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode temp=root;
        List<Integer> list= new ArrayList<Integer>();
        int min=0;
        int count=0;
        while(temp!=null || !stack.empty()){
            while(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            if(!stack.empty()){
                temp=stack.pop();
                list.add(temp.val);
                temp=temp.right;
            }
        }
        int size=list.size();
        //int[] array = list.toArray();

        return -1;
    }
}
