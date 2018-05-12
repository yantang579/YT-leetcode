package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lqy on 2018/1/2.
 * <p>
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree.
 * The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null ||t2==null) return t1==null?t2:t1;
        Queue<TreeNode> qu1=new LinkedList<TreeNode>();
        Queue<TreeNode> qu2=new LinkedList<TreeNode>();
        qu1.offer(t1);
        qu2.offer(t2);
        while(!qu1.isEmpty()&& !qu2.isEmpty()){
            TreeNode temp1=qu1.poll();
            TreeNode temp2=qu2.poll();
            temp1.val=temp1.val+temp2.val;
            if(temp1.left!=null && temp2.left!=null){
                qu1.offer(temp1.left);
                qu2.offer(temp2.left);
            }
            if(temp1.left==null && temp2.left!=null){
                temp1.left=temp2.left;
            }
            if(temp1.right!=null && temp2.right!=null){
                qu1.offer(temp1.right);
                qu2.offer(temp2.right);
            }
            if(temp1.right==null && temp2.right!=null){
                temp1.right=temp2.right;
            }
        }
        return t1;
    }
}
