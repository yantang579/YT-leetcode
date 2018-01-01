package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.Stack;

/**
 * Created by yantang on 2018/1/1.
 *
 * Subtree of Another Tree
 * Given two non-empty binary trees s and t,
 * check whether tree t has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 */
public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Stack<TreeNode> p=new Stack<TreeNode>();
        p.push(s);
        while(!p.empty()){
            TreeNode temp=p.pop();
            if(temp.val==t.val){
                if(isSameTree(temp,t)) return true;
            }
            if(temp.right!=null) p.push(temp.right);
            if(temp.left !=null) p.push(temp.left);
        }
        return false;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        if (p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
