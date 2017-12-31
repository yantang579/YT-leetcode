package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

/**
 * Created by lqy on 2017/12/31.
 *
 * Given a binary tree, determine if it is height-balanced.
 * For this problem,
 * a height-balanced binary tree is defined as
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(Depth(root.left,1)-Depth(root.right,1))<=1 && isBalanced(root.left) && isBalanced(root.right)) return true;
        return false;
    }
    public int Depth(TreeNode root,int depth){
        if(root==null) return depth;
        return Math.max(Depth(root.left,depth+1),Depth(root.right,depth+1));
    }
}
