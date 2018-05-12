package com.leetcode.easy;

import com.leetcode.classes.TreeNode;
/**
 * Created by lqy on 2017/12/31.
 * <p>
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        int depth=0;
        if(root==null) return 0;
        else return Math.max(maxDepth(root.left,depth+1),maxDepth(root.right,depth+1));
    }
    public int maxDepth(TreeNode p,int depth){
        if(p==null) return depth;
        else return Math.max(maxDepth(p.left,depth+1),maxDepth(p.right,depth+1));
    }

}
