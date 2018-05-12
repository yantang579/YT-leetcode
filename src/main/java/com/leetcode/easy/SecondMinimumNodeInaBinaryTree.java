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
    public int first;
    public int second;
    public int findSecondMinimumValue(TreeNode root){
        if(root==null) return -1;
        if(root.left==null && root.right==null) return -1;
        first=root.val;
        second=Integer.MAX_VALUE;
        find(root);
        if(second!=Integer.MAX_VALUE) return second;
        return -1;
    }
    public void find(TreeNode root){
        if(root!=null){
            if(root.val!=first && root.val<second){
                second=root.val;
            }
            if(root.left!=null & root.right!=null){
                find(root.left);
                find(root.right);
            }
        }
    }
}
