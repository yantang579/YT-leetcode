package com.leetcode;

import com.leetcode.classes.TreeNode;
import com.leetcode.easy.FindModeinBinarySearchTree;

/**
 * Created by yantang on 2018/1/1.
 */
public class Test_FindModelinBinarySearchTree {
    public static void main(String[] args){
        TreeNode root= new TreeNode(6);
        root.left=new TreeNode(2);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(0);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(2);
        root.left.right.right=new TreeNode(6);
        root.right.left=new TreeNode(7);
        root.right.right=new TreeNode(9);
        FindModeinBinarySearchTree test= new FindModeinBinarySearchTree();
        test.findMode(root);
    }



}
