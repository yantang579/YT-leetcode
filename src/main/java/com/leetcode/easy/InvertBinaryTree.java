package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lqy on 2017/12/31.
 * Invert a binary tree.
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        Queue<TreeNode> qu=new LinkedList<TreeNode>();
        qu.offer(root);
        while(!qu.isEmpty()){
            TreeNode temp=new TreeNode(0);
            temp=qu.peek().left;
            qu.peek().left=qu.peek().right;
            qu.peek().right=temp;
            if(qu.peek().left!=null) qu.offer(qu.peek().left);
            if(qu.peek().right!=null) qu.offer(qu.peek().right);
            qu.poll();
        }
        return root;
    }
}
