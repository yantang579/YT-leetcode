package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yantang on 2017/12/31.
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root==null) return null;
        List<Double> res=new LinkedList<Double>();
        Queue<TreeNode> qu= new LinkedList<TreeNode>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int size=qu.size();
            double average=0;
            for(int i=0;i<size;i++){
                if(qu.peek().left!=null) qu.offer(qu.peek().left);
                if(qu.peek().right!=null) qu.offer(qu.peek().right);
                average+=qu.poll().val;
            }
            average=average/size;
            res.add(average);
        }
        return res;
    }
}
