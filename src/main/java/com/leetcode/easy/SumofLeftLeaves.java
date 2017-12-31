package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.Stack;

/**
 * Created by lqy on 2017/12/31.
 * Sum of Left Leaves
 * <p>
 * Find the sum of all left leaves in a given binary tree.
 */
public class SumofLeftLeaves {
    /**
     * interation DFS
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int sum = 0;
        while (!stack.empty()) {
            TreeNode temp;
            temp = stack.pop();
            if (temp.left != null && temp.left.left == null && temp.left.right == null) {
                sum += temp.left.val;
            }
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        return sum;
    }
    public int sumOfLeftLeaves2(TreeNode root){
        if(root==null) return 0;
        int sum=0;
        if(root.left!=null && root.left.left==null && root.left.right==null) sum+=root.left.val;
        return sum+sumOfLeftLeaves2(root.left)+sumOfLeftLeaves2(root.right);
    }
}
