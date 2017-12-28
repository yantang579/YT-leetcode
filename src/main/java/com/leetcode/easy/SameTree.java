package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.Stack;
/**
 * Created by lqy on 2017/12/28.
 * <p>
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SameTree {
    /**
     * recurison
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        if (p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

    /**
     * iteration
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        Stack<TreeNode> pStack = new Stack<TreeNode>();
        Stack<TreeNode> qStack = new Stack<TreeNode>();
        pStack.push(p);
        qStack.push(q);
        while (!pStack.empty() && !qStack.empty()) {
            TreeNode t1 = pStack.pop();
            TreeNode t2 = qStack.pop();
            if (t1.val != t2.val) return false;
            else {
                if (t1.left != null && t2.left != null) {
                    pStack.push(t1.left);
                    qStack.push(t2.left);
                } else if (t1.left == null && t2.left == null) {
                } else {
                    return false;
                }

                if (t1.right != null && t2.right != null) {
                    pStack.push(t1.right);
                    qStack.push(t2.right);
                } else if (t1.right == null && t2.right == null) {
                } else {
                    return false;
                }
            }
        }
        if (!pStack.empty() || !qStack.empty())
            return false;
        return true;
    }
}
