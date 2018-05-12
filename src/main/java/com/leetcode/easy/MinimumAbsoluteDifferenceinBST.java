package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.Stack;

/**
 * Created by lqy on 2018/1/4.
 * Minimum Absolute Difference in BST
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * Note: There are at least two nodes in this BST.
 */
public class MinimumAbsoluteDifferenceinBST {
    int minDiff=Integer.MAX_VALUE;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        int min=-1;
        int pre=0;
        return preOrder(root,min,pre);
    }
    public int preOrder(TreeNode root,int min,int pre){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(root!=null || !stack.empty()){
            while(root!=null) {
                stack.push(root);
                root=root.left;
            }
            if(!stack.empty()){
                root=stack.pop();
                if(min==-1){
                    pre=root.val;
                    min=Integer.MAX_VALUE;
                }
                else{
                    min=Math.min(min,Math.abs(root.val-pre));
                    pre=root.val;
                }
                root=root.right;
            }
        }
        return min;
    }

    public int getMinimumDifference2(TreeNode root){
        getDiff(root);
        return minDiff;
    }
    public void getDiff(TreeNode root){
        if (root == null) return;
        getDiff(root.left);
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        getDiff(root.right);
    }

}
