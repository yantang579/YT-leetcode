package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

/**
 * Created by lqy on 2018/1/2.
 * <p>
 * Given a binary tree, find the length of the longest path where each node in the path has the same value.
 * This path may or may not pass through the root.
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class LongestUnivaluePath {
    int max=0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        maxPath(root,root.val);
        return max;
    }
    public int maxPath(TreeNode root,int val){
        if(root==null) return 0;
        int left=maxPath(root.left,root.val);
        int right=maxPath(root.right,root.val);
        max=Math.max(max,left+right);
        if(root.val==val)return Math.max(left,right)+1;
        return 0;
    }
}
