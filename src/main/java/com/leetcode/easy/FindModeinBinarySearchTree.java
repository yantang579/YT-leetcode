package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yantang on 2018/1/1.
 * <p>
 * Find Mode in Binary Search Tree
 * Given a binary search tree (BST) with duplicates,
 * find all the mode(s) (the most frequently occurred element) in the given BST.
 * <p>
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Note: If a tree has more than one mode, you can return them in any order.
 * <p>
 * Follow up: Could you do that without using any extra space?
 * (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class FindModeinBinarySearchTree {
    public int[] findMode(TreeNode root) {
        if(root==null) return new int[0];
        Stack<TreeNode> stack= new Stack<TreeNode>();
        TreeNode temp=root;
        int mode=0;
        int curCount=0;
        int maxCount=0;
        List<Integer> list= new ArrayList<Integer>();
        while(temp!=null || !stack.empty()){
            while(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            if(!stack.empty()){
                temp=stack.pop();
                if(curCount==0){
                    mode=temp.val;
                    curCount++;
                }
                else if(mode!=temp.val){
                    if(curCount==maxCount){
                        list.add(mode);
                    }
                    else if(curCount>maxCount){
                        list.clear();
                        list.add(mode);
                        maxCount=curCount;
                    }
                    else{}
                    mode=temp.val;
                    curCount=1;
                }
                else{
                    curCount++;
                }
                temp=temp.right;
            }
        }
        if(curCount==maxCount){
            list.add(mode);
        }
        else if(curCount>maxCount){
            list.clear();
            list.add(mode);
        }
        else{}
        int[] res= new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
