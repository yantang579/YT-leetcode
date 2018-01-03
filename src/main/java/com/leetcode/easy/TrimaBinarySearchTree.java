package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

/**
 * Created by lqy on 2018/1/2.
 *
 * Given a binary search tree and the lowest and highest boundaries as L and R,
 * trim the tree so that all its elements lies in [L, R] (R >= L).
 * You might need to change the root of the tree,
 * so the result should return the new root of the trimmed binary search tree.
 */
public class TrimaBinarySearchTree {
    /**
     * recursion
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null) return root;
        if(root.val<L) return trimBST(root.right,L,R);
        else if(root.val>R) return trimBST(root.left,L,R);
        else{
            root.left=trimBST(root.left,L,R);
            root.right=trimBST(root.right,L,R);
            return root;
        }
    }

    /**
     * iteration
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST2(TreeNode root, int L, int R) {
        if(root==null) return root;
        //find the root
        while(root.val<L || root.val>R){
            if(root.val<L) root=root.right;
            if(root.val>R) root=root.left;
        }
        TreeNode temp=root;
        //remote the invalid nodes from left subtree
        while(temp!=null){
            while(temp.left!=null&& temp.left.val<L){
                temp.left=temp.left.right;
            }
            temp=temp.left;
        }
        temp=root;
        //remote the invalid nodes from right subtree
        while(temp!=null){
            while(temp.right!=null &&temp.right.val>R){
                temp.right=temp.right.left;
            }
            temp=temp.right;
        }
        return root;
    }
}
