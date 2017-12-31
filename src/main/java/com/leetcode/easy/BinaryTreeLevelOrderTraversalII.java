package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.*;

/**
 * Created by lqy on 2017/12/31.
 * <p>
 * Given a binary tree,
 * return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     / \
 *    15 7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        Queue<TreeNode> qu= new LinkedList<TreeNode>();
        if(root==null) return res;
        qu.offer(root);
        while(!qu.isEmpty()){
            int size=qu.size();
            List<Integer> list= new LinkedList<Integer>();
            for(int i=0;i<size;i++){
                if(qu.peek().left!=null) qu.offer(qu.peek().left);
                if(qu.peek().right!=null) qu.offer(qu.peek().right);
                list.add(qu.poll().val);
            }
            res.add(0,list);
        }
        return res;
    }
}
