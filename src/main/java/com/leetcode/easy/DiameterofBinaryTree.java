package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

/**
 * Created by yantang on 2018/1/1.
 *
 * Diameter of Binary Tree
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Note:The length of path between two nodes is represented by the number of edges between them.
 *
 */
public class DiameterofBinaryTree {
    int max=0;
    /**
     * For every node,the length of longest path =MaxDepth of its left subtree + MaxDepth of its right subtree;
     * @param root
     * @return
     */

    public int diameterOfBinaryTree(TreeNode root) {
        MaxDepth(root);
        return max;
    }
    public int MaxDepth(TreeNode root){
        if(root == null) return 0;
        int left=MaxDepth(root.left);
        int right=MaxDepth(root.right);
        max=Math.max(max,left+right);

        return Math.max(left,right)+1;
    }
}
