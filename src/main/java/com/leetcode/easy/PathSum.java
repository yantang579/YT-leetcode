package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lqy on 2017/12/31.
 *
 * Given a binary tree and a sum,
 * determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    /**
     * changed the value of each node in this trees
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        Queue<TreeNode> qu=new LinkedList<TreeNode>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int size=qu.size();
            for(int i=0;i<size;i++){
                if(qu.peek().left==null && qu.peek().right==null && qu.peek().val==sum) return true;
                if(qu.peek().left!=null){
                    qu.peek().left.val+=qu.peek().val;
                    qu.offer(qu.peek().left);
                }
                if(qu.peek().right!=null){
                    qu.peek().right.val+=qu.peek().val;
                    qu.offer(qu.peek().right);
                }
                qu.poll();
            }
        }
        return false;
    }

    /**
     * not change the value of the node in this trees
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum2(TreeNode root,int sum){
        if(root==null) return false;
        if(root.left==null & root.right==null & root.val-sum==0) return true;
        return hasPathSum2(root.left,sum-root.val) || hasPathSum2(root.right,sum-root.val);
    }
}
