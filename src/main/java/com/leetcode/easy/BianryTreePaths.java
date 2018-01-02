package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lqy on 2018/1/2.
 * <p>
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 */
public class BianryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        Queue<TreeNode> qu =new LinkedList<TreeNode>();
        Queue<String> str=new LinkedList<String>();
        List<String> list=new ArrayList<String>();
        if(root==null) return list;
        qu.offer(root);
        str.offer(String.valueOf(root.val));
        while(!qu.isEmpty()){
            TreeNode node=qu.poll();
            String temp;
            if(node.left==null && node.right==null){
                temp=str.peek();
                list.add(temp);
            }
            if(node.left!=null){
                temp=str.peek()+"->"+String.valueOf(node.left.val);
                qu.offer(node.left);
                str.offer(temp);
            }
            if(node.right!=null){
                temp=str.peek()+"->"+String.valueOf(node.right.val);
                qu.offer(node.right);
                str.offer(temp);
            }
            str.poll();
        }
        return list;
    }
}
