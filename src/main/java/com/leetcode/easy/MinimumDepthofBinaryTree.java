package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lqy on 2017/12/31.
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> qu=new LinkedList<TreeNode>();
        qu.offer(root);
        int depth=1;
        boolean find=false;
        while(!qu.isEmpty()){
            int size=qu.size();
            for(int i=0;i<size;i++){
                if(qu.peek().left ==null && qu.peek().right==null) return depth;
                if(qu.peek().left!=null) qu.offer(qu.peek().left);
                if(qu.peek().right!=null) qu.offer(qu.peek().right);
                qu.poll();
            }
            depth++;
        }
        return depth;
    }
}
